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

public class QuizActivity3 extends AppCompatActivity {

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
        list.add ( new QuestionModel ( " The tracks on a disk which can be accessed without repositioning the R/W heads is ", "Surface", "Cylinder", "Cluster", "All of the above", "Cylinder" ) );
        list.add ( new QuestionModel ( " Which of the following is the 1's complement of 10 ?", "01", "110", "11", "10", "01" ) );
        list.add ( new QuestionModel ( " A section of code to which control is transferred when a processor is interrupted is known as", "M", "SVC", "IP", "MDR", "M" ) );
        list.add ( new QuestionModel ( "Which part interprets program instructions and initiate control operations  ?", "Input", "Storage unit", "Logic unit", "Control unit", "Control unit" ) );
        list.add ( new QuestionModel ( "The binary system uses powers of", "2", "10", "8", "16", "2" ) );

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
                    Intent scoreIntent = new Intent ( QuizActivity3.this, ScoreActivity.class );
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
        Intent intent = new Intent ( QuizActivity3.this, QuizActivity.class );
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
