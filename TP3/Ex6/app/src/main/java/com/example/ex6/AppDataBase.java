package com.example.ex6;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Database(entities = {PlanningEntite.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase  {

    public abstract EntitiesDao EntitiesDao();

    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);



}
