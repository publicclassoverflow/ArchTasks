package com.coollime.archtasks;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.coollime.archtasks.database.AppDatabase;
import com.coollime.archtasks.database.TaskEntry;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    // Logging constant
    private static final String TAG = MainViewModel.class.getSimpleName();

    // LiveData object of a list of TaskEntry objects
    private LiveData<List<TaskEntry>> tasks;

    public MainViewModel(@NonNull Application application) {
        super(application);
        // Get the instance of the database and load all the tasks in it
        AppDatabase database = AppDatabase.getInstance(this.getApplication());
        Log.d(TAG, "Actively retrieving the tasks from the database");
        tasks = database.taskDao().loadAllTasks();
    }

    /**
     * The ViewModel will get the tasks instead of having the MainActivity retrieving them directly
     */
    public LiveData<List<TaskEntry>> getTasks() {
        return tasks;
    }
}
