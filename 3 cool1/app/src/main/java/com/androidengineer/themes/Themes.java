package com.androidengineer.themes;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;


public class Themes extends Activity implements OnClickListener
{
	Integer[] imageIDs = {
            R.drawable.camera,
            R.drawable.check,
            R.drawable.fg,
            R.drawable.gf,
            R.drawable.gfg,
            R.drawable.rtt,
            R.drawable.sched
    };
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		Utils.onActivityCreateSetTheme(this);
		setContentView(R.layout.main);

		findViewById(R.id.button1).setOnClickListener(this);
		findViewById(R.id.button2).setOnClickListener(this);
		findViewById(R.id.button3).setOnClickListener(this);
		findViewById(R.id.button4).setOnClickListener(this);
		
		GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(new ImageAdapter(this));

        gridView.setOnItemClickListener(new OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent,
            View v, int position, long id) {

            }
        });
	}
	
	public class ImageAdapter extends BaseAdapter 
    {
        private Context context;

        public ImageAdapter(Context c)
        {
            context = c;
        }

        //---returns the number of images---
        public int getCount() {
            return imageIDs.length;
        }

        //---returns the item---
        public Object getItem(int position) {
            return position;
        }

        //---returns the ID of an item---
        public long getItemId(int position) {
            return position;
        }

        //---returns an ImageView view---
        public View getView(int position, View convertView,
                ViewGroup parent)
        {
            ImageView imageView;
            if (convertView == null) {
                imageView = new ImageView(context);
                imageView.setLayoutParams(new
                        GridView.LayoutParams(80, 80));
                imageView.setScaleType(
                        ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(5, 5, 5, 5);
            } else {
                imageView = (ImageView) convertView;
            }
            imageView.setImageResource(imageIDs[position]);
            return imageView;
        }
    }

	@Override
	public void onClick(View v)
	{
		switch (v.getId())
		{
		case R.id.button1:
			Utils.changeToTheme(this, Utils.THEME_DEFAULT);
			break;
		case R.id.button2:
			Utils.changeToTheme(this, Utils.THEME_WHITE);
			break;
		case R.id.button3:
			Utils.changeToTheme(this, Utils.THEME_BLUE);
			break;
		case R.id.button4:
			Utils.changeToTheme(this, Utils.THEME_BROWN);
			break;
		}

	}

}