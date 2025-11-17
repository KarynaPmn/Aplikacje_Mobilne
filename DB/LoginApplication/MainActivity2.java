package com.example.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    TextView tv_name;
    ListView lv_people;

    List<Person> people;
    ArrayAdapter<Person> peopleArrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lv_people = findViewById(R.id.lv_people);
        PeopleManager peopleManager = new PeopleManager(this);
        people = peopleManager.getAllPeople();
        peopleArrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                people
        );
        lv_people.setAdapter(peopleArrayAdapter);

        tv_name = findViewById(R.id.tv_name);
        Person person = (Person) getIntent().getSerializableExtra("user_data");
        tv_name.setText(person.getName());

    }
}