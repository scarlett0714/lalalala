package com.example.airbnb

import androidx.room.*

@Dao
interface AccommodationDao {
    @Insert
    fun insert(song: Accommodation)

    @Update
    fun update(song: Accommodation)

    @Delete
    fun delete(song: Accommodation)

    @Query("SELECT * FROM AccommodationTable") //SongTable로부터(FROM) 모든 값을(*) 가져와라(SELECT)
    fun getSongs(): List<Accommodation>

    @Query("SELECT * FROM AccommodationTable WHERE id = :id") //id값이 넘겨받은 id값인 song을 가져와라(WHERE : 조건문)
    fun getSong(id: Int): Accommodation

    @Query("UPDATE AccommodationTable SET isLike= :isLike WHERE id = :id")
    fun updateIsLikeById(isLike: Boolean, id: Int)

    //좋아요가 클릭된 애들만 addSongs
    @Query("SELECT * FROM AccommodationTable WHERE isLike = :isLike")
    fun getLikedSongs(isLike: Boolean): List<Accommodation>
}