package com.bagus.utsmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView textViewName, textViewEmail, textViewRole, textViewWaktuAbsensi;
    private Button buttonAbsenMasuk, buttonAbsenKeluar;
    private String waktuAbsenMasuk = "";
    private String waktuAbsenKeluar = "";

    private SimpleDateFormat sdf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.utama);

        // Inisialisasi formatter waktu
        sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault());

        // Inisialisasi view
        textViewName = findViewById(R.id.textViewName);
        textViewEmail = findViewById(R.id.textViewEmail);
        textViewRole = findViewById(R.id.textViewRole);
        textViewWaktuAbsensi = findViewById(R.id.textViewWaktuAbsensi);
        buttonAbsenMasuk = findViewById(R.id.buttonAbsenMasuk);
        buttonAbsenKeluar = findViewById(R.id.buttonAbsenKeluar);

        // Ambil data dari intent
        String name = getIntent().getStringExtra("USER_NAME");
        String email = getIntent().getStringExtra("USER_EMAIL");
        String role = getIntent().getStringExtra("USER_ROLE");

        // Tampilkan data user
        textViewName.setText("Nama: " + name);
        textViewEmail.setText("Email: " + email);
        textViewRole.setText("Posisi: " + role);

        // Absen Masuk
        buttonAbsenMasuk.setOnClickListener(v -> {
            String waktuSekarang = sdf.format(new Date());
            waktuAbsenMasuk = waktuSekarang;
            textViewWaktuAbsensi.setText("Absen Masuk: " + waktuSekarang);
            Toast.makeText(this, "Absen Masuk dicatat!", Toast.LENGTH_SHORT).show();
        });

        // Absen Keluar
        buttonAbsenKeluar.setOnClickListener(v -> {
            String waktuSekarang = sdf.format(new Date());
            waktuAbsenKeluar = waktuSekarang;
            textViewWaktuAbsensi.setText("Absen Keluar: " + waktuSekarang);
            Toast.makeText(this, "Absen Keluar dicatat!", Toast.LENGTH_SHORT).show();
        });
    }
}