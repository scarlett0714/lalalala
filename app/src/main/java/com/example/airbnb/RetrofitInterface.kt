package com.example.airbnb

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitInterface {
    @GET("/main/{roomIdx}")
    fun getIsland(
        @Path("roomIdx") roomIdx: Int
    ): Call<IslandResponse> //response -> 나중에 Callback<>에 들어갈 내용

    @GET("/main/images/{roomIdx}")
    fun getIsland2(
        @Path("roomIdx") roomIdx: Int
    ): Call<IslandResponse2> //response -> 나중에 Callback<>에 들어갈 내용
}