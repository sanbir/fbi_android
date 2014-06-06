package com.manish.customgridview;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class Sport extends Activity
{

    GridView gridView;
    ArrayList<Item> gridArray = new ArrayList<Item>();
    CustomGridViewAdapter customGridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        TextView text0 = (TextView) findViewById(R.id.text0);
        text0.setText("    Спорт >");

        //set grid view item
        Bitmap icon1 = BitmapFactory.decodeResource(this.getResources(), R.drawable.skiing);
        Bitmap icon2 = BitmapFactory.decodeResource(this.getResources(), R.drawable.pingpong);
        Bitmap icon3 = BitmapFactory.decodeResource(this.getResources(), R.drawable.athletics);
        Bitmap icon4 = BitmapFactory.decodeResource(this.getResources(), R.drawable.basketball);

        gridArray.add(new Item(icon1, "Лыжные гонки"));
        gridArray.add(new Item(icon2, "Настольный теннис"));
        gridArray.add(new Item(icon3, "Легкая атлетика"));
        gridArray.add(new Item(icon4, "Баскетбол"));

        gridView = (GridView) findViewById(R.id.gridView1);
        customGridAdapter = new CustomGridViewAdapter(this, R.layout.row_grid, gridArray);
        gridView.setAdapter(customGridAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent,
                                    View v, int position, long id) {

                switch (position) {
                    case 0:
                        UserItemNew itemNew = new UserItemNew();
                        itemNew.setHeadline("Тренировки по лыжным гонкам");
                        itemNew.setBody("Понедельник\n" +
                                "Среда\t\t\t\t\t\t16:00\n" +
                                "Пятница\n\n" +
                                "Тренировки проводятся в доме спорта\n\n" +
                                "Тренеры:\n" +
                                "Родионов Владимир Андреевич (юноши)\n" +
                                "Богалий Анна Ивановна (девушки)");

                        Intent intent = new Intent(Sport.this, UserActivityNew.class);
                        intent.putExtra("custom", itemNew);
                        startActivity(intent);
                        break;
                    case 1:
                        itemNew = new UserItemNew();
                        itemNew.setHeadline("Тренировки по настольному теннису");
                        itemNew.setBody("Понедельник\n" +
                                "Вторник\t\t\t17:30-19:00\n" +
                                "Пятница\n" +
                                "\n" +
                                "Тренировки проводятся в зале учебного корпуса\n" +
                                "\n" +
                                "Тренер:\n" +
                                "Мазенокова Ольга Валентиновна\n");


                        intent = new Intent(Sport.this, UserActivityNew.class);
                        intent.putExtra("feed", itemNew);
                        startActivity(intent);
                        break;
                    case 2:
                        itemNew = new UserItemNew();
                        itemNew.setHeadline("Расписание тренировок по легкой атлетике");
                        itemNew.setBody("понедельник\n" +
                                "9:00-11:00\n" +
                                "14:30-17:00\n" +
                                "КСК «Сибирь»\n" +
                                "\n" +
                                "вторник\n" +
                                "9:00-11:15\n" +
                                "14:00-18:30\n" +
                                "Дом спорта СГУПС\n" +
                                "\n" +
                                "среда\n" +
                                "9:00-11:00\n" +
                                "14:30-17:00\n" +
                                "КСК «Сибирь»\n" +
                                "\n" +
                                "четверг\t\n" +
                                "11:00-14:00\n" +
                                "Дом спорта СГУПС\n" +
                                "\n" +
                                "пятница\n" +
                                "9:00-11:00\n" +
                                "14:30-17:00\n" +
                                "КСК «Сибирь»\n" +
                                "\n" +
                                "суббота\n" +
                                "9:00-11:15\n" +
                                "14:00-18:30\n" +
                                "Дом спорта СГУПС\n" +
                                "\n" +
                                "\n" +
                                "Тренеры:\n" +
                                "Никитин Александр Николаевич\n" +
                                "Никитина Ольга Владимировна\n" +
                                "Мартынов Александр Федорович\n");


                        intent = new Intent(Sport.this, UserActivityNew.class);
                        intent.putExtra("custom", itemNew);
                        startActivity(intent);
                        break;
                    case 3:
                        itemNew = new UserItemNew();
                        itemNew.setHeadline("Тренировки по баскетболу (девушки)");
                        itemNew.setBody("понедельник\n" +
                                "18:30-20:00\n" +
                                "\n" +
                                "четверг\n" +
                                "17:00-18:30\n" +
                                "\n" +
                                "пятница\n" +
                                "18:30-20:00\n" +
                                "\n" +
                                "Тренировки проводятся в игровом зале дома спорта\n" +
                                "\n" +
                                "Тренер: Коваленко Яков Петрович\n");


                        intent = new Intent(Sport.this, UserActivityNew.class);
                        intent.putExtra("feed", itemNew);
                        startActivity(intent);
                        break;
                }

            }
        });


    }


}