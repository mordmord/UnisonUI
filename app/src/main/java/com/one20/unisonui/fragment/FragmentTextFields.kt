package com.one20.one20ui.fragment

import android.app.Fragment
import android.os.Bundle
import android.view.*
import com.one20.one20ui.R
import com.one20.one20ui.activity.BaseActivity
import com.one20.unisonui.widget.UnisonEditText
import com.one20.unisonui.widget.UnisonSwitch

/**
 * Created by ryanmord on 9/14/17.
 */
class FragmentTextFields: Fragment() {

    lateinit var activity: BaseActivity

    lateinit var mLightEditText: UnisonEditText
    lateinit var mDarkEditText: UnisonEditText

    lateinit var mLightSwitch: UnisonSwitch
    lateinit var mDarkSwitch: UnisonSwitch


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var v = inflater?.inflate(R.layout.fragment_textfields, container, false)

        mLightEditText  = v!!.findViewById(R.id.light_editText)
        mDarkEditText   = v.findViewById(R.id.dark_editText)

        mLightSwitch    = v.findViewById(R.id.switch_1)
        mDarkSwitch     = v.findViewById(R.id.switch_2)

        mLightSwitch.setOnClickListener {
            mLightEditText.setErrorEnabled(!mLightEditText.mErrorEnabled)
        }

        mDarkSwitch.setOnClickListener {
            mDarkEditText.setErrorEnabled(!mDarkEditText.mErrorEnabled)
        }

        return v
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)

        activity.supportActionBar!!.title = "Text Fields"
    }


    override fun onStart() {
        super.onStart()
        this.activity = getActivity() as BaseActivity
    }


    companion object {
        fun newInstance(): FragmentTextFields {
            return FragmentTextFields()
        }
    }

}