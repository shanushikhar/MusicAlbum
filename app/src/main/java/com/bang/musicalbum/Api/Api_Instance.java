package com.bang.musicalbum.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api_Instance {


    private static Retrofit sRetrofit = null;

    private static String URL = "http://rallycoding.herokuapp.com/";

    public static Api_interface getAPi() {


       if(sRetrofit == null){
           sRetrofit = new Retrofit
                   .Builder()
                   .baseUrl(URL)
                   .addConverterFactory(GsonConverterFactory.create())
                   .build();

        }

        return sRetrofit.create(Api_interface.class);
    }

}
