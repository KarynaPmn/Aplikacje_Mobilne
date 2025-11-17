package com.example.myapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText et_name, et_surname, et_email, et_password, et_repeatPassword;
    Button btn_login, btn_help;
//    ListView view_people;
    ArrayAdapter<Person> peopleArrayAdapter;

    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        et_name = findViewById(R.id.et_name);
        et_surname = findViewById(R.id.et_surname);
        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
        et_repeatPassword = findViewById(R.id.et_repeatPassword);

        btn_login = findViewById(R.id.btn_login);
        btn_help = findViewById(R.id.btn_help);
//        view_people = findViewById(R.id.view_people);

        PeopleManager peopleManager = new PeopleManager(this);
        List<Person> peopleList = peopleManager.getAllPeople();

        db = new DatabaseHelper(MainActivity.this);

        peopleArrayAdapter = new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                peopleList
        );
//        view_people.setAdapter(peopleArrayAdapter);

        btn_login.setOnClickListener(v -> {
            String name = et_name.getText().toString();
            String surname = et_surname.getText().toString();
            String email = et_email.getText().toString();
            String password = et_password.getText().toString();

            if (    !name.isEmpty() &&
                    !surname.isEmpty() &&
                    !email.isEmpty() &&
                    !password.isEmpty() &&
                    password.equals(et_repeatPassword.getText().toString())
            ) {
                Person newPerson = new Person(name, surname, email, password);

                // Odswierzenie adaptera
                if (peopleManager.addPerson(newPerson)) {
                    peopleList.add(newPerson);
                    peopleArrayAdapter.notifyDataSetChanged();
                }

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("user_data", newPerson);
                startActivity(intent);
            }
        });
    }
}