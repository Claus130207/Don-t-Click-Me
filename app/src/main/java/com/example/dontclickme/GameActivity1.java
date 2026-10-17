package com.example.dontclickme;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GameActivity1 extends AppCompatActivity {
    String[] dialogLines = {
            "Huh ...",
            "Who is this ?",
            "Oh hello there",
            "I am A4TeCH",
            "But you can call me Clicky",
            "I think that you're in the wrong place",
            "Maybe you have something to do elsewhere",
            "I don't know",
            "You can stay if you want",
            "But whatever you do",
            "DON'T",
            "CLICK",
            "ME",
            ""
    };

    TextView Dialog;
    boolean StartIntent;
    ImageButton Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_game1);
        Dialog = findViewById(R.id.textView6);
        Button = findViewById(R.id.imageButton9);
        StartIntent = false;
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }

    public void Delay(int delayMillis, Runnable action) {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(action, delayMillis);
    }

    public void Hint(View view){
        Toast.makeText(this, "click anywhere u want on the screen", Toast.LENGTH_SHORT).show();
    }

    private void showDialogLines(final String[] lines, final int index, final long delayMillis) {
        if (index >= lines.length) return;

        Dialog.setText(lines[index]);

        if (index == 2) {
            Button.setVisibility(View.INVISIBLE);
            Animation popIn = AnimationUtils.loadAnimation(GameActivity1.this, R.anim.pop_in);
            Button.startAnimation(popIn);
            Button.setVisibility(View.VISIBLE);
        }

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            showDialogLines(lines, index + 1, delayMillis);
        }, delayMillis);

        if(index == 13){
            Intent intent = new Intent(this, GameActivity2.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
    }

    public void START(View view){
        if (!StartIntent) {
            StartIntent = true;
            showDialogLines(dialogLines, 0, 2000);
        };
    }




}