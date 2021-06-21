package com.example.ita_projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;

import com.airbnb.lottie.LottieAnimationView;

public class IntroActivity extends AppCompatActivity {

    LottieAnimationView lottieAnimationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        lottieAnimationView = findViewById(R.id.lottie);

        lottieAnimationView.animate()
                .translationY(1600)
                .setDuration(2000)
                .setStartDelay(4000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent =  new Intent(IntroActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },5000);


    }
}