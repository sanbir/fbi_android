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

public class ProfStudentActivity extends Activity
{

    GridView gridView;
    ArrayList<Item> gridArray = new ArrayList<Item>();
    CustomGridViewAdapter customGridAdapter;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView (R.layout.menu_activity);

        TextView text0 = (TextView) findViewById(R.id.text0);
        text0.setText("    Профком >");

        //set grid view item
        Bitmap icon1 = BitmapFactory.decodeResource(this.getResources(), R.drawable.website);
        Bitmap icon2 = BitmapFactory.decodeResource(this.getResources(), R.drawable.contact);

        gridArray.add(new Item(icon1, "Сайт sgups.net"));
        gridArray.add(new Item(icon2, "Телефоны"));

        gridView = (GridView) findViewById(R.id.gridView1);
        customGridAdapter = new CustomGridViewAdapter(this, R.layout.row_grid, gridArray);
        gridView.setAdapter(customGridAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent,
                                    View v, int position, long id) {

                switch (position) {
                    case 0:
                        Intent i = new Intent(getApplicationContext(), WebBrowserActivity.class);
                        i.putExtra("site","http://www.sgups.net/");
                        startActivity(i);
                        break;
                    case 1:
                        UserItemNew itemNew = new UserItemNew();
                        itemNew.setHeadline("Телефоны");
                        itemNew.setBody("3280229");

                        Intent intent = new Intent(ProfStudentActivity.this, UserActivityNew.class);
                        intent.putExtra("feed", itemNew);
                        startActivity(intent);
                        break;
                }

            }
        });
    }

}
