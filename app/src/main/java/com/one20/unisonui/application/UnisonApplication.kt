package com.one20.unisonui.application

import android.app.Application
import android.os.Environment
import com.one20.unisoninfrastructure.logging.UnisonFileLogger
import com.one20.unisoninfrastructure.logging.UnisonLogger

/**
 * Created by ryanmord on 1/29/18.
 */
class UnisonApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        val dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).absolutePath + "/" + "myDirectory/newText.txt"

        var logger = UnisonFileLogger(dir)
        logger.showCallingClass = true
        logger.showCallingMethod = true
        logger.showLineNumber = true
        UnisonLogger.initialize(logger)
        UnisonLogger.initialize(UnisonLogger())
    }

}