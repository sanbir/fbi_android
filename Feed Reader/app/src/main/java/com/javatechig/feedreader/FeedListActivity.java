package com.javatechig.feedreader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.javatechig.feedreader.model.FeedItem;

public class FeedListActivity extends Activity {

	private ArrayList<FeedItem> feedList = null;
	private ProgressBar progressbar = null;
	private ListView feedListView = null;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_posts_list);
		progressbar = (ProgressBar) findViewById(R.id.progressBar);

        InputStream in = null;
        try {
            in = getApplicationContext().getAssets().open("local_json.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file1 = new File(getApplicationContext().getExternalFilesDir(
                Environment.getExternalStorageState()), "local_json.json");

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

		new DownloadFilesTask().execute(in);
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

	public void updateList() {
		feedListView= (ListView) findViewById(R.id.custom_list);
		feedListView.setVisibility(View.VISIBLE);
		progressbar.setVisibility(View.GONE);
		
		feedListView.setAdapter(new CustomListAdapter(this, feedList));
		feedListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> a, View v, int position,	long id) {
				Object o = feedListView.getItemAtPosition(position);
				FeedItem newsData = (FeedItem) o;
				
				Intent intent = new Intent(FeedListActivity.this, FeedDetailsActivity.class);
				intent.putExtra("feed", newsData);
				startActivity(intent);
			}
		});
	}

	private class DownloadFilesTask extends AsyncTask<InputStream, Integer, Void> {

		@Override
		protected void onProgressUpdate(Integer... values) {
		}

        @Override
        protected Void doInBackground(InputStream... params) {
            InputStream url = params[0];

            // getting JSON string from URL
            JSONObject json = getJSONFromUrl(url);

            //parsing json data
            parseJson(json);
            return null;
        }

        @Override
		protected void onPostExecute(Void result) {
			if (null != feedList) {
				updateList();
			}
		}

	}

	
	public JSONObject getJSONFromUrl(InputStream is) {

		JSONObject jObj = null;
		String json = null;

		try {

			BufferedReader reader = new BufferedReader(new InputStreamReader(
					is, "iso-8859-1"), 8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			is.close();
			json = sb.toString();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			jObj = new JSONObject(json);
		} catch (JSONException e) {
			Log.e("JSON Parser", "Error parsing data " + e.toString());
		}

		// return JSON String
		return jObj;

	}

	public void parseJson(JSONObject json) {
		try {

			// parsing json object
			if (json.getString("status").equalsIgnoreCase("ok")) {
				JSONArray posts = json.getJSONArray("posts");

				feedList = new ArrayList<FeedItem>();

				for (int i = 0; i < posts.length(); i++) {
					JSONObject post = (JSONObject) posts.getJSONObject(i);
					FeedItem item = new FeedItem();
					item.setTitle(post.getString("title"));
					item.setDate(post.getString("date"));
					item.setId(post.getString("id"));
					item.setUrl(post.getString("url"));
					item.setContent(post.getString("content"));
					JSONArray attachments = post.getJSONArray("attachments");

					if (null != attachments && attachments.length() > 0) {
						JSONObject attachment = attachments.getJSONObject(0);
						if (attachment != null)
							item.setAttachmentUrl(attachment.getString("url"));
					}

					feedList.add(item);
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

}
