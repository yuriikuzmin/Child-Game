package com.kuzmin.children_1;



import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Level_sub extends AppCompatActivity {

    //Переменные класс -начало
    public int numLeft;
    public int numRight;
    public int numAdd; //переменная суммы
    public int  value_btn;//переменная ссылки на кнопку при ответе
    public int counter=0;
    public int j=0;
    //Переменные класса - конец

    Dialog dialog;
    Dialog dialog_less;
    Array array = new Array();
    Random random = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_subtration);

        Window w = getWindow(); //Раскрываем игру на весь экран
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ImageView img_Left = (ImageView) findViewById(R.id.img_Left);//закрепили слагаемые за левой
        ImageView img_Right = (ImageView) findViewById(R.id.img_Right);//и правой позициями
        ImageView img_add_1 = (ImageView) findViewById(R.id.img_add_1);
        ImageView img_add_2 = (ImageView) findViewById(R.id.img_add_2);
        ImageView img_equlas = (ImageView) findViewById(R.id.img_equlas);
        TextView counter_game=(TextView) findViewById(R.id.counter_game);

        //Присваиваем переменным id адреса кнопок
        Button button_0 = (Button) findViewById(R.id.button_0);
        Button button_1 = (Button) findViewById(R.id.button_1);
        Button button_2 = (Button) findViewById(R.id.button_2);
        Button button_3 = (Button) findViewById(R.id.button_3);
        Button button_4 = (Button) findViewById(R.id.button_4);
        Button button_5 = (Button) findViewById(R.id.button_5);
        Button button_6 = (Button) findViewById(R.id.button_6);
        Button button_7 = (Button) findViewById(R.id.button_7);
        Button button_8 = (Button) findViewById(R.id.button_8);
        Button button_9 = (Button) findViewById(R.id.button_9);

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
                    Intent intent = new Intent(Level_sub.this, MainDirectory.class);
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
        text_dialog_res.setText(R.string.text_norm_dialog2);

        //Устанавливаем текст в диалоговое окно

        //Обрабатываем нажатие кнопки перейти в меню выбора игры
        Button btn_back_dialog_res=(Button)dialog_less.findViewById(R.id.btn_back_dialog);
        btn_back_dialog_res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Level_sub.this, MainDirectory.class);
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

                    Intent intent = new Intent(Level_sub.this, MainDirectory.class);
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
                    if (counter == 60) {
                        dialog.show();
                    }
                    if (counter < 60) {
                        dialog_less.show();
                    }
                } else {
                    j = j + 1;
                    img_add_1.setImageResource(R.drawable.img_blank);//устанавливаем пустые окно
                    //ответов
                    img_equlas.setImageResource(R.drawable.equlas);
                    Button button_enter = (Button) findViewById(R.id.button_enter);
                    button_enter.setEnabled(true);

                    TextView text_description = (TextView) findViewById(R.id.description_add);
                    text_description.setText(R.string.description_add);

                    //Генерация чисел - начало
                    numLeft = random.nextInt(10);
                    numRight = random.nextInt(10);
                    while (numLeft < numRight) {
                        numRight = random.nextInt(10);
                    }
                    //Генерация чисел - конец
                    //text_description.setText(R.string.description_add);
                    img_Left.setImageResource(array.img_array_digital[numLeft]);
                    img_Right.setImageResource(array.img_array_digital[numRight]);


                    numAdd = numLeft - numRight; //разность случайных сгенерированных чисел
                    View.OnClickListener button_all = new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (R.id.button_0 == view.getId()) {
                                value_btn = 0;

                            }
                            if (R.id.button_1 == view.getId()) {
                                value_btn = 1;

                            }
                            if (R.id.button_2 == view.getId()) {
                                value_btn = 2;

                            }
                            if (R.id.button_3 == view.getId()) {
                                value_btn = 3;

                            }
                            if (R.id.button_4 == view.getId()) {
                                value_btn = 4;

                            }
                            if (R.id.button_5 == view.getId()) {
                                value_btn = 5;

                            }
                            if (R.id.button_6 == view.getId()) {
                                value_btn = 6;

                            }
                            if (R.id.button_7 == view.getId()) {
                                value_btn = 7;

                            }
                            if (R.id.button_8 == view.getId()) {
                                value_btn = 8;

                            }
                            if (R.id.button_9 == view.getId()) {
                                value_btn = 9;

                            }

                        }
                    };
                    button_0.setOnClickListener(button_all);
                    button_1.setOnClickListener(button_all);
                    button_2.setOnClickListener(button_all);
                    button_3.setOnClickListener(button_all);
                    button_4.setOnClickListener(button_all);
                    button_5.setOnClickListener(button_all);
                    button_6.setOnClickListener(button_all);
                    button_7.setOnClickListener(button_all);
                    button_8.setOnClickListener(button_all);
                    button_9.setOnClickListener(button_all);


                    //обрабатываем нажатеие кнопки Ввод
                    button_enter.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            //Что нужно выполнить при нажатии на кнопку
                            if (numAdd == value_btn) {
                                img_add_1.setImageResource(array.img_array_digital[numAdd]);//выводим результат в первую картинку суммы
                                TextView text_description = (TextView) findViewById(R.id.description_add);
                                text_description.setText(R.string.text_description_true_sub);
                                img_equlas.setImageResource(R.drawable.equlas);
                                counter = counter + 3;

                            } else {
                                img_add_1.setImageResource(array.img_array_digital[value_btn]);//выводим результат в первую картинку суммы
                                TextView text_description = (TextView) findViewById(R.id.description_add);
                                text_description.setText(R.string.text_description_false_sub);
                                img_equlas.setImageResource(R.drawable.non_equlas);
                                counter = counter - 2;

                            }
                            if (counter < 0) {
                                counter = 0;
                            }
                            String v = Integer.toString(counter);
                            counter_game.setText(v);
                            button_enter.setEnabled(false);
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
            Intent intent=new Intent(Level_sub.this, MainDirectory.class);
            startActivity(intent);
            finish();
        } catch ( Exception e) {}
    }
}