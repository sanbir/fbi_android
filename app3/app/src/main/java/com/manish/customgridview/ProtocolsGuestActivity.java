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
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;

public class ProtocolsGuestActivity extends Activity
{

    GridView gridView;
    ArrayList<Item> gridArray = new ArrayList<Item>();
    CustomGridViewAdapter customGridAdapter;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView (R.layout.menu_activity);

        TextView text0 = (TextView) findViewById(R.id.text0);
        text0.setText("    Протоколы зачисления >");

        //set grid view item
        Bitmap icon1 = BitmapFactory.decodeResource(this.getResources(), R.drawable.ml);
        Bitmap icon2 = BitmapFactory.decodeResource(this.getResources(), R.drawable.mml);
        Bitmap icon3 = BitmapFactory.decodeResource(this.getResources(), R.drawable.l);
        Bitmap icon4 = BitmapFactory.decodeResource(this.getResources(), R.drawable.pi);
        Bitmap icon5 = BitmapFactory.decodeResource(this.getResources(), R.drawable.ist);
        Bitmap icon6 = BitmapFactory.decodeResource(this.getResources(), R.drawable.bist);
        Bitmap icon7 = BitmapFactory.decodeResource(this.getResources(), R.drawable.mist);
        Bitmap icon8 = BitmapFactory.decodeResource(this.getResources(), R.drawable.bpi);

        gridArray.add(new Item(icon1, ""));
        gridArray.add(new Item(icon2, ""));
        gridArray.add(new Item(icon3, ""));
        gridArray.add(new Item(icon4, ""));
        gridArray.add(new Item(icon5, ""));
        gridArray.add(new Item(icon6, ""));
        gridArray.add(new Item(icon7, ""));
        gridArray.add(new Item(icon8, ""));

        gridView = (GridView) findViewById(R.id.gridView1);
        customGridAdapter = new CustomGridViewAdapter(this, R.layout.row_grid, gridArray);
        gridView.setAdapter(customGridAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent,
                                    View v, int position, long id) {

                switch (position) {
                    case 0:
                        InputStream in = null;
                        try {
                            in = getApplicationContext().getAssets().open("uch_plan_ml.xls");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        File file1 = new File(getApplicationContext().getExternalFilesDir(
                                Environment.getExternalStorageState()), "Учебный план МЛ");

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
                        newIntent1.setDataAndType(path1, "application/vnd.ms-excel");
                        newIntent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);


                        try {
                            startActivity(newIntent1);
                        } catch (ActivityNotFoundException ex) {
                            ex.printStackTrace();
                        }
                        break;
                    case 1:
                        in = null;
                        try {
                            in = getApplicationContext().getAssets().open("uch_plan_mml.xls");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        file1 = new File(getApplicationContext().getExternalFilesDir(
                                Environment.getExternalStorageState()), "Учебный план ММЛ");

                        out = null;
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

                        path1 = Uri.fromFile(file1);

                        // Parse the file into a uri to share with another application

                        newIntent1 = new Intent(Intent.ACTION_VIEW);
                        newIntent1.setDataAndType(path1, "application/vnd.ms-excel");
                        newIntent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);


                        try {
                            startActivity(newIntent1);
                        } catch (ActivityNotFoundException ex) {
                            ex.printStackTrace();
                        }
                        break;
                    case 2:
                        in = null;
                        try {
                            in = getApplicationContext().getAssets().open("uch_plan_l.xls");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        file1 = new File(getApplicationContext().getExternalFilesDir(
                                Environment.getExternalStorageState()), "Учебный план Л");

                        out = null;
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

                        path1 = Uri.fromFile(file1);

                        // Parse the file into a uri to share with another application

                        newIntent1 = new Intent(Intent.ACTION_VIEW);
                        newIntent1.setDataAndType(path1, "application/vnd.ms-excel");
                        newIntent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);


                        try {
                            startActivity(newIntent1);
                        } catch (ActivityNotFoundException ex) {
                            ex.printStackTrace();
                        }
                        break;
                    case 3:
                        in = null;
                        try {
                            in = getApplicationContext().getAssets().open("uch_plan_pi.xls");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        file1 = new File(getApplicationContext().getExternalFilesDir(
                                Environment.getExternalStorageState()), "Учебный план ПИ");

                        out = null;
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

                        path1 = Uri.fromFile(file1);

                        // Parse the file into a uri to share with another application

                        newIntent1 = new Intent(Intent.ACTION_VIEW);
                        newIntent1.setDataAndType(path1, "application/vnd.ms-excel");
                        newIntent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);


                        try {
                            startActivity(newIntent1);
                        } catch (ActivityNotFoundException ex) {
                            ex.printStackTrace();
                        }
                        break;

                    case 4:
                        in = null;
                        try {
                            in = getApplicationContext().getAssets().open("uch_plan_ist.xls");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        file1 = new File(getApplicationContext().getExternalFilesDir(
                                Environment.getExternalStorageState()), "Учебный план ИСТ");

                        out = null;
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

                        path1 = Uri.fromFile(file1);

                        // Parse the file into a uri to share with another application

                        newIntent1 = new Intent(Intent.ACTION_VIEW);
                        newIntent1.setDataAndType(path1, "application/vnd.ms-excel");
                        newIntent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);


                        try {
                            startActivity(newIntent1);
                        } catch (ActivityNotFoundException ex) {
                            ex.printStackTrace();
                        }
                        break;
                    case 5:
                        in = null;
                        try {
                            in = getApplicationContext().getAssets().open("uch_plan_bist.xls");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        file1 = new File(getApplicationContext().getExternalFilesDir(
                                Environment.getExternalStorageState()), "Учебный план БИСТ");

                        out = null;
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

                        path1 = Uri.fromFile(file1);

                        // Parse the file into a uri to share with another application

                        newIntent1 = new Intent(Intent.ACTION_VIEW);
                        newIntent1.setDataAndType(path1, "application/vnd.ms-excel");
                        newIntent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);


                        try {
                            startActivity(newIntent1);
                        } catch (ActivityNotFoundException ex) {
                            ex.printStackTrace();
                        }
                        break;
                    case 6:
                        in = null;
                        try {
                            in = getApplicationContext().getAssets().open("uch_plan_mist.xls");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        file1 = new File(getApplicationContext().getExternalFilesDir(
                                Environment.getExternalStorageState()), "Учебный план МИСТ");

                        out = null;
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

                        path1 = Uri.fromFile(file1);

                        // Parse the file into a uri to share with another application

                        newIntent1 = new Intent(Intent.ACTION_VIEW);
                        newIntent1.setDataAndType(path1, "application/vnd.ms-excel");
                        newIntent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);


                        try {
                            startActivity(newIntent1);
                        } catch (ActivityNotFoundException ex) {
                            ex.printStackTrace();
                        }
                        break;
                    case 7:
                        in = null;
                        try {
                            in = getApplicationContext().getAssets().open("uch_plan_bpi.xls");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        file1 = new File(getApplicationContext().getExternalFilesDir(
                                Environment.getExternalStorageState()), "Учебный план БПИ");

                        out = null;
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

                        path1 = Uri.fromFile(file1);

                        // Parse the file into a uri to share with another application

                        newIntent1 = new Intent(Intent.ACTION_VIEW);
                        newIntent1.setDataAndType(path1, "application/vnd.ms-excel");
                        newIntent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);


                        try {
                            startActivity(newIntent1);
                        } catch (ActivityNotFoundException ex) {
                            ex.printStackTrace();
                        }
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
