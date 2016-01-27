package com.amstudios.bulksmssender;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

/**
 * Created by Asad-PC on 1/27/2016.
 */
public class SplashActivity extends Activity {

    private final int SPLASH_DISPLAY_LENGTH = 4000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView rotate_image =(ImageView) findViewById(R.id.splashscreen);
        RotateAnimation rotate = new RotateAnimation(30, 360, Animation.RELATIVE_TO_PARENT, 0.5f,  Animation.RELATIVE_TO_PARENT, 0.5f);
        rotate.setDuration(2500);
        rotate_image.startAnimation(rotate);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(SplashActivity.this, SMSActivity.class);
                startActivity(mainIntent);
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
