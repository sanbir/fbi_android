package com.manish.customgridview;

import java.util.ArrayList;


import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.GridView;
/**
 * 
 * @author manish.s
 *
 */

public class MainActivity extends Activity {
	GridView gridView;
	ArrayList<Item> gridArray = new ArrayList<Item>();
	 CustomGridViewAdapter customGridAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//set grid view item
		Bitmap icon1 = BitmapFactory.decodeResource(this.getResources(), R.drawable.fbi144);
		Bitmap icon2 = BitmapFactory.decodeResource(this.getResources(), R.drawable.camera);
        Bitmap icon3 = BitmapFactory.decodeResource(this.getResources(), R.drawable.horn);
        Bitmap icon4 = BitmapFactory.decodeResource(this.getResources(), R.drawable.study);
        Bitmap icon5 = BitmapFactory.decodeResource(this.getResources(), R.drawable.news);
        Bitmap icon6 = BitmapFactory.decodeResource(this.getResources(), R.drawable.prof);
        Bitmap icon7 = BitmapFactory.decodeResource(this.getResources(), R.drawable.gfg);
        Bitmap icon8 = BitmapFactory.decodeResource(this.getResources(), R.drawable.er);
        Bitmap icon9 = BitmapFactory.decodeResource(this.getResources(), R.drawable.rtt);
		
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
	}

}