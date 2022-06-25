package com.example.airbnb

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.airbnb.databinding.ItemAccommodationsBinding

class MainpageRVAdapter() :
    RecyclerView.Adapter<MainpageRVAdapter.ViewHolder>(){
    private val songs = ArrayList<Accommodation>()

    //more버튼 누르면 DB에서도 좋아요눌린 노래 지우기
    interface MyItemClickListener{
        fun onRemoveSong(songId: Int)
    }
    private lateinit var mItemClickListener: MyItemClickListener

    fun setMyItemClickListener(itemClickListener: MyItemClickListener){
        mItemClickListener = itemClickListener
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MainpageRVAdapter.ViewHolder{
        val binding: ItemAccommodationsBinding = ItemAccommodationsBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainpageRVAdapter.ViewHolder, position: Int) {
        holder.bind(songs[position])

        //more버튼 누르면 좋아요한 노래 지우기

    }

    override fun getItemCount(): Int = songs.size

    //recyclerView에 모든 좋아요랑 노래를 추가하기
    @SuppressLint("NotifyDataSetChanged")
    fun addSongs(songs: ArrayList<Accommodation>){
        this.songs.clear()
        this.songs.addAll(songs)

        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun removeSong(position: Int){
        songs.removeAt(position)
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: ItemAccommodationsBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(song: Accommodation){
            binding.itemAccommodationCoverImgIv.setImageResource(song.coverImg!!)
            binding.itemAccommodationDistanceTv.text = song.title
            binding.itemAccommodationDateTv.text = song.singer
            binding.itemAccommodationPriceTv.text = song.singer
        }
    }


}