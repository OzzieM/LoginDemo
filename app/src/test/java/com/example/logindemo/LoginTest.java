package com.example.logindemo;

import androidx.appcompat.app.AppCompatActivity;

import org.junit.Test;

import static org.junit.Assert.*;

public class LoginTest {
    @Test
    public void loginCheck() {
        assertEquals("sleepy", Utils.verifyPassword(MainActivity.t));
    }
    @Test
    public void passwordCheck(){
        assertEquals("bear", Utils.verifyPassword(MainActivity.t2));
    }
}
