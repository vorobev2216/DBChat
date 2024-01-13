package com.example.dbchat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.dbchat.databinding.UserListItemBinding

class UserAdapter() : ListAdapter<User, UserAdapter.itemHolder>(ItemComparator()) {

    class itemHolder(private val binding: UserListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) = with(binding) {
            messgetv.text = user.message
            userName.text = user.name
        }

        companion object {
            fun create(parent: ViewGroup): itemHolder {
                return itemHolder(
                    UserListItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }
    }

    class ItemComparator : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem != newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemHolder {
        return itemHolder.create(parent)
    }

    override fun onBindViewHolder(holder: itemHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

