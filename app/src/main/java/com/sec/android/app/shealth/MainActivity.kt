package com.sec.android.app.shealth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.Button
import org.mozilla.geckoview.GeckoRuntime
import org.mozilla.geckoview.GeckoSession
import org.mozilla.geckoview.GeckoView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        val view: GeckoView = findViewById(R.id.geckoview)
        val session = GeckoSession()
        val runtime: GeckoRuntime = GeckoRuntime.create(this)

        session.open(runtime)
        view.setSession(session)
        session.loadUri("https://reddit.com")

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
}