package com.example.exampreparation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class FullFormActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_full_form );

       // getSupportActionBar ().setDisplayShowHomeEnabled ( true );
        //getSupportActionBar ().setDisplayHomeAsUpEnabled ( true );

        webView = findViewById ( R.id.webView );
        webView.setWebViewClient ( new WebViewClient () );
        webView.loadUrl ( "file:///android_asset/Full Forms.html" );

        WebSettings webSettings = webView.getSettings ();
        webSettings.setJavaScriptEnabled ( true );

        webView.getSettings ().setBuiltInZoomControls ( true );
        webView.getSettings ().setDisplayZoomControls ( false );

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent ( FullFormActivity.this, HomeActivity.class );
        startActivity ( intent );
        finish ();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id =item.getItemId ();
        if (id == android.R.id.home){

            Intent intent = new Intent ( FullFormActivity.this, HomeActivity.class );
            startActivity ( intent );
            finish ();

        }

        return super.onOptionsItemSelected ( item );
    }
}
