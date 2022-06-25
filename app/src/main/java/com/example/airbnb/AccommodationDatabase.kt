package com.example.airbnb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Accommodation::class], version = 1)
abstract class AccommodationDatabase: RoomDatabase(){
    abstract fun songDao(): AccommodationDao

    companion object {
        private var instance: AccommodationDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AccommodationDatabase? {
            if(instance == null){
                synchronized(AccommodationDatabase::class){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AccommodationDatabase::class.java,
                        "song-database"
                    ).allowMainThreadQueries().build()
                }
            }

            return instance
        }
    }
}