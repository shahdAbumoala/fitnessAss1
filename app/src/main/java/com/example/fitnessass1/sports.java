package com.example.fitnessass1;

import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class sports extends AppCompatActivity {
private ListView lvProgram ;
    String[] programName = {"Puch Up", "Squat", "Modified Set Up", "Android"};
    String[] programDescription = {"C Description", "C++ Description", "Java Description",
            "Android Description"};
    // Define an integer array to hold the image recourse ids
    int[] programImages = {R.drawable.pushup, R.drawable.squat2,
            R.drawable.modifiedsetup1, R.drawable.facepullcable};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sports);

        lvProgram = findViewById(R.id.lvProgram);
        // Specify an adapter and pass context along with all the arrays in constructor
        PogramAdapter programAdapter = new PogramAdapter(this, programName, programImages, programDescription);
        //ProgramAdapter programAdapter = new ProgramAdapter(this, programName, programImages, programDescription, urls);

        // Set the adapter with the ListView
        lvProgram.setAdapter(programAdapter);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}

