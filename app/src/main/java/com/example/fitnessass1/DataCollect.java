package com.example.fitnessass1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DataCollect extends AppCompatActivity {
    private TextView textname ;
    private EditText edtheight ;
    private EditText edtweight ;
    private EditText edtage ;
    private RadioGroup radiogroup1;
     int Equation ;
    String selectedText ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_data_collect);

        edtheight = findViewById(R.id.edtheight);
        edtweight = findViewById(R.id.edtweight);
        edtage = findViewById(R.id.edtage);
        radiogroup1 = findViewById(R.id.radiogroup1);

        String heightStr = edtheight.getText().toString();
        String weightStr = edtweight.getText().toString();
        String ageStr = edtage.getText().toString();

        int height = Integer.parseInt(heightStr);
        int weight = Integer.parseInt(weightStr);
        int age = Integer.parseInt(ageStr);

         Equation = 10 * weight + (int)(6.25 * height) - 5 * age +5;

        radiogroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton selectedRadioButton = findViewById(checkedId);
                selectedText = selectedRadioButton.getText().toString();
                //Toast.makeText(MainActivity.this, "Selected: " + selectedText, Toast.LENGTH_SHORT).show();
            }
        });


        Intent intent = getIntent();
        textname = findViewById(R.id.textname);
        String msg = intent.getStringExtra("data");
        String msg2 = "Hi " + msg ;
        textname.setText(msg2);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onclickDone(View view) {
        String msg = Equation + "";
        String msg2 = "Based on the information you entered previously, and since your goal is to " +  selectedText + " , the calories your body needs daily are " + Equation +"calories.";
        Intent intent = new Intent(this, information.class);
        intent.putExtra("data" , msg);
        startActivity(intent);
    }
}