package com.app.retrofitparsing.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.app.retrofitparsing.adapter.GetUserListAdapter;
import com.app.retrofitparsing.model.GetUsers;
import com.app.retrofitparsing.model.User;
import com.app.retrofitparsing.utils.ApiService;
import com.app.retrofitparsing.model.ContactList;
import com.app.retrofitparsing.model.Contacts;
import com.app.retrofitparsing.adapter.MyContactAdapter;
import com.app.retrofitparsing.R;
import com.app.retrofitparsing.network.RetroClient;
import com.app.retrofitparsing.utils.CommonUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetResponseActivity extends AppCompatActivity {

    private ListView listView;
    private View parentView;

    private List<Contacts> contactList;
    private List<GetUsers.Data> userList;
    private MyContactAdapter adapter;
    private Button btnNextActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_response);
        contactList = new ArrayList<>();

        parentView = findViewById(R.id.parentLayout);
        btnNextActivity = findViewById(R.id.btnNextActivity);

        /**
         * Getting List and Setting List Adapter
         */
        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Snackbar.make(parentView, contactList.get(position).getName() + " => " + contactList.get(position).getPhone().getHome(), Snackbar.LENGTH_LONG).show();
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(@NonNull final View view) {
                //callGetWs();
                callGetUsersWs();
            }
        });


        btnNextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GetResponseActivity.this, RecyclerViewActivity.class);
                startActivity(intent);
            }
        });
    }

    private void callGetUsersWs() {
        /**
         * Checking Internet Connection
         */
        if (isInternetAvailable(getApplicationContext())) {
            CommonUtils.startProgressDialog(GetResponseActivity.this);
            //Creating an object of our api interface
            ApiService api = RetroClient.getApiService();

            /**
             * Calling JSON
             */
            Call<GetUsers> call = api.getUser();

            /**
             * Enqueue Callback will be call when get response...
             */
            call.enqueue(new Callback<GetUsers>() {
                @Override
                public void onResponse(Call<GetUsers> call, Response<GetUsers> response) {
                    //Dismiss Dialog
                    CommonUtils.dismissProgressDialog(GetResponseActivity.this);

                    if (response.isSuccessful()) {
                        /**
                         * Got Successfully
                         */
                        userList = response.body().getData();

                        /**
                         * Binding that List to Adapter
                         */
                        GetUserListAdapter adapter = new GetUserListAdapter(GetResponseActivity.this, 0, userList);
                        listView.setAdapter(adapter);

                    } else {
                        Snackbar.make(parentView, "Something went wrong!!", Snackbar.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<GetUsers> call, Throwable t) {
                    CommonUtils.dismissProgressDialog(GetResponseActivity.this);
                }
            });

        } else {
            Snackbar.make(parentView, "No Internet Connection Available", Snackbar.LENGTH_LONG).show();
        }
    }

    private void callGetWs() {
        /**
         * Checking Internet Connection
         */
        if (isInternetAvailable(getApplicationContext())) {
            CommonUtils.startProgressDialog(GetResponseActivity.this);

            //Creating an object of our api interface
            ApiService api = RetroClient.getApiService();

            /**
             * Calling JSON
             */
            Call<ContactList> call = api.getMyJSON();

            /**
             * Enqueue Callback will be call when get response...
             */
            call.enqueue(new Callback<ContactList>() {
                @Override
                public void onResponse(Call<ContactList> call, Response<ContactList> response) {
                    //Dismiss Dialog
                    CommonUtils.dismissProgressDialog(GetResponseActivity.this);

                    if (response.isSuccessful()) {
                        /**
                         * Got Successfully
                         */
                        contactList = response.body().getContacts();

                        /**
                         * Binding that List to Adapter
                         */
                        adapter = new MyContactAdapter(GetResponseActivity.this, contactList);
                        listView.setAdapter(adapter);

                    } else {
                        Snackbar.make(parentView, "Something went wrong!!", Snackbar.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<ContactList> call, Throwable t) {
                    CommonUtils.dismissProgressDialog(GetResponseActivity.this);
                }
            });

        } else {
            Snackbar.make(parentView, "No Internet Connection Available", Snackbar.LENGTH_LONG).show();
        }
    }


    public static boolean isInternetAvailable(Context context) {
        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            if (netInfo != null && netInfo.isConnectedOrConnecting()) {
                return true;
            } else {
                Toast.makeText(context, "No Intrnet Connection", Toast.LENGTH_SHORT).show();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
