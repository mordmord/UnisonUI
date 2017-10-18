package com.one20.unisonui.util

import android.content.Context
import android.util.DisplayMetrics



/**
 * Created by ryanmord on 9/12/17.
 */
class UiUtil {

    companion object {
        fun convertDpToPx(context: Context, dp: Int): Int {
            val displayMetrics = context.resources.displayMetrics
            return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT))
        }
    }

}