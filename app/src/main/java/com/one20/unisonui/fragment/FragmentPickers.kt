package com.one20.one20ui.fragment

import android.app.DatePickerDialog
import android.app.Fragment
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.*
import android.widget.DatePicker
import android.widget.TimePicker
import com.one20.one20ui.R
import com.one20.one20ui.activity.BaseActivity
import com.one20.one20uilib.widget.UnisonButton
import com.one20.one20uilib.widget.UnisonPicker

/**
 * Created by ryanmord on 9/21/17.
 */
class FragmentPickers : Fragment(), DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
    override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
    }

    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
    }


    lateinit var lightDateButton: UnisonButton
    lateinit var darkDateButton: UnisonButton
    lateinit var lightTimeButton: UnisonButton
    lateinit var darkTimeButton: UnisonButton

    lateinit var datePickerLight: DatePickerDialog
    lateinit var datePickerDark: DatePickerDialog

    lateinit var timePickerLight: TimePickerDialog
    lateinit var timePickerDark: TimePickerDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        datePickerLight = UnisonPicker.createLightDatePicker(activity, this, 2017, 8, 21)
        datePickerDark  = UnisonPicker.createDarkDatePicker(activity, this, 2017, 8, 21)

        timePickerLight = UnisonPicker.createLightTimePicker(activity, this, 12, 12, false)
        timePickerDark  = UnisonPicker.createDarkTimePicker(activity, this, 12, 12, true)
    }




    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val v = inflater!!.inflate(R.layout.fragment_pickers, container, false)

        lightDateButton = v.findViewById(R.id.light_date_button)
        lightTimeButton = v.findViewById(R.id.light_time_button)
        darkDateButton  = v.findViewById(R.id.dark_date_button)
        darkTimeButton  = v.findViewById(R.id.dark_time_button)


        lightDateButton.setOnClickListener {
            datePickerLight.show()
        }

        lightTimeButton.setOnClickListener {
            timePickerLight.show()
        }

        darkDateButton.setOnClickListener {
            datePickerDark.show()
        }

        darkTimeButton.setOnClickListener {
            timePickerDark.show()
        }


        return v
    }


    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)

        (activity as BaseActivity).supportActionBar!!.title = "Pickers"
    }


    companion object {
        fun newInstance(): FragmentPickers {
            return FragmentPickers()
        }
    }

}