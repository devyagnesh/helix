package com.example.helix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.helix.databinding.ActivityLoginBinding
import com.example.helix.utils.isEmailValid
import java.lang.Exception

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var email:EditText
    private lateinit var password:EditText
    private lateinit var btnResetNow:TextView
    private lateinit var  errorMessageLabel : TextView
    private lateinit var btnLogin:Button
    private lateinit var  btnGoToSignup:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@LoginActivity,R.layout.activity_login)


        email = binding.loginEmail
        password = binding.loginPassword
        btnResetNow = binding.resetPasswordAct
        errorMessageLabel = binding.errMsgLabel
        btnLogin = binding.btnLogin
        btnGoToSignup = binding.btnGotoSignup


        btnLogin.setOnClickListener {
           try {
               if(email.text.isEmpty() || !isEmailValid(email.text.toString()) ||password.text.toString().isEmpty()){
                   throw Exception(resources.getText(R.string.err_login_msg_empty_field).toString())
               }

               else {
                   val intent = Intent(this@LoginActivity,Dashboard::class.java);
                   startActivity(intent)
                   finish()
               }
           }catch (e:Exception){
               errorMessageLabel.text = e.message
               errorMessageLabel.visibility = View.VISIBLE
           }
        }

        btnGoToSignup.setOnClickListener {
            val intent : Intent = Intent(this@LoginActivity,SignupActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}