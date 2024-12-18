package com.app.firstapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var button: Button
    private lateinit var resultTextView: TextView
    private lateinit var countTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Инициализация view
        editText = findViewById(R.id.etInput)
        button = findViewById(R.id.btnButton)
        resultTextView = findViewById(R.id.tvResult)
        countTextView = findViewById(R.id.tvCount)
    }

    fun onTransformClick(view: View) {
        val text = editText.text // Текст в поле ввода

        resultTextView.text = text.reversed() // Текст в обратном порядке

        countTextView.text = text.filter { !it.isWhitespace() }.count().toString() // Количество не пробелов
    }
}