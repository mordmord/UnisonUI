package com.one20.one20uilib.util

import android.content.Context
import android.graphics.Typeface
import java.util.*

/**
 * Class to handle font related tasks
 */
class FontUtil {

    companion object {

        /**
         * @param   context Application context
         *
         * @return  DIN-Regular typeface
         */
        fun dinReg(context: Context): Typeface {
            return Typeface.createFromAsset(context.assets, String.format(Locale.US, "fonts/%s", "DIN-Regular.otf"))
        }


        /**
         * @param   context Application context
         *
         * @return  DINCond-Bold typeface
         */
        fun dinCondBold(context: Context): Typeface {
            return Typeface.createFromAsset(context.assets, String.format(Locale.US, "fonts/%s", "DINCond-Bold.otf"))
        }
    }

}