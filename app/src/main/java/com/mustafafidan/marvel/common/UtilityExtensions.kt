package com.mustafafidan.marvel.common

import android.content.Context
import android.text.format.DateFormat
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun String.getFormattedDate(context : Context) : String{
    val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
    var date : Date?= null;
    try {
        date = sdf.parse(this)
    } catch (e: ParseException) {
        return ""
    }
    val dateFormat = DateFormat.getLongDateFormat(context)
    val timeFormat = DateFormat.getTimeFormat(context)
    val dateFormatStr = dateFormat.format(date)
    val timeFormatStr = timeFormat.format(date)
    return  "$dateFormatStr $timeFormatStr"
}


fun String.md5(): String {
    val MD5 = "MD5"
    try {

        val digest: MessageDigest = MessageDigest
            .getInstance(MD5)
        digest.update(this.toByteArray())
        val messageDigest: ByteArray = digest.digest()

        val hexString = StringBuilder()
        for (aMessageDigest in messageDigest) {
            var h = Integer.toHexString(0xFF and aMessageDigest.toInt())
            while (h.length < 2) h = "0$h"
            hexString.append(h)
        }
        return hexString.toString()
    } catch (e: NoSuchAlgorithmException) {
        e.printStackTrace()
    }
    return ""
}

fun timeStamp() : String{
    val tsLong = System.currentTimeMillis() / 1000
    return tsLong.toString()
}