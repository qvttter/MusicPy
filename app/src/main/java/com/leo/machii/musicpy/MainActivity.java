package com.leo.machii.musicpy;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_open)
    Button btnOpen;
    @BindView(R.id.btn_close)
    Button btnClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        if (Settings.canDrawOverlays(MainActivity.this)) {
            Intent intent = new Intent(MainActivity.this, MainService.class);
            Toast.makeText(MainActivity.this, "已开启Toucher", Toast.LENGTH_SHORT).show();
            startService(intent);
            finish();
        } else {
            //若没有权限，提示获取.
            Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
            Toast.makeText(MainActivity.this, "需要取得权限以使用悬浮窗", Toast.LENGTH_SHORT).show();
            startActivity(intent);
            finish();
        }
    }

    @OnClick({R.id.btn_open, R.id.btn_close})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_open:

                break;
            case R.id.btn_close:
                break;
        }
    }
}
