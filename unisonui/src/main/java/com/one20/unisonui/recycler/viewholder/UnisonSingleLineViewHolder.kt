package com.one20.unisonui.recycler.viewholder

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.one20.unisonui.R

/**
 * ViewHolder class for a single lined recycler item
 */
class UnisonSingleLineViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    /**
     * Item view
     */
    private var view: View = itemView!!

    /**
     * Item views
     */
    var textView:   TextView
    var imgView:    ImageView

    /**
     * Initialize/find views
     */
    init {
        textView = view.findViewById(R.id.item_text)
        imgView = view.findViewById(R.id.list_image)
    }



    /**
     * Set item text.
     *
     * @param text  Text string
     */
    fun setText(text: String) {
        textView.text = text
    }

    /**
     * Set item text.
     *
     * @param text  String resource
     */
    fun setText(text: Int) {
        textView.setText(text)
    }



    companion object {
        /**
         * Inflate and return item view
         *
         * @param   context Application context
         *
         * @return  Inflated view to use
         */
        fun inflatedView(context: Context, root: ViewGroup): View {
            return LayoutInflater.from(context).inflate(R.layout.recycler_single_line_image_item, root, false)
        }
    }


}