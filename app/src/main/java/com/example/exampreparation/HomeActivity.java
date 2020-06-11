package com.example.exampreparation;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.muddzdev.styleabletoastlibrary.StyleableToast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class HomeActivity extends AppCompatActivity {

    private Button startbtn1;
    private Button startbtn2;
    private Button startbtn3;
    private Button startbtn4;
    private Button startbtn5;
    private Button startbtn6;

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_home );

        startbtn1 = findViewById ( R.id.startbtn1 );

        startbtn1.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Intent categoryIntent = new Intent ( HomeActivity.this, CategoryActivity.class );
                startActivity ( categoryIntent );
                finish ();
            }
        } );

        startbtn2 = findViewById ( R.id.startbtn2 );

        startbtn2.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent ( HomeActivity.this, QuizActivity.class );
                startActivity ( intent );
                finish ();
            }
        } );



        startbtn3 = findViewById ( R.id.startbtn3 );

        startbtn3.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Intent categoryIntent = new Intent ( HomeActivity.this, FullFormActivity.class );
                startActivity ( categoryIntent );
                finish ();
            }
        } );

        startbtn4 = findViewById ( R.id.startbtn4 );

        startbtn4.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Intent categoryIntent = new Intent ( HomeActivity.this, ShortcutKeysActivity.class );
                startActivity ( categoryIntent );
                finish ();
            }
        } );

        startbtn5 = findViewById ( R.id.startbtn5 );

        startbtn5.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Intent categoryIntent = new Intent ( HomeActivity.this, ImportantQuestionsActivity.class );
                startActivity ( categoryIntent );
                finish ();
            }
        } );

        startbtn6 = findViewById ( R.id.startbtn6 );

        startbtn6.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Intent categoryIntent = new Intent ( HomeActivity.this, CProgrammingActivity.class );
                startActivity ( categoryIntent );
                finish ();
            }
        } );



        Toolbar toolbar = findViewById ( R.id.toolbar );
        setSupportActionBar ( toolbar );

        final DrawerLayout drawer = findViewById ( R.id.drawer_layout );
        NavigationView navigationView = findViewById ( R.id.nav_view );
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder (
                R.id.nav_home, R.id.nav_study,R.id.nav_quiz, R.id.nav_logout)
                .setDrawerLayout ( drawer )
                .build ( );
        NavController navController = Navigation.findNavController ( this, R.id.nav_host_fragment );
        NavigationUI.setupActionBarWithNavController ( this, navController, mAppBarConfiguration );
        NavigationUI.setupWithNavController ( navigationView, navController );

        navigationView.bringToFront ();

        navigationView.setNavigationItemSelectedListener ( new NavigationView.OnNavigationItemSelectedListener ( ) {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId ())

                {
                    case R.id.nav_home:
                    break;


                    case R.id.nav_study:
                        Intent i = new Intent ( HomeActivity.this, CategoryActivity.class );
                        startActivity ( i );
                        break;

                    case R.id.nav_quiz:
                        Intent j = new Intent ( HomeActivity.this, QuizActivity.class );
                        startActivity ( j );
                        break;

                    case R.id.nav_logout:
                        FirebaseAuth.getInstance().signOut();
                        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();

                        

                }
                drawer.closeDrawers ();
                return false;
            }
        } );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater ( ).inflate ( R.menu.home, menu );
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController ( this, R.id.nav_host_fragment );
        return NavigationUI.navigateUp ( navController, mAppBarConfiguration )
                || super.onSupportNavigateUp ( );
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId ();

        if (id  == R.id.action_privacy) {

            Intent intent = new Intent ( HomeActivity.this, PolicyActivity.class );
            startActivity ( intent );
            finish ();

            return true;
        }
        else
            if (id  == R.id.action_about){

                StyleableToast.makeText ( getApplicationContext (), "Developer",R.style.rightToast ).show ();
                return true;
            }

            else
            if (id  == R.id.action_contact){

                StyleableToast.makeText ( getApplicationContext (), "dangalroshika123@gmail.com",R.style.rightToast ).show ();
                return true;
            }


            else


        return super.onOptionsItemSelected ( item );
    }
}
