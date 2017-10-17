package com.one20.unisonui.dialog

import android.app.AlertDialog
import android.content.Context
import android.view.View
import com.one20.unisonui.R

/**
 * Class for creating styled dialog instances
 */
class UnisonDialog {

    companion object {

        /**
         * Color ref for negative button color
         */
        private var negativeButtonColor: Int = R.color.mid_grey_1


        /**
         * Create basic alert dialog instance with message. NO TITLE.
         *
         * @param   context         Application context
         * @param   message         Message in dialog
         * @param   dark            True for dark theme, false for light
         * @param   negativeButton  Negative button text
         * @param   positiveButton  Positive button text
         * @param   negativeClicked Callback method for negative click
         * @param   positiveClicked Callback method for positive click
         */
        fun create(
                context: Context,
                message: String,
                dark: Boolean,
                negativeButton: String,
                positiveButton: String,
                negativeClicked: () -> Unit,
                positiveClicked: () -> Unit
        ): AlertDialog {

            val style = if(dark) R.style.UnisonAlertDialog_Dark else R.style.UnisonAlertDialog_Light

            val d = AlertDialog.Builder(context, style).create()

            d.setMessage(message)
            d.setButton(AlertDialog.BUTTON_NEGATIVE, negativeButton, { _, _ ->
                negativeClicked()
            })
            d.setButton(AlertDialog.BUTTON_POSITIVE, positiveButton, { _, _ ->
                positiveClicked()
            })

            d.create()
            d.window.attributes.windowAnimations = style
            d.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(android.support.v4.content.ContextCompat.getColor(context, negativeButtonColor))

            return d
        }




        /**
         * Create basic alert dialog instance with message.
         *
         * @param   context         Application context
         * @param   title           Title string
         * @param   message         Message in dialog
         * @param   dark            True for dark theme, false for light
         * @param   negativeButton  Negative button text
         * @param   positiveButton  Positive button text
         * @param   negativeClicked Callback method for negative click
         * @param   positiveClicked Callback method for positive click
         */
        fun createWithTitle(
                context: Context,
                title: String,
                message: String,
                dark: Boolean,
                negativeButton: String,
                positiveButton: String,
                negativeClicked: () -> Unit,
                positiveClicked: () -> Unit
        ): AlertDialog {

            val style = if(dark) R.style.UnisonAlertDialog_Dark else R.style.UnisonAlertDialog_Light

            val d = AlertDialog.Builder(context, style).create()
            d.setTitle(title)

            d.setMessage(message)
            d.setButton(AlertDialog.BUTTON_NEGATIVE, negativeButton, { _, _ ->
                negativeClicked()
            })
            d.setButton(AlertDialog.BUTTON_POSITIVE, positiveButton, { _, _ ->
                positiveClicked()
            })

            d.create()
            d.window.attributes.windowAnimations = style
            d.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(android.support.v4.content.ContextCompat.getColor(context, negativeButtonColor))

            return d
        }



        /**
         * Create basic alert dialog instance with custom view body.
         *
         * @param   context         Application context
         * @param   title           Title string
         * @param   view            Custom view reference to inflate as body
         * @param   dark            True for dark theme, false for light
         * @param   negativeButton  Negative button text
         * @param   positiveButton  Positive button text
         * @param   negativeClicked Callback method for negative click
         * @param   positiveClicked Callback method for positive click
         */
        fun createWithView(
                context: Context,
                title: String,
                view: Int,
                dark: Boolean,
                negativeButton: String,
                positiveButton: String,
                negativeClicked: () -> Unit,
                positiveClicked: () -> Unit
        ): AlertDialog {
            val inflatedView = View.inflate(context, view, null)
            return this.createWithView(context, title, inflatedView, dark, negativeButton, positiveButton, negativeClicked, positiveClicked)
        }




        /**
         * Create basic alert dialog instance with custom view body.
         *
         * @param   context         Application context
         * @param   title           Title string
         * @param   view            Custom view reference to use as body
         * @param   dark            True for dark theme, false for light
         * @param   negativeButton  Negative button text
         * @param   positiveButton  Positive button text
         * @param   negativeClicked Callback method for negative click
         * @param   positiveClicked Callback method for positive click
         */
        fun createWithView(
                context: Context,
                title: String,
                view: View,
                dark: Boolean,
                negativeButton: String,
                positiveButton: String,
                negativeClicked: () -> Unit,
                positiveClicked: () -> Unit
        ): AlertDialog {

            val style = if(dark) R.style.UnisonAlertDialog_Dark else R.style.UnisonAlertDialog_Light

            val d = AlertDialog.Builder(context, style).create()
            d.setTitle(title)

            d.setView(view)

            d.setButton(AlertDialog.BUTTON_NEGATIVE, negativeButton, { _, _ ->
                negativeClicked()
            })
            d.setButton(AlertDialog.BUTTON_POSITIVE, positiveButton, { _, _ ->
                positiveClicked()
            })

            d.create()
            d.window.attributes.windowAnimations = style
            d.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(android.support.v4.content.ContextCompat.getColor(context, negativeButtonColor))

            return d
        }
    }

}