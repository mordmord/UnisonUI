package com.one20.unisonui.recycler.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.one20.unisonui.recycler.viewholder.UnisonMultiLineViewHolder
import com.one20.unisonui.recycler.ItemClickListener
import com.one20.unisonui.recycler.model.UnisonRecyclerItemModel

/**
 * Adapter used in conjunction with a RecyclerView to show items with
 * a primary and secondary lines of text, and an optional image
 */
class UnisonMultiLineRecyclerAdapter(var context: Context, var data: ArrayList<UnisonRecyclerItemModel>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    /**
     * Click listener to notify of item click events
     */
    private var listener: ItemClickListener? = null



    /**
     *  Set click listener to notify of click events
     */
    fun setItemClickListener(listener: ItemClickListener) {
        this.listener = listener
    }


    /**
     * @return Total number of items to be displayed
     */
    override fun getItemCount(): Int {
        return data.size
    }


    /**
     * Format ViewHolder with correct data/image prior to display
     */
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        val dataItem = data[position]

        if(holder is UnisonMultiLineViewHolder) {
            //  primary text
            holder.setPrimaryText(dataItem.primaryText)

            //  secondary text
            if(!TextUtils.isEmpty(dataItem.secondaryText)) {
                holder.setSecondaryText(dataItem.secondaryText)
            }

            //  Image handling
            if(dataItem.imageRes != 0) {
                holder.image.visibility = View.VISIBLE

                Glide.with(context)
                        .load(dataItem.imageRes)
                        .apply(RequestOptions.circleCropTransform())
                        .into(holder.image)

            } else {
                holder.image.visibility = View.GONE
            }
        }
    }



    /**
     *
     */
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val holder = UnisonMultiLineViewHolder(UnisonMultiLineViewHolder.inflatedView(context, parent!!))

        holder.itemView.setOnClickListener {
            listener?.itemClicked(holder.adapterPosition)
        }

        return holder
    }

}