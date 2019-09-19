package com.bang.musicalbum.Api;

import com.bang.musicalbum.Model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api_interface {


    @GET("api/music_albums")
    Call<Model> getAll() ;

}

