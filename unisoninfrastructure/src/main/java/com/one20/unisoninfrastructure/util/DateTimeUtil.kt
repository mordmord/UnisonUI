package com.one20.unisoninfrastructure.util

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

/**
 * Utility class to handle Date/Time functions
 */
class DateTimeUtil {
    companion object {

        //  DATE FORMAT STRINGS
        val yyyy_MM_dd = "yyyyMMdd"
        val HH_mm_ss = "HHmmss"

        //  DATE FORMATS
        val dateFormatter_yyyy_MM_dd = DateTimeFormat.forPattern(yyyy_MM_dd)
        val dateFormatter_HH_mm_ss = DateTimeFormat.forPattern(HH_mm_ss)


        /**
         * Get a yyyyMMdd date string for today, plus or minus the designated
         * day offset passed
         *
         * @param dayOffset Day offset to +/- from today
         */
        fun getYYYYMMDDWithDayOffset(dayOffset: Int): String {
            val date = DateTime()
            date.plusDays(dayOffset)

            return dateFormatter_yyyy_MM_dd.print(date)
        }

        /**
         * Converts the timestamp, the result of milliseconds since January 1, 1970, into a readable time
         * format.
         *
         * @param millis milliseconds since 01/01/1970.
         * @return
         */
        fun convertMillisTo_HH_mm_ss(millis: Long): String {
            val date: String
            val time = DateTime(millis)

            return dateFormatter_HH_mm_ss.print(time)
        }


        /**
         * convert millis to yyyy mm dd hh mm ss, represented as 'ints'
         * e.g. new DateTime(2017, 02, 12, 00, 00, 00)
         */
        fun convertMillisToDateTime(millis: Long): DateTime? {
            return DateTime(millis)
        }
    }
}