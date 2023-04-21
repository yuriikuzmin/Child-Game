package com.kuzmin.children_1;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainDirectory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.directory_selection);

        Window w=getWindow(); //Раскрываем игру на весь экран
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ImageButton img_add = (ImageButton)findViewById(R.id.img_add);
        img_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(MainDirectory.this, Level_add.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                }
            }
        });

        ImageButton img_subtraction = (ImageButton)findViewById(R.id.img_subtraction);
        img_subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(MainDirectory.this, Level_sub.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                }
            }
        });

        ImageButton img_selection = (ImageButton)findViewById(R.id.img_selection);
        img_selection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(MainDirectory.this, Level_sel.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                }
            }
        });

        ImageButton img_unit = (ImageButton)findViewById(R.id.img_unit);
        img_unit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(MainDirectory.this, Level_units.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                }
            }
        });
    }
}