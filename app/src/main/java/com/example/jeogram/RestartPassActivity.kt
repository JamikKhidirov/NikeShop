package com.example.jeogram

import android.annotation.SuppressLint
import android.app.Notification
import android.app.Notification.Action
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.jeogram.databinding.ActivityRestartPassBinding
import androidx.appcompat.app.AlertDialog
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class RestartPassActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_restart_pass)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }





        val binding = ActivityRestartPassBinding.inflate(layoutInflater)
        val backBtn: AppCompatImageButton = findViewById(R.id.round_button7)
        val btnReg: AppCompatButton = findViewById(R.id.btnReg1)
        val emailEditText: TextInputEditText = findViewById(R.id.emailEditText)
        val emailLay: TextInputLayout = findViewById(R.id.inputlay)

        backBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            finish()
            startActivity(intent)
        }



            emailEditText.setOnFocusChangeListener { v, hasFocus ->
                if (hasFocus){
                    emailLay.hint = ""
                    emailEditText.hint = ""
                }

                else{
                    if(emailEditText.text?.isEmpty() == true){
                        emailLay.hint = "Введите email"
                        emailEditText.hint = "Введите email"
                    }
                }
            }


        btnReg.setOnClickListener {

            val email = emailEditText?.text.toString().trim()


            if (emailEditText.text?.length != 0) {
                var conteinsAtsymbol: Boolean = false
                for (char in email) {
                    if (char == '@') {
                        conteinsAtsymbol = true
                        showAlterDialog()
                        emailEditText.setText("")
                        break
                    }
                    else if (char != '@'){
                        emailEditText.error = "Некоректный email!"
                    }
                }

            if (email.isEmpty()) {
                Toast.makeText(
                    this,
                    "Поле воода email пустое! Для начала заполните это поле!",
                    Toast.LENGTH_SHORT
                ).show()
                emailEditText.error = "Поле email не должно быть пустым"



                    if (!conteinsAtsymbol) {
                        Toast.makeText(this, "Некоректный email!", Toast.LENGTH_SHORT)
                            .show()
                        emailEditText.error = "Некоректный email!"
                    }
                }
            }

        }


    }
    private fun showAlterDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Код отправлен")
            .setMessage("Мы отправили код на вашу почту")
            .setPositiveButton("ОК") {dialog, _ ->
                dialog.dismiss()
            }

        val alterDialog = builder.create()
        alterDialog.show()
    }
}