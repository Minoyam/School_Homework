package com.cnm.shw.webview

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.cnm.shw.R
import kotlinx.android.synthetic.main.activity_webview.*


class WebViewActivity : AppCompatActivity() {
    lateinit var webView: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)
        webView = wv_webview

        bt_webview_move.setOnClickListener {
            val imm: InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(et_webview_address.windowToken, 0)
            if (et_webview_address.text.isEmpty())
                makeToast("주소를 입력해주세요")
            else {
                webView.webViewClient = WebViewClient()
                webView.loadUrl("http://" + et_webview_address.text.toString())
            }
        }
        bt_webview_before.setOnClickListener {
            if (!webView.canGoBack())
                makeToast("이전 페이지가 없습니다.")
            else
                webView.goBack()
        }
        bt_webview_next.setOnClickListener {
            if (!webView.canGoForward())
                makeToast("다음 페이지가 없습니다.")
            else
                webView.goForward()
        }
    }

    private fun makeToast(message: String) =
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()

}
