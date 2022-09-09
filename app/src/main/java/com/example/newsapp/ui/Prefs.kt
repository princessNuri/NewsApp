package com.example.newsapp.ui

import android.content.Context
import android.net.Uri
import java.net.URI

class Prefs(context: Context) {
    private var preferences= context.getSharedPreferences("settings",Context.MODE_PRIVATE)

    fun saveState(){
        preferences.edit().putBoolean("isShown",true).apply()
    }
    fun isShown():Boolean{
        return preferences.getBoolean("isShown",true)
    }

    fun saveAvatar(uri: Uri?) {
        uri?.let {
            preferences.edit().putString("avatar",uri.toString()).apply()
        }
    }

    fun getAvatar():Uri? {
        val s = preferences.getString("avatar","")
        return Uri.parse(s)
    }
}