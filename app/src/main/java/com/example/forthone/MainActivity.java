package com.example.forthone;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;

    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button_OK);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = findViewById(R.id.txt_hello2);
                text.setText("Venas una !");
            }
        });

        textView = findViewById(R.id.aloha);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {  // ✅ Fixed method name (onClick)
                textView.setText("Hai hai");
                textView.setBackgroundColor(Color.parseColor("#FFFFFF")); // ✅ Fixed color format
            }
        });

        final Intent intent = new Intent(this, MainActivity2.class);
        String name = "Rusira T.T" ;
        int age = 25 ;

        intent.putExtra("USER_NAME", name);
        intent.putExtra("USER_AGE", age);

        button = findViewById(R.id.btn_goto);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });




    }
}
