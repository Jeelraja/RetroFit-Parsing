package com.app.retrofitparsing.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.retrofitparsing.R;
import com.app.retrofitparsing.activity.HeadersActivity;
import com.app.retrofitparsing.activity.RecyclerViewActivity;
import com.app.retrofitparsing.model.GetUserHeaders;
import com.squareup.picasso.Picasso;

import java.util.List;

public class GetUserListWithHeadersAdapter extends RecyclerView.Adapter<GetUserListWithHeadersAdapter.ViewHolder> {

    private static final String TAG = GetUserListWithHeadersAdapter.class.getSimpleName();
    private Context mContext;
    private List<GetUserHeaders.Data> mUserList;


    public GetUserListWithHeadersAdapter(HeadersActivity mContext, List<GetUserHeaders.Data> mUserList) {
        this.mContext = mContext;
        this.mUserList = mUserList;
    }


    @NonNull
    @Override
    public GetUserListWithHeadersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_row_view, parent, false);
        return new GetUserListWithHeadersAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GetUserListWithHeadersAdapter.ViewHolder holder, int position) {
        GetUserHeaders.Data items = mUserList.get(position);
        holder.textViewName.setText(items.getFirstname() + " " + items.getLastname());
        holder.textViewEmail.setText(items.getEmailId());
        Picasso.with(mContext).load(items.getProfilePath()).
                placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView textViewName;
        public TextView textViewEmail;

        public ViewHolder(View itemView) {
            super(itemView);
            findViews(itemView);
        }

        private void findViews(View rootView) {
            imageView = (ImageView) rootView.findViewById(R.id.imageView);
            textViewName = (TextView) rootView.findViewById(R.id.textViewName);
            textViewEmail = (TextView) rootView.findViewById(R.id.textViewEmail);
        }
    }

}
