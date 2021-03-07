package com.example.tp3;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PlanningEntityDao {
    @Query("SELECT * FROM PlanningEntity")

    List<PlanningEntity> getAll();

    @Query("SELECT * FROM PlanningEntity WHERE soir LIKE :first AND " +
           " matin LIKE :last LIMIT 1")
    PlanningEntity findByName(String first, String last);


    @Query("SELECT * FROM PlanningEntity WHERE id LIKE :id LIMIT 1")
    PlanningEntity findById(int id);

    @Query("SELECT * FROM PlanningEntity WHERE matin LIKE :matin LIMIT 1")
    PlanningEntity findByMatin(String matin);

    @Insert
    void insertAll(PlanningEntity... planningEntities);


    @Delete
    void delete(PlanningEntity planing);

    @Query("SELECT * FROM PlanningEntity ORDER BY id ASC")
    List<PlanningEntity> getAlphabetizedWords();

    @Query("DELETE FROM PlanningEntity")
    void deleteAll();
}
