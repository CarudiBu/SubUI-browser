package com.sec.android.app.shealth

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.widget.Button
import android.widget.Toast
import org.mozilla.geckoview.GeckoRuntime
import org.mozilla.geckoview.GeckoSession
import org.mozilla.geckoview.GeckoView

class BrowserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_browser)

        supportActionBar?.hide()

        val view: GeckoView = findViewById(R.id.geckoview)

        var geckoSession = GeckoSession()

        if (geckoRuntime == null) {
            geckoRuntime = GeckoRuntime.create(this)
        }

        geckoSession.open(geckoRuntime!!)

        view.setSession(geckoSession)

        val sharedPref = getSharedPreferences("com.carudibu.subuibrowser.PREFS", Context.MODE_PRIVATE)

        geckoSession.loadUri(sharedPref.getString("starting_url", "https://reddit.com") ?: "https://reddit.com")

        findViewById<Button>(R.id.back).setOnClickListener {
            geckoSession.goBack()
        }
        findViewById<Button>(R.id.forward).setOnClickListener {
            geckoSession.goForward()
        }
        findViewById<Button>(R.id.quit).setOnClickListener {
            finish()
        }

    }

    companion object {
        var geckoRuntime: GeckoRuntime? = null
    }
}