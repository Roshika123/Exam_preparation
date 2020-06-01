package com.example.exampreparation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class QuizActivity extends AppCompatActivity {

    private Button quizbtn1;
    private Button quizbtn2;
    private Button quizbtn3;
    private Button quizbtn4;
    private Button quizbtn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_quiz );
// for showing back pressed arrow
        //getSupportActionBar ().setDisplayShowHomeEnabled ( true );
        //getSupportActionBar ().setDisplayHomeAsUpEnabled ( true );


        quizbtn1 = findViewById ( R.id.quizbtn1 );
        quizbtn2 = findViewById ( R.id.quizbtn2 );
        quizbtn3 = findViewById ( R.id.quizbtn3 );
        quizbtn4 = findViewById ( R.id.quizbtn4 );
        quizbtn5 = findViewById ( R.id.quizbtn5 );

        quizbtn1.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Intent categoryIntent = new Intent ( QuizActivity.this, QuizActivity1.class );
                startActivity ( categoryIntent );
                finish ();
            }
        } );

        quizbtn2.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent ( QuizActivity.this, QuizActivity2.class );
                startActivity ( intent );
                finish ();
            }
        } );
        quizbtn3.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent ( QuizActivity.this, QuizActivity3.class );
                startActivity ( intent );
                finish ();
            }
        } );

        quizbtn4.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent ( QuizActivity.this, QuizActivity4.class );
                startActivity ( intent );
                finish ();
            }
        } );

        quizbtn5.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent ( QuizActivity.this, QuizActivity5.class );
                startActivity ( intent );
                finish ();
            }
        } );

    }





// back pressed


    @Override
    public void onBackPressed() {

        Intent intent = new Intent ( QuizActivity.this, HomeActivity.class );
        startActivity ( intent );
        finish ();

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId ();
        if (id == android.R.id.home){

            Intent intent = new Intent ( QuizActivity.this, HomeActivity.class );
            startActivity ( intent );
            finish ();

        }

        return super.onOptionsItemSelected ( item );
    }


}
