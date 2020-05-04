package com.example.spring2020finalproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.TaskViewHolder> {
    private ArrayList<TaskItem> tasksList;

    public static class TaskViewHolder extends RecyclerView.ViewHolder {
        public TextView taskSummary;
        public TextView dueDate;
        public TextView dueTime;
        public Button removeTask;

        public TaskViewHolder(View itemView) {
            super(itemView);
            taskSummary = itemView.findViewById(R.id.taskTextView);
            dueDate = itemView.findViewById(R.id.dueDateTextView);
            dueTime = itemView.findViewById(R.id.dueTimeTextView);
            removeTask = itemView.findViewById(R.id.removeTaskButton);
        }
    }

    public TaskListAdapter(ArrayList<TaskItem> setTaskList) {
        tasksList = setTaskList;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item, parent, false);
        TaskViewHolder taskListViewHolder = new TaskViewHolder(v);
        return taskListViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final TaskViewHolder holder, final int position) {
        final TaskItem currentItem = MainActivity.taskList.get(position);
        holder.taskSummary.setText(currentItem.getTask());
        holder.dueDate.setText(currentItem.getDueDate());
        holder.dueTime.setText(currentItem.getDueTime());
        // Below is currently under development.
        holder.removeTask.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                viewList.index = MainActivity.taskList.indexOf(currentItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tasksList.size();
    }
}
