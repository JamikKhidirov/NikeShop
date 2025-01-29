package com.example.jeogram

import android.annotation.SuppressLint
import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivityReg : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_reg)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val backBtn: ImageButton = findViewById(R.id.round_button)
        val voyTi: LinearLayout = findViewById(R.id.voyTi)
        val nameLay: TextInputLayout = findViewById(R.id.nameLay)
        val nameEdit: TextInputEditText = findViewById(R.id.nameEdit)
        val emailLay: TextInputLayout = findViewById(R.id.emailLay)
        val emailEdit: TextInputEditText = findViewById(R.id.emailEdit)
        val layPass: TextInputLayout = findViewById(R.id.layPass)
        val passEdt: TextInputEditText = findViewById(R.id.passEdit)


        passEdt.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                layPass.hint = ""
                passEdt.hint = ""
            } else if (passEdt.text?.isEmpty() == true) {
                passEdt.hint = "98776756757zhgd"
            }
        }

        emailEdit.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                emailEdit.hint = ""
                emailLay.hint = ""
            } else if (emailEdit.text?.isEmpty() == true) {
                emailEdit.hint = "xyz@gmail.com"
            }
        }

            nameEdit.setOnFocusChangeListener { v, hasFocus ->
                if (hasFocus) {
                    nameEdit.hint = ""
                    nameLay.hint = ""
                } else if (nameEdit.text?.isEmpty() == true) {
                    nameEdit.hint = "xxxxxxxx"
                }

            }



            voyTi.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

            backBtn.setOnClickListener {
                if (isPreviousActivityExists()){
                    finish()
                }
                else{
                    //Ничего не делаем
                }
            }


    }

    fun isPreviousActivityExists(): Boolean {
        val activityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val tasks = activityManager.getRunningTasks(1) // Получаем список задач
        return tasks.isNotEmpty() && tasks[0].id != this.taskId // Проверяем, есть ли другие активности в стеке
    }
}

