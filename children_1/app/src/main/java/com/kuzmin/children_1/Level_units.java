package com.kuzmin.children_1;



import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Level_units extends AppCompatActivity {

    //Переменные класс -начало
    public int num;
    public int counter;
    public int j;
    //Переменные класса - конец

    Dialog dialog;
    Dialog dialog_less;
    Array array = new Array();
    Random random = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_unit);

        Window w = getWindow(); //Раскрываем игру на весь экран
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        TextView counter_game=(TextView) findViewById(R.id.counter_game);//игровой счетчик
        ImageButton unit_time=(ImageButton)findViewById((R.id.unit_time));
        ImageButton unit_weight=(ImageButton)findViewById((R.id.unit_weight));
        ImageButton unit_long=(ImageButton)findViewById((R.id.unit_long));
        ImageButton unit_square=(ImageButton)findViewById((R.id.unit_square));
        //Присваиваем переменным id адреса кнопок

        //Вызов нового диалогового окна
        dialog=new Dialog(this);//создаем новое диалоговое окно
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрываем заголовок
        dialog.setContentView(R.layout.layout_dilog);//путь к макету диалогового окна
        //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон диалогового окна
        dialog.setCancelable(false);//окно нельзя закрыт кнопкой назад

        //Установили картинку для диалогового окна
        ImageView img_salute=(ImageView)dialog.findViewById(R.id.img_salute);
        img_salute.setImageResource(R.drawable.img_salute);
        Animation salutStart = AnimationUtils.loadAnimation(this, R.anim.salut);
        img_salute.startAnimation(salutStart);


        //Устанавливаем текст в диалоговое окно
        TextView text_dialog_sel =(TextView)dialog.findViewById(R.id.text_dialog_sel);
        text_dialog_sel.setText(R.string.text_max_dialog);


        //Обрабатываем нажатие кнопки перейти в меню выбора игры
        Button btn_back_dialog=(Button)dialog.findViewById(R.id.btn_back_dialog);
        btn_back_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Level_units.this, MainDirectory.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
                dialog.dismiss();
            }
        });

        //Вызов нового второго диалогового окна
        dialog_less=new Dialog(this);//создаем новое диалоговое окно
        dialog_less.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрываем заголовок
        dialog_less.setContentView(R.layout.layout_dilog);//путь к макету диалогового окна
        //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон диалогового окна
        dialog_less.setCancelable(false);//окно нельзя закрыт кнопкой назад

        //Установили картинку для диалогового окна
        ImageView img_dialog_res=(ImageView)dialog_less.findViewById(R.id.img_salute);
        img_dialog_res.setImageResource(R.drawable.img_dialog_res);

        //
        TextView text_dialog_res =(TextView)dialog_less.findViewById(R.id.text_dialog_sel);
        text_dialog_res.setText(R.string.text_norm_dialog3);

        //Устанавливаем текст в диалоговое окно

        //Обрабатываем нажатие кнопки перейти в меню выбора игры
        Button btn_back_dialog_res=(Button)dialog_less.findViewById(R.id.btn_back_dialog);
        btn_back_dialog_res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Level_units.this, MainDirectory.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
                dialog_less.dismiss();
            }
        });



        //Кнопка назад - начало
        Button button_back = (Button) findViewById(R.id.button_back_add);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    Intent intent = new Intent(Level_units.this, MainDirectory.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                }
            }
        });
        //Кнопка назад - конец
        Button button_example = (Button) findViewById(R.id.button_example);
        button_example.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (j == 20) {
                    if (counter == 80) {
                        dialog.show();
                    }
                    if (counter < 80) {
                        dialog_less.show();
                    }
                } else {
                    j = j + 1;
                    unit_long.setEnabled(true);
                    unit_weight.setEnabled(true);
                    unit_time.setEnabled(true);
                    unit_square.setEnabled(true);
                    TextView text_description = (TextView) findViewById(R.id.description_add);
                    text_description.setText(R.string.description_unit);
                    TextView text_exercise = (TextView) findViewById(R.id.text_exercise);
                    TextView textView3 = (TextView) findViewById(R.id.textView3);


                    //Генерация чисел - начало
                    num = random.nextInt(25);
                    text_exercise.setText(array.array_unit[num]);
                    textView3.setText(R.string.text_unit_indication);
                    text_exercise.setTextSize(24);
                    //Генерация чисел - конец

                    unit_time.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            unit_long.setEnabled(false);
                            unit_weight.setEnabled(false);
                            unit_square.setEnabled(false);
                            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                                if (0 <= num & num <= 5) {

                                    text_description.setText(R.string.text_description_true_unit);
                                    text_exercise.setText(array.array_unit_description[num]);
                                    text_exercise.setTextSize(15);
                                    textView3.setText(R.string.text_empty);
                                    counter = counter + 4;
                                    unit_time.setEnabled(false);

                                } else {

                                    text_description.setText(R.string.text_description_false_unit);
                                    counter = counter - 2;
                                    textView3.setText(R.string.text_empty);

                                }
                                if (counter < 0) {
                                    counter = 0;
                                }
                                String v = Integer.toString(counter);
                                counter_game.setText(v);
                            }
                            return true;

                        }
                    });


                    unit_weight.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            unit_long.setEnabled(false);
                            unit_time.setEnabled(false);
                            unit_square.setEnabled(false);
                            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {


                                if (6 <= num & num <= 11) {
                                    text_description.setText(R.string.text_description_true_unit);
                                    text_exercise.setText(array.array_unit_description[num]);
                                    text_exercise.setTextSize(15);
                                    textView3.setText(R.string.text_empty);
                                    counter = counter + 4;
                                    unit_weight.setEnabled(false);

                                } else {

                                    text_description.setText(R.string.text_description_false_unit);
                                    counter = counter - 2;
                                    textView3.setText(R.string.text_empty);

                                }

                                if (counter < 0) {
                                    counter = 0;
                                }
                                String v = Integer.toString(counter);
                                counter_game.setText(v);
                            }
                            return true;
                        }
                    });

                    unit_long.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            unit_time.setEnabled(false);
                            unit_weight.setEnabled(false);
                            unit_square.setEnabled(false);
                            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {


                                if (12 <= num & num <= 21) {
                                    text_description.setText(R.string.text_description_true_unit);
                                    text_exercise.setText(array.array_unit_description[num]);
                                    text_exercise.setTextSize(15);
                                    textView3.setText(R.string.text_empty);
                                    counter = counter + 4;
                                    unit_long.setEnabled(false);

                                } else {

                                    text_description.setText(R.string.text_description_false_unit);
                                    counter = counter - 2;
                                    textView3.setText(R.string.text_empty);

                                }

                                if (counter < 0) {
                                    counter = 0;
                                }
                                String v = Integer.toString(counter);
                                counter_game.setText(v);
                            }
                            return true;
                        }

                    });

                    unit_square.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            unit_long.setEnabled(false);
                            unit_weight.setEnabled(false);
                            unit_time.setEnabled(false);
                            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {


                                if (22 <= num & num <= 24) {

                                    text_description.setText(R.string.text_description_true_unit);
                                    text_exercise.setText(array.array_unit_description[num]);
                                    text_exercise.setTextSize(15);
                                    textView3.setText(R.string.text_empty);
                                    counter = counter + 4;
                                    unit_square.setEnabled(false);

                                } else {

                                    text_description.setText(R.string.text_description_false_unit);
                                    counter = counter - 2;
                                    textView3.setText(R.string.text_empty);

                                }

                                if (counter < 0) {
                                    counter = 0;
                                }
                                String v = Integer.toString(counter);
                                counter_game.setText(v);
                            }
                            return true;
                        }
                    });


                }
            }
        });

    }

    //Системная кнопка назад
    @Override
    public void onBackPressed() {
        try {
            Intent intent=new Intent(Level_units.this, MainDirectory.class);
            startActivity(intent);
            finish();
        } catch ( Exception e) {}
    }
}