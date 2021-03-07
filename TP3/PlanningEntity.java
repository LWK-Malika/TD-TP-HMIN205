package com.example.tp3;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class PlanningEntity {
    @PrimaryKey
    public int id;

    @ColumnInfo(name = "matin")
    public String matin;

    @ColumnInfo(name = "midi")
    public String midi;

    @ColumnInfo(name = "aprem")
    public String aprem;

    @ColumnInfo(name = "soir")
    public String soir;
}
