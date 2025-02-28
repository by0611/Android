package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private int Ron;
    private EditText number;
    private TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        number = findViewById(R.id.txtnumber);
        output = findViewById(R.id.lblOutput);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void RonNumber(){
        Ron = (int) (Math.random()*100)+1;
    }
    public void button_clickIn(View view){
        String str = number.getText().toString();
        int count = Integer.parseInt(str);

        if (count > 100 || count < 1){
            output.setText("範圍錯誤");
        }
        else if (count > Ron) {
            output.setText("太大了");
        } else if (count < Ron) {
            output.setText("太小了");}
        else {
            output.setText("恭喜答對！");
        }
    }
    public void button_click_restart(View view){
        TextView output = (TextView) findViewById(R.id.lblOutput);
        output.setText("請輸入新數字！");
        number.setText("");
        RonNumber();
    }
}