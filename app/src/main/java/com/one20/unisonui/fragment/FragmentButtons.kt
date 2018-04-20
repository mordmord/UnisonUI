package com.one20.one20ui.fragment

import android.app.Fragment
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Button
import com.one20.one20ui.R
import com.one20.one20ui.activity.BaseActivity
import com.one20.unisonui.activity.PDFDisplayActivity

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

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view?.findViewById<Button>(R.id.showPDF)?.setOnClickListener {
            startActivity(Intent(activity, PDFDisplayActivity::class.java))
        }
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