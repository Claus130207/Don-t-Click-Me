package com.example.dontclickme;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GameActivity4 extends AppCompatActivity {
    int x;
    boolean ok;
    TextView Count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_game4);
        Count = findViewById(R.id.textView12);
        ok = true;
        x=40;
        Count.setText(String.valueOf(x));
    }

    public void Hint4(View view){
        Toast.makeText(this, "Find Clicky by just clicking on the buttons :)", Toast.LENGTH_SHORT).show();
    }

    public void MenuClick3(View view){
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }

    public void ClickButton3(View view){
        if(ok){
            x++;
            Count.setText(String.valueOf(x));
        }
        else{
            GameActivity2.activity = 4;
            Intent intent = new Intent(this, GameActivity5.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }

        if(x == 60){
            ok = false;
        }
    }
}