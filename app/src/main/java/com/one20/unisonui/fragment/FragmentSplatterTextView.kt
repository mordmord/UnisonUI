package com.one20.one20ui.fragment

import android.app.Fragment
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.one20.one20ui.R
import com.one20.unisonui.widget.UnisonEditText
import com.one20.unisonui.widget.UnisonSplatterTextView

/**
 * Created by ryanmord on 10/3/17.
 */

class FragmentSplatterTextView: Fragment() {

    lateinit var splatterText: UnisonSplatterTextView
    lateinit var editText: UnisonEditText



    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val v = View.inflate(activity, R.layout.fragment_splatter_textview, null)

        splatterText = v.findViewById(R.id.splatter_text)
        editText = v.findViewById(R.id.splatter_edit_text)

        editText.setTextChangeListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                splatterText.setText(p0.toString())
            }
        })

        return v
    }



    companion object {
        fun newInstance(): FragmentSplatterTextView {
            return FragmentSplatterTextView()
        }
    }
}