package com.coollime.archtasks;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.coollime.archtasks.database.AppDatabase;

public class AddTaskViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final AppDatabase mDb;
    private final int mTaskId;

    public AddTaskViewModelFactory(AppDatabase mDb, int mTaskId) {
        this.mDb = mDb;
        this.mTaskId = mTaskId;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        // Factory functionality here
        return (T) new AddTaskViewModel(mDb, mTaskId);
    }
}
