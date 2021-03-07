package com.example.ex6;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class PlanningEntite {

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
