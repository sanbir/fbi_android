package com.manish.customgridview;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class ScheduleTeacherActivity extends Activity
{

    GridView gridView;
    ArrayList<Item> gridArray = new ArrayList<Item>();
    CustomGridViewAdapter customGridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        TextView text0 = (TextView) findViewById(R.id.text0);
        text0.setText("    Расписание >");

        //set grid view item
        Bitmap icon1 = BitmapFactory.decodeResource(this.getResources(), R.drawable.teacher);
        Bitmap icon2 = BitmapFactory.decodeResource(this.getResources(), R.drawable.schedule_group);
        Bitmap icon3 = BitmapFactory.decodeResource(this.getResources(), R.drawable.schedule_classrooms);

        gridArray.add(new Item(icon1, "Расписание преподавателя"));
        gridArray.add(new Item(icon2, "Расписание групп"));
        gridArray.add(new Item(icon3, "Расписание аудиторий"));

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
                }

            }
        });


    }

}
