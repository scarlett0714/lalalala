package com.example.airbnb

import com.google.gson.annotations.SerializedName

data class IslandResponse(
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: IslandResult
)

data class IslandResult(
    @SerializedName("roomLocation") val place: String,
    @SerializedName("roomDistance") val code: String,
    @SerializedName("roomDate") val date: String,
    @SerializedName("roomEndDate") val endDate: String,
    @SerializedName("cost") val price: Int,
    @SerializedName("roomRating") val rating: Double,
    @SerializedName("roomLocation") val roomLike: Boolean
)

data class IslandResponse2(
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("result") val resultImg: IslandResultImg
)

data class IslandResultImg(
    @SerializedName("result") val songs: ArrayList<String>
)
