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

    var geckoRuntime: GeckoRuntime? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_browser)

        supportActionBar?.hide()

        val view: GeckoView = findViewById(R.id.geckoview)
        val session = GeckoSession()

        if (geckoRuntime == null) {
            geckoRuntime = GeckoRuntime.create(this)
        }

        val sharedPref = getSharedPreferences("com.carudibu.subuibrowser.PREFS", Context.MODE_PRIVATE)

        session.open(geckoRuntime!!)
        view.setSession(session)
        session.loadUri(sharedPref.getString("starting_url", "https://reddit.com") ?: "https://reddit.com")

        findViewById<Button>(R.id.back).setOnClickListener {
            session.goBack()
        }
        findViewById<Button>(R.id.forward).setOnClickListener {
            session.goForward()
        }
        findViewById<Button>(R.id.quit).setOnClickListener {
            finish()
        }

    }

    override fun onDestroy() {
        super.onDestroy()


    }
}