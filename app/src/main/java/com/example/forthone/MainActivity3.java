package com.example.forthone;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    Button btnSave , btnADD;
    EditText txtName , txtDesc;

    private DbHandler dbHandler;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.list_view), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Context context = this;
        dbHandler = new DbHandler(context);



        btnSave = findViewById(R.id.btn_addTODO);


        txtName = findViewById(R.id.ins_Name);
        txtDesc = findViewById(R.id.ins_desc);
        btnADD = findViewById(R.id.btn_desc);

        btnADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = txtName.getText().toString();
                String desc = txtDesc.getText().toString();
                long started = System.currentTimeMillis();
                ToDo toDo = new ToDo(title,desc,started,0);
                dbHandler.addToDo(toDo);
            }
        });

    }
}