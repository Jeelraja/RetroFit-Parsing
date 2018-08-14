package com.app.retrofitparsing.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.app.retrofitparsing.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnGetResponse, mBtnPostResponse, mBtnHeaders, mBtnMultipart, mBtnUpdate, mBtnDelete;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById();

    }

    private void findViewById() {

        mBtnGetResponse = findViewById(R.id.btnGetResponse);
        mBtnPostResponse = findViewById(R.id.btnPostResponse);
        mBtnHeaders = findViewById(R.id.btnHeaders);
        mBtnMultipart = findViewById(R.id.btnMultipart);
        mBtnUpdate=findViewById(R.id.btnUpdate);
        mBtnDelete=findViewById(R.id.btnDelete);

        mBtnGetResponse.setOnClickListener(this);
        mBtnPostResponse.setOnClickListener(this);
        mBtnHeaders.setOnClickListener(this);
        mBtnMultipart.setOnClickListener(this);
        mBtnUpdate.setOnClickListener(this);
        mBtnDelete.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.btnGetResponse:
                intent = new Intent(MainActivity.this, GetResponseActivity.class);
                startActivity(intent);
                break;

            case R.id.btnPostResponse:
                intent = new Intent(MainActivity.this, PostResponseActivity.class);
                startActivity(intent);
                break;

            case R.id.btnHeaders:
                intent = new Intent(MainActivity.this, HeadersActivity.class);
                startActivity(intent);
                break;

            case R.id.btnMultipart:
                intent = new Intent(MainActivity.this, MultipartActivity.class);
                startActivity(intent);
                break;

            case R.id.btnUpdate:

                break;

            case R.id.btnDelete:

                break;
        }
    }
}
