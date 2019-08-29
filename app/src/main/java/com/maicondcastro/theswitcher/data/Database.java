package com.maicondcastro.theswitcher.data;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.maicondcastro.theswitcher.model.Division;
import com.maicondcastro.theswitcher.model.DivisionDao;

@androidx.room.Database(entities = Division.class, version = 1)
abstract class Database extends RoomDatabase {

    abstract DivisionDao divisionDao();

    private static Database instance = null;

    static Database getInstance(Context context) {
        if (instance == null) {
            synchronized (Database.class) {
                instance = Room.databaseBuilder(context.getApplicationContext(), Database.class, "database")
                        .fallbackToDestructiveMigration()
                        .build();
            }
        }
        return instance;
    }
}
