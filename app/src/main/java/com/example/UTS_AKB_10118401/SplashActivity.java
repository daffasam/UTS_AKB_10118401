package com.example.UTS_AKB_10118401;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

// Tanggal Pengerjaan : 23 Mei 2022
// Nama : Daffa Sacofi Mutawakkil
// NIM : 10118401
// Kelas : IF-6

public class SplashActivity extends AppCompatActivity {

    private static int SplashTimeOut = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, SlideActivity.class);
                startActivity(intent);
                finish();
            }
        }, SplashTimeOut);
    }
}