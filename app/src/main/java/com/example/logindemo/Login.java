package com.example.logindemo;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = AppDatabase.LOGIN_TABLE)
public class Login {
    public String mUsername;

    public String mPassword;

    @PrimaryKey(autoGenerate = true)
    public int mID;

    public Login(String username, String password)
    {
        mUsername = username;
        mPassword = password;
    }

    public String getmUsername() {
        return mUsername;
    }

    public String getmPassword() {
        return mPassword;
    }

    public int getmID() {
        return mID;
    }

    public void setmUsername(String mUsername) {
        this.mUsername = mUsername;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public void setmID(int mID) {
        this.mID = mID;
    }

    @Override
    public String toString(){
        return mUsername + " "+ mPassword + " "+ mID + "\n";
    }


    public static String getUsernameTest(String username){return username;}
}
