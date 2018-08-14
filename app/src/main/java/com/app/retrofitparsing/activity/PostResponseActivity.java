package com.app.retrofitparsing.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.retrofitparsing.R;
import com.app.retrofitparsing.model.User;
import com.app.retrofitparsing.model.UserPostObject;
import com.app.retrofitparsing.network.RetroClient;
import com.app.retrofitparsing.utils.ApiService;
import com.app.retrofitparsing.utils.CommonUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.app.retrofitparsing.activity.GetResponseActivity.isInternetAvailable;

public class PostResponseActivity extends AppCompatActivity {

    private EditText mEdtName, mEdtJob;
    private Button mBtnWithObj, mBtnWithField;
    public static final String API_KEY = "ICXE1wOphgKgcyMoHr0hVHbbJ";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_response);
        findViews();
    }

    private void findViews() {

        mEdtName = findViewById(R.id.edtName);
        mEdtJob = findViewById(R.id.edtJob);
        mBtnWithObj = findViewById(R.id.btnWithObj);
        mBtnWithField = findViewById(R.id.btnWithField);

        mBtnWithObj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callPostWithObjWs();
            }
        });
        mBtnWithField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callPostWithFieldWs();
            }
        });
    }

    private void callPostWithObjWs() {

        if (isInternetAvailable(getApplicationContext())) {
            CommonUtils.startProgressDialog(PostResponseActivity.this);
            //Creating an object of our api interface
            ApiService api = RetroClient.getApiService();
            UserPostObject userPostObject = new UserPostObject();
            userPostObject.setName(mEdtName.getText().toString());
            userPostObject.setName(mEdtJob.getText().toString());
            Call<User> call3 = api.userPostObject(userPostObject);
            call3.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    CommonUtils.dismissProgressDialog(PostResponseActivity.this);
                    User userList = response.body();
                    Toast.makeText(PostResponseActivity.this, "" + userList.getCreatedat(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    call.cancel();
                    CommonUtils.dismissProgressDialog(PostResponseActivity.this);
                }
            });

        }
    }
    private void callPostWithFieldWs() {

        if (isInternetAvailable(getApplicationContext())) {
            CommonUtils.startProgressDialog(PostResponseActivity.this);

            //Creating an object of our api interface
            ApiService api = RetroClient.getApiService();
            Call<User> call3 = api.doCreateUserWithField(mEdtName.getText().toString(), mEdtJob.getText().toString());
            call3.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    CommonUtils.dismissProgressDialog(PostResponseActivity.this);
                    User userList = response.body();
                    Toast.makeText(PostResponseActivity.this, "" + userList.getCreatedat(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    call.cancel();
                    CommonUtils.dismissProgressDialog(PostResponseActivity.this);
                }
            });

        }
    }

}
