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
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Level_sel extends AppCompatActivity {

    //Переменные класс -начало
    public int numLeft;
    public int numRight;
    public int numAdd; //переменная суммы
    public int refer;//переменная сылки на картинку второго числа в ответе
    public int  value_btn;//переменная ссылки на кнопку при ответе
    public int  value_btn1;//переменная ссылки на кнопку при ответе
    public String v;//переменная ссылки на кнопку при ответе
    public int i=0;
    public int counter=0;
    //Переменные класса - конец

    Dialog dialog;
    Dialog dialog_less;
    Array array = new Array();
    Random random = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_sel);

        Window w = getWindow(); //Раскрываем игру на весь экран
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

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
                    Intent intent = new Intent(Level_sel.this, MainDirectory.class);
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
        text_dialog_res.setText(R.string.text_norm_dialog);

        //Устанавливаем текст в диалоговое окно

        //Обрабатываем нажатие кнопки перейти в меню выбора игры
        Button btn_back_dialog_res=(Button)dialog_less.findViewById(R.id.btn_back_dialog);
        btn_back_dialog_res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Level_sel.this, MainDirectory.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
                dialog_less.dismiss();
            }
        });




        ImageView img_Left = (ImageView) findViewById(R.id.img_Left);//закрепили слагаемые за левой
        ImageView img_Right = (ImageView) findViewById(R.id.img_Right);//и правой позициями
        ImageView img_plus = (ImageView) findViewById(R.id.img_plus);
        TextView counter_game=(TextView) findViewById(R.id.counter_game);//игровой счетчик
        TextView text_picture_Left=(TextView)findViewById(R.id.text_picture_left);
        TextView text_picture_Right=(TextView)findViewById(R.id.text_picture_right);

        //Присваиваем переменным id адреса кнопок


        //Кнопка назад - начало
        Button button_back = (Button) findViewById(R.id.button_back_add);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    Intent intent = new Intent(Level_sel.this, MainDirectory.class);
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
                //ограничиваем игру 20 циклами это 20 баллов
                if(i==20){
                    if(counter==20) {
                    dialog.show();}
                    if(counter<20) {
                        dialog_less.show();
                    }
                }

                else {
                    img_plus.setImageResource(R.drawable.img_question);//устанавливаем знак вопроса

                    TextView text_description = (TextView) findViewById(R.id.description_add);
                    text_description.setText(R.string.description_sel);

                    //Генерация чисел - начало
                    numLeft = random.nextInt(20);
                    numRight = random.nextInt(20);
                    while (numLeft == numRight) {
                        numRight = random.nextInt(20);
                    }
                    //Генерация чисел - конец

                    //text_description.setText(R.string.description_add);
                    img_Left.setImageResource(array.array_pictures[numLeft]);
                    img_Right.setImageResource(array.array_pictures[numRight]);
                    text_picture_Left.setText(array.array_text_pictures[numLeft]);
                    text_picture_Right.setText(array.array_text_pictures[numRight]);

                    img_Left.setEnabled(true);//включаем картинку
                    img_Right.setEnabled(true);//включаем  картинку
                    i=i+1;


                    //обрабатываем нажатие левой  картинки
                    img_Left.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                                img_Right.setEnabled(false);//выключаем правую картинку
                                if (numLeft > numRight) {
                                    img_plus.setImageResource(R.drawable.img_larger);
                                    text_description.setText(R.string.text_description_true_sel);
                                    counter = counter + 1;

                                } else {
                                    img_plus.setImageResource(R.drawable.img_larger_no);
                                    text_description.setText(R.string.text_description_false_sel);
                                    counter = counter - 1;

                                }
                                if (counter < 0) {
                                    counter = 0;
                                }
                                v= Integer.toString(counter);
                                counter_game.setText(v);
                                img_Left.setEnabled(false);//включаем  картинку

                            }

                            return true;
                        }
                    });

                    img_Right.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                                img_Left.setEnabled(false);//выключаем  картинку
                                if (numLeft < numRight) {
                                    img_plus.setImageResource(R.drawable.img_less);
                                    text_description.setText(R.string.text_description_true_sel);
                                    counter = counter + 1;

                                } else {
                                    img_plus.setImageResource(R.drawable.img_less_no);
                                    text_description.setText(R.string.text_description_false_sel);
                                    counter = counter - 1;

                                }
                                if (counter < 0) {
                                    counter = 0;
                                }
                                String v = Integer.toString(counter);
                                counter_game.setText(v);
                                img_Right.setEnabled(false);//включаем  картинку

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
            Intent intent=new Intent(Level_sel.this, MainDirectory.class);
            startActivity(intent);
            finish();
        } catch ( Exception e) {}
    }
}