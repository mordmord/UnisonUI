package com.one20.one20ui.fragment

import android.app.Fragment
import android.os.Bundle
import android.view.*
import com.one20.one20ui.R
import com.one20.one20ui.activity.BaseActivity

/**
 * Created by ryanmord on 9/12/17.
 */
class FragmentButtons: Fragment() {

    lateinit var activity: BaseActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater!!.inflate(R.layout.fragment_buttons, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)

        activity.supportActionBar!!.title = "Buttons"
    }

    override fun onStart() {
        super.onStart()
        this.activity = getActivity() as BaseActivity
    }



    companion object {
        fun newInstance(): FragmentButtons {
           var frag = FragmentButtons()
            return frag
        }
    }
}