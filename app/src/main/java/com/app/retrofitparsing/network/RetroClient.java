package com.app.retrofitparsing.network;

import com.app.retrofitparsing.utils.ApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClient {
    /********
     * URLS
     *******/
    //private static final String ROOT_URL = "http://pratikbutani.x10.mx";
    private static final String ROOT_URL = "https://reqres.in";
    private static final String ROOT_URL_GET = "https://api.stackexchange.com";
    private static final String ROOT_URL_GET_HEADERS = "https://api.stackexchange.com"; //please change URL having headers
    private static final String ROOT_URL_PICK_IMAGE = "http://mushtaq.16mb.com/";
    private static final String ROOT_URL_DELETE = "http://198.58.98.34:4400/api/";

    /**
     * Get Retrofit Instance
     */
    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiService getApiService() {
        return getRetrofitInstance().create(ApiService.class);
    }

    /**
     * Get Retrofit GET Instance
     */
    private static Retrofit getRetrofitGetInstance() {
        return new Retrofit.Builder()
                .baseUrl(ROOT_URL_GET)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiService getApiGetService() {
        return getRetrofitGetInstance().create(ApiService.class);
    }

    /**
     * Get Retrofit Headers Instance
     */
    private static Retrofit getRetrofitHeadersInstance() {
        return new Retrofit.Builder()
                .baseUrl(ROOT_URL_GET_HEADERS)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiService getApiHeadersService() {
        return getRetrofitHeadersInstance().create(ApiService.class);
    }

    /**
     * Get Retrofit Multipart Instance
     */
    private static Retrofit getRetrofitMultipartInstance() {
        return new Retrofit.Builder()
                .baseUrl(ROOT_URL_PICK_IMAGE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiService getApiMultipartService() {
        return getRetrofitMultipartInstance().create(ApiService.class);
    }

}
