package com.one20.unisonui.bars

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import com.one20.unisonui.R


/**
 * Search/Nav bar containing menu button, search field, and "active styled" navigation button
 */
class UnisonSearchNavBar(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    /**
     * Listener for bar events
     */
    private var mListener: IBarListener? = null

    /**
     * Image button containing hamburger menu item
     */
    private var menuButton: ImageButton

    /**
     * TextView for search text
     */
    private var searchText: EditText

    /**
     * Button located within the search edit text field
     */
    private var searchButton: ImageButton

    /**
     * Navigation image button
     */
    private var navigationButton: ImageButton


    /**
     * Inflate and setup view
     */
    init {
        View.inflate(context, R.layout.layout_search_nav_bar, this)

        menuButton = findViewById(R.id.menu_button)
        searchText = findViewById(R.id.search_text)
        searchButton = findViewById(R.id.search_mic)
        navigationButton = findViewById(R.id.nav_button)

        menuButton.setOnClickListener {
            mListener?.menuClicked()
        }

        searchButton.setOnClickListener {
            mListener?.searchButtonClicked()
        }

        navigationButton.setOnClickListener {
            mListener?.navButtonClicked()
        }

        searchText.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                mListener?.searchTextChanged(p0!!)
            }
        })
    }


    /**
     * Set callback for view events
     */
    fun setBarListener(l: IBarListener) {
        mListener = l
    }



    companion object {

        /**
         * Listener interface for event callback methods
         */
        interface IBarListener {
            fun menuClicked()
            fun searchTextChanged(text: CharSequence)
            fun searchButtonClicked()
            fun navButtonClicked()
        }
    }


}