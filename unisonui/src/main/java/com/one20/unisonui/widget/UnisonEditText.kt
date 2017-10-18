package com.one20.unisonui.widget

import android.content.Context
import android.support.design.widget.TextInputEditText
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.one20.unisonui.R

/**
 * One20 styled edit text
 */
class UnisonEditText(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    /**
     * Application context
     */
    private var mContext: Context = context

    /**
     * AttributeSet
     */
    private var mAttrs: AttributeSet = attrs

    /**
     * Header label text view
     */
    private var mHeaderLabel: TextView

    /**
     * Edit TextView
     */
    private var mEditText: TextInputEditText

    /**
     * Error text TextView
     */
    private var mErrorText: TextView

    /**
     * Error icon ImageView
     */
    private var mErrorIcon: ImageView

    /**
     * Holds error enabled state. True for error showing, false otherwise
     */
    var mErrorEnabled = false



    /**
     * Initialize and format view
     */
    init {
        val a = context.obtainStyledAttributes(mAttrs, R.styleable.UnisonEditText, 0, 0)
        val hint: String?
        val text: String?
        val errorText: String?
        val headerText: String?
        val multiline: Boolean?
        val inputType: Int?

        try {
            val dark = a.getBoolean(R.styleable.UnisonEditText_dark, false)

            hint            = a.getNonResourceString(R.styleable.UnisonEditText_hint)
            text            = a.getNonResourceString(R.styleable.UnisonEditText_text)
            errorText       = a.getNonResourceString(R.styleable.UnisonEditText_errorText)
            headerText      = a.getNonResourceString(R.styleable.UnisonEditText_headerLabel)
            multiline       = a.getBoolean(R.styleable.UnisonEditText_multiline, false)
            inputType       = a.getInt(R.styleable.UnisonEditText_android_inputType, EditorInfo.TYPE_TEXT_VARIATION_NORMAL)
            mErrorEnabled   = a.getBoolean(R.styleable.UnisonEditText_errorEnabled, false)

            if(dark) {
                LayoutInflater.from(mContext).inflate(R.layout.widget_single_line_edittext_dark, this, true)
            } else {
                LayoutInflater.from(mContext).inflate(R.layout.widget_single_line_edittext, this, true)
            }

        } finally {
            a.recycle()
        }

        //Find views
        mHeaderLabel    = findViewById(R.id.header_label)
        mEditText       = findViewById(R.id.textInputEditText)
        mErrorText      = findViewById(R.id.error_text)
        mErrorIcon      = findViewById(R.id.error_icon)


        //Format views
        mHeaderLabel.text = headerText

        mEditText.hint = hint
        mEditText.setText(text)
        mEditText.setSingleLine(!multiline!!)
        mEditText.inputType = inputType!!

        mErrorText.text = errorText
        setErrorEnabled(mErrorEnabled)
    }


    /**
     * Sets error to enabled/disabled state
     *
     * @param enabled   True for enabled (showing), false for disabled (hidden)
     */
    fun setErrorEnabled(enabled: Boolean) {
        mErrorEnabled = enabled

        mEditText.isActivated = enabled

        mErrorText.visibility = if(mErrorEnabled) { View.VISIBLE } else { View.INVISIBLE }
        mErrorIcon.visibility = if(mErrorEnabled) { View.VISIBLE } else { View.INVISIBLE }
    }



    /**
     * @return text currently in the edit text
     */
    fun getText(): Editable {
        return mEditText.text
    }

    /**
     * Set text to display in the edit text
     *
     * @param text  String to show
     */
    fun setText(text: String) {
        mEditText.setText(text)
    }


    fun setTextChangeListener(watcher: TextWatcher) {
        mEditText.addTextChangedListener(watcher)
    }


}