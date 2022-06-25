package com.example.airbnb

import com.example.airbnb.ApplicationClass.Companion.retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class IslandService {
    private lateinit var islandview: IslandView

    private val IslandService = retrofit.create(RetrofitInterface::class.java)

    fun setIslandView(islandview: IslandView){
        this.islandview = islandview
    }

    fun sender(roomIdx:Int){
        IslandService.getIsland(roomIdx).enqueue(object: Callback<IslandResponse> {
            //응답이 왔을 때 처리
            override fun onResponse(call: Call<IslandResponse>, response: Response<IslandResponse>) {
                val resp:IslandResponse = response.body()!!
                when(resp.code){
                    //API code값 사용
                    1000->islandview.onIslandSuccess(resp.result) //result를 받아서 UI를 구현해야함
                    else->islandview.onIslandFailure(resp.code) //무슨 오류인지 알아야하므로 code가져가기
                }
            }
            //실패했을 때 처리
            override fun onFailure(call: Call<IslandResponse>, t: Throwable) {

            }

        })
    }

    fun sender2(roomIdx:Int){
        IslandService.getIsland2(roomIdx).enqueue(object: Callback<IslandResponse2> {
            //응답이 왔을 때 처리
            override fun onResponse(call: Call<IslandResponse2>, response: Response<IslandResponse2>) {
                val resp:IslandResponse2 = response.body()!!
                when(resp.code){
                    //API code값 사용
                    1000->islandview.onIslandSuccess2(resp.resultImg) //result를 받아서 UI를 구현해야함
                    else->islandview.onIslandFailure2(resp.code) //무슨 오류인지 알아야하므로 code가져가기
                }
            }
            //실패했을 때 처리
            override fun onFailure(call: Call<IslandResponse2>, t: Throwable) {

            }

        })
    }
}