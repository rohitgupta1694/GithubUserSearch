package com.github.usersearch.utils

import android.util.Log
import com.github.usersearch.BuildConfig

fun String.showDebugLogs(tag: String) {
    if (BuildConfig.DEBUG) {
        Log.d(tag, this)
    }
}