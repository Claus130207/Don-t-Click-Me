package com.example.dontclickme;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GameActivity5 extends AppCompatActivity {
    TextView Dialog5, Count4;
    int x;
    EditText yaman;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game5);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_game5);
        x = 60;
        Dialog5 = findViewById(R.id.textView15);
        Count4 = findViewById(R.id.textView14);
        yaman = findViewById(R.id.editTextText);
        yaman.setVisibility(View.GONE);
        Count4.setText(String.valueOf(x));
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            yaman.setVisibility(View.VISIBLE);
            Animation popIn = AnimationUtils.loadAnimation(GameActivity5.this, R.anim.pop_in);
            yaman.startAnimation(popIn);
            Dialog5.setText("Now it is imposible to click me");
            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                Dialog5.setText("EVER");
                new Handler(Looper.getMainLooper()).postDelayed(() -> {
                    Dialog5.setText("AGAIN");
                    new Handler(Looper.getMainLooper()).postDelayed(() -> {
                        Dialog5.setText("");
                    }, 2000);
                }, 2000);
            }, 2000);
        }, 2000);
    }

    public void Hint5(View view){
        Toast.makeText(this, "What is the version of the app ?", Toast.LENGTH_SHORT).show();
    }

    public void MenuClick4(View view){
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }

    public void submit(View view){
        String input = yaman.getText().toString();
        if(input.equals("27062025")){
            GameActivity2.activity = 5;
            Intent intent = new Intent(this, GameActivity6.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
        else {
            Toast.makeText(this, "The password is incorrect", Toast.LENGTH_SHORT).show();
        }
    }
}