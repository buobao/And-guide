package com.turman.and_guide.appshortcuts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

public class MyReceiver extends BroadcastReceiver {
    @RequiresApi(api = Build.VERSION_CODES.N_MR1)
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("MyReceiver", "onReceive: " + intent);
        if (Intent.ACTION_LOCALE_CHANGED.equals(intent.getAction())) {
            // Refresh all shortcut to update the labels.
            // (Right now shortcut labels don't contain localized strings though.)
            new ShortcutHelper(context).refreshShortcuts(/*force=*/ true);
        }
    }
}
