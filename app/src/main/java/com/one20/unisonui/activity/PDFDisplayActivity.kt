package com.one20.unisonui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.one20.one20ui.R
import com.one20.unisonui.widget.UnisonPDFView

/**
 * Created by ryanmord on 4/19/18.
 */
class PDFDisplayActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf_viewer)


        var toolbar = this.findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "PDF View"

        var pdfView = this.findViewById<UnisonPDFView>(R.id.pdfView)
        pdfView.showPdfAsset("cabcard-v2.pdf")
    }
}