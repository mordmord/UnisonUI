package com.one20.one20ui.fragment

import android.app.Fragment
import android.os.Bundle
import android.view.*
import com.one20.one20ui.R
import com.one20.one20ui.activity.BaseActivity

/**
 * Created by ryanmord on 9/13/17.
 */
class FragmentSwitchesSliders: Fragment() {

    lateinit var activity: BaseActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater!!.inflate(R.layout.fragment_switches_and_sliders, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)

        activity.supportActionBar!!.title = "Switches & Sliders"
    }


    override fun onStart() {
        super.onStart()

        this.activity = getActivity() as BaseActivity
    }


    companion object {
        fun newInstance(): FragmentSwitchesSliders {
            return FragmentSwitchesSliders()
        }
    }

}