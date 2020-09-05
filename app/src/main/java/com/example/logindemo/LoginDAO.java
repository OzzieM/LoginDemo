package com.example.logindemo;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface LoginDAO {
    @Insert
    void insert(Login... logins);
    @Update
    void update(Login... logins);
    @Delete
    void delete(Login login);

    @Query("SELECT * FROM " + AppDatabase.LOGIN_TABLE + " Where mUsername = :name")
    Login getUsername(String name);
    @Query("SELECT * FROM " + AppDatabase.LOGIN_TABLE)
    List<Login> getAllUsers();
}
