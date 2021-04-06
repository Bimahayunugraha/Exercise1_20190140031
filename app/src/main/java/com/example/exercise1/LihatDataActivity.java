package com.example.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class LihatDataActivity extends AppCompatActivity {

    //Deklarasi variabel dengan jenis data TextView
    TextView tvnama, tvnomor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);

        //Menghubungkan variabel tvnama dengan komponen TextView pada layout
        tvnama = findViewById(R.id.tvNamaKontak);

        //Menghubungkan variabel tvnomor dengan komponen TextView pada layout
        tvnomor = findViewById(R.id.tvNomorTelepon);

        /*Membuat variabel dengan jenis data bundle dan assign value
          dari variabel tersebut dengan getIntent().getExtras()*/
        Bundle bundle = getIntent().getExtras();

        /*Membuat variabel nama dan assign value dari pesan yang dikirimkan
          dari activity sebelumnya*/
        String nama = bundle.getString("a");

        /*Membuat fungsi untuk mengatur TextView nama dan nomor telepon
          berdasarkan pesan yang dikirimkan dari activity sebelumnya*/
        switch (nama)
        {
            case "Inayah" :
                tvnama.setText("Inayah M");
                tvnomor.setText("08122233344");
                break;
            case "Ilham" :
                tvnama.setText("Ilham R");
                tvnomor.setText("08133224455");
                break;
            case "Eris" :
                tvnama.setText("Eris J");
                tvnomor.setText("0812553344");
                break;
            case "Fikri" :
                tvnama.setText("M Fikri");
                tvnomor.setText("08122453344");
                break;
            case "Maul" :
                tvnama.setText("Maul M");
                tvnomor.setText("08126633344");
                break;
            case "Intan" :
                tvnama.setText("Intan S");
                tvnomor.setText("08122555344");
                break;
            case "Vina" :
                tvnama.setText("Vina R");
                tvnomor.setText("08125556344");
                break;
            case "Gita" :
                tvnama.setText("Gita S");
                tvnomor.setText("08199233344");
                break;
            case "Lutfi" :
                tvnama.setText("Lutfi M");
                tvnomor.setText("08122233234");
                break;
            case "Vian" :
                tvnama.setText("Vian M");
                tvnomor.setText("08122969344");
                break;
        }
    }
}