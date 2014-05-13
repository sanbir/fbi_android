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
		Bitmap icon1 = BitmapFactory.decodeResource(this.getResources(), R.drawable.ml);
		Bitmap icon2 = BitmapFactory.decodeResource(this.getResources(), R.drawable.mml);
        Bitmap icon3 = BitmapFactory.decodeResource(this.getResources(), R.drawable.l);
        Bitmap icon4 = BitmapFactory.decodeResource(this.getResources(), R.drawable.pi);
        Bitmap icon5 = BitmapFactory.decodeResource(this.getResources(), R.drawable.ist);
        Bitmap icon6 = BitmapFactory.decodeResource(this.getResources(), R.drawable.bist);
        Bitmap icon7 = BitmapFactory.decodeResource(this.getResources(), R.drawable.mist);
        Bitmap icon8 = BitmapFactory.decodeResource(this.getResources(), R.drawable.bpi);
		
		gridArray.add(new Item(icon1,"МЛ"));
		gridArray.add(new Item(icon2,"ММЛ"));
		gridArray.add(new Item(icon3,"Л"));
		gridArray.add(new Item(icon4,"ПИ"));
        gridArray.add(new Item(icon5,"ИСТ"));
        gridArray.add(new Item(icon6,"БИСТ"));
        gridArray.add(new Item(icon7,"МИСТ"));
        gridArray.add(new Item(icon8,"БПИ"));
		
		gridView = (GridView) findViewById(R.id.gridView1);
		customGridAdapter = new CustomGridViewAdapter(this, R.layout.row_grid, gridArray);
		gridView.setAdapter(customGridAdapter);
	}

}
