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

import com.manish.customgridview.displayingbitmaps.ui.ImageGridActivity;

import java.util.ArrayList;

public class GuestActivity extends Activity
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

        //set grid view item
        icon1 = BitmapFactory.decodeResource(this.getResources(), R.drawable.fbi256);
        icon2 = BitmapFactory.decodeResource(this.getResources(), R.drawable.plan_nabora);
        icon3 = BitmapFactory.decodeResource(this.getResources(), R.drawable.testt);
        icon4 = BitmapFactory.decodeResource(this.getResources(), R.drawable.price);
        icon5 = BitmapFactory.decodeResource(this.getResources(), R.drawable.employee);
        icon6 = BitmapFactory.decodeResource(this.getResources(), R.drawable.plan);
        icon7 = BitmapFactory.decodeResource(this.getResources(), R.drawable.protocols);
        icon8 = BitmapFactory.decodeResource(this.getResources(), R.drawable.camera);

        item1 = new Item(icon1,"О ФБИ");
        item2 = new Item(icon2,"План набора");
        item3 = new Item(icon3,"Вступительные испытания");
        item4 = new Item(icon4,"Стоимость обучения");
        item5 = new Item(icon5,"Наши работодатели");
        item6 = new Item(icon6,"Учебные планы");
        item7 = new Item(icon7,"Протоколы зачисления");
        item8 = new Item(icon8,"Фотогалерея");

        gridArray.add(item1);
        gridArray.add(item2);
        gridArray.add(item3);
        gridArray.add(item4);
        gridArray.add(item5);
        gridArray.add(item6);
        gridArray.add(item7);
        gridArray.add(item8);

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
                } else if (menuItemName.equals("План набора")) {
                    startActivity (new Intent(getApplicationContext(), PlanGuestActivity.class));
                } else if (menuItemName.equals("Вступительные испытания")) {
                    UserItemNew itemNew = new UserItemNew();
                    itemNew.setHeadline("Раздел в разработке");
                    itemNew.setBody("");

                    Intent intent = new Intent(GuestActivity.this, UserActivityNew.class);
                    intent.putExtra("feed", itemNew);
                    startActivity(intent);

                } else if (menuItemName.equals("Стоимость обучения")) {
                    UserItemNew itemNew = new UserItemNew();
                    itemNew.setHeadline("Раздел в разработке");
                    itemNew.setBody("");

                    Intent intent = new Intent(GuestActivity.this, UserActivityNew.class);
                    intent.putExtra("feed", itemNew);
                    startActivity(intent);

                } else if (menuItemName.equals("Наши работодатели")) {
                    UserItemNew itemNew = new UserItemNew();
                    itemNew.setHeadline("Раздел в разработке");
                    itemNew.setBody("");

                    Intent intent = new Intent(GuestActivity.this, UserActivityNew.class);
                    intent.putExtra("feed", itemNew);
                    startActivity(intent);

                } else if (menuItemName.equals("Учебные планы")) {
                    startActivity (new Intent(getApplicationContext(), LearnPlansGuestActivity.class));

                } else if (menuItemName.equals("Протоколы зачисления")) {
                    startActivity (new Intent(getApplicationContext(), ProtocolsGuestActivity.class));

                } else if (menuItemName.equals("Фотогалерея")) {
                    startActivity (new Intent(getApplicationContext(), ImageGridActivity.class));

                }

                /////////////////////////////////

                /*switch (position) {
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
                }*/

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
        Intent settingsActivity = new Intent(GuestActivity.this,
                PreferencesGuest.class);
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
        if (! prefs.getBoolean("plan_nabora", true)) {
            gridArray.remove(item2);
        } else {
            if (! gridArray.contains(item2)) {
                gridArray.add(item2);
            }
        }
        if (! prefs.getBoolean("exams", true)) {
            gridArray.remove(item3);
        } else {
            if (! gridArray.contains(item3)) {
                gridArray.add(item3);
            }
        }
        if (! prefs.getBoolean("cost", true)) {
            gridArray.remove(item4);
        } else {
            if (! gridArray.contains(item4)) {
                gridArray.add(item4);
            }
        }
        if (! prefs.getBoolean("employers", true)) {
            gridArray.remove(item5);
        } else {
            if (! gridArray.contains(item5)) {
                gridArray.add(item5);
            }
        }
        if (! prefs.getBoolean("learn_plans", true)) {
            gridArray.remove(item6);
        } else {
            if (! gridArray.contains(item6)) {
                gridArray.add(item6);
            }
        }
        if (! prefs.getBoolean("protocols", true)) {
            gridArray.remove(item7);
        } else {
            if (! gridArray.contains(item7)) {
                gridArray.add(item7);
            }
        }
        if (! prefs.getBoolean("photo", true)) {
            gridArray.remove(item8);
        } else {
            if (! gridArray.contains(item8)) {
                gridArray.add(item8);
            }
        }

        ListPreference = prefs.getString("listPref", "nr1");
    }

    @Override
    protected void onResume() {
        super.onResume();
        getPrefs();
        gridView.setAdapter(customGridAdapter);
    }

}
