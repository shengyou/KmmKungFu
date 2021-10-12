package io.kraftsman.app.kmmkungfu.android

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import io.kraftsman.app.kmmkungfu.Detector
import android.widget.TextView
import io.kraftsman.app.kmmkungfu.PasswordGenerator
import io.kraftsman.app.kmmkungfu.Validator
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val validator = Validator()
    private val mainScope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val passwordTextView: TextView = findViewById(R.id.passwordTextView)
        val messageTextView: TextView = findViewById(R.id.messageTextView)

        val versionText: String = Detector().detect()
        messageTextView.text = versionText

        val generateButton: Button = findViewById(R.id.generateBtn)
        generateButton.setOnClickListener {
            messageTextView.setTextColor(Color.parseColor("#AAAAAA"))
            messageTextView.text = versionText

            passwordTextView.text = PasswordGenerator().generate(7)
        }

        val inspectButton: Button = findViewById(R.id.inspectBtn)
        inspectButton.setOnClickListener {
            messageTextView.setTextColor(Color.parseColor("#AAAAAA"))
            messageTextView.text = versionText

            mainScope.launch {
                kotlin.runCatching {
                    validator.inspect(passwordTextView.text.toString())
                }.onSuccess {
                    if (it.result) {
                        messageTextView.setTextColor(Color.parseColor("#E91E63"))
                    } else {
                        messageTextView.setTextColor(Color.parseColor("#8BC34A"))
                    }

                    messageTextView.text = it.message
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mainScope.cancel()
    }
}
