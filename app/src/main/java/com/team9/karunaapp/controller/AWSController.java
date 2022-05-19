package com.team9.karunaapp.controller;

import android.util.Log;

import com.amplifyframework.auth.AuthUserAttribute;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.LocatedPersons;
import com.team9.karunaapp.model.LocatedPerson;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class AWSController {


    public ArrayList<AuthUserAttribute> getAwsUserAttributes() {

        Amplify.Auth.getCurrentUser();

        AtomicReference<List<AuthUserAttribute>> test = new AtomicReference<>(new ArrayList<AuthUserAttribute>());

        Amplify.Auth.fetchUserAttributes(
                result -> {
                    test.set(result);
                    Log.i("Test", result.toString()); },
                error -> Log.e("Test", error.toString())
        );

        return (ArrayList<AuthUserAttribute>) test.get();

    }

    public void createLocatedPerson(LocatedPerson person) {

        //Temporal.Date date = new Temporal.Date("1970-01-01Z");
        /*
        LocatedPersons item = LocatedPersons.builder()
                .surname(person.getSurname())
                .firstName(person.getFirstName())
                .dateEntered(person.getDateEntered())
                .location(person.getLocation())
                .status(person.getStatus())
                .hasPhoto(person.getHasPhoto())
                .uploadedByUser(person.getUploadedBy())
                .disasterId(person.getDisasterId())
                .build();
        Amplify.DataStore.save(
                item,
                success -> Log.i("Amplify", "Saved item: " + success.item().getId()),
                error -> Log.e("Amplify", "Could not save item to DataStore", error)
        );
         */

        LocatedPersons item = LocatedPersons.builder()
                .uploadedByUsersId("a3f4095e-39de-43d2-baf4-f8c16f0f6f4d")
                .disasterId("a3f4095e-39de-43d2-baf4-f8c16f0f6f4d")
                .surname("Lorem ipsum dolor sit amet")
                .firstName("Lorem ipsum dolor sit amet")
                .dateEntered(person.getDateEntered())
                .location("Lorem ipsum dolor sit amet")
                .status("Lorem ipsum dolor sit amet")
                .hasPhoto(true)
                .build();
        Amplify.DataStore.save(
                item,
                success -> Log.i("Amplify", "Saved item: " + success.item().getId()),
                error -> Log.e("Amplify", "Could not save item to DataStore", error)
        );

    }
}
