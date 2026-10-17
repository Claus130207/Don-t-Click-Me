package com.example.dontclickme;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GameActivity3 extends AppCompatActivity {
    int x = 20;
    boolean ok;
    TextView CountText2, Dialog2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_game3);
        CountText2 = findViewById(R.id.textView9);
        CountText2.setText(String.valueOf(x));
        Dialog2 = findViewById(R.id.textView10);
        ok = true;
    }

    public void Hint3(View view){
        Toast.makeText(this,"CLICK HIM", Toast.LENGTH_SHORT).show();
    }

    public void MenuClick2(View view){
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }

    public void ClickButton2(View view){
        if(ok){
            x++;
            CountText2.setText(String.valueOf(x));
        }
        else{
            Dialog2.setText("I TOLD YOU TO STOP");
            GameActivity2.activity = 3;
            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                Dialog2.setText("Let's see if you can find me now");
                new Handler(Looper.getMainLooper()).postDelayed(() -> {
                    Intent intent = new Intent(this, GameActivity4.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                }, 2000);
            }, 2000);
        }

        if(x==40){
            ok = false;
        }

    }
}