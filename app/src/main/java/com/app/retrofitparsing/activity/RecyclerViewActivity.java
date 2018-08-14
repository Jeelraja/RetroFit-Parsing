package com.app.retrofitparsing.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.app.retrofitparsing.R;
import com.app.retrofitparsing.adapter.RecyclerAdapter;
import com.app.retrofitparsing.model.GetQuestions;
import com.app.retrofitparsing.network.RetroClient;
import com.app.retrofitparsing.utils.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.app.retrofitparsing.activity.GetResponseActivity.isInternetAvailable;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RelativeLayout parentView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        parentView = findViewById(R.id.parentLayout);
        mRecyclerView = findViewById(R.id.recycler_list);
        callGetQuestionsWs();
    }

    private void callGetQuestionsWs() {
        /**
         * Checking Internet Connection
         */
        if (isInternetAvailable(getApplicationContext())) {
            final ProgressDialog dialog;
            /**
             * Progress Dialog for User Interaction
             */
            dialog = new ProgressDialog(RecyclerViewActivity.this);
            dialog.setTitle("Process");
            dialog.setMessage("Please Wait..");
            dialog.show();

            //Creating an object of our api interface
            ApiService api = RetroClient.getApiGetService();
            Call<GetQuestions> call = api.getQuestions();
            call.enqueue(new Callback<GetQuestions>() {

                @Override
                public void onResponse(Call<GetQuestions> call, Response<GetQuestions> response) {
                    dialog.dismiss();
                    if (response.isSuccessful()) {

                        List<GetQuestions.Items> items = response.body().getItems();
                        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                        mRecyclerView.addItemDecoration(new DividerItemDecoration(RecyclerViewActivity.this, 0));
                        mRecyclerView.setLayoutManager(mLayoutManager);
                        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
                        RecyclerAdapter mAdapter = new RecyclerAdapter(RecyclerViewActivity.this, items);
                        mRecyclerView.setAdapter(mAdapter);

                    } else {
                        Toast.makeText(RecyclerViewActivity.this, "Something went wrong!!", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<GetQuestions> call, Throwable t) {
                    dialog.dismiss();
                }
            });

        } else {
            Snackbar.make(parentView, "No Internet Connection Available", Snackbar.LENGTH_LONG).show();
        }
    }
}
