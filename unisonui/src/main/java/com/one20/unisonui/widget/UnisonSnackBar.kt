package com.one20.unisonui.widget

import android.support.design.widget.Snackbar
import android.view.View

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
         * Create and show SnackBar
         *
         * @param   v           Root view
         * @param   message     Message to show
         * @param   duration    Length to show
         */
        fun makeAndShow(v: View, message: CharSequence, duration: Int) {
            Snackbar.make(v, message, duration).show()
        }

        /**
         * Create and show SnackBar with action
         *
         * @param   v           Root view
         * @param   message     Message to show
         * @param   duration    Show duration
         * @param   listener    Callback to notify of action click event
         * @param   action      Action button string resource
         */
        fun makeAndShow(v: View, message: CharSequence, duration: Int, listener: View.OnClickListener, action: Int) {
            val s = Snackbar.make(v, message, duration)
            s.setAction(action, listener)
            s.show()
        }


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
            return Snackbar.make(v, message, duration)
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
            return s
        }



    }

}