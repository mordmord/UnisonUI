package com.one20.unisonui.dialog

import android.content.Context
import android.os.Build
import android.support.annotation.StringRes
import android.support.v7.app.AlertDialog
import android.view.View
import com.one20.unisonui.R
import org.jetbrains.annotations.NotNull
import kotlin.reflect.KFunction0

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
        fun create(@NotNull context: Context,
                @StringRes message: Int,
                dark: Boolean,
                @StringRes negativeButton: Int,
                @StringRes positiveButton: Int,
                negativeClicked: KFunction0<Unit>,
                positiveClicked: KFunction0<Unit>
        ): AlertDialog {

            val style = if(dark) R.style.UnisonAlertDialog_Dark else R.style.UnisonAlertDialog_Light

            val d = AlertDialog.Builder(context, style)
                    .setMessage(context.getString(message))
                    .create()

            d.setButton(AlertDialog.BUTTON_NEGATIVE, context.getString(negativeButton), { _, _ ->
                negativeClicked()
            })
            d.setButton(AlertDialog.BUTTON_POSITIVE, context.getString(positiveButton), { _, _ ->
                positiveClicked()
            })

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                d.create()
                d.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(android.support.v4.content.ContextCompat.getColor(context, negativeButtonColor))
            }

            d.window.attributes.windowAnimations = style

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
                @StringRes title: Int,
                @StringRes message: Int,
                dark: Boolean,
                @StringRes negativeButton: Int,
                @StringRes positiveButton: Int,
                negativeClicked: () -> Unit,
                positiveClicked: () -> Unit
        ): AlertDialog {

            val style = if(dark) R.style.UnisonAlertDialog_Dark else R.style.UnisonAlertDialog_Light

            val d = AlertDialog.Builder(context, style)
                    .setTitle(title)
                    .setMessage(context.getString(message))
                    .create();

            d.setButton(AlertDialog.BUTTON_NEGATIVE, context.getString(negativeButton), { _, _ ->
                negativeClicked()
            })
            d.setButton(AlertDialog.BUTTON_POSITIVE, context.getString(positiveButton), { _, _ ->
                positiveClicked()
            })

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                d.create()
                d.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(android.support.v4.content.ContextCompat.getColor(context, negativeButtonColor))
            }

            d.window.attributes.windowAnimations = style

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
                @StringRes title: Int,
                view: Int,
                dark: Boolean,
                @StringRes negativeButton: Int,
                @StringRes positiveButton: Int,
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
                @StringRes title: Int,
                view: View,
                dark: Boolean,
                @StringRes negativeButton: Int,
                @StringRes positiveButton: Int,
                negativeClicked: () -> Unit,
                positiveClicked: () -> Unit
        ): AlertDialog {

            val style = if(dark) R.style.UnisonAlertDialog_Dark else R.style.UnisonAlertDialog_Light

            val d = AlertDialog.Builder(context, style)
                    .setTitle(title)
                    .setView(view)
                    .create()

            d.setButton(AlertDialog.BUTTON_NEGATIVE, context.getString(negativeButton), { _, _ ->
                negativeClicked()
            })
            d.setButton(AlertDialog.BUTTON_POSITIVE, context.getString(positiveButton), { _, _ ->
                positiveClicked()
            })

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                d.create()
                d.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(android.support.v4.content.ContextCompat.getColor(context, negativeButtonColor))
            }

            d.window.attributes.windowAnimations = style

            return d
        }
    }

}