package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Registo extends AppCompatActivity {

    EditText login, pass, repass, email;
    Intent i;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registo);
    }

    public void fazRegisto(View v){
        String log, mail, senha, resenha;
        login = findViewById(R.id.registoctxlogin);
        log = login.getText().toString();
        email = findViewById(R.id.registoctxemail);
        mail = email.getText().toString();
        pass = findViewById(R.id.registoctxpass);
        senha = pass.getText().toString();
        repass = findViewById(R.id.registoctxrepass);
        resenha = repass.getText().toString();
        if(log.isEmpty() || mail.isEmpty() || senha.isEmpty() || resenha.isEmpty()){
            Toast.makeText(this, "Preencha todos os campos de registo", Toast.LENGTH_SHORT).show();
        } else if (!senha.equals(resenha)){
            Toast.makeText(this, "Os campos password têm de coincidir", Toast.LENGTH_SHORT).show();
        }else{
            //inserir dados na BD
            db = new DBHelper(this);
            long res = db.insert(log,mail,senha);
            if(res>0){
                Toast.makeText(this, "Registo inserido com sucesso!", Toast.LENGTH_SHORT).show();
                login.setText("");
                email.setText("");
                pass.setText("");
                repass.setText("");
            }else{
                Toast.makeText(this, "Não foi possível registar dados", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void voltar(View v){
        i = new Intent(Registo.this, Login.class);
        startActivity(i);
        finish();
    }
}