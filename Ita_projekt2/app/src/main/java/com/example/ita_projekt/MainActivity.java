package com.example.ita_projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.security.auth.login.LoginException;

public class MainActivity extends AppCompatActivity {

    EditText username, password, repassword;
    Button signup, signin;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);
        signup = (Button) findViewById(R.id.btnsignup);
        signin = (Button) findViewById(R.id.btnsignin);
        DB = new DBHelper(this);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User holderNaive = new User();
                 UserNameAndPass userNameAndPass  = holderNaive.getUserNameAndPass();

                userNameAndPass.setUsername(username.getText().toString());// = username.getText().toString();
                userNameAndPass.setPassword(password.getText().toString());
                userNameAndPass.setRepassword(repassword.getText().toString());
                //String pass = password.getText().toString();
                //String repass = repassword.getText().toString();

                if(userNameAndPass.getPassword().equals("") || userNameAndPass.getUsername().equals("") ||userNameAndPass.getRepassword().equals(""))
                    Toast.makeText(MainActivity.this,"Prosim izpolnite polja",Toast.LENGTH_SHORT).show();
                else{
                    if(userNameAndPass.getRepassword().equals(userNameAndPass.getRepassword())) {
                        String user = userNameAndPass.getUsername();
                        String pass = userNameAndPass.getPassword();
                        Boolean checkuser = DB.checkusername(user);
                        Boolean checkpass = DB.checkPassword(pass);
                        if (checkuser == false && checkpass == true) {
                            Boolean insert = DB.insertData(user, pass);
                            if (insert == true) {
                                Toast.makeText(MainActivity.this, "Registracija je uspešna", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), Menu.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(MainActivity.this, "Registracija je neuspešna", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "Uporabnk že obstaja/geslo rabi vsaj eno st", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(MainActivity.this, "Geslo se ne ujema", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        //ZA PREHOD NA LOGIN ACTIVITY
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });


    }



}