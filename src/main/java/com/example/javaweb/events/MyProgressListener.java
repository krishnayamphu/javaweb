package com.example.javaweb.events;

import org.apache.commons.fileupload.ProgressListener;

import javax.servlet.annotation.WebListener;

@WebListener
public class MyProgressListener implements ProgressListener {
    private long megaBytes = -1;
    private long totalFileSize;
    private long currentFileRead;

    @Override
    public void update(long bytesRead, long contentLength, int items) {
        long mBytes = bytesRead / 1000000;
        if (megaBytes == mBytes) {
            return;
        }
        megaBytes = mBytes;
        System.out.println("We are currently reading item " + items);
        if (contentLength == -1) {
            System.out.println("So far, " + bytesRead + " bytes have been read.");
        } else {
            System.out.println("So far, " + bytesRead + " of " + contentLength
                    + " bytes have been read.");
        }
    }

    public long getMegaBytes() {
        return megaBytes;
    }
}
