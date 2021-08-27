package com.cookiejarapps.android.secondscreentest

import android.app.ActivityOptions
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.hardware.display.DisplayManager
import android.util.Log
import android.webkit.WebView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        val intent = packageManager.getLaunchIntentForPackage("com.cookiejarapps.android.secondscreentest")
        intent!!.addFlags(Intent.FLAG_ACTIVITY_LAUNCH_ADJACENT or Intent.FLAG_ACTIVITY_NEW_TASK)
        val options = ActivityOptions.makeBasic().setLaunchDisplayId(1)
        startActivity(intent, options.toBundle())
    }
}