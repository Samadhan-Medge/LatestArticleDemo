package com.samadhan.nytimes.utils

import android.text.TextUtils
import com.google.gson.Gson

object ObjectConvertor {
    fun <T> convertStringToObject(strObjectString: String, type: Class<*>): T? {
        return try {
            if (TextUtils.isEmpty(strObjectString)) null else Gson().fromJson<T>(strObjectString, type)
        } catch (e: Exception) {
            null
        }
    }
}