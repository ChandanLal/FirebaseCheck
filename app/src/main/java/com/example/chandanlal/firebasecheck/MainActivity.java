package com.example.chandanlal.firebasecheck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.Member;

public class MainActivity extends AppCompatActivity {
        EditText name, age,height,number;
        Button save;
        DatabaseReference reff;
            member member;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        height = findViewById(R.id.height);
        number = findViewById(R.id.phone);
        save = findViewById(R.id.save);
        reff = FirebaseDatabase.getInstance().getReference().child("Member");
        member = new member();
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int ages= Integer.parseInt(age.getText().toString().trim());
                Float hit = Float.parseFloat(height.getText().toString().trim());
                Long phn = Long.parseLong(number.getText().toString().trim());
                member.setName(name.getText().toString().trim());
                member.setAge(ages);
                member.setHt(hit);
                member.setPh(phn);
                reff.push().setValue(member);
                Toast.makeText(MainActivity.this    ,"table create",Toast.LENGTH_LONG).show();
            }
        });

    }
}
