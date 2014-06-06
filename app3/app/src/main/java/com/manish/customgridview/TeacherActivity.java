package com.manish.customgridview;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;

public class TeacherActivity extends Activity
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

    Item item1;
    Item item2;
    Item item3;
    Item item4;
    Item item5;
    Item item6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        LinearLayout layout1 = (LinearLayout) findViewById(R.id.layout1);
        layout1.setVisibility(View.GONE);

        //set grid view item
        icon1 = BitmapFactory.decodeResource(this.getResources(), R.drawable.news);
        icon2 = BitmapFactory.decodeResource(this.getResources(), R.drawable.horn);
        icon3 = BitmapFactory.decodeResource(this.getResources(), R.drawable.schedule);
        icon4 = BitmapFactory.decodeResource(this.getResources(), R.drawable.camera);
        icon5 = BitmapFactory.decodeResource(this.getResources(), R.drawable.nirs);
        icon6 = BitmapFactory.decodeResource(this.getResources(), R.drawable.prof);

        item1 = new Item(icon1,"Новости");
        item2 = new Item(icon2,"Объявления");
        item3 = new Item(icon3,"Расписание");
        item4 = new Item(icon4,"Фотогалерея");
        item5 = new Item(icon5,"НИРС");
        item6 = new Item(icon6,"Профком сотрудников");

        gridArray.add(item1);
        gridArray.add(item2);
        gridArray.add(item3);
        gridArray.add(item4);
        gridArray.add(item5);
        gridArray.add(item6);

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

                if (menuItemName.equals("Новости")) {
                    ArrayList<UserItemNew> notices = NewsAndNoticesSource.getListNews();
                    Intent intent = new Intent(TeacherActivity.this, UserListViewNew.class);
                    intent.putExtra("customList", notices);
                    startActivity(intent);
                } else if (menuItemName.equals("Объявления")) {
                    ArrayList<UserItemNew> notices = NewsAndNoticesSource.getListNotices();
                    Intent intent = new Intent(TeacherActivity.this, UserListViewNew.class);
                    intent.putExtra("customList", notices);
                    startActivity(intent);
                } else if (menuItemName.equals("Расписание")) {
                    startActivity (new Intent(getApplicationContext(), ScheduleTeacherActivity.class));

                } else if (menuItemName.equals("Фотогалерея")) {
                    startActivity (new Intent(getApplicationContext(), ImageGridActivity.class));

                } else if (menuItemName.equals("НИРС")) {
                    InputStream in = null;
                    try {
                        in = getApplicationContext().getAssets().open("nirs.doc");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    File file1 = new File(getApplicationContext().getExternalFilesDir(
                            Environment.getExternalStorageState()), "НИРС");

                    OutputStream out = null;
                    try {
                        out = new FileOutputStream(file1);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    try {
                        copyCompletely(in, out);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        out.flush();
                        out.close();
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Uri path1 = Uri.fromFile(file1);

                    // Parse the file into a uri to share with another application

                    Intent newIntent1 = new Intent(Intent.ACTION_VIEW);
                    newIntent1.setDataAndType(path1, "application/msword");
                    newIntent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);


                    try {
                        startActivity(newIntent1);
                    } catch (ActivityNotFoundException ex) {
                        ex.printStackTrace();
                    }

                } else if (menuItemName.equals("Профком сотрудников")) {
                    ArrayList<UserItemNew> news = NewsAndNoticesSource.getListPhonesTeacherProfcom();
                    Intent intent = new Intent(TeacherActivity.this, PhonesListViewActivity.class);
                    intent.putExtra("customList", news);
                    startActivity(intent);

                }


            }
        });


    }

    public static void copyCompletely(InputStream input, OutputStream output) throws IOException {
    // if both are file streams, use channel IO
    if ((output instanceof FileOutputStream) && (input instanceof FileInputStream)) {
        try {
            FileChannel target = ((FileOutputStream) output).getChannel();
            FileChannel source = ((FileInputStream) input).getChannel();

            source.transferTo(0, Integer.MAX_VALUE, target);

            source.close();
            target.close();

            return;
        } catch (Exception e) { /* failover to byte stream version */
        }
    }

    byte[] buf = new byte[8192];
    while (true) {
        int length = input.read(buf);
        if (length < 0)
            break;
        output.write(buf, 0, length);
    }

    try {
        input.close();
    } catch (IOException ignore) {
    }
    try {
        output.close();
    } catch (IOException ignore) {
    }
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
        Intent settingsActivity = new Intent(TeacherActivity.this,
                PreferencesTeacher.class);
        startActivity(settingsActivity);
        return true;
    }

    boolean CheckboxPreference;
    String ListPreference;

    private void getPrefs() {
        // Get the xml/preferences.xml preferences
        SharedPreferences prefs = PreferenceManager
                .getDefaultSharedPreferences(getBaseContext());

        if (! prefs.getBoolean("news", true)) {
            gridArray.remove(item1);
        } else {
            if (! gridArray.contains(item1)) {
                gridArray.add(item1);
            }
        }
        if (! prefs.getBoolean("notices", true)) {
            gridArray.remove(item2);
        } else {
            if (! gridArray.contains(item2)) {
                gridArray.add(item2);
            }
        }
        if (! prefs.getBoolean("schedule", true)) {
            gridArray.remove(item3);
        } else {
            if (! gridArray.contains(item3)) {
                gridArray.add(item3);
            }
        }
        if (! prefs.getBoolean("photo", true)) {
            gridArray.remove(item4);
        } else {
            if (! gridArray.contains(item4)) {
                gridArray.add(item4);
            }
        }
        if (! prefs.getBoolean("nirs", true)) {
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

        ListPreference = prefs.getString("listPref", "nr1");
    }

    @Override
    protected void onResume() {
        super.onResume();
        getPrefs();
        gridView.setAdapter(customGridAdapter);
    }

}