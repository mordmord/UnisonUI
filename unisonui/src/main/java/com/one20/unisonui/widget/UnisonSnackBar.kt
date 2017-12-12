package com.one20.unisonui.widget

import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.view.View
import com.one20.unisonui.R

/**
 * Class for creating styled dialog instances
 */
class UnisonSnackBar {

    companion object {

        /**
         * Short display duration
         */
        @JvmStatic val LENGTH_SHORT         = Snackbar.LENGTH_SHORT

        /**
         * Long display duration
         */
        @JvmStatic val LENGTH_LONG          = Snackbar.LENGTH_LONG

        /**
         * Indefinite display duration
         */
        @JvmStatic val LENGTH_INDEFINITE    = Snackbar.LENGTH_INDEFINITE





        /**
         * Create and return SnackBar
         *
         * @param   v           Root view
         * @param   message     Message to show
         * @param   duration    Show duration
         *
         * @return  Properly formatted SnackBar instance
         */
        fun make(v: View, message: CharSequence, duration: Int): Snackbar {
            var snackbar = Snackbar.make(v, message, duration)
            snackbar.setActionTextColor(ContextCompat.getColor(v.context, R.color.yellow))

            return snackbar
        }

        /**
         * Create and return SnackBar
         *
         * @param   v           Root view
         * @param   message     Message to show
         * @param   duration    Show duration
         * @param   listener    Callback to notify of action click events
         * @param   action      Action button string resource
         *
         * @return  Properly formatted SnackBar instance
         */
        fun make(v: View, message: CharSequence, duration: Int, listener: View.OnClickListener, action: Int): Snackbar {
            val s = Snackbar.make(v, message, duration)
            s.setAction(action, listener)
            s.setActionTextColor(ContextCompat.getColor(v.context, R.color.yellow))

            return s
        }



    }

}