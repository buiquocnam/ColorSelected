package com.example.colorselected;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button buttonRed;
    Button buttonGreen;
    Button buttonBlue;

    private SharedPreferences sharedPreferences;
    private View rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rootView = findViewById(android.R.id.content);

        sharedPreferences = getSharedPreferences("BackgroundColor", MODE_PRIVATE);

        // Lấy màu nền đã lưu và thiết lập cho root view
        int savedColor = sharedPreferences.getInt("bgColor", Color.WHITE);
        rootView.setBackgroundColor(savedColor);

        AnhXa();


        // Xử lý sự kiện bấm nút để thay đổi màu nền
        ClickDoiMau();
    }

    private void AnhXa(){
        buttonRed = findViewById(R.id.buttonRed);
         buttonGreen = findViewById(R.id.buttonGreen);
         buttonBlue = findViewById(R.id.buttonGray);
    }

    private void ClickDoiMau(){
        buttonRed.setOnClickListener(view -> changeBackgroundColor(Color.RED));
        buttonGreen.setOnClickListener(view -> changeBackgroundColor(Color.GREEN));
        buttonBlue.setOnClickListener(view -> changeBackgroundColor(Color.GRAY));
    }

    private void changeBackgroundColor(int color) {
        // Thay đổi màu nền
        rootView.setBackgroundColor(color);

        // Lưu màu đã chọn vào SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("bgColor", color);
        editor.apply();
    }
}