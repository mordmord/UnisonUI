package com.one20.unisonui.widget

import android.content.Context
import android.support.design.widget.TextInputEditText
import android.text.*
import android.text.method.DigitsKeyListener
import android.text.method.KeyListener
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.one20.unisonui.R
import java.util.Locale.filter
import android.text.Spanned
import android.text.InputFilter
import android.util.Log


/**
 * One20 styled edit text
 */
class UnisonEditText(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    /**
     * Header label text view
     */
    private var headerLabel: TextView

    /**
     * Edit TextView
     */
    private var editText: TextInputEditText

    /**
     * Error text TextView
     */
    private var errorText: TextView

    /**
     * Error icon ImageView
     */
    private var errorIcon: ImageView

    /**
     * Holds error enabled state. True for error showing, false otherwise
     */
    var mErrorEnabled = false



    /**
     * Initialize and format view
     */
    init {
        val a = context.obtainStyledAttributes(attrs, R.styleable.UnisonEditText, 0, 0)
        val hint: String?
        val text: String?
        val errorText: String?
        val headerText: String?
        val multiline: Boolean?
        val inputType: Int?
        val alphanumeric: Boolean

        try {
            val dark = a.getBoolean(R.styleable.UnisonEditText_dark, false)

            hint            = a.getNonResourceString(R.styleable.UnisonEditText_hint)
            text            = a.getNonResourceString(R.styleable.UnisonEditText_text)
            errorText       = a.getNonResourceString(R.styleable.UnisonEditText_errorText)
            headerText      = a.getNonResourceString(R.styleable.UnisonEditText_headerLabel)
            multiline       = a.getBoolean(R.styleable.UnisonEditText_multiline, false)
            inputType       = a.getInt(R.styleable.UnisonEditText_android_inputType, EditorInfo.TYPE_TEXT_FLAG_AUTO_CORRECT)
            alphanumeric    = a.getBoolean(R.styleable.UnisonEditText_alphanumeric, false)
            mErrorEnabled   = a.getBoolean(R.styleable.UnisonEditText_errorEnabled, false)

            if(dark) {
                LayoutInflater.from(context).inflate(R.layout.widget_single_line_edittext_dark, this, true)
            } else {
                LayoutInflater.from(context).inflate(R.layout.widget_single_line_edittext, this, true)
            }

        } finally {
            a.recycle()
        }

        //Find views
        headerLabel = findViewById(R.id.header_label)
        editText = findViewById(R.id.textInputEditText)
        this.errorText = findViewById(R.id.error_text)
        errorIcon = findViewById(R.id.error_icon)


        //Format views
        headerLabel.text = headerText

        editText.hint = hint
        editText.setText(text)
        multiline.let {
            editText.setSingleLine(!multiline!!)
        }
        inputType.let {
            editText.inputType = inputType!!
        }

        if(alphanumeric) {
            editText.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            val filter =  InputFilter { source, _, end, _, _, _ ->
                try {
                    val c = source[end-1]
                    return@InputFilter if (Character.isLetter(c) || Character.isDigit(c)) {
                        source
                    } else {
                        ""
                    }
                } catch (e: Exception) {
                }
                null
            }
            editText.filters = arrayOf(filter)
        }

        this.errorText.text = errorText
        setErrorEnabled(mErrorEnabled)
    }


    /**
     * Sets error to enabled/disabled state
     *
     * @param enabled   True for enabled (showing), false for disabled (hidden)
     */
    fun setErrorEnabled(enabled: Boolean) {
        mErrorEnabled = enabled

        editText.isActivated = enabled

        errorText.visibility = if(mErrorEnabled) { View.VISIBLE } else { View.INVISIBLE }
        errorIcon.visibility = if(mErrorEnabled) { View.VISIBLE } else { View.INVISIBLE }
    }



    /**
     * @return text currently in the edit text
     */
    fun getText(): Editable {
        return editText.text
    }

    /**
     * Set text to display in the edit text
     *
     * @param text  String to show
     */
    fun setText(text: String) {
        editText.setText(text)
    }


    fun setTextChangeListener(watcher: TextWatcher) {
        editText.addTextChangedListener(watcher)
    }


}