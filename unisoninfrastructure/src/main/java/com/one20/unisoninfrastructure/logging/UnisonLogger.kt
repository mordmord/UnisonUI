package com.one20.unisoninfrastructure.logging

import android.util.Log

/**
 * Base logger class for logging to console with various log levels
 */
open class UnisonLogger: AbstractLogger() {

    override fun log(level: Int, message: String) {
        when (level) {
            LEVEL_WARN -> {
                Log.w(generateTag(), message)
            }
            LEVEL_DEBUG -> {
                Log.d(generateTag(), message)
            }
            LEVEL_ERROR -> {
                Log.e(generateTag(), message)
            } else -> Log.i(generateTag(), message)
        }
    }

    override fun log(level: Int, throwable: Throwable) {
        when (level) {
            LEVEL_WARN -> {
                Log.w(generateTag(), throwable.toString())
            }
            LEVEL_DEBUG -> {
                Log.d(generateTag(), throwable.toString())
            }
            LEVEL_ERROR -> {
                Log.e(generateTag(), throwable.toString())
            } else -> Log.i(generateTag(), throwable.toString())
        }
    }




    companion object {

        private val LEVEL_ERROR = 0
        private val LEVEL_DEBUG = 1
        private val LEVEL_WARN  = 2

        private var loggers: ArrayList<AbstractLogger> = ArrayList()

        fun initialize(logger: AbstractLogger) {
            loggers.add(logger)
        }


        fun d(message: String) {
            loggers.forEach {
                it.log(LEVEL_DEBUG, message)
            }
        }


        fun d(throwable: Throwable) {
            loggers.forEach {
                it.log(LEVEL_DEBUG, throwable)
            }
        }


        fun e(message: String) {
            loggers.forEach {
                it.log(LEVEL_ERROR, message)
            }
        }


        fun e(throwable: Throwable) {
            loggers.forEach {
                it.log(LEVEL_ERROR, throwable)
            }
        }


        fun w(message: String) {
            loggers.forEach {
                it.log(LEVEL_WARN, message)
            }
        }


        fun w(throwable: Throwable) {
            loggers.forEach {
                it.log(LEVEL_WARN, throwable)
            }
        }

        fun file(message: String) {
            loggers.forEach {
                if(it is UnisonFileLogger) {
                    it.log(LEVEL_DEBUG, message)
                }
            }
        }

    }

}