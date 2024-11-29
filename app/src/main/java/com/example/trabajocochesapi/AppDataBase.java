package com.example.trabajocochesapi;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {CocheEntity.class}, version = 1 ,exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {

    //Aqui usamos el singleton como dijiste.
    private static AppDataBase INSTANCE;

    public static AppDataBase getDatabase(Context context) {

        if (INSTANCE == null) {
            //Si es nulo la creamos
            INSTANCE =
                    Room.databaseBuilder(
                            context.getApplicationContext(), //esto es el contexto
                            AppDataBase.class, "db"     //esto es la clase de la base de datos
                    ).build();

        }
        return INSTANCE;

    }

    public abstract CocheDAO getCocheDao();
}

