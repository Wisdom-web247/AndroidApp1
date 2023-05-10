package com.example.myapplication6

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class register : AppCompatActivity() {

    //Binding variables so that we will be able to put functions
     lateinit var etPassword:EditText
     lateinit var etUsername:EditText
     lateinit var btnRegister:Button





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        Toast.makeText(this, " has been registered", Toast.LENGTH_SHORT).show();

        etUsername= findViewById(R.id.etRUserName)
        etPassword= findViewById(R.id.etRPassword)
        btnRegister=findViewById(R.id.btnRegister)

            btnRegister.setOnClickListener {
           //Toast.makeText(this, etUsername + " has been registered", Toast.LENGTH_SHORT).show();

    }

    }
}