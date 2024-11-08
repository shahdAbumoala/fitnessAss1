package com.example.fitnessass1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class information extends AppCompatActivity {
//private ImageButton imgtable ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_information);

       // imgtable = findViewById(R.id.imgtable);



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onclickdumb(View view) {
        //String msg = "Hello" + edtusername.getText().toString();
        Intent intent = new Intent(this, sports.class);
        // intent.putExtra("data" , msg);
        startActivity(intent);
    }
}

//Based on the information you entered previously, and since your goal is to lose weight, the calories your body needs daily are 2000 calories.