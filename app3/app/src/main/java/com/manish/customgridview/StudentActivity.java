package com.manish.customgridview;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.manish.customgridview.displayingbitmaps.ui.ImageGridActivity;

import java.util.ArrayList;

public class StudentActivity extends Activity
{
    GridView gridView;
    ArrayList<Item> gridArray = new ArrayList<Item>();
    CustomGridViewAdapter customGridAdapter;

    Bitmap icon1;
    Bitmap icon2;
    Bitmap icon3;
    Bitmap icon4;
    Bitmap icon5;
    Bitmap icon6;
    Bitmap icon7;
    Bitmap icon8;
    Bitmap icon9;

    Item item1;
    Item item2;
    Item item3;
    Item item4;
    Item item5;
    Item item6;
    Item item7;
    Item item8;
    Item item9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        LinearLayout layout1 = (LinearLayout) findViewById(R.id.layout1);
        layout1.setVisibility(View.GONE);

        icon1 = BitmapFactory.decodeResource(this.getResources(), R.drawable.fbi256);
        icon2 = BitmapFactory.decodeResource(this.getResources(), R.drawable.camera);
        icon3 = BitmapFactory.decodeResource(this.getResources(), R.drawable.horn);
        icon4 = BitmapFactory.decodeResource(this.getResources(), R.drawable.study);
        icon5 = BitmapFactory.decodeResource(this.getResources(), R.drawable.news);
        icon6 = BitmapFactory.decodeResource(this.getResources(), R.drawable.prof);
        icon7 = BitmapFactory.decodeResource(this.getResources(), R.drawable.library);
        icon8 = BitmapFactory.decodeResource(this.getResources(), R.drawable.sport);
        icon9 = BitmapFactory.decodeResource(this.getResources(), R.drawable.sdo);

        item1 = new Item(icon1,"О ФБИ");
        item2 = new Item(icon2,"Фотогалерея");
        item3 = new Item(icon3,"Объявления");
        item4 = new Item(icon4,"Учеба");
        item5 = new Item(icon5,"Новости");
        item6 = new Item(icon6,"Профком");
        item7 = new Item(icon7,"Библиотека");
        item8 = new Item(icon8,"Спорт");
        item9 = new Item(icon9,"СДО");

        //set grid view item
        gridArray.add(item1);
        gridArray.add(item2);
        gridArray.add(item3);
        gridArray.add(item4);
        gridArray.add(item5);
        gridArray.add(item6);
        gridArray.add(item7);
        gridArray.add(item8);
        gridArray.add(item9);

        getPrefs();

        gridView = (GridView) findViewById(R.id.gridView1);
        customGridAdapter = new CustomGridViewAdapter(this, R.layout.row_grid, gridArray);
        gridView.setAdapter(customGridAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent,
                                    View v, int position, long id) {

                String menuItemName = null;
                ViewGroup gridChild = (ViewGroup) v;
                int childSize = gridChild.getChildCount();
                for(int k = 0; k < childSize; k++) {
                    if( gridChild.getChildAt(k) instanceof TextView) {
                        menuItemName = ((TextView) gridChild.getChildAt(k)).getText().toString();
                    }
                }

                if (menuItemName.equals("О ФБИ")) {
                    startActivity (new Intent(getApplicationContext(), OfbiActivity.class));
                } else if (menuItemName.equals("Фотогалерея")) {
                    startActivity (new Intent(getApplicationContext(), ImageGridActivity.class));
                } else if (menuItemName.equals("Объявления")) {
                    ArrayList<UserItemNew> notices = NewsAndNoticesSource.getListNotices();
                    Intent intent = new Intent(StudentActivity.this, UserListViewNew.class);
                    intent.putExtra("customList", notices);
                    startActivity(intent);

                } else if (menuItemName.equals("Учеба")) {
                    startActivity (new Intent(getApplicationContext(), StudyActivity.class));

                } else if (menuItemName.equals("Новости")) {
                    ArrayList<UserItemNew> news = NewsAndNoticesSource.getListNews();
                    Intent intent = new Intent(StudentActivity.this, UserListViewNew.class);
                    intent.putExtra("customList", news);
                    startActivity(intent);

                } else if (menuItemName.equals("Профком")) {
                    startActivity (new Intent(getApplicationContext(), ProfStudentActivity.class));

                } else if (menuItemName.equals("Библиотека")) {
                    Intent i = new Intent(getApplicationContext(), WebBrowserActivity.class);
                    i.putExtra("site","http://81.1.243.214");
                    startActivity(i);

                } else if (menuItemName.equals("Спорт")) {
                    UserItemNew itemNew = new UserItemNew();
                    itemNew.setHeadline("Спорт");
                    itemNew.setBody("Здесь будет информация о спорте");

                    Intent intent = new Intent(StudentActivity.this, UserActivityNew.class);
                    intent.putExtra("feed", itemNew);
                    startActivity(intent);

                } else if (menuItemName.equals("СДО")) {
                    UserItemNew itemNew = new UserItemNew();
                    itemNew.setHeadline("СДО");
                    itemNew.setDate("Телефоны");
                    itemNew.setBody("3280240");

                    Intent intent = new Intent(StudentActivity.this, UserActivityNew.class);
                    intent.putExtra("feed", itemNew);
                    startActivity(intent);

                }




            }
        });


    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.action_settings).setVisible(true);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent settingsActivity = new Intent(StudentActivity.this,
                Preferences.class);
        startActivity(settingsActivity);
        return true;
    }

    boolean CheckboxPreference;
    String ListPreference;

    private void getPrefs() {
        // Get the xml/preferences.xml preferences
        SharedPreferences prefs = PreferenceManager
                .getDefaultSharedPreferences(getBaseContext());

        if (! prefs.getBoolean("ofbi", true)) {
            gridArray.remove(item1);
        } else {
            if (! gridArray.contains(item1)) {
                gridArray.add(item1);
            }
        }
        if (! prefs.getBoolean("photo", true)) {
            gridArray.remove(item2);
        } else {
            if (! gridArray.contains(item2)) {
                gridArray.add(item2);
            }
        }
        if (! prefs.getBoolean("notices", true)) {
            gridArray.remove(item3);
        } else {
            if (! gridArray.contains(item3)) {
                gridArray.add(item3);
            }
        }
        if (! prefs.getBoolean("study", true)) {
            gridArray.remove(item4);
        } else {
            if (! gridArray.contains(item4)) {
                gridArray.add(item4);
            }
        }
        if (! prefs.getBoolean("news", true)) {
            gridArray.remove(item5);
        } else {
            if (! gridArray.contains(item5)) {
                gridArray.add(item5);
            }
        }
        if (! prefs.getBoolean("profcom", true)) {
            gridArray.remove(item6);
        } else {
            if (! gridArray.contains(item6)) {
                gridArray.add(item6);
            }
        }
        if (! prefs.getBoolean("library", true)) {
            gridArray.remove(item7);
        } else {
            if (! gridArray.contains(item7)) {
                gridArray.add(item7);
            }
        }
        if (! prefs.getBoolean("sport", true)) {
            gridArray.remove(item8);
        } else {
            if (! gridArray.contains(item8)) {
                gridArray.add(item8);
            }
        }
        if (! prefs.getBoolean("sdo", true)) {
            gridArray.remove(item9);
        } else {
            if (! gridArray.contains(item9)) {
                gridArray.add(item9);
            }
        }

        ListPreference = prefs.getString("listPref", "nr1");
    }

/*    @Override
    protected void onStart() {
        getPrefs();
    }*/

    @Override
    protected void onResume() {
        super.onResume();
        getPrefs();
        gridView.setAdapter(customGridAdapter);
    }


}
