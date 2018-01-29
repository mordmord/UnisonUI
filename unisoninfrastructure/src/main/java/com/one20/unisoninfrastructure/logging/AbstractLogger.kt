package com.one20.unisoninfrastructure.logging

/**
 * Created by ryanmord on 1/29/18.
 */
abstract class AbstractLogger {

    abstract fun log(level: Int, message: String)
    abstract fun log(level: Int, throwable: Throwable)

    /**
     * Boolean indicating whether calling class should be included in log tag
     */
    var showCallingClass = true

    /**
     * Boolean indicating whether calling method should be included in log tag
     */
    var showCallingMethod = false

    /**
     * Boolean indicating whether line number of log call should be included in log tag
     */
    var showLineNumber = false


    /**
     * Generates the appropriate Tag item for a log statement
     */
    fun generateTag(): String {
        val stacktrace = Thread.currentThread().stackTrace
        val stackLevel = 5 // 5 is the typical level for the calling class location

        var fileName = ""
        if(stacktrace != null && stacktrace.size >= stackLevel) {
            if(showCallingClass) {
                fileName = stacktrace[stackLevel].fileName
            }
            if(showCallingMethod) {
                fileName += " " + stacktrace[stackLevel].methodName
            }
            if(showLineNumber) {
                fileName += "[" + stacktrace[stackLevel].lineNumber + "]"
            }
        }

        return fileName
    }

}