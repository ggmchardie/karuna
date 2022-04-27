package com.team9.karunaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.amplifyframework.core.Amplify;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Amplify.Auth.signInWithWebUI(
                this,
                result -> {
                    Intent intent = new Intent(this, MainScreen.class);
                    Log.i("AuthQuickStart", result.toString());
                    startActivity(intent);
                },
                error -> Log.e("AuthQuickStart", error.toString())
        );

        Amplify.Auth.fetchAuthSession(
                result -> Log.i("AmplifyQuickstart", result.toString()),
                error -> Log.e("AmplifyQuickstart", error.toString())
        );
    }
}