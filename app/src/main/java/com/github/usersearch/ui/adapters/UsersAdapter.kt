package com.github.usersearch.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.github.usersearch.R
import com.github.usersearch.data.models.UserItem
import kotlinx.android.synthetic.main.user_recycler_item.view.*

class UsersAdapter : RecyclerView.Adapter<UsersAdapter.UsersViewHolder>() {

    private var usersList: List<UserItem> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        return UsersViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.user_recycler_item, parent, false))
    }

    override fun getItemCount() = usersList.size

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.bindViews(usersList[position])
    }

    class UsersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindViews(userItem: UserItem) {
            itemView.userName.text = userItem.login
            //Image Loading
            Glide.with(itemView)
                .load(userItem.avatarUrl)
                .apply(
                    RequestOptions()
                        .placeholder(R.drawable.circle_profile_placeholder)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                )
                .into(itemView.userProfileImage)
        }
    }

    fun addItemsToList(usersList: List<UserItem>) {
        this.usersList = usersList
        notifyDataSetChanged()
    }

}