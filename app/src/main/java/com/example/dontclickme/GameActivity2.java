package com.example.dontclickme;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GameActivity2 extends AppCompatActivity {
    int hit;
    TextView Count, Dialog;
    ImageButton Button3;
    boolean ok, hintButton;
    public static int activity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_game2);
        hit = 0;
        Count = findViewById(R.id.textView4);
        Dialog = findViewById(R.id.textView5);
        Button3 = findViewById(R.id.imageButton9);
        ok = true;
        hintButton = false;
    }

    public void MenuClick(View view){
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }

    public void Hint2(View view){
        if(!hintButton) {
            Toast.makeText(this, "Why don't you click him", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Find Clicky, maybe if you go to the pause-menu and get back it will show himself", Toast.LENGTH_SHORT).show();
        }
    }

    public void ClickButton(View view){
        if(ok) {
            hit++;
            Count.setText(String.valueOf(hit));
        }
        else {
            Dialog.setText("STOP");
            activity = 2;
            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                Button3.setVisibility(View.GONE);
                Dialog.setText("I told you to leave me alone");
                hintButton = true;
                new Handler(Looper.getMainLooper()).postDelayed(() -> {
                    Button3.setVisibility(View.GONE);
                    Dialog.setText("");
                    hintButton = true;
                }, 2000);
            }, 2000);
        }

        if(hit == 20){
            ok = false;
        }
    }
}