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
import com.app.retrofitparsing.activity.RecyclerViewActivity;
import com.app.retrofitparsing.model.GetQuestions;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private static final String TAG = RecyclerAdapter.class.getSimpleName();
    private Context mContext;
    private List<GetQuestions.Items> mQuestionList;


    public RecyclerAdapter(RecyclerViewActivity mContext, List<GetQuestions.Items> mQuestionList) {
        this.mContext = mContext;
        this.mQuestionList = mQuestionList;
    }


    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_row_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        GetQuestions.Items items = mQuestionList.get(position);
        holder.textViewName.setText(items.getTitle());
        holder.textViewEmail.setText(items.getOwner().getDisplayName());
        Picasso.with(mContext).load(items.getOwner().getProfileImage()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mQuestionList.size();
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
