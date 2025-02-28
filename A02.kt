
package com.example.myapplicationkolin

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var Ron: Int = 0
    private lateinit var number: EditText
    private lateinit var output: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        number = findViewById(R.id.txtnumber)
        output = findViewById(R.id.lblOutput)

        RonNumber()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun RonNumber() {
        Ron = (1..100).random()
    }

    fun button_clickIn(view: View) {
        val str = number.text.toString().trim()
        if (str.isEmpty()) {
            output.text = "請輸入數字！"
            return
        }

        val count = str.toIntOrNull()
        if (count == null) {
            output.text = "請輸入有效的數字！"
            return
        }

        when {
            count < 0 || count > 100 -> output.text = "範圍錯誤"
            count > Ron -> output.text = "太大了"
            count < Ron -> output.text = "太小了"
            else -> output.text = "恭喜答對！"
        }
    }

    fun button_click_restart(view: View) {
        output.text = "請輸入新數字！"
        number.setText("")
        RonNumber()
    }
}
