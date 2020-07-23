package com.example.exampreparation;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.muddzdev.styleabletoastlibrary.StyleableToast;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity5 extends AppCompatActivity {

    private TextView question, no_counter;
    private LinearLayout options_layout;
    private Button next_btn;
    private int count = 0;
    private List<QuestionModel> list;
    private int position = 0;
    private int score;
    //private Button correctoption;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_quiz1 );

        // correctoption = findViewById ( R.id.button1 );

        question = findViewById ( R.id.question );
        no_counter = findViewById ( R.id.no_counter );
        options_layout = findViewById ( R.id.optionsLayout );
        next_btn = findViewById ( R.id.nextButton );

        list = new ArrayList<> ( );
        //String optionA;
        list.add ( new QuestionModel ( " Any type of storage that is used for holding information between steps in its processing is ", "CPU", "Primary storage", "Intermediate storage", "Internal storage", "Intermediate storage" ) );
        list.add ( new QuestionModel ( " A program component that allows structuring of a program in an unusual way is known as ", "Correlation", "Coroutine", "Diagonalization", "Quene", "Coroutine" ) );
        list.add ( new QuestionModel ( "The section of the CPU that selects, interprets and sees to the execution of program instructions", "Memory", "Register unit", "Control unit", "ALU", "Control unit" ) );
        list.add ( new QuestionModel ( "Which type of system puts the user into direct conversation with the computer through a keyboard ?", "Real time processing", "Interactive computer", "Batch processing", "Time sharing", "Interactive computer" ) );
        list.add ( new QuestionModel ( " A single packet on a data link is known as", "Path", "Frame", "Block", "Group", "Frame" ) );

        for (int i = 0; i < 4; i++) {
            options_layout.getChildAt ( i ).setOnClickListener ( new View.OnClickListener ( ) {
                @Override
                public void onClick(View view) {
                    checkAnswer ( (Button) view );
                }
            } );
        }

        playAnim ( question, 0, list.get ( position ).getQuestion ( ) );
        next_btn.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(android.view.View v) {
                next_btn.setEnabled ( false );
                next_btn.setAlpha ( 0.07f );
                enableOption ( true );
                position++;
                if (position == list.size ( )) {
                    Intent scoreIntent = new Intent ( QuizActivity5.this, ScoreActivity.class );
                    finish ( );
                    scoreIntent.putExtra ( "score", score );
                    scoreIntent.putExtra ( "total", list.size ( ) );
                    startActivity ( scoreIntent );
                    return;
                }

                count = 0;
                playAnim ( question, 0, list.get ( position ).getQuestion ( ) );

            }
        } );

    }
    // method created of enable option line no 69
    private void enableOption(boolean enable) {

        for (int i = 0; i < 4; i++) {
            options_layout.getChildAt ( i ).setEnabled ( enable );
            if (enable) {
                options_layout.getChildAt ( i ).setBackgroundTintList ( ColorStateList.valueOf ( Color.parseColor ( "#3d3636" ) ) );

            }
        }

    }
    //method created PlayAnim
    private void playAnim(final View view, final int value, final String data) {
        view.animate ( ).alpha ( value ).scaleX ( value ).scaleY ( 1 ).setDuration ( 500 ).setStartDelay ( 50 )
                .setInterpolator ( new DecelerateInterpolator ( ) ).setListener ( new Animator.AnimatorListener ( ) {
            @Override
            public void onAnimationStart(Animator animation) {

                if (value == 0 && count < 4) {
                    String option = "";
                    if (count == 0) {
                        option = list.get ( position ).getOptionA ( );
                    } else if (count == 1) {
                        option = list.get ( position ).getOptionB ( );
                    } else if (count == 2) {
                        option = list.get ( position ).getOptionC ( );
                    } else if (count == 3) {
                        option = list.get ( position ).getOptionD ( );
                    }

                    playAnim ( options_layout.getChildAt ( count ), 0, option );
                    count++;

                }

            }

            @Override
            public void onAnimationEnd(Animator animation) {

                if (value == 0) {
                    try {
                        ((TextView) view).setText ( data );
                        no_counter.setText ( position + 1 + "/" + list.size ( ) );
                    } catch (ClassCastException ex) {
                        ((Button) view).setText ( data );
                    }
                    view.setTag ( data );

                    playAnim ( view, 1, data );
                }

            }


            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        } );
    }
    // for back pressed
    @Override
    public void onBackPressed() {
        Intent intent = new Intent ( QuizActivity5.this, QuizActivity.class );
        startActivity ( intent );
        finish ();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//method created of checkAnswer// replacing view with selectedoption
    private void checkAnswer(Button selectedoption) {

        enableOption ( false );
        next_btn.setEnabled ( true );
        next_btn.setAlpha ( 1 );
        if (selectedoption.getText ( ).toString ( ).equals ( list.get ( position ).getCorrectAns ( ) )) {
            score++;
            selectedoption.setBackgroundTintList ( ColorStateList.valueOf ( Color.parseColor ( "#0e9913" ) ) );
            StyleableToast.makeText ( getApplicationContext ( ), "Right Answer", R.style.rightToast ).show ( );
        } else {
            selectedoption.setBackgroundTintList ( ColorStateList.valueOf ( Color.parseColor ( "#ff0000" ) ) );
            Button correctoption = (Button) options_layout.findViewWithTag ( list.get ( position ).getCorrectAns ( ) );
            //Button correctoption = (Button) options_layout.findViewById ( list.get ( position ).getCorrectAns ( ) );

            //correctoption.setBackgroundTintList ( ColorStateList.valueOf ( Color.parseColor ( "#0e9913" ) ) );

            StyleableToast.makeText ( getApplicationContext ( ), "Wrong Answer", R.style.wrongToast ).show ( );
        }



    }

}
