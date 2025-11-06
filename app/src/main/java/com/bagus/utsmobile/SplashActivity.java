// SplashActivity.java
package com.bagus.utsmobile;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_DELAY = 3500; // 3 detik

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView logo = findViewById(R.id.splash_logo);

        // Buat animasi fade-in (dari transparan ke jelas)
        AlphaAnimation fadeIn = new AlphaAnimation(0.0f, 1.0f); // dari 0% ke 100% opacity
        fadeIn.setDuration(9500); // durasi 9.5 detik
        fadeIn.setFillAfter(true); // biarkan tetap jelas setelah animasi selesai


        // Jalankan animasi
        logo.startAnimation(fadeIn);

        // Setelah animasi + delay tambahan, pindah ke LoginActivity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_DELAY);
    }
}