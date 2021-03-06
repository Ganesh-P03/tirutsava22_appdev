package com.example.broadcast.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.broadcast.R
import com.example.broadcast.models.Event
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.item_event.view.*

open class EventItemsAdapter(private val context: Context,
                             private val list:ArrayList<Event>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var onClickListener: OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_event,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model = list[position]

        holder.itemView.tv_event_name.text = model.event_name
        holder.itemView.tv_event_desc.text = model.description
        holder.itemView.tv_event_type.text = model.type
        holder.itemView.tv_event_time.text = model.time


        holder.itemView.setOnClickListener {

            if (onClickListener != null) {
                onClickListener!!.onClick(position, model)
            }
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener

    }

    interface OnClickListener {
        fun onClick(position: Int, model: Event)
    }

    private class MyViewHolder(view: View):RecyclerView.ViewHolder(view)

}