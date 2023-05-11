package com.example.myapplication6

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException


class register : AppCompatActivity() {

    //Binding variables so that we will be able to put functions
     lateinit var etPassword:EditText
     lateinit var etUsername:EditText
     lateinit var btnRegister:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        etUsername= findViewById(R.id.etRUserName)
        etPassword= findViewById(R.id.etRPassword)
        btnRegister=findViewById(R.id.btnRegister)

            btnRegister.setOnClickListener {
               // Toast.makeText(this,"Success is working", Toast.LENGTH_LONG).show();
                registerUser()
    }

    }

    private fun registerUser() {
        val userName: String = etUsername.getText().toString().trim()
        val password: String = etPassword.getText().toString().trim()

        if (userName.isEmpty()) {
            etUsername.setError("Username is required")
            etUsername.requestFocus()
            return
        } else if (password.isEmpty()) {
            etPassword.setError("Password is required")
            etPassword.requestFocus()
            return
        }

        val call: Call<ResponseBody> =
            RetrofitClient.getInstance().api.createUser(User(userName, password))

        call.enqueue(object : Callback<ResponseBody?> {
            override fun onResponse(call: Call<ResponseBody?>?, response: Response<ResponseBody?>) {
                var s = ""
                try {
                    s = response.body()!!.string()
                } catch (e: IOException) {
                    e.printStackTrace()
                }

                if (s == "SUCCESS") {
                    Toast.makeText(
                        this@register,
                        "Successfully registered. Please login",
                        Toast.LENGTH_LONG
                    ).show()
                    startActivity(Intent(this@register, login::class.java))
                } else {
                    Toast.makeText(this@register, "User already exists!", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<ResponseBody?>, t: Throwable) {
                Toast.makeText(this@register, t.message, Toast.LENGTH_LONG).show()
            }
        })

            }

    }


