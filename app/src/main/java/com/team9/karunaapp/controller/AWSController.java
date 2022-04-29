package com.team9.karunaapp.controller;

import android.util.Log;

import com.amplifyframework.core.Amplify;
import com.amplifyframework.core.model.temporal.Temporal;
import com.amplifyframework.datastore.generated.model.LocatedPersons;
import com.team9.karunaapp.model.LocatedPerson;

public class AWSController {

    public void createLocatedPerson(LocatedPerson person) {

        //Temporal.Date date = new Temporal.Date("1970-01-01Z");
        LocatedPersons item = LocatedPersons.builder()
                .surname("Lorem ipsum dolor sit amet")
                .firstName("Lorem ipsum dolor sit amet")
                .dateEntered(person.getDate())
                .location("Lorem ipsum dolor sit amet")
                .status("Lorem ipsum dolor sit amet")
                .hasPhoto(true)
                .uploadedByUser("Lorem ipsum dolor sit amet")
                .disasterId("Lorem ipsum dolor sit amet")
                .build();
        Amplify.DataStore.save(
                item,
                success -> Log.i("Amplify", "Saved item: " + success.item().getId()),
                error -> Log.e("Amplify", "Could not save item to DataStore", error)
        );

    }
}
