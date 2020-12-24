package com.example.roomapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.ListFragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.roomapp.R
import com.example.roomapp.model.User
import com.example.roomapp.databinding.CustomRowBinding
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    private var userList = emptyList<User>()
    private lateinit var binding: CustomRowBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    override fun onBindViewHolder(holder: ListAdapter.ViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.itemView.textView.text = currentItem.id.toString()
        holder.itemView.txt_title.text = currentItem.firstName
        holder.itemView.txt_lasttitle.text = currentItem.lastName
        holder.itemView.txt_description.text = currentItem.age.toString()

//        holder.itemView.row_layout.setOnClickListener {
//            val action =
//            holder.itemView.findNavController().navigate(action)
//        }
    }

    fun setData(user: List<User>) {
        this.userList = user
        notifyDataSetChanged()
    }

    override fun getItemCount() = userList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}
}