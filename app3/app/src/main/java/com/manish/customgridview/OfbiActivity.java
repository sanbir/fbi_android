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

public class OfbiActivity extends Activity
{

    GridView gridView;
    ArrayList<Item> gridArray = new ArrayList<Item>();
    CustomGridViewAdapter customGridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        TextView text0 = (TextView) findViewById(R.id.text0);
        text0.setText("    О ФБИ >");

        //set grid view item
        Bitmap icon1 = BitmapFactory.decodeResource(this.getResources(), R.drawable.dean);
        Bitmap icon2 = BitmapFactory.decodeResource(this.getResources(), R.drawable.mission);
        Bitmap icon3 = BitmapFactory.decodeResource(this.getResources(), R.drawable.kafedra);
        Bitmap icon4 = BitmapFactory.decodeResource(this.getResources(), R.drawable.engineer);
        Bitmap icon5 = BitmapFactory.decodeResource(this.getResources(), R.drawable.u4_lab_base);
        Bitmap icon6 = BitmapFactory.decodeResource(this.getResources(), R.drawable.video);

        gridArray.add(new Item(icon1, "Декан"));
        gridArray.add(new Item(icon2, "Миссия факультета"));
        gridArray.add(new Item(icon3, "Кафедры"));
        gridArray.add(new Item(icon4, "Направления и специальности"));
        gridArray.add(new Item(icon5, "Учебно-лабораторная база"));
        gridArray.add(new Item(icon6, "Видео-презентация факультета"));

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
                        //startActivity (new Intent(getApplicationContext(), StartActivity.class));
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
