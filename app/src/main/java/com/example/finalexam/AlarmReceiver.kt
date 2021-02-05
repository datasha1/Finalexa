package com.example.finalexam

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val prefs = context?.getSharedPreferences("KATSITA", Context.MODE_PRIVATE)
        val quote = prefs?.getString((1..20).random().toString(), "Error, no quote")

        prefs?.edit()?.putString("actualQuote", quote)?.apply()
    }
}