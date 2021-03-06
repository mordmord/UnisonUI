package com.one20.unisonui.recycler.decorator

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import com.one20.unisonui.R
import com.one20.unisonui.util.UiUtil

/**
 * Created by ryanmord on 9/29/17.
 */
class UnisonSimpleRecyclerDivider(context: Context): android.support.v7.widget.RecyclerView.ItemDecoration() {

    /**
     * Divider drawable
     */
    private var mDivider: Drawable = android.support.v4.content.ContextCompat.getDrawable(context, R.drawable.drawable_line)

    /**
     * padding
     */
    private var mPaddingStart: Int  = UiUtil.Companion.convertDpToPixels(context, 32)
    private var mPaddingEnd: Int    = UiUtil.Companion.convertDpToPixels(context, 0)



    override fun onDrawOver(c: Canvas?, parent: android.support.v7.widget.RecyclerView?) {
        val left = mPaddingStart
        val right = parent!!.width

        val childCount = parent.childCount
        for (i in 0 until childCount) {
            val child = parent.getChildAt(i)

            val params = child.layoutParams as android.support.v7.widget.RecyclerView.LayoutParams

            val top = child.bottom + params.bottomMargin
            val bottom = top + mDivider.intrinsicHeight

            mDivider.setBounds(left, top, right, bottom)
            mDivider.draw(c)
        }
    }


}