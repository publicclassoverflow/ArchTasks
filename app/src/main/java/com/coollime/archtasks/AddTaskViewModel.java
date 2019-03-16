package com.coollime.archtasks;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.coollime.archtasks.database.AppDatabase;
import com.coollime.archtasks.database.TaskEntry;

public class AddTaskViewModel extends ViewModel {
    // LiveData object of a single TaskEntry object
    private LiveData<TaskEntry> task;

    public AddTaskViewModel(AppDatabase database, int taskId) {
        // The constructor uses taskDao to load the task specified by its id
        task = database.taskDao().loadTaskById(taskId);
    }

    public LiveData<TaskEntry> getTask() {
        return task;
    }
}
