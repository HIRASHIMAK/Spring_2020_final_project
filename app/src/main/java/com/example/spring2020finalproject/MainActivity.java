package com.example.spring2020finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Below switches the screen to the view_list screen.
        Button viewListButton = findViewById(R.id.viewListButton);
        viewListButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), viewList.class);
                startActivity(intent);
            }
        });

        //Below handles the case when "Add task" button is hit
        Button addTaskButton = findViewById(R.id.addTaskButton);
        addTaskButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                // Create a string of task summary.
                EditText taskSummary = findViewById(R.id.taskSummaryText);
                String task = taskSummary.getText().toString();
                //Create a string array of month, date, and year of the due date in that order.
                EditText dueDateText = findViewById(R.id.dateText);
                String[] dueDate = dueDateText.getText().toString().split("/");
                //Create a string of due date.
                EditText timeText = findViewById(R.id.timeText);
                String dueTime = timeText.getText().toString();
            }
        });

    }
}