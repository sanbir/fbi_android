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

public class GuestActivity extends Activity
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
        Bitmap icon2 = BitmapFactory.decodeResource(this.getResources(), R.drawable.plan_nabora);
        Bitmap icon3 = BitmapFactory.decodeResource(this.getResources(), R.drawable.testt);
        Bitmap icon4 = BitmapFactory.decodeResource(this.getResources(), R.drawable.price);
        Bitmap icon5 = BitmapFactory.decodeResource(this.getResources(), R.drawable.employee);
        Bitmap icon6 = BitmapFactory.decodeResource(this.getResources(), R.drawable.plan);
        Bitmap icon7 = BitmapFactory.decodeResource(this.getResources(), R.drawable.protocols);
        Bitmap icon8 = BitmapFactory.decodeResource(this.getResources(), R.drawable.camera);

        gridArray.add(new Item(icon1,"О ФБИ"));
        gridArray.add(new Item(icon2,"План набора"));
        gridArray.add(new Item(icon3,"Вступительные испытания"));
        gridArray.add(new Item(icon4,"Стоимость обучения"));
        gridArray.add(new Item(icon5,"Наши работодатели"));
        gridArray.add(new Item(icon6,"Учебные планы"));
        gridArray.add(new Item(icon7,"Протоколы зачисления"));
        gridArray.add(new Item(icon8,"Фотогалерея"));

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
                        startActivity (new Intent(getApplicationContext(), PlanGuestActivity.class));
                        break;
                    case 2:
                        UserItemNew itemNew = new UserItemNew();
                        itemNew.setHeadline("Раздел в разработке");
                        itemNew.setBody("");

                        Intent intent = new Intent(GuestActivity.this, UserActivityNew.class);
                        intent.putExtra("feed", itemNew);
                        startActivity(intent);
                        break;
                    case 3:
                        itemNew = new UserItemNew();
                        itemNew.setHeadline("Раздел в разработке");
                        itemNew.setBody("");

                        intent = new Intent(GuestActivity.this, UserActivityNew.class);
                        intent.putExtra("feed", itemNew);
                        startActivity(intent);
                        break;
                    case 4:
                        itemNew = new UserItemNew();
                        itemNew.setHeadline("Раздел в разработке");
                        itemNew.setBody("");

                        intent = new Intent(GuestActivity.this, UserActivityNew.class);
                        intent.putExtra("feed", itemNew);
                        startActivity(intent);
                        break;
                    case 5:
                        startActivity (new Intent(getApplicationContext(), LearnPlansGuestActivity.class));
                        break;
                    case 6:
                        startActivity (new Intent(getApplicationContext(), ProtocolsGuestActivity.class));
                        break;
                    case 7:
                        startActivity (new Intent(getApplicationContext(), ImageGridActivity.class));
                        break;
                }

            }
        });


    }


}
