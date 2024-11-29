package com.example.trabajocochesapi;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CocheDAO {
    @Query("select * from cocheentity")
    LiveData<List<CocheEntity>> getCoches();

    @Insert
    void addCoche(CocheEntity movie);

    @Insert
    void addCoches(List<CocheEntity> movies);

    @Delete
    void deleteCoches(CocheEntity movie);

    @Query("DELETE FROM cocheentity")
    void deleteCoches();
}

