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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        LinearLayout layout1 = (LinearLayout) findViewById(R.id.layout1);
        layout1.setVisibility(View.GONE);

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

        getPrefs();
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
    String editTextPreference;
    String ringtonePreference;
    String secondEditTextPreference;
    String customPref;

    private void getPrefs() {
        // Get the xml/preferences.xml preferences
        SharedPreferences prefs = PreferenceManager
                .getDefaultSharedPreferences(getBaseContext());
        CheckboxPreference = prefs.getBoolean("checkboxPref", true);
        ListPreference = prefs.getString("listPref", "nr1");
        editTextPreference = prefs.getString("editTextPref",
                "Nothing has been entered");
        ringtonePreference = prefs.getString("ringtonePref",
                "DEFAULT_RINGTONE_URI");
        secondEditTextPreference = prefs.getString("SecondEditTextPref",
                "Nothing has been entered");
        // Get the custom preference
        SharedPreferences mySharedPreferences = getSharedPreferences(
                "myCustomSharedPrefs", Activity.MODE_PRIVATE);
        customPref = mySharedPreferences.getString("myCusomPref", "");
    }

/*    @Override
    protected void onStart() {
        getPrefs();
    }*/
}
