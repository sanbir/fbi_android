package com.manish.customgridview;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

public class StudyActivity extends Activity
{
    GridView gridView;
    ArrayList<Item> gridArray = new ArrayList<Item>();
    CustomGridViewAdapter customGridAdapter;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView (R.layout.menu_activity);

        TextView text0 = (TextView) findViewById(R.id.text0);
        text0.setText("    Учеба >");

        //set grid view item
        Bitmap icon1 = BitmapFactory.decodeResource(this.getResources(), R.drawable.schedule);
        Bitmap icon2 = BitmapFactory.decodeResource(this.getResources(), R.drawable.progress);
        Bitmap icon3 = BitmapFactory.decodeResource(this.getResources(), R.drawable.plan);
        Bitmap icon4 = BitmapFactory.decodeResource(this.getResources(), R.drawable.nirs);

        gridArray.add(new Item(icon1, "Расписание"));
        gridArray.add(new Item(icon2, "Успеваемость"));
        gridArray.add(new Item(icon3, "Учебный план"));
        gridArray.add(new Item(icon4, "НИРС"));

        gridView = (GridView) findViewById(R.id.gridView1);
        customGridAdapter = new CustomGridViewAdapter(this, R.layout.row_grid, gridArray);
        gridView.setAdapter(customGridAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent,
                                    View v, int position, long id) {

                switch (position) {
                    case 0:
                        File file = new File("/storage/emulated/0/Download/Rezultaty.xlsx");

                        // The unique identifier for the file
                        Uri path = Uri.fromFile(file);

                        // Parse the file into a uri to share with another application

                        Intent newIntent = new Intent(Intent.ACTION_VIEW);
                        newIntent.setDataAndType(path, "application/vnd.ms-excel");
                        newIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                        try {
                            startActivity(newIntent);
                        } catch (ActivityNotFoundException ex) {
                            ex.printStackTrace();
                        }
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
                }

            }
        });
    }

}
