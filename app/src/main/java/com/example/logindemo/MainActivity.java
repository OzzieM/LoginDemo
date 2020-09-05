package com.example.logindemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    LoginDAO mLoginDAO;
    List<Login> mLogin;

    Button loginButton;
    EditText username;
    EditText password;
    String temp, temp2;
    static String t = "sleepy";
    static String t2 = "bear";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.loginUsername);
        password = findViewById(R.id.loginPassword);

        mLoginDAO = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.LOGIN_TABLE)
                .allowMainThreadQueries()
                .build()
                .getLoginDAO();

        basicSetup();
        login();
    }

    public void logInfo(){
        Log.i("Username : ", temp);
        Log.i("Password : ", temp2);
    }

    public void basicSetup(){
        mLogin = mLoginDAO.getAllUsers();
        if (mLogin.isEmpty()) {
            mLoginDAO.insert(new Login("sleepy","bear"));
        }
    }

    public void login() {
        loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent welcome = new Intent(MainActivity.this, Welcome.class);

                mLogin = mLoginDAO.getAllUsers();
                temp = username.getText().toString();
                temp2 = password.getText().toString();

                Log.i("Username : ", temp);
                Log.i("Password :", temp2);

                if(username.getText().toString().equals("") || password.getText().toString().equals("")){
                    username.requestFocus();
                    //username.setError("Input username");
                    Toast.makeText(MainActivity.this, "One or more fields are blank", Toast.LENGTH_SHORT).show();
                }
                if(username.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Input Username", Toast.LENGTH_SHORT).show();
                }
                if(password.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Input Password", Toast.LENGTH_SHORT).show();
                }

                else if(!mLogin.isEmpty()){
                    StringBuilder stringBuilder = new StringBuilder();

                    for(Login login : mLogin){
                        stringBuilder.append(login);
                        Log.i(login.getmUsername(), login.getmPassword());
                        if(login.getmUsername().equals(temp) && login.getmPassword().equals(temp2)){
                            Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            welcome.putExtra("name", temp);
                            startActivity(welcome);
                        }

                        if(!login.getmUsername().equals(temp)){
                            Toast.makeText(MainActivity.this, "Incorrect Username", Toast.LENGTH_SHORT).show();
                            username.setError("Incorrect username");
                        }
                        if(!login.getmPassword().equals(temp2)){
                            Toast.makeText(MainActivity.this, "Incorrect Password", Toast.LENGTH_SHORT).show();
                            password.setError("Incorrect password");

                        }

                    }
                }

            }
        });
    }

}

