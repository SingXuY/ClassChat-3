package com.example.classchat.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.classchat.Activity.Activity_SearchAddCourse;
import com.example.classchat.R;
import com.example.classchat.model.AddCourseDataBase;

import java.util.List;

public class Adapter_AuthListAdapter extends BaseAdapter {
    LayoutInflater inflater;
    List<String> ls;
    Context mContext;

    AddCourseDataBase medium;

    public Adapter_AuthListAdapter(Context context, List<String> objects){
        mContext=context;
        this.inflater=LayoutInflater.from(context);
        this.ls=objects;

    }

    public boolean isEnabled(int position) {
        return false;
    }
    @Override
    public int getCount() {
        return ls.size();
    }

    @Override
    public Object getItem(int position) {
        return ls.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_auth, null);
            new ViewHolder(convertView);
        }
        ViewHolder holder = (ViewHolder) convertView.getTag();// get convertView's holder

        holder.string.setText(getItem(position).toString());


        return convertView;
    }

    class ViewHolder {
        TextView string;


        public ViewHolder(View convertView){
            string = (TextView) convertView.findViewById(R.id.auth_list_item);
            convertView.setTag(this);//set a viewholder
        }
    }


}

