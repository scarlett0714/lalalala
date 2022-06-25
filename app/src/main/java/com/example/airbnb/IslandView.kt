package com.example.airbnb

interface IslandView {
    fun onIslandSuccess(result : IslandResult)
    fun onIslandFailure(code : Int)

    fun onIslandSuccess2(resultImg : IslandResultImg)
    fun onIslandFailure2(code : Int)
}