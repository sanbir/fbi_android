package com.manish.customgridview;

import java.util.ArrayList;


import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	GridView gridView;
	ArrayList<Item> gridArray = new ArrayList<Item>();
	CustomGridViewAdapter customGridAdapter;

    //////////////////
    ArrayList<Bitmap> bitmaps = new ArrayList<Bitmap>();
    //////////////////

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu_activity);
		
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
		gridArray.add(new Item(icon2,"Фотогалерея zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz"));
		gridArray.add(new Item(icon3,"Объявления"));
		gridArray.add(new Item(icon4,"Учеба"));
        gridArray.add(new Item(icon5,"Новости"));
        gridArray.add(new Item(icon6,"Профком"));
        gridArray.add(new Item(icon7,"Библиотека"));
        gridArray.add(new Item(icon8,"Спорт"));
        gridArray.add(new Item(icon9,"СДО"));
		
/*		gridArray.add(new Item(icon1,"МЛ"));
		gridArray.add(new Item(icon2,"ММЛ"));
		gridArray.add(new Item(icon3,"Л"));
		gridArray.add(new Item(icon4,"ПИ"));
        gridArray.add(new Item(icon5,"ИСТ"));
        gridArray.add(new Item(icon6,"БИСТ"));
        gridArray.add(new Item(icon7,"МИСТ"));
        gridArray.add(new Item(icon8,"БПИ"));*/
		
		gridView = (GridView) findViewById(R.id.gridView1);
		customGridAdapter = new CustomGridViewAdapter(this, R.layout.row_grid, gridArray);
		gridView.setAdapter(customGridAdapter);

        ///////////////////
        final TextView text0 = (TextView) findViewById(R.id.text0);
        //text0.setText("    Протоколы зачисления >");
        text0.setText("");
        bitmaps.add(BitmapFactory.decodeResource(this.getResources(), R.drawable.dean));
        bitmaps.add(BitmapFactory.decodeResource(this.getResources(), R.drawable.mission));
        bitmaps.add(BitmapFactory.decodeResource(this.getResources(), R.drawable.kafedra));
        bitmaps.add(BitmapFactory.decodeResource(this.getResources(), R.drawable.engineer));
        bitmaps.add(BitmapFactory.decodeResource(this.getResources(), R.drawable.u4_lab_base));
        bitmaps.add(BitmapFactory.decodeResource(this.getResources(), R.drawable.video));


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent,
                                    View v, int position, long id) {
                Toast.makeText(MainActivity.this, position + "#Selected",
                        Toast.LENGTH_SHORT).show();

                /////////////////////////
                if (position == 0) {
                    startActivity (new Intent(getApplicationContext(), StartActivity.class));

                    /*text0.setText("    О ФБИ >");
                    gridArray.clear();
                    gridArray.add(new Item(bitmaps.get(0), "Декан"));
                    gridArray.add(new Item(bitmaps.get(1), "Миссия факультета"));
                    gridArray.add(new Item(bitmaps.get(2), "Кафедры"));
                    gridArray.add(new Item(bitmaps.get(3), "Направления и специальности"));
                    gridArray.add(new Item(bitmaps.get(4), "Учебно-лабораторная база"));
                    gridArray.add(new Item(bitmaps.get(5), "Видео-презентация факультета"));*/
                }


            }
        });


	}


}
