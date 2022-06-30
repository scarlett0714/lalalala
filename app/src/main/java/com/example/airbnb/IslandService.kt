package com.example.airbnb

import android.util.Log
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
                Log.d("response", response.body().toString())
                val resp:IslandResponse = response.body()!!
                Log.d("na", resp.toString())
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
        Log.d("lililili", "야호")
        IslandService.getIsland2(roomIdx).enqueue(object: Callback<IslandResponsetwo> {
            //응답이 왔을 때 처리
            override fun onResponse(call: Call<IslandResponsetwo>, response: Response<IslandResponsetwo>) {
                Log.d("nanana", response.toString())
                val resp:IslandResponsetwo = response.body()!!
                Log.d("lilili", resp.toString())
                when(resp.code){
                    //API code값 사용
                    1000->islandview.onIslandSuccess2(resp.result_Img) //result를 받아서 UI를 구현해야함
                    else->islandview.onIslandFailure2(resp.code) //무슨 오류인지 알아야하므로 code가져가기
                }
            }
            //실패했을 때 처리
            override fun onFailure(call: Call<IslandResponsetwo>, t: Throwable) {
                Log.d("fail", t.toString())
            }

        })
    }
}