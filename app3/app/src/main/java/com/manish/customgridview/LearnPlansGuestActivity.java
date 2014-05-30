package com.manish.customgridview;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class LearnPlansGuestActivity extends Activity
{

    GridView gridView;
    ArrayList<Item> gridArray = new ArrayList<Item>();
    CustomGridViewAdapter customGridAdapter;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView (R.layout.menu_activity);

        TextView text0 = (TextView) findViewById(R.id.text0);
        text0.setText("    Учебные планы >");

        //set grid view item
        Bitmap icon1 = BitmapFactory.decodeResource(this.getResources(), R.drawable.ml);
        Bitmap icon2 = BitmapFactory.decodeResource(this.getResources(), R.drawable.mml);
        Bitmap icon3 = BitmapFactory.decodeResource(this.getResources(), R.drawable.l);
        Bitmap icon4 = BitmapFactory.decodeResource(this.getResources(), R.drawable.pi);
        Bitmap icon5 = BitmapFactory.decodeResource(this.getResources(), R.drawable.ist);
        Bitmap icon6 = BitmapFactory.decodeResource(this.getResources(), R.drawable.bist);
        Bitmap icon7 = BitmapFactory.decodeResource(this.getResources(), R.drawable.mist);
        Bitmap icon8 = BitmapFactory.decodeResource(this.getResources(), R.drawable.bpi);

        gridArray.add(new Item(icon1, ""));
        gridArray.add(new Item(icon2, ""));
        gridArray.add(new Item(icon3, ""));
        gridArray.add(new Item(icon4, ""));
        gridArray.add(new Item(icon5, ""));
        gridArray.add(new Item(icon6, ""));
        gridArray.add(new Item(icon7, ""));
        gridArray.add(new Item(icon8, ""));

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
                        //startActivity (new Intent(getApplicationContext(), OfbiActivity.class));
                        break;
                    case 5:
                        //startActivity (new Intent(getApplicationContext(), StartActivity.class));
                        break;
                    case 6:
                        //startActivity (new Intent(getApplicationContext(), StartActivity.class));
                        break;
                    case 7:
                        //startActivity (new Intent(getApplicationContext(), StudyActivity.class));
                        break;
                }

            }
        });
    }

}
