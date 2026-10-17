package com.example.dontclickme;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.nio.file.attribute.FileAttribute;

public class GameActivity7 extends AppCompatActivity {
    String[] finaldialog ={
            "WAIT",
            "Before you reach 100 clicks",
            "Maybe we haven't started good",
            "Do you want to be friends ?"
    };
    TextView FINALdialog;
    boolean finalul;
    ImageButton yes, no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game7);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_game7);
        FINALdialog = findViewById(R.id.textView19);
        yes = findViewById(R.id.yesbutton);
        no = findViewById(R.id.nobutton);
        yes.setVisibility(View.GONE);
        no.setVisibility(View.GONE);
        finalul = false;
        if (!finalul) {
            finalul = true;
            showDialogLines(finaldialog, 0, 2000);
        };

    }

    private void showDialogLines(final String[] lines, final int index, final long delayMillis) {
        if (index >= lines.length) return;

        FINALdialog.setText(lines[index]);

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            showDialogLines(lines, index + 1, delayMillis);
        }, delayMillis);

        if(index == 3){
            yes.setVisibility(View.INVISIBLE);
            Animation popIn = AnimationUtils.loadAnimation(GameActivity7.this, R.anim.pop_in);
            yes.startAnimation(popIn);
            yes.setVisibility(View.VISIBLE);

            no.setVisibility(View.INVISIBLE);
            Animation popIn2 = AnimationUtils.loadAnimation(GameActivity7.this, R.anim.pop_in);
            no.startAnimation(popIn2);
            no.setVisibility(View.VISIBLE);
        }
    }

    public void yesclick(View view){
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            FINALdialog.setText("SIKE");
            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }, 2000);

        }, 2000);
    }

    public void noclick(View view){
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            FINALdialog.setText("THEN GET OUT OF HERE");
            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }, 2000);

        }, 2000);
    }
}