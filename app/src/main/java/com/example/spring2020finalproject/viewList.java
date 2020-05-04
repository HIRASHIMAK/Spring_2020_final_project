package com.example.spring2020finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class viewList extends AppCompatActivity {
    public static int index = -1;
    private RecyclerView taskListRecyclerView;
    private RecyclerView.Adapter taskListViewAdapter;
    private RecyclerView.LayoutManager tasksViewLayoutManager;
    private Button completeRemovalButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_list);
        buildTaskRecyclerView();
        configureBackButton();

        //Below removes the desired completed task from view_list screen
        completeRemovalButton = findViewById(R.id.removeCompleteButton);
        completeRemovalButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (!(index > MainActivity.taskList.size()) && !(index < 0)) {
                    MainActivity.taskList.remove(index);
                    taskListViewAdapter.notifyItemRemoved(index);
                }
                index = -1;
            }
        });
    }

    /**
     * configureBackButton will switch from viewList activity to Main activity
     */
    private void configureBackButton() {
        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void buildTaskRecyclerView() {
        //Assigns value to the RecyclerView
        taskListRecyclerView = findViewById(R.id.tasksView);
        taskListRecyclerView.setHasFixedSize(true);
        //Assigns value to private instance variable LayoutManager
        tasksViewLayoutManager = new LinearLayoutManager(this);
        //Assigns value to private instance variable Adapter
        taskListViewAdapter = new TaskListAdapter(MainActivity.taskList);
        // Sets the manager and adapter for RecyclerView
        taskListRecyclerView.setLayoutManager(tasksViewLayoutManager);
        taskListRecyclerView.setAdapter(taskListViewAdapter);
    }
}
