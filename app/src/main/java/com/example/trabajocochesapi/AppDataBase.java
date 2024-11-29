package com.example.trabajocochesapi;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {CocheEntity.class}, version = 1 ,exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {

    private static AppDataBase INSTANCE;

    public static AppDataBase getDatabase(Context context) {

        if (INSTANCE == null) {

            INSTANCE =
                    Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDataBase.class, "db"
                    ).build();

        }
        return INSTANCE;

    }

    public abstract CocheDAO getCocheDao();
}

