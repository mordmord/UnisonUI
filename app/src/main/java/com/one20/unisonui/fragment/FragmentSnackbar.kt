package com.one20.one20ui.fragment

import android.app.Fragment
import android.os.Bundle
import android.view.*
import com.one20.one20ui.R
import com.one20.one20ui.activity.BaseActivity
import com.one20.one20uilib.widget.UnisonButton
import com.one20.one20uilib.widget.UnisonEditText
import com.one20.one20uilib.widget.UnisonSnackBar

/**
 * Created by ryanmord on 9/15/17.
 */
class FragmentSnackbar: Fragment() {

    lateinit var mActivity: BaseActivity

    lateinit var textEdit: UnisonEditText
    lateinit var button: UnisonButton
    lateinit var showWithActionButton: UnisonButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var v = inflater!!.inflate(R.layout.fragment_snackbar, container, false)

        textEdit = v.findViewById(R.id.snackbar_text)
        button = v.findViewById(R.id.snackbar_button)
        showWithActionButton = v.findViewById(R.id.snackbar_button_1)



        button.setOnClickListener {
            UnisonSnackBar.makeAndShow(view, textEdit.getText().toString(), UnisonSnackBar.LENGTH_LONG)
        }



        showWithActionButton.setOnClickListener({
            val s = UnisonSnackBar.make(view, textEdit.getText().toString(), UnisonSnackBar.LENGTH_INDEFINITE)
            s.setAction("CANCEL", {
                s.dismiss()
                print("hey")
            })
            s.show()
        })



        return v!!
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)

        mActivity.supportActionBar!!.title = "One20SnackBar"
    }



    override fun onStart() {
        super.onStart()

        mActivity = activity as BaseActivity
    }


    companion object {
        fun newInstance(): FragmentSnackbar {
           return FragmentSnackbar()
        }
    }
}