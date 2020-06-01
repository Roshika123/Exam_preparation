package com.example.exampreparation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class CProgrammingActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_c_programming );

        getSupportActionBar ().setDisplayShowHomeEnabled ( true );
        getSupportActionBar ().setDisplayHomeAsUpEnabled ( true );

        webView = findViewById ( R.id.webView );
        webView.setWebViewClient ( new WebViewClient () );
        webView.loadUrl ( "file:///android_asset/C Programming.html" );

        WebSettings webSettings = webView.getSettings ();
        webSettings.setJavaScriptEnabled ( true );

        webView.getSettings ().setBuiltInZoomControls ( true );
        webView.getSettings ().setDisplayZoomControls ( false );

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent ( CProgrammingActivity.this, HomeActivity.class );
        startActivity ( intent );
        finish ();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id =item.getItemId ();
        if (id == android.R.id.home){

            Intent intent = new Intent ( CProgrammingActivity.this, HomeActivity.class );
            startActivity ( intent );
            finish ();

        }

        return super.onOptionsItemSelected ( item );

    }
}
