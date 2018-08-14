package com.app.retrofitparsing.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.app.retrofitparsing.R;
import com.app.retrofitparsing.adapter.GetUserListWithHeadersAdapter;
import com.app.retrofitparsing.model.GetUserHeaders;
import com.app.retrofitparsing.network.RetroClient;
import com.app.retrofitparsing.utils.ApiService;
import com.app.retrofitparsing.utils.CommonUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.app.retrofitparsing.activity.GetResponseActivity.isInternetAvailable;

public class HeadersActivity extends AppCompatActivity {

    private RecyclerView mRecycleView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        mRecycleView = findViewById(R.id.recycler_list);
        callGetUsersHeadersWs();
    }

    private void callGetUsersHeadersWs() {
        if (isInternetAvailable(getApplicationContext())) {
            CommonUtils.startProgressDialog(HeadersActivity.this);
            //Creating an object of our api interface
            ApiService api = RetroClient.getApiHeadersService();
            Call<GetUserHeaders> call = api.getUserWithHeaders("U2FsdGVkX19BDEZMuN7b4uquiY1DhwKpBfyf3nPUVQw=");
            call.enqueue(new Callback<GetUserHeaders>() {

                @Override
                public void onResponse(Call<GetUserHeaders> call, Response<GetUserHeaders> response) {

                    CommonUtils.dismissProgressDialog(HeadersActivity.this);
                    List<GetUserHeaders.Data> data = response.body().getData();
                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                    mRecycleView.addItemDecoration(new DividerItemDecoration(HeadersActivity.this, 0));
                    mRecycleView.setLayoutManager(mLayoutManager);
                    mRecycleView.setItemAnimator(new DefaultItemAnimator());
                    GetUserListWithHeadersAdapter mAdapter = new GetUserListWithHeadersAdapter(HeadersActivity.this, data);
                    mRecycleView.setAdapter(mAdapter);
                }

                @Override
                public void onFailure(Call<GetUserHeaders> call, Throwable t) {
                    Toast.makeText(HeadersActivity.this, "Something went wrong!!", Toast.LENGTH_SHORT).show();
                }
            });

        } else {
            Toast.makeText(this, "No Internet Connection Available", Toast.LENGTH_SHORT).show();
        }
    }
}
