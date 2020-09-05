package com.example.logindemo;

import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = {Login.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase{
    public static String DBNAME = "db-test";

    public static final String LOGIN_TABLE = "login";

    public abstract LoginDAO getLoginDAO();
}
