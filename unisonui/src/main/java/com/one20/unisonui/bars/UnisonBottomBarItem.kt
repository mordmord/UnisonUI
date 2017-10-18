package com.one20.unisonui.bars

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.widget.*
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.support.v4.content.ContextCompat
import android.util.TypedValue
import com.one20.unisonui.R


/**
 * Bar item object used in conjunction with UnisonBottomBar
 */
@SuppressLint("ViewConstructor")
class UnisonBottomBarItem(context: Context, title: String, img: Int) : RelativeLayout(context) {

    /**
     * Application context
     */
    private var mContext: Context = context

    /**
     * ImageView of bar item
     */
    private var mImage: ImageView

    /**
     * TextView of bar item
     */
    private var mTitle: TextView

    /**
     * Item text
     */
    private var mTitleText: String = title

    /**
     * Image reference
     */
    private var mImageRef: Int = img




    /**
     * Initialize and inflate view
     */
    init {
        View.inflate(mContext, R.layout.bottom_bar_item, this)

        val outValue = TypedValue()
        context.theme.resolveAttribute(android.R.attr.selectableItemBackground, outValue, true)
        setBackgroundResource(outValue.resourceId)

        mImage = findViewById(R.id.item_image)
        mTitle = findViewById(R.id.item_title)

        mImage.setImageResource(mImageRef)

        val porterDuffColorFilter = PorterDuffColorFilter(ContextCompat.getColor(mContext, R.color.mid_grey_1),
                PorterDuff.Mode.SRC_ATOP)
        mImage.colorFilter = porterDuffColorFilter

        mTitle.text = mTitleText
    }





    /**
     * Format item to enabled/disabled state
     */
    override fun setActivated(enabled: Boolean) {
        super.setActivated(enabled)

        val color = if(enabled) R.color.yellow else R.color.mid_grey_1
        val porterDuffColorFilter = PorterDuffColorFilter(ContextCompat.getColor(mContext, color),
                PorterDuff.Mode.SRC_ATOP)

        mImage.colorFilter = porterDuffColorFilter
        mTitle.setTextColor(ContextCompat.getColor(mContext, color))

    }


}