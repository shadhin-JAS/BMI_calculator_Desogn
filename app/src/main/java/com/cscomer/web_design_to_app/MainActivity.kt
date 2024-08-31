package com.cscomer.web_design_to_app

import android.app.Activity
import android.graphics.Bitmap
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cscomer.web_design_to_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.webViwe.loadUrl("https://evaly.com.bd")

        binding.webViwe.settings.javaScriptEnabled = true

        binding.webViwe.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)

                binding.webViwe.visibility = View.GONE
                binding.progressbar.visibility = View.VISIBLE
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)

                binding.webViwe.visibility = View.VISIBLE
                binding.progressbar.visibility = View.GONE
            }
        }
    }

    override fun onBackPressed() {

        if (binding.webViwe.canGoBack()) {
            binding.webViwe.goBack()

        }
        else{
            super.onBackPressed()
        }
    }
}
