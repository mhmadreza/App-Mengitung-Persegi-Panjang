package com.mr.menghitungpersegipanjang;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etPanjang, etLebar;
    private TextView tvKeliling, tvLuas;
    private Button btnHitung;

    private static final String KELILING_KEY = "keliling_key";
    private static final String LUAS_KEY = "luas_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI();
    }

    private void setupUI() {
        /* Inisiasi variabel diatas untuk Edit Text */
        etPanjang = (EditText)findViewById(R.id.et_panjang);
        etLebar = (EditText)findViewById(R.id.et_lebar);

        /* Inisiasi variabel diatas untuk Text View */
        tvKeliling = (TextView)findViewById(R.id.tv_keliling);
        tvLuas = (TextView)findViewById(R.id.tv_luas);

        /* Inisiasi variabel diatas untuk Button */
        btnHitung = (Button)findViewById(R.id.btn_hitung);
        /* Cara 1 Jika Button Hitung di Klik */
        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungKeliling();
                hitungLuas();
            }
        });
    }

    /* Cara 2 Jika Button Hitung di Klik melewati Layout onClick */
    /*public void hitung(View view) {
        hitungKeliling();
        hitungLuas();
    }*/

    private void hitungKeliling() {
        int panjang = Integer.parseInt(etPanjang.getText().toString());
        int lebar = Integer.parseInt(etLebar.getText().toString());
        int hasilKeliling = 2*panjang + 2*lebar;
        /* Note, edit text mengandung String, Setelah di convert menjadi Integer maka setText harus mendapati nilai String */
        tvKeliling.setText(""+hasilKeliling);
    }

    private void hitungLuas() {
        int panjang = Integer.parseInt(etPanjang.getText().toString());
        int lebar = Integer.parseInt(etLebar.getText().toString());
        int hasilLuas = panjang * lebar;
        /* Note, edit text mengandung String, Setelah di convert menjadi Integer maka setText harus mendapati nilai String */
        tvLuas.setText(""+hasilLuas);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString(KELILING_KEY, tvKeliling.getText().toString());
        outState.putString(LUAS_KEY, tvLuas.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        String savedKeliling = savedInstanceState.getString(KELILING_KEY);
        tvKeliling.setText(savedKeliling);
        String savedLuas = savedInstanceState.getString(LUAS_KEY);
        tvLuas.setText(savedLuas);
        super.onRestoreInstanceState(savedInstanceState);
    }
}