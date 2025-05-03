package com.example.forthone;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity4 extends AppCompatActivity {

    ListView listView ;
    String[] medicine = new String[]{"panadol" , "Parasitamol" , "Amoxilin" , "hasankaBEHETh" , "GEthwanBheth" };
    String[] location = new String[]{"Colombo","Jaffna","Kandy","Galle","Matara"};
    int image [] = {R.drawable.a , R.drawable.b , R.drawable.c , R.drawable.d , R.drawable.e};

    Button add ;
    TextView count ;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        CustomAdapter adapter = new CustomAdapter(this,medicine,image,location);

        context = this;

        listView = findViewById(R.id.list_final);
        listView.setAdapter(adapter);
        add = findViewById(R.id.btn_addTODO2);
        count = findViewById(R.id.txt_count);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,MainActivity3.class));
            }
        });

    }



    
}


class CustomAdapter extends ArrayAdapter<String> {

    Context context;
    int[] image;
    String[] medicine;
    String[] loc;

    CustomAdapter(Context context,String[] medicine , int[] image , String[] loc){
        super(context,R.layout.list_item,R.id.txt_medicine,medicine);
        this.context = context;
        this.image = image;
        this.medicine = medicine;
        this.loc = loc;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View row =  inflater.inflate(R.layout.list_item,parent,false);
        ImageView imageView = row.findViewById(R.id.image_icon);
        TextView medicines = row.findViewById(R.id.txt_medicine);
        TextView locations = row.findViewById(R.id.txt_location);
        Button button = row.findViewById(R.id.button);
        Button button2 = row.findViewById(R.id.button2);

        imageView.setImageResource(image[position]);
        medicines.setText(medicine[position]);
        locations.setText(loc[position]);

        return row;
    }


}