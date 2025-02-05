package com.example.jeogram

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OnboardActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_onboard)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.onbord)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets }

        val btn = findViewById<AppCompatButton>(R.id.startBtn)

        btn.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.onbord1, Onbord2.newInstance())
                .commit()
        }

    }

    private fun showAlterDialog(){
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Код отправлен")
            .setMessage("Мы отправили код на вашу почту")
            .setPositiveButton("ОК"){dialog, _ ->
                dialog.dismiss()
            }

        val alterDialog = dialog.create()
        alterDialog.show()
    }
}