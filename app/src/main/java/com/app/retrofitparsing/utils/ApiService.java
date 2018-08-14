package com.app.retrofitparsing.utils;

import com.app.retrofitparsing.model.ContactList;
import com.app.retrofitparsing.model.GetQuestions;
import com.app.retrofitparsing.model.GetUserHeaders;
import com.app.retrofitparsing.model.GetUsers;
import com.app.retrofitparsing.model.ServerResponse;
import com.app.retrofitparsing.model.UserPostObject;
import com.app.retrofitparsing.model.User;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface ApiService {

    /*
   Retrofit get annotation with our URL
   And our method that will return us the List of ContactList
   */
    @GET("/json_data.json")
    Call<ContactList> getMyJSON();

    @GET("/api/unknown")
    Call<GetUsers> getUser();

    //https://api.stackexchange.com
    @GET("/2.2/questions?order=desc&sort=votes&" +
            "site=stackoverflow&tagged=android&filter=withbody")
    Call<GetQuestions> getQuestions();

    @POST("/api/users?")
    Call<User> userPostObject(@Body UserPostObject userPostObject);

    @FormUrlEncoded
    @POST("/api/users?")
    Call<User> doCreateUserWithField(@Field("name") String name, @Field("job") String job);

    @GET("users")
    Call<GetUserHeaders> getUserWithHeaders(@Header("Authorization") String authorization);

    @Multipart
    @POST("retrofit_example/upload_image.php")
    Call<ServerResponse> uploadFile(@Part MultipartBody.Part file,
                                    @Part("file") RequestBody name);

    @DELETE("department/delete/{id}")
    Call<User> deletePost(@Path("id") long id);
}
