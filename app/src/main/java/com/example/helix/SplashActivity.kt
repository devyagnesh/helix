package com.example.helix

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowInsets
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.helix.databinding.ActivitySplashBinding
import com.example.helix.utils.isInternetAvailable

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivitySplashBinding = DataBindingUtil.setContentView(this,R.layout.activity_splash);

        val SPLASH_TIME_OUT= 2000L;

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
            window.insetsController!!.hide(WindowInsets.Type.navigationBars())
        }


        if(!isInternetAvailable(this)){
            Toast.makeText(this,"No internet connection",Toast.LENGTH_LONG).show()
        }

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@SplashActivity,LoginActivity::class.java)
            startActivity(intent);
            finish();
        },SPLASH_TIME_OUT)


    }


}