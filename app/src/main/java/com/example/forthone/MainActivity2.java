package com.example.forthone;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @SuppressLint({"IntentReset", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);


        Button button;
        Button email;
        Button dialing;
        TextView textUserName , textUserAge;

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.list_view), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        button = findViewById(R.id.btn_sscreen);
        textUserName = findViewById(R.id.txt_username);
        textUserAge = findViewById(R.id.txt_age);

        Intent intent = getIntent();
        String namee =  intent.getStringExtra("USER_NAME");
        int age = intent.getIntExtra("USER_AGE",0);

        textUserName.setText(namee);
        textUserAge.setText(String.valueOf(age));




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });


        Intent person = new Intent(Intent.ACTION_SEND);
        final Intent chooser;
        person.setData(Uri.parse("email:yogomax55@gmail.com"));
        person.putExtra(person.EXTRA_EMAIL,new String[]{"fefefef.com"});
        person.putExtra(person.EXTRA_SUBJECT,"subject meka bn subject eka");
        person.putExtra(person.EXTRA_TEXT,"message meka bn message eka");
        person.setType("text/plain");
        Intent.createChooser(person, "Select Email App");
        chooser = Intent.createChooser(person, "send Email App");


        email = findViewById(R.id.btn_email);
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            startActivity(chooser);
            }
        });

        Intent call = new Intent(Intent.ACTION_DIAL);
        call.setData(Uri.parse("tel:0712345678"));
// No need to set the type to "text/plain"
        Intent choosing = Intent.createChooser(call, "Select Call App"); // Store the chooser Intent

        dialing = findViewById(R.id.btn_call);
        dialing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(choosing); // Start the chooser Intent
            }
        });


        final Intent page3 = new Intent(this, MainActivity3.class);


        button = findViewById(R.id.btn_page3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(page3);
            }
        });


        final Intent page4 = new Intent(this, MainActivity4.class);


        button = findViewById(R.id.btn_page4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(page4);
            }
        });

    }
}