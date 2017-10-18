package com.one20.unisonui.widget

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import com.one20.unisonui.R

/**
 * Class for creating styled picker instances
 */
class UnisonPicker {

    companion object {

        /**
         * Create light date picker
         *
         * @param   context     Application context
         * @param   listener    DateSetListener to notify of changes
         * @param   year        Initial year
         * @param   month       Initial month
         * @param   day         Initial day
         */
        fun createLightDatePicker(context: Context, listener: DatePickerDialog.OnDateSetListener, year: Int, month: Int, day: Int): DatePickerDialog {
            val d = DatePickerDialog(context, R.style.UnisonPickerDialog_Light, listener, year, month, day)
            d.window.attributes.windowAnimations = R.style.UnisonPickerDialog
            return d
        }

        /**
         * Create dark date picker
         *
         * @param   context     Application context
         * @param   listener    DateSetListener to notify of changes
         * @param   year        Initial year
         * @param   month       Initial month
         * @param   day         Initial day
         */
        fun createDarkDatePicker(context: Context, listener: DatePickerDialog.OnDateSetListener, year: Int, month: Int, day: Int): DatePickerDialog {
            val d = DatePickerDialog(context, R.style.UnisonPickerDialog_Dark, listener, year, month, day)
            d.window.attributes.windowAnimations = R.style.UnisonPickerDialog
            return d
        }



        /**
         * Create light time picker
         *
         * @param   context         Application context
         * @param   listener        DateSetListener to notify of changes
         * @param   hour            Initial year
         * @param   minute          Initial month
         * @param   is24HourView    True for 24 hour, false for 12 hour
         */
        fun createLightTimePicker(context: Context, listener: TimePickerDialog.OnTimeSetListener, hour: Int, minute: Int, is24HourView:  Boolean): TimePickerDialog {
            val d  = TimePickerDialog(context, R.style.UnisonPickerDialog_Light, listener, hour, minute, is24HourView)
            d.window.attributes.windowAnimations = R.style.UnisonPickerDialog
            return d
        }


        /**
         * Create dark time picker
         *
         * @param   context         Application context
         * @param   listener        DateSetListener to notify of changes
         * @param   hour            Initial year
         * @param   minute          Initial month
         * @param   is24HourView    True for 24 hour, false for 12 hour
         */
        fun createDarkTimePicker(context: Context, listener: TimePickerDialog.OnTimeSetListener, hour: Int, minute: Int, is24HourView: Boolean): TimePickerDialog {
            val d = TimePickerDialog(context, R.style.UnisonPickerDialog_Dark, listener, hour, minute, is24HourView)
            d.window.attributes.windowAnimations = R.style.UnisonPickerDialog
            return d
        }
    }


}