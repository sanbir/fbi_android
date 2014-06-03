package com.manish.customgridview;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        LinearLayout layout1 = (LinearLayout) findViewById(R.id.layout1);
        layout1.setVisibility(View.GONE);

        //set grid view item
        Bitmap icon1 = BitmapFactory.decodeResource(this.getResources(), R.drawable.news);
        Bitmap icon2 = BitmapFactory.decodeResource(this.getResources(), R.drawable.horn);
        Bitmap icon3 = BitmapFactory.decodeResource(this.getResources(), R.drawable.schedule);
        Bitmap icon4 = BitmapFactory.decodeResource(this.getResources(), R.drawable.camera);
        Bitmap icon5 = BitmapFactory.decodeResource(this.getResources(), R.drawable.nirs);
        Bitmap icon6 = BitmapFactory.decodeResource(this.getResources(), R.drawable.prof);

        gridArray.add(new Item(icon1,"Новости"));
        gridArray.add(new Item(icon2,"Объявления"));
        gridArray.add(new Item(icon3,"Расписание"));
        gridArray.add(new Item(icon4,"Фотогалерея"));
        gridArray.add(new Item(icon5,"НИРС"));
        gridArray.add(new Item(icon6,"Профком сотрудников"));

        gridView = (GridView) findViewById(R.id.gridView1);
        customGridAdapter = new CustomGridViewAdapter(this, R.layout.row_grid, gridArray);
        gridView.setAdapter(customGridAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent,
                                    View v, int position, long id) {

                switch (position) {
                    case 0:
                        ArrayList<UserItemNew> notices = NewsAndNoticesSource.getListNews();
                        Intent intent = new Intent(TeacherActivity.this, UserListViewNew.class);
                        intent.putExtra("customList", notices);
                        startActivity(intent);
                        break;
                    case 1:
                        notices = NewsAndNoticesSource.getListNotices();
                        intent = new Intent(TeacherActivity.this, UserListViewNew.class);
                        intent.putExtra("customList", notices);
                        startActivity(intent);
                        break;
                    case 2:
                        startActivity (new Intent(getApplicationContext(), ScheduleTeacherActivity.class));
                        break;
                    case 3:
                        startActivity (new Intent(getApplicationContext(), ImageGridActivity.class));
                        break;
                    case 4:
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
                        break;
                    case 5:
                        UserItemNew itemNew = new UserItemNew();
                        itemNew.setHeadline("Телефоны");
                        itemNew.setBody("3280295");

                        intent = new Intent(TeacherActivity.this, UserActivityNew.class);
                        intent.putExtra("feed", itemNew);
                        startActivity(intent);
                        break;
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

}