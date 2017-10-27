package com.dyx.arja.utils;

import android.graphics.Bitmap;
import android.os.Environment;
import android.text.format.Time;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Author：dayongxin
 * Function：
 */
public class SDCardUtils {
    public void savePicture(Bitmap bitmap) {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            try {
                File sdcardDir = Environment
                        .getExternalStorageDirectory();
                Time t = new Time();
                t.setToNow();
                String filename = sdcardDir.getCanonicalPath()
                        + "/DCIM/camera"
                        + String.format(
                        "/dayongxin.jpg",
                        t.year, t.month + 1, t.monthDay,
                        t.hour, t.minute, t.second);
                File file = new File(filename);
                FileOutputStream out = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
