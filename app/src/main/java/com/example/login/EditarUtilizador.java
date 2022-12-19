package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.EditText;

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
        id = it.getExtras().getInt ("Id");

        etlogin = findViewById(R.id.eregistoctxlogin);
        etemail = findViewById(R.id.eregistoctxemail);
        etpassword = findViewById(R.id.eregistoctxpass);
        etrepass = findViewById(R.id.eregistoctxrepass);

        db = new DBHelper(this);
        Cursor c = db.editaDados(id);
        etlogin.setText(c.getColumnIndex("Login"));
        etemail.setText(c.getColumnIndex("email"));
        etpassword.setText(c.getColumnIndex("password"));
        etrepass.setText("password");

    }
}