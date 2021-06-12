package com.example.comeraykartodev.ui

import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.comeraykartodev.R
import com.example.comeraykartodev.ui.vm.MainViewModel
import kotlinx.android.synthetic.main.activity_splash_screen.*


class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        val connectionManager: ConnectivityManager =
            this.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectionManager.activeNetworkInfo
        val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true
        if (isConnected) {
            iv_resmim.alpha = 0f
            iv_resmim.animate().setDuration(3000).alpha(1f).withEndAction {
                val i = Intent(this, MainActivity::class.java)
                startActivity(i)
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                finish()
            }
        } else {
            Toast.makeText(
                applicationContext,
                "İnternet Bağlantınız Bulunmamaktadır",
                Toast.LENGTH_LONG
            ).show()
            finish()
        }

    }
}