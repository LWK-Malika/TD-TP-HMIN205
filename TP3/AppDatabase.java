package com.example.tp3;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {PlanningEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PlanningEntityDao planningEntityDao();

    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

}
