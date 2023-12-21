package com.example.myapplication;
import android.app.IntentService;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

public class DownloadService extends IntentService {

    private Handler handler;

    public DownloadService() {
        super("DownloadService");
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        // Get the receipt details from the intent
        String receiptDetails = intent.getStringExtra("receiptDetails");

        // Check external storage state
        String state = Environment.getExternalStorageState();

        if (Environment.MEDIA_MOUNTED.equals(state)) {
            // External storage is available, proceed with file creation and writing

            // Create a file to save the receipt
            File receiptFile = new File(getExternalFilesDir(null), "Receipt.txt");

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                // Use SAF for Android 10 and above
                ContentResolver resolver = getContentResolver();
                ContentValues contentValues = new ContentValues();
                contentValues.put(MediaStore.MediaColumns.DISPLAY_NAME, "Receipt.txt");
                contentValues.put(MediaStore.MediaColumns.MIME_TYPE, "text/plain");
                contentValues.put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_DOCUMENTS);

                Uri uri = resolver.insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI, contentValues);

                try {
                    OutputStream outputStream = resolver.openOutputStream(uri);
                    if (outputStream != null) {
                        outputStream.write(receiptDetails.getBytes());
                        outputStream.close();
                        showToast("Receipt downloaded successfully");
                    } else {
                        showToast("Error: OutputStream is null");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    showToast("Error downloading receipt: " + e.getMessage());
                }
            } else {
                // For versions below Android 10
                try {
                    // Write receipt details to the file
                    FileWriter writer = new FileWriter(receiptFile);
                    writer.append(receiptDetails);
                    writer.flush();
                    writer.close();

                    // Display a message indicating successful download
                    showToast("Receipt downloaded successfully");
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.e("DownloadService", "Error downloading receipt: " + e.getMessage());
                    showToast("Error downloading receipt: " + e.getMessage());
                }
            }
        } else {
            // External storage is not available or in a state where writing is not allowed
            showToast("External storage not available for writing");
        }
    }


    private void showToast(final String message) {
        // Display a toast message on the main thread using a Handler
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(DownloadService.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

