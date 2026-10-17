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

public class GameActivity6 extends AppCompatActivity {
    int x;
    boolean ok;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game6);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_game6);
        x = 60;
        ok = true;
        text = findViewById(R.id.textView17);
        text.setText(String.valueOf(x));

    }

    public void Hint6(View view){
        Toast.makeText(this,"YOU KNOW WHAT TO DO", Toast.LENGTH_SHORT).show();
    }

    public void MenuClick6(View view){
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
    }

    public void theLastClick(View view){
            if(ok){
                x++;
                text.setText(String.valueOf(x));
            }
            else {
                Intent intent = new Intent(this, GameActivity7.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }

            if(x == 99){
                ok = false;
            }
    }
}