package com.one20.one20uilib.widget

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.widget.Button
import com.one20.one20uilib.util.UiUtil
import com.one20.one20uilib.util.FontUtil


/**
 * Min horizontal padding of button
 */
private const val HORIZONTAL_PADDING    = 16
/**
 * Min vertical padding of button
 */
private const val VERTICAL_PADDING      = 10



/**
 * Button styled with One20 styling
 */
class UnisonButton : Button {

    /**
     * Application context
     */
    private var mContext: Context

    /**
     * Typefaces
     */
    private lateinit var dinCondBold: Typeface
    private lateinit var dinReg: Typeface


    /**
     * Constructor
     */
    constructor(context: Context) : super(context) {
        mContext = context
        initialize()
    }

    /**
     * Constructor
     */
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        mContext = context
        initialize()
    }

    /**
     * Constructor
     */
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        mContext = context
        initialize()
    }


    /**
     * Initialize and format button for appropriate styling
     */
    private fun initialize() {

        val hPadding = UiUtil.convertDpToPx(mContext, HORIZONTAL_PADDING)
        val vPadding = UiUtil.convertDpToPx(mContext, VERTICAL_PADDING)

        setPadding(hPadding, vPadding, hPadding, vPadding)

        dinCondBold = FontUtil.dinCondBold(mContext)
        dinReg = FontUtil.dinReg(mContext)

        setAllCaps(true)

        setLineSpacing(-4f, 1f)

        typeface = dinCondBold
    }

}