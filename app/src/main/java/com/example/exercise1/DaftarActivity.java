package com.example.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class DaftarActivity extends AppCompatActivity {

    //Deklarasi variabel dengan tipe data EditText
    EditText edtNama, edtAlamat, edtEmail, edtPassword, edtRepass;

    //Deklarasi variabel dengan tipe data Button
    Button btnBatal, btnDaftar;

    boolean isNamaValid, isAlamatValid, isEmailValid, isPasswordValid, isRePasswordValid;
    TextInputLayout namaError, alamatError ,emailError, passError, repassError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        //Menghubungkan variabel edtNama dengan komponen EditText pada layout
        edtNama = (EditText) findViewById((R.id.edNama));

        //Menghubungkan variabel edtAlamat dengan komponen EditText pada layout
        edtAlamat = (EditText) findViewById(R.id.edAlamat);

        //Menghubungkan variabel edtEmail dengan komponen EditText pada layout
        edtEmail = (EditText) findViewById(R.id.edEmail);

        //Menghubungkan variabel edtPassword dengan komponen EditText pada layout
        edtPassword = (EditText) findViewById(R.id.edPwd);

        //Menghubungkan variabel edtRepass dengan komponen EditText pada layout
        edtRepass = (EditText) findViewById(R.id.edRePwd);

        btnBatal = (Button) findViewById(R.id.btnBatal);
        btnDaftar = (Button) findViewById(R.id.btnDaftar);

        namaError = (TextInputLayout) findViewById(R.id.tilNama);
        alamatError = (TextInputLayout) findViewById(R.id.tilAlamat);
        emailError = (TextInputLayout) findViewById(R.id.tilEmail);
        passError = (TextInputLayout) findViewById(R.id.tilPwd);
        repassError = (TextInputLayout) findViewById(R.id.tilRePwd);

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validasi();
            }
        });

        btnBatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(in);
            }
        });

    }

    public void validasi() {
        if (this.edtNama.getText().toString().isEmpty() || edtAlamat.getText().toString().isEmpty()
                || edtEmail.getText().toString().isEmpty() || edtPassword.getText().toString().isEmpty()
                || edtRepass.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Data Harus Diisi Semua", Toast.LENGTH_LONG).show();
        }
        if (edtNama.getText().toString().isEmpty()) {
            namaError.setError("Nama Tidak Boleh Kosong");
            isNamaValid = false;
        } else {
            isNamaValid = true;
            namaError.setErrorEnabled(false);
        }
        if (edtNama.getText().toString().isEmpty()) {
            alamatError.setError("Alamat Tidak Boleh Kosong");
            isAlamatValid = false;
        } else {
            isAlamatValid = true;
            alamatError.setErrorEnabled(false);
        }
        if (edtEmail.getText().toString().isEmpty()) {
            emailError.setError("Email Tidak Boleh Kosong");
            isEmailValid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(edtEmail.getText().toString()).matches()) {
            emailError.setError("Masukkan Email Anda Dengan Benar");
            isEmailValid = false;
        } else {
            isEmailValid = true;
            emailError.setErrorEnabled(false);
        }
        if (edtPassword.getText().toString().isEmpty()) {
            passError.setError("Password Tidak Boleh Kosong");
            isPasswordValid = false;
        } else if (this.edtPassword.getText().length() < 6) {
            passError.setError("Panjang Password Minimal 6 Karakter");
            isPasswordValid = false;
        } else {
            isPasswordValid = true;
            passError.setErrorEnabled(false);
        }
        if (edtRepass.getText().toString().isEmpty()) {
            repassError.setError("Re-Password Tidak Boleh Kosong");
            isRePasswordValid = false;
        } else if (edtRepass.getText().length() < 6) {
            repassError.setError("Panjang Re-Password Minimal 6 Karakter");
            isRePasswordValid = false;
        } else if (!edtRepass.getText().toString().equals(edtPassword.getText().toString())) {
            repassError.setError("Password Tidak Sama");
            isRePasswordValid = false;
        } else {
            isRePasswordValid = true;
            repassError.setErrorEnabled(false);
        }
        if (isNamaValid && isAlamatValid && isEmailValid && isPasswordValid && isRePasswordValid) {
            Toast.makeText(getApplicationContext(), "Pendaftaran Berhasil", Toast.LENGTH_LONG).show();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
    }
}