package com.maicondcastro.theswitcher.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DivisionDao {

    @Insert
    void insert(Division division);

    @Update
    void update(Division division);

    @Delete
    void delete(Division division);

    @Query("SELECT * FROM Division")
    List<Division> getDivisions();
}
