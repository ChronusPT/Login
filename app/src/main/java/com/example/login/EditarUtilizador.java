package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class EditarUtilizador extends AppCompatActivity {

    Intent it;
    int id;
    DBHelper db;
    EditText etlogin, etemail, etpassword, etrepass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_utilizador);

        it = getIntent();
        //Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
        id = it.getExtras().getInt ("id");

        etlogin = findViewById(R.id.eregistoctxlogin);
        etemail = findViewById(R.id.eregistoctxemail);
        etpassword = findViewById(R.id.eregistoctxpass);
        etrepass = findViewById(R.id.eregistoctxrepass);

        db = new DBHelper(this);
        String valores [] = new String[3];
        valores = db.editaDados(id);

        etlogin.setText(valores[0]);
        etemail.setText(valores[1]);
        etpassword.setText(valores[2]);
        etrepass.setText(valores[2]);

    }
}