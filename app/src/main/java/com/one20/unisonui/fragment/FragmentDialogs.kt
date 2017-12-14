package com.one20.one20ui.fragment

import android.app.Fragment
import android.os.Bundle
import android.view.*
import android.widget.Toast
import com.one20.one20ui.R
import com.one20.one20ui.activity.BaseActivity
import com.one20.unisonui.dialog.UnisonDialogBuilder
import com.one20.unisonui.widget.UnisonButton

/**
 * Created by ryanmord on 9/19/17.
 */
class FragmentDialogs: Fragment() {

    lateinit var activity: BaseActivity

    lateinit var mShowDialogButton: UnisonButton
    lateinit var mShowWithTitleButton: UnisonButton
    lateinit var mShowWithViewButton: UnisonButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val v = inflater.inflate(R.layout.fragment_dialogs, container, false)

        mShowDialogButton       = v.findViewById(R.id.show_dialog_button)
        mShowWithTitleButton    = v.findViewById(R.id.show_with_title)
        mShowWithViewButton     = v.findViewById(R.id.show_with_view)

        mShowDialogButton.setOnClickListener({
            val d = UnisonDialogBuilder.create(activity, R.string.test_message_body, false, R.string.test_negative_button, R.string.test_positive_button, this::negativeClick, this::positiveClick)
            d.show()
        })

        mShowWithTitleButton.setOnClickListener({
            val d = UnisonDialogBuilder.createWithTitle(activity, R.string.test_title, R.string.test_message_body, true, R.string.test_negative_button, R.string.test_positive_button, this::negativeClick, this::positiveClick)
            d.show()
        })

        mShowWithViewButton.setOnClickListener({
            val d = UnisonDialogBuilder.createWithView(activity, R.string.test_title,
                    R.layout.test_dialog_view, false, R.string.test_negative_button, R.string.test_positive_button, this::negativeClick, this::positiveClick)

            d.show()
        })

        return v
    }


    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)

        activity.supportActionBar!!.title = "Dialogs"
    }


    override fun onStart() {
        super.onStart()

        this.activity = getActivity() as BaseActivity
    }


    private fun negativeClick() {
        Toast.makeText(activity, "Negative click", Toast.LENGTH_SHORT).show()
    }

    private fun positiveClick() {
        Toast.makeText(activity, "Positive click", Toast.LENGTH_SHORT).show()
    }


    companion object {
        fun newInstance(): FragmentDialogs {
            return FragmentDialogs()
        }
    }
}