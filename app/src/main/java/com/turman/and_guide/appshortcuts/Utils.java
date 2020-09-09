package com.turman.and_guide.appshortcuts;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

public class Utils {
    private Utils(){

    }

    public static void showToast(final Context context, final String message) {
        new Handler(Looper.getMainLooper()).post(() -> Toast.makeText(context,message,Toast.LENGTH_SHORT).show());
    }
}
