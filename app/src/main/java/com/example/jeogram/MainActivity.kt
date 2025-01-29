package com.example.jeogram

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatToggleButton
import androidx.core.content.ContextCompat
import androidx.core.content.withStyledAttributes
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import com.example.jeogram.R.id.btnReg
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imageButton: AppCompatImageButton = findViewById(R.id.round_button2)
        val emailEditText: TextInputEditText = findViewById(R.id.emailEditText)
        val passwordEditText: TextInputEditText = findViewById(R.id.passwordEditText)
        val btnReg: AppCompatButton = findViewById(btnReg)
        val soz: LinearLayout = findViewById(R.id.sozAkk)
        val vosta = findViewById<TextView>(R.id.vostanvit)
        val lay: TextInputLayout = findViewById(R.id.layEdit)
        val layPass: TextInputLayout = findViewById(R.id.layPass)

        vosta.setOnClickListener {
            val intent = Intent(this, RestartPassActivity::class.java)
            finish()
            startActivity(intent)
        }

        emailEditText.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus){
                emailEditText.hint = ""
                lay.hint = ""
            }

            else{
                if(emailEditText.text?.isEmpty() == true){
                    emailEditText.hint = "Введите email"
                }
            }

        }


        passwordEditText.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus){
                passwordEditText.hint = ""
                layPass.hint = ""
            }
            else if (passwordEditText.text?.isEmpty() == true){
                passwordEditText.hint = "Введите пороль"
            }
        }

        soz.setOnClickListener {
            val intent = Intent(this, MainActivityReg::class.java)
            startActivity(intent)
        }

        imageButton.setOnClickListener {
            val intent = Intent(this, MainActivityReg::class.java)
            finish()
            startActivity(intent)
        }

        btnReg.setOnClickListener {

            val originalBack = btnReg.background

            if (emailEditText?.length() != 0 && passwordEditText?.length() != 0) {

                btnReg.setBackgroundResource(R.drawable.backbtn2)
                val email = emailEditText.text
                val pass = passwordEditText.text
                Toast.makeText(
                    this,
                    "Ваш email $email, ваш пороль $pass регистрация прошла успешно",
                    Toast.LENGTH_SHORT
                ).show()
                emailEditText.setText("")
                passwordEditText.setText("")
                emailEditText.clearFocus()
                passwordEditText.clearFocus()
            } else {
                Toast.makeText(this, "Не все поля заполнены!", Toast.LENGTH_SHORT).show()
            }

            Handler(Looper.getMainLooper()).postDelayed({
                btnReg.background = originalBack // Замените на оригинальный цвет кнопки
            }, 500)
        }

    }
}