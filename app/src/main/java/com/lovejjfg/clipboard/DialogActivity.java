package com.lovejjfg.clipboard;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class DialogActivity extends AppCompatActivity {

    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        onNewIntent(getIntent());
    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent == null) {
            return;
        }
        String text = intent.getStringExtra("text");
        if (alertDialog == null) {
            alertDialog = new AlertDialog.Builder(this)
                    .setTitle("检测到你复制了内容")
                    .setMessage(text)
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                        }
                    })
                    .create();
        }
        alertDialog.setMessage(text);
        alertDialog.show();
    }
}
