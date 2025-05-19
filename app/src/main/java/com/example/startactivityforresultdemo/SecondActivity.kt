package com.example.resultdemo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val inputEditText = findViewById<EditText>(R.id.inputEditText)
        val sendButton = findViewById<Button>(R.id.sendResultButton)

        sendButton.setOnClickListener {
            val input = inputEditText.text.toString().trim()

            if (input.isEmpty()) {
                Toast.makeText(this, "Please enter something!", Toast.LENGTH_SHORT).show()
            } else if (!input.matches(Regex("^[a-zA-Z0-9 ]+$"))) {
                Toast.makeText(this, "Only alphanumeric input allowed", Toast.LENGTH_SHORT).show()
            } else {
                val resultIntent = Intent()
                resultIntent.putExtra("user_input", input)
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            }
        }
    }
}
