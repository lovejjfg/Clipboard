package com.lovejjfg.clipboard;

import android.app.Service;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;

/**
 * Created by Joe on 2016/11/16.
 * Email lovejjfg@gmail.com
 */

public class ClipService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Log.e("TAG", "onCreate: ");
        super.onCreate();
    }

    @Override
    public int onStartCommand(final Intent intent, final int flags, final int startId) {
        // Gets a handle to the Clipboard Manager
        final ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        clipboard.addPrimaryClipChangedListener(new ClipboardManager.OnPrimaryClipChangedListener() {
            @Override
            public void onPrimaryClipChanged() {

                CharSequence text = clipboard.getPrimaryClip().getItemAt(0).getText();
                Log.e("TAG", "onCreate: 改变了::" + text);
                if (!TextUtils.isEmpty(text)) {
                    Intent i = new Intent(ClipService.this, DialogActivity.class);
                    // Sets the Activity to start in a new, empty task
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.putExtra("text", text);
                    ClipService.this.startActivity(i);
                }
            }
        });
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.e("TAG", "onDestroy: ");
        super.onDestroy();
    }
}
