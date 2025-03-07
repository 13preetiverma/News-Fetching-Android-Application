package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class splashScreen extends AppCompatActivity {


    TextView name;
    ImageView myimage;
    LottieAnimationView lottie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        name = findViewById(R.id.logo);
        lottie = findViewById(R.id.lottie);
        myimage=findViewById(R.id.myimage);

        name.animate().translationX(-1000).setDuration(2000).setStartDelay(1000);
        lottie.animate().translationX(2000).setDuration(2000).setStartDelay(2900);
        myimage.animate().translationX(2000).setDuration(2000).setStartDelay(2900);


        Thread thread = new Thread() {
            public void run() {
                try {
                    sleep(4500);
                } catch (Exception exp) {
                    exp.printStackTrace();
                } finally {
                    Intent intent = new Intent(splashScreen.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        thread.start();
    }
}