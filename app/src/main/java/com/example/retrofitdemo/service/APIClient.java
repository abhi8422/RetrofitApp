package com.example.retrofitdemo.service;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public class APIClient {
    public static final String BASE_URL = "http://riztech.herokuapp.com/";
    public static  APIInterface apiInterface=null;

    public static APIInterface getClient() {
        if (apiInterface==null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            apiInterface=retrofit.create(APIInterface.class);
        }
        return apiInterface;
    }
    public interface APIInterface {
        @GET("myapp/api/employees")
        Call<List<Employee>> getAllEmployee();

        @GET("myapp/api/employees/{employeeId}")
        Call<Employee> findEmployee(@Path("employeeId")String employeeId );

        @POST("myapp/api/employees/single")
        Call<BaseResponse> addEmployee(@Body Employee employee);


    }


}
