package com.example.myapplication;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

public class PeopleManager {
    private DatabaseHelper db;

    public PeopleManager(Context context) {
        db = new DatabaseHelper(context);
    }

    public List<Person> getAllPeople() {
        List<Person> peopleList = new ArrayList<>();
        Cursor cursor = db.getAllPeople();
        while (cursor.moveToNext()) {
            peopleList.add(new Person(
                    cursor.getInt(0),
                    cursor.getString(1), // String name = c.getString(c.getColumnIndex("first_name"));
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4)
            ));
        }
        cursor.close();

        return peopleList;
    }

    public boolean addPerson(Person person) {
        long result = db.addPerson(
                person.getName(),
                person.getSurname(),
                person.getEmail(),
                person.getPassword()
        );

        return result != -1;
    }

    public boolean updatePerson(Person person) {
        return db.updatePerson(person.getId(), person.getName(), person.getSurname(), person.getEmail(), person.getPassword()) > 0;
    }

    public boolean deletePerson(int id) {
        return db.deletePerson(id) > 0;
    }
}
