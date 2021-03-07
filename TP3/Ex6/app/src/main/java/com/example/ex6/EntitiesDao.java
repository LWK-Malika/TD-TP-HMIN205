package com.example.ex6;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Query;
import androidx.room.Insert;
import androidx.lifecycle.LiveData;

import java.util.List;

@Dao
public interface EntitiesDao {
    @Query("SELECT * FROM PlanningEntite")

    List<PlanningEntite> getAll();

    @Query("SELECT * FROM PlanningEntite WHERE soir LIKE :first AND " +
            " matin LIKE :last LIMIT 1")
    PlanningEntite findByName(String first, String last);


    @Query("SELECT * FROM PlanningEntite WHERE id LIKE :id LIMIT 1")
    PlanningEntite findById(int id);

    @Query("SELECT * FROM PlanningEntite WHERE matin LIKE :matin LIMIT 1")
    PlanningEntite findByMatin(String matin);

    @Insert
    void insertAll(PlanningEntite... planningEntities);


    @Delete
    void delete(PlanningEntite planing);

    @Query("SELECT * FROM PlanningEntite ORDER BY id ASC")
    List<PlanningEntite> getAlphabetizedWords();

    @Query("DELETE FROM PlanningEntite")
    void deleteAll();


}
