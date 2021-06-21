package com.example.ita_projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.time.Instant;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button btnlogin, registracija;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.username1);
        password = (EditText) findViewById(R.id.password1);
        btnlogin = (Button) findViewById(R.id.btnsignin1);
        registracija = (Button)findViewById(R.id.btnreg1);
        DB = new DBHelper(this);


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass =  password.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(LoginActivity.this, "Prosim izpolnite polja", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkUserpassword(user,pass);
                    if(checkuserpass == true){
                        Toast.makeText(LoginActivity.this, "Uspešna prijava", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),Menu.class);
                        startActivity(intent);
                                
                    }else{
                        Toast.makeText(LoginActivity.this, "Napaka", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        //ZA PREHOD NA register ACTIVITY
        registracija.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });



    }
}