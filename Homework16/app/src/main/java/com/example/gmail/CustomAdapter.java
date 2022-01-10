package com.example.gmail;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    private ArrayList<String> data;
    public CustomAdapter(ArrayList<String> data){
        this.data = data;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, null);
            TextView a = convertView.findViewById(R.id.textView1);
            viewHolder = new MyHolder();
            viewHolder.setA(a);
            convertView.setTag(viewHolder);
        } else{
            viewHolder = (MyHolder) convertView.getTag();
        }

        viewHolder.getA().setText(data.get(position));
        return convertView;
    }

    private class MyHolder{
        private TextView a;

        private MyHolder() {

        }

        public TextView getA() {
            return a;
        }

        public void setA(TextView a) {
            this.a = a;
        }
    }

}

