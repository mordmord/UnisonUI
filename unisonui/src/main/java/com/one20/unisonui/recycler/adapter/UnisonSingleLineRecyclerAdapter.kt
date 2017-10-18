package com.one20.unisonui.recycler.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.one20.unisonui.recycler.viewholder.UnisonSingleLineViewHolder
import com.one20.unisonui.recycler.ItemClickListener
import com.one20.unisonui.recycler.model.UnisonRecyclerItemModel

/**
 * Adapter used in conjunction with a RecyclerView to display items
 * with a single line of text and an optional image
 */
class UnisonSingleLineRecyclerAdapter(context: Context, items: ArrayList<UnisonRecyclerItemModel>) : RecyclerView.Adapter<ViewHolder>() {

    /**
     * Application context
     */
    private var context: Context = context

    /**
     * Item click listener callback
     */
    private var listener: ItemClickListener? = null

    /**
     * Data to display
     */
    private var data: ArrayList<UnisonRecyclerItemModel> = items


    /**
     * Set listener to notify of click events
     */
    fun setItemClickListener(listener: ItemClickListener) {
        this.listener = listener
    }


    /**
     * Create new view holder for use. Attaches click listener
     */
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val h = UnisonSingleLineViewHolder(UnisonSingleLineViewHolder.inflatedView(context, parent!!))

        h.itemView.setOnClickListener {
            listener?.itemClicked(h.adapterPosition)
        }

        return h
    }


    /**
     * Format the view holder before display with appropriate data/image
     */
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val info = this.data.get(position)

        (holder as UnisonSingleLineViewHolder).setText(info.primaryText)

        if(info.imageRes != 0) {
            holder.imgView.visibility = View.VISIBLE
            Glide.with(context)
                    .load(info.imageRes)
                    .apply(RequestOptions().circleCrop())
                    .into(holder.imgView)
        } else {
            holder.imgView.visibility = View.GONE
        }
    }

    /**
     * @return Total number of items to be displayed
     */
    override fun getItemCount(): Int {
        return data.size
    }

}