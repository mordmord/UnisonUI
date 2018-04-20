package com.one20.unisonui.widget

import android.content.Context
import android.util.AttributeSet
import com.github.barteksc.pdfviewer.PDFView

/**
 * View used to render PDF assets.
 *
 * {@link} https://github.com/barteksc/AndroidPdfViewer
 */
class UnisonPDFView(context: Context, attributeSet: AttributeSet): PDFView(context, attributeSet) {

    /**
     * Name of the PDF Asset currently loaded
     */
    private var assetName: String = ""

    /**
     * Load and show a PDF into the view.
     *
     * @param asset The name of the PDF File located in the /assets folder
     *              of your application.
     */
    fun showPdfAsset(asset: String) {
        this.assetName = asset
        super.fromAsset(asset)
                .enableSwipe(true) // allows to block changing pages using swipe
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .defaultPage(0)
                // allows to draw something on the current page, usually visible in the middle of the screen
                .enableAnnotationRendering(false) // render annotations (such as comments, colors or forms)
                .password(null)
                .scrollHandle(null)
                .enableAntialiasing(true) // improve rendering a little bit on low-res screens
                .load()
    }
}