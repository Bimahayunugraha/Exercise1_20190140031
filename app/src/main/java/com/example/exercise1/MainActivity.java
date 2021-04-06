package com.example.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    EditText edEmail, edPassword;
    TextView register;
    Button button;
    boolean emailvalid, passvalid;
    TextInputLayout emailError, passError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Menghubungkan variabel edEmail dengan komponen EditText pada layout
        edEmail = (EditText) findViewById(R.id.edtEmail);

        //Menghubungkan variabel edPwd dengan komponen EditText pada layout
        edPassword = (EditText) findViewById(R.id.edtPassword);

        register = (TextView) findViewById(R.id.register);

        //Menghubungkan variabel button dengan komponen Button pada layout
        button = (Button) findViewById(R.id.button);

        emailError = (TextInputLayout) findViewById(R.id.tilEmail);
        passError = (TextInputLayout) findViewById(R.id.tilPassword);

        //Membuat fungsi onclik pada button login
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Fungsi validasi untuk email tidak boleh kosong
                if (edEmail.getText().toString().isEmpty()) {
                    emailError.setError("Email Tidak Boleh Kosong");
                    emailvalid = false;
                } else if (!Patterns.EMAIL_ADDRESS.matcher(edEmail.getText().toString()).matches()) {
                    emailError.setError("Masukkan Email Anda dengan Benar");
                    emailvalid = false;
                } else {
                    emailvalid = true;
                    emailError.setErrorEnabled(false);
                }

                //Fungsi validasi untuk password tidak boleh kosong
                if (edPassword.getText().toString().isEmpty()) {
                    passError.setError("Password Tidak Boleh Kosong");
                    passvalid = false;
                } else if (edPassword.getText().length() < 6) {
                    passError.setError("Password Tidak Boleh Melebihi 6 Karakter");
                    passvalid = false;
                } else {
                    passvalid = true;
                    passError.setErrorEnabled(false);
                }

                //Fungsi jika email atau password yang di masukkan salah
                if (!emailvalid || !passvalid || !edEmail.getText().toString().equals("admin@mail.com") || !edPassword.getText().toString().equals("123456")) {
                    Toast.makeText(getApplicationContext(), "Email atau Password Salah", Toast.LENGTH_LONG).show();
                    return;
                }

                //Fungsi untuk login sukses
                Toast.makeText(getApplicationContext(), "Login Sukses", Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DaftarActivity.class);
                startActivity(intent);
            }
        });
    }

}