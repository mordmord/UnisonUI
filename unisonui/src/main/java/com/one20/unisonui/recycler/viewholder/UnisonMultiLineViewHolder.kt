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
 * ViewHolder to display multiple lines of text (primary/secondary), and an optional
 * ImageView.
 */
class UnisonMultiLineViewHolder(itemView: View?): RecyclerView.ViewHolder(itemView) {

    /**
     * Item view
     */
    private var view: View = itemView!!

    /**
     * TextView item
     */
    var textView: TextView
    var secondaryText: TextView
    var image: ImageView

    /**
     * Initialize/find views
     */
    init {
        textView        = view.findViewById(R.id.item_text)
        secondaryText   = view.findViewById(R.id.secondary_item_text)
        image           = view.findViewById(R.id.list_image)
    }




    /**
     * Set item text.
     *
     * @param text  Text string
     */
    fun setPrimaryText(text: String) {
        textView.text = text
    }

    /**
     * Set item text.
     *
     * @param text  String resource
     */
    fun setPrimaryText(text: Int) {
        textView.setText(text)
    }




    /**
     * Set item text.
     *
     * @param text  Text string
     */
    fun setSecondaryText(text: String) {
        secondaryText.text = text
    }

    /**
     * Set item text.
     *
     * @param text  String resource
     */
    fun setSecondaryText(text: Int) {
        secondaryText.setText(text)
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
            return LayoutInflater.from(context).inflate(R.layout.recycler_multi_line_item, root, false)
        }

    }
}