package kz.kaspi.ai

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kz.kaspi.ai.ui.TokenKaspiAi

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bottomText = findViewById<TextView>(R.id.textView)

        lifecycleScope.launch {
            repeat(10) {
                delay(1000)
                bottomText.text = TokenKaspiAi.ACCESS_TOKEN.name
                delay(1000)
                bottomText.text = TokenKaspiAi.REFRESH_TOKEN.name
                delay(1000)
                bottomText.text = TokenKaspiAi.JWT_TOKEN.name
            }
        }
    }
}


