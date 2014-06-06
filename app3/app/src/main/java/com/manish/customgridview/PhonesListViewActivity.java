package com.manish.customgridview;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhonesListViewActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_new);

        ArrayList<UserItemNew> image_details =
                (ArrayList<UserItemNew>) this.getIntent().getSerializableExtra("customList");

        //ArrayList<UserItemNew> image_details = getListData();
        final ListView lv1 = (ListView) findViewById(R.id.custom_list);
        lv1.setAdapter(new PhoneListAdapter(this, image_details));
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = lv1.getItemAtPosition(position);
                UserItemNew newsData = (UserItemNew) o;
				/*Toast.makeText(UserListViewNew.this, "Selected :" + " " + newsData,
						Toast.LENGTH_LONG).show();*/

                String number = "tel:" + newsData.getReporterName().trim();
                Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse(number));
                startActivity(callIntent);
            }

        });

    }


}