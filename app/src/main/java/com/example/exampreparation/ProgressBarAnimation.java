package com.example.exampreparation;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProgressBarAnimation extends Animation {

    private Context context;
    private ProgressBar progressBar;
    private TextView textView;
    private float from;
    private float to;

    public ProgressBarAnimation(Context context1, ProgressBar progressBar, TextView textView1, float from, float to){

        this.context = context1;
        this.progressBar = progressBar;
        this.textView = textView1;
        this.from = from;
        this.to = to;

    }
//override methods
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {

        super.applyTransformation ( interpolatedTime, t );
        float value = from + (to - from ) * interpolatedTime;
        progressBar.setProgress ( (int) value );
        textView.setText ( (int) value+"%" );

    }
}
