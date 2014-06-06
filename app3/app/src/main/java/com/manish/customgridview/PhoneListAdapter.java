package com.manish.customgridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PhoneListAdapter extends BaseAdapter {

    private ArrayList<UserItemNew> listData;

    private LayoutInflater layoutInflater;

    public PhoneListAdapter(Context context, ArrayList<UserItemNew> listData) {
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.phones_list_row, null);
            holder = new ViewHolder();
            holder.headlineView = (TextView) convertView.findViewById(R.id.title);
            holder.reporterNameView = (TextView) convertView.findViewById(R.id.reporter);
            //holder.imageView = (ImageView) convertView.findViewById(R.id.thumbImage);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        UserItemNew newsItem = (UserItemNew) listData.get(position);

        holder.headlineView.setText(newsItem.getHeadline());
        holder.reporterNameView.setText(newsItem.getReporterName());
        //holder.imageView.setImageResource(android.R.drawable.ic_menu_call);
/*
        if (holder.imageView != null) {
            new ImageDownloaderTaskNew(holder.imageView).execute(newsItem.getUrl());
        }*/

        return convertView;
    }

    static class ViewHolder {
        TextView headlineView;
        TextView reporterNameView;
        //TextView reportedDateView;
        //ImageView imageView;
    }
}