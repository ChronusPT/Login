package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText login, pass;
    Intent i;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void fazLogin(View v){
        String log, senha;
        login = findViewById(R.id.loginctxlogin);
        log = login.getText().toString();
        pass = findViewById(R.id.loginctxpass);
        senha = pass.getText().toString();
        if(log.isEmpty() || senha.isEmpty()){
            Toast.makeText(this, "Preencha os campos de login", Toast.LENGTH_SHORT).show();
        }
        else{
            //fazer validação na BD
            db = new DBHelper(this);
            if (db.verificaLogin(log, senha)>0){
                i = new Intent(Login.this, MostraUtilizadores.class);
                i.putExtra("id", db.verificaLogin(log,senha));
                startActivity(i);
                finish();
            }
        }
    }
    public void fazRegisto(View v){
        i = new Intent(Login.this, Registo.class);
        startActivity(i);
        finish();
    }
}