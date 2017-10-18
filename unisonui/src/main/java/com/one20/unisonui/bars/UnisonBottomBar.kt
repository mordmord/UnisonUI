package com.one20.unisonui.bars

import android.content.Context
import android.os.Build
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import com.one20.unisonui.R
import java.util.*

/**
 * Bottom tab-bar view for navigation. This widget is overridden from Android's
 * BottomNavigationView for further customization and control over behavior
 */
class UnisonBottomBar : LinearLayout {

    /**
     * Application context
     */
    var mContext: Context

    /**
     * Callback to notify on item click events
     */
    var mItemListener: ((index: Int) -> Unit)? = null

    /**
     * Array of bar items to display
     */
    var mItems = ArrayList<UnisonBottomBarItem>()






    /**
     * @constructor
     */
    constructor(context: Context): super(context) {
        mContext = context
        initialize()
    }

    /**
     * @constructor
     */
    constructor(context: Context, attributeSet: AttributeSet): super(context, attributeSet) {
        mContext = context
        initialize()
    }

    /**
     * @constructor
     */
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int): super(context, attributeSet, defStyleAttr) {
        mContext = context
        initialize()
    }


    /**
     * Initialize layout with parameters and colors
     */
    private fun initialize() {
        orientation = HORIZONTAL

        val p = LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1.0f)
        p.gravity = Gravity.CENTER

        this.layoutParams = p


        setBackgroundColor(ContextCompat.getColor(mContext, R.color.background_dark))
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            elevation = 8.0F
        }
    }


    /**
     * Set callback to notify of click events
     *
     * @param   listener implementation
     */
    fun setItemClickNotifier(listener: (index: Int) -> Unit) {
        mItemListener = listener
    }


    /**
     * Set bar items to show in bottom bar
     *
     * @param   Array of items to show
     */
    fun setBarItems(items: ArrayList<UnisonBottomBarItem>) {
        for(item in items) {
            item.layoutParams = LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1.0f)
            item.tag = items.indexOf(item)

            item.setOnClickListener({
                onItemClick(item.tag as Int)
            })

            addView(item)

            mItems.add(item)
        }
    }


    /**
     * Handle item clicks, toggle buttons to appropriate
     * enabled/disabled state, and notify callback
     *
     * @param   Index of item clicked
     */
    private fun onItemClick(index: Int) {
        for(i in 0 until mItems.size) {
            mItems[i].isActivated = i == index
        }

        mItemListener?.invoke(index)
    }


    /**
     * Set selected item index
     *
     * @param   index of item to select
     */
    fun setSelectedIndex(index: Int) {
        mItems[index].isActivated = true
    }
}
