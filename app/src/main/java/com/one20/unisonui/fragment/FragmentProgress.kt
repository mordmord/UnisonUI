package com.one20.one20ui.fragment

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.one20.one20ui.R
import com.one20.one20uilib.widget.UnisonButton

/**
 * Created by ryanmord on 10/9/17.
 */
class FragmentProgress: Fragment() {

    lateinit var progressDialogButton: UnisonButton

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val v = inflater!!.inflate(R.layout.fragment_progress, container, false)



        return v
    }


    companion object {
        fun newInstance(): FragmentProgress {
            return FragmentProgress()
        }
    }

}