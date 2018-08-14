package com.app.retrofitparsing.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.retrofitparsing.R;
import com.app.retrofitparsing.model.GetUsers;

import java.util.List;

public class GetUserListAdapter extends ArrayAdapter<GetUsers.Data> {

    List<GetUsers.Data> userList;
    Context context;
    private LayoutInflater mInflater;

    public GetUserListAdapter(@NonNull Context context, int resource, @NonNull List<GetUsers.Data> userList) {
        super(context, resource, userList);
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        this.userList = userList;
    }


    /*public GetUserListAdapter(Context context, List<GetUsers.Data> userList) {
        super(context, 0, userList);
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        userList = userList;
    }*/

    @Override
    public GetUsers.Data getItem(int position) {
        return userList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final GetUserListAdapter.ViewHolder vh;
        if (convertView == null) {
            View view = mInflater.inflate(R.layout.layout_row_view, parent, false);
            vh = GetUserListAdapter.ViewHolder.create((RelativeLayout) view);
            view.setTag(vh);
        } else {
            vh = (GetUserListAdapter.ViewHolder) convertView.getTag();
        }

        GetUsers.Data item = getItem(position);

        vh.textViewName.setText(item.getName());
        vh.textViewEmail.setText(item.getColor());
        //Picasso.with(context).load(item.getProfilePic()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(vh.imageView);

        return vh.rootView;
    }

    private static class ViewHolder {
        public final RelativeLayout rootView;
        public final ImageView imageView;
        public final TextView textViewName;
        public final TextView textViewEmail;

        private ViewHolder(RelativeLayout rootView, ImageView imageView, TextView textViewName, TextView textViewEmail) {
            this.rootView = rootView;
            this.imageView = imageView;
            this.textViewName = textViewName;
            this.textViewEmail = textViewEmail;
        }

        public static GetUserListAdapter.ViewHolder create(RelativeLayout rootView) {
            ImageView imageView = (ImageView) rootView.findViewById(R.id.imageView);
            TextView textViewName = (TextView) rootView.findViewById(R.id.textViewName);
            TextView textViewEmail = (TextView) rootView.findViewById(R.id.textViewEmail);
            return new GetUserListAdapter.ViewHolder(rootView, imageView, textViewName, textViewEmail);
        }
    }


}
