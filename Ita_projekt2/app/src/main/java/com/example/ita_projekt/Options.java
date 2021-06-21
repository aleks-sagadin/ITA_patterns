package com.example.ita_projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.sql.SQLOutput;

public class Options extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);


        User holderNaive = new User();
        UserNameAndPass heavy = holderNaive.getUserNameAndPass();
        heavy.getPassword();

        System.out.println("PEDER toLE JE: " +heavy);
        System.out.println("PEDROSA: " + heavy.getPassword());
    }
}