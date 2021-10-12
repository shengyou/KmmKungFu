package io.kraftsman.app.kmmkungfu.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import io.kraftsman.app.kmmkungfu.Detector
import android.widget.TextView
import io.kraftsman.app.kmmkungfu.PasswordGenerator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val passwordTextView: TextView = findViewById(R.id.responseText)
        val versionTextView: TextView = findViewById(R.id.versionTextView)

        versionTextView.text = Detector().detect()

        val generateButton: Button = findViewById(R.id.generateBtn)
        generateButton.setOnClickListener {
            passwordTextView.text = PasswordGenerator().generate(7)
        }
    }
}
