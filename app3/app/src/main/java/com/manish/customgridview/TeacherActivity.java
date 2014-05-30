package com.manish.customgridview;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class TeacherActivity extends Activity
{

    GridView gridView;
    ArrayList<Item> gridArray = new ArrayList<Item>();
    CustomGridViewAdapter customGridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set grid view item
        Bitmap icon1 = BitmapFactory.decodeResource(this.getResources(), R.drawable.news);
        Bitmap icon2 = BitmapFactory.decodeResource(this.getResources(), R.drawable.horn);
        Bitmap icon3 = BitmapFactory.decodeResource(this.getResources(), R.drawable.schedule);
        Bitmap icon4 = BitmapFactory.decodeResource(this.getResources(), R.drawable.camera);
        Bitmap icon5 = BitmapFactory.decodeResource(this.getResources(), R.drawable.nirs);
        Bitmap icon6 = BitmapFactory.decodeResource(this.getResources(), R.drawable.prof);

        gridArray.add(new Item(icon1,"Новости"));
        gridArray.add(new Item(icon2,"Объявления"));
        gridArray.add(new Item(icon3,"Расписание"));
        gridArray.add(new Item(icon4,"Фотогалерея"));
        gridArray.add(new Item(icon5,"НИРС"));
        gridArray.add(new Item(icon6,"Профком сотрудников"));

        gridView = (GridView) findViewById(R.id.gridView1);
        customGridAdapter = new CustomGridViewAdapter(this, R.layout.row_grid, gridArray);
        gridView.setAdapter(customGridAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent,
                                    View v, int position, long id) {

                switch (position) {
                    case 0:
                        //startActivity (new Intent(getApplicationContext(), OfbiActivity.class));
                        break;
                    case 1:
                        //startActivity (new Intent(getApplicationContext(), StartActivity.class));
                        break;
                    case 2:
                        startActivity (new Intent(getApplicationContext(), ScheduleTeacherActivity.class));
                        break;
                    case 3:
                        //startActivity (new Intent(getApplicationContext(), StudyActivity.class));
                        break;
                    case 4:
                        //startActivity (new Intent(getApplicationContext(), StartActivity.class));
                        break;
                    case 5:
                        //startActivity (new Intent(getApplicationContext(), ProfStudentActivity.class));
                        break;
                }

            }
        });


    }


}