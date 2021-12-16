package com.example.hupudemo.view.activity

import android.net.http.SslError
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.LayoutInflater
import android.webkit.SslErrorHandler
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.hupudemo.R
import com.example.hupudemo.databinding.ActivityIndexDetailsBinding
import retrofit2.http.Url

class IndexDetailsActivity : AppCompatActivity() {

    private var binding : ActivityIndexDetailsBinding? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIndexDetailsBinding.inflate(LayoutInflater.from(this))
        setContentView(binding?.root)
        val url = intent.getStringExtra("myUrl")
        Log.i("XXX", "onCreate: ")
        //开启和H5的交互页面
        binding?.webView?.settings?.javaScriptEnabled = true
        binding?.webView?.settings?.domStorageEnabled = true
        /*允许ssl证书*/
        binding?.webView?.webViewClient = object : WebViewClient() {
            override fun onReceivedSslError(
                webview: WebView?,
                handler: SslErrorHandler?,
                ssl: SslError?
            ) {
                handler?.proceed()
            }

            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                return true
            }
        }

        binding?.webView?.webViewClient = WebViewClient()
        if (url != null) {
            binding?.webView?.loadUrl(url)
        }

    }
}