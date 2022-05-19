package com.team9.karunaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.amplifyframework.auth.AuthUserAttribute;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.core.model.temporal.Temporal;
import com.amplifyframework.datastore.generated.model.LocatedPersons;
import com.team9.karunaapp.controller.AWSController;
import com.team9.karunaapp.model.LocatedPerson;

import java.util.ArrayList;
import java.util.List;


public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);
    }


    public void testButton(View view) {

        Temporal.Date date = new Temporal.Date("2022-04-30Z");
        LocatedPerson person = new LocatedPerson(
                date,
                "Robertson",
                "Drew",
                "sydney",
                "active",
                true,
                "teely@gmail.com",
                "1"
        );

        AWSController awsController = new AWSController();
        //awsController.createLocatedPerson(person);
        ArrayList<AuthUserAttribute> drew = awsController.getAwsUserAttributes();

        drew.toString();

    }
}