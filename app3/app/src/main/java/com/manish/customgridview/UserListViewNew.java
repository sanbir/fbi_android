package com.manish.customgridview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import java.util.ArrayList;

public class UserListViewNew extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listview_new);

		ArrayList<UserItemNew> image_details = getListData();
		final ListView lv1 = (ListView) findViewById(R.id.custom_list);
		lv1.setAdapter(new CustomListAdapterNew(this, image_details));
		lv1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> a, View v, int position, long id) {
				Object o = lv1.getItemAtPosition(position);
				UserItemNew newsData = (UserItemNew) o;
				/*Toast.makeText(UserListViewNew.this, "Selected :" + " " + newsData,
						Toast.LENGTH_LONG).show();*/

                Intent intent = new Intent(UserListViewNew.this, UserActivityNew.class);
                intent.putExtra("feed", newsData);
                startActivity(intent);
			}

		});

	}

	private ArrayList<UserItemNew> getListData() {
		ArrayList<UserItemNew> results = new ArrayList<UserItemNew>();
		UserItemNew newsData = new UserItemNew();
		newsData.setHeadline("Dance of Democracy");
		newsData.setReporterName("Pankaj Gupta");
		newsData.setDate("May 26, 2013, 13:35");
		newsData.setUrl("http://www.stu.ru/images/theme/29804.jpg");
        newsData.setBody("ffffffffff1");
        newsData.setUrlBig("http://www.stu.ru/images/theme/29805.jpg");
		results.add(newsData);

		newsData = new UserItemNew();
		newsData.setHeadline("Major Naxal attacks in the past");
		newsData.setReporterName("Pankaj Gupta");
		newsData.setDate("May 26, 2013, 13:35");
		newsData.setUrl("http://www.stu.ru/images/theme/29806.jpg");
        newsData.setBody("ffffffffff2");
        newsData.setUrlBig("http://www.stu.ru/images/theme/29807.jpg");
		results.add(newsData);

		return results;
	}
}
