package com.one20.unisonui.widget

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import com.one20.unisonui.util.FontUtil
import com.one20.unisonui.util.UiUtil
import com.one20.unisonui.R
import me.grantland.widget.AutofitTextView

/**
 * TextView that is auto sized and shows white splatter styling
 */
class UnisonSplatterTextView : AutofitTextView {

    /**
     * Application context
     */
    var mContext: Context

    constructor(context: Context?) : super(context) {
        this.mContext = context!!
        initialize()
    }

    constructor(context: Context?, attributeSet: AttributeSet) : super(context, attributeSet) {
        this.mContext = context!!
        initialize()
    }

    constructor(context: Context?, attributeSet: AttributeSet, defStyleAttr: Int) : super(context, attributeSet, defStyleAttr) {
        this.mContext = context!!
        initialize()
    }

    /**
     * Initialize and format view and layout
     */
    private fun initialize() {
        val padding = UiUtil.convertDpToPx(mContext, 16)
        setPadding(padding, 0, padding, 0)

        background = resources.getDrawable(R.drawable.small_splatter_white)
        gravity = Gravity.CENTER_VERTICAL

        setSingleLine(true)
        maxTextSize = 70F
        setMinTextSize(24)
        setTextColor(resources.getColor(R.color.black))

        setAllCaps(true)

        val dinCondBold = FontUtil.dinCondBold(mContext)
        typeface = dinCondBold

    }



}