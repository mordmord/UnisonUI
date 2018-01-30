package com.one20.unisoninfrastructure.logging

import java.io.File
import java.io.PrintWriter



/**
 * Logger implementation for writing logs to a file
 */
class UnisonFileLogger(filePath: String) : UnisonLogger() {

    /**
     * Path to local log file
     */
    private var mFilePath: String? = null

    /**
     * Actual log file
     */
    private var mFile: File? = null

    /**
     * Instance for writing lines to log file
     */
    private var mPrintWriter: PrintWriter? = null


    init {
        this.mFilePath = filePath
        this.mFile = File(this.mFilePath)
    }

    /**
     * Checks file existence and creates new file if doesn't already exist
     */
    private fun checkFile() {
        mFile?.let {
            if(!mFile!!.exists()) {
                mFile!!.createNewFile()
            }
        }

        if(mPrintWriter == null) {
            mPrintWriter = PrintWriter(mFile)
        }
    }


    override fun log(level: Int, message: String) {
        checkFile()

        mPrintWriter?.println(message)
        mPrintWriter?.close()
    }

    override fun log(level: Int, throwable: Throwable) {
        checkFile()

        mPrintWriter?.println(throwable.toString())
        mPrintWriter?.close()
    }
}