package com.dextroxd.motoheaven;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Splash_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent in = new Intent(Splash_screen.this,MainActivity.class);
                startActivity(in);
                finish();
            }
        },2000);
        ImageView iv =  findViewById(R.id.image_view);
        iv.setAlpha(0f);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(iv,"alpha",0f,1f);
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(iv,"translationY",50,0);
        objectAnimator.setDuration(300);
        objectAnimator1.setDuration(300);
        objectAnimator.start();
        objectAnimator1.start();
    }
}
