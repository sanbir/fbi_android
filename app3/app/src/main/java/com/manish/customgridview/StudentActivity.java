package com.manish.customgridview;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.manish.customgridview.displayingbitmaps.ui.ImageGridActivity;

import java.util.ArrayList;

public class StudentActivity extends Activity
{
    GridView gridView;
    ArrayList<Item> gridArray = new ArrayList<Item>();
    CustomGridViewAdapter customGridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        LinearLayout layout1 = (LinearLayout) findViewById(R.id.layout1);
        layout1.setVisibility(View.GONE);

        //set grid view item
        Bitmap icon1 = BitmapFactory.decodeResource(this.getResources(), R.drawable.fbi256);
        Bitmap icon2 = BitmapFactory.decodeResource(this.getResources(), R.drawable.camera);
        Bitmap icon3 = BitmapFactory.decodeResource(this.getResources(), R.drawable.horn);
        Bitmap icon4 = BitmapFactory.decodeResource(this.getResources(), R.drawable.study);
        Bitmap icon5 = BitmapFactory.decodeResource(this.getResources(), R.drawable.news);
        Bitmap icon6 = BitmapFactory.decodeResource(this.getResources(), R.drawable.prof);
        Bitmap icon7 = BitmapFactory.decodeResource(this.getResources(), R.drawable.library);
        Bitmap icon8 = BitmapFactory.decodeResource(this.getResources(), R.drawable.sport);
        Bitmap icon9 = BitmapFactory.decodeResource(this.getResources(), R.drawable.sdo);

        gridArray.add(new Item(icon1,"О ФБИ"));
        gridArray.add(new Item(icon2,"Фотогалерея"));
        gridArray.add(new Item(icon3,"Объявления"));
        gridArray.add(new Item(icon4,"Учеба"));
        gridArray.add(new Item(icon5,"Новости"));
        gridArray.add(new Item(icon6,"Профком"));
        gridArray.add(new Item(icon7,"Библиотека"));
        gridArray.add(new Item(icon8,"Спорт"));
        gridArray.add(new Item(icon9,"СДО"));

        gridView = (GridView) findViewById(R.id.gridView1);
        customGridAdapter = new CustomGridViewAdapter(this, R.layout.row_grid, gridArray);
        gridView.setAdapter(customGridAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent,
                                    View v, int position, long id) {

            switch (position) {
                case 0:
                    startActivity (new Intent(getApplicationContext(), OfbiActivity.class));
                    break;
                case 1:
                    startActivity (new Intent(getApplicationContext(), ImageGridActivity.class));
                    break;
                case 2:
                    //startActivity (new Intent(getApplicationContext(), StartActivity.class));
                    break;
                case 3:
                    startActivity (new Intent(getApplicationContext(), StudyActivity.class));
                    break;
                case 4:
                    //startActivity (new Intent(getApplicationContext(), StartActivity.class));
                    break;
                case 5:
                    startActivity (new Intent(getApplicationContext(), ProfStudentActivity.class));
                    break;
                case 6:
                    //startActivity (new Intent(getApplicationContext(), StartActivity.class));
                    break;
                case 7:
                    //startActivity (new Intent(getApplicationContext(), StartActivity.class));
                    break;
                case 8:
                    //startActivity (new Intent(getApplicationContext(), StartActivity.class));
                    break;
            }

            }
        });


    }

}
