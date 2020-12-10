package com.test.bitpandachallenge.ui.listofwallets

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.test.bitpandachallenge.data.local.DomainModel
import com.test.bitpandachallenge.databinding.ItemWalletBinding
import com.test.bitpandachallenge.utils.ClickListener

class ListOfWalletsAdapter(private val clickListener: ClickListener) : ListAdapter<DomainModel, RecyclerView.ViewHolder>(WalletDiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return FeedViewHolder(ItemWalletBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = getItem(position)
        (holder as FeedViewHolder).bind(clickListener, data)
    }

    class FeedViewHolder(private val binding: ItemWalletBinding):
        RecyclerView.ViewHolder(binding.root){

        fun bind(listener: ClickListener, item: DomainModel){
            binding.apply {
                clickListener = listener
                domain = item
                executePendingBindings()
            }
        }
    }
}

private class WalletDiffCallback: DiffUtil.ItemCallback<DomainModel>(){
    override fun areItemsTheSame(oldItem: DomainModel, newItem: DomainModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: DomainModel, newItem: DomainModel): Boolean {
        return oldItem == newItem
    }
}