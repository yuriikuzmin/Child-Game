package com.kuzmin.children_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Window w=getWindow(); //Раскрываем игру на весь экран
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        final ImageView img_main=(ImageView)findViewById(R.id.img_main);
        //код корторый скругляет углы
        img_main.setClipToOutline(true);

        final ImageView img_text_main=(ImageView)findViewById(R.id.img_text_main);
        //код корторый скругляет углы
        img_text_main.setClipToOutline(true);

        Button button_start=(Button)findViewById(R.id.button_start);
        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent=new Intent(MainActivity.this, MainDirectory.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                    //empty
                }

            }
        });
    }
}
