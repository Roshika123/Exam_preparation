package com.example.exampreparation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        //System.out.println("Splash screen=====");
        ImageView imageView = findViewById ( R.id.ImageView );
        Animation animation = AnimationUtils.loadAnimation ( getApplicationContext (), R.anim.fade );
        imageView.startAnimation ( animation );


        Thread timer = new Thread (  ){


            @Override
            public void run() {

                try {
                    sleep ( 3500 );
                    Intent intent = new Intent ( getApplicationContext (), LoginActivity.class );
                    startActivity ( intent );
                    finish ();
                   super.run ( );
                } catch (InterruptedException e){
                    //System.out.println("Exception=====");
                    e.printStackTrace ();
                }


            }
        };
        timer.start ();

    }
}
