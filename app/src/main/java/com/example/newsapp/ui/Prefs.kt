package com.example.newsapp.ui

import android.content.Context

class Prefs(context: Context) {
    private var preferences= context.getSharedPreferences("settings",Context.MODE_PRIVATE)

    fun saveState(){
        preferences.edit().putBoolean("isShown",true).apply()
    }
    fun isShown():Boolean{
        return preferences.getBoolean("isShown",false)
    }
    fun savePicture(){

    }
}