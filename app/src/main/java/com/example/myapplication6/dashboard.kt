package com.example.myapplication6

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class dashboard : AppCompatActivity() {

    lateinit var welcomeText: String
    lateinit var tvWelcome: TextView
    @SuppressLint("MissingInflatedId")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //add the following code above  onCreate
        lateinit var welcomeText: String;
        lateinit var tvWelcome: TextView

        setContentView(R.layout.activity_dashboard)


        //add this inside onCreate under setContentView
        welcomeText ="Welcome "+ getIntent().getStringExtra("Username").toString() + "!";
        tvWelcome = this.findViewById(R.id.tvWelcome);
        tvWelcome.setText(welcomeText);
    }
}