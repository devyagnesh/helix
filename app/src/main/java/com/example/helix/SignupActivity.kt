package com.example.helix

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.helix.databinding.ActivitySignupBinding
import com.example.helix.utils.isEmailValid
import com.example.helix.utils.isFullNameValid

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    private lateinit var fullname:EditText
    private lateinit var email:EditText
    private lateinit var password:EditText
    private lateinit var confirmPassword:EditText
    private lateinit var btnSignup:Button
    private lateinit var  btnToGoLogin:TextView
    private lateinit var errMessageLabel:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@SignupActivity,R.layout.activity_signup)

        fullname = binding.signupFullname
        email = binding.signupEmail
        password = binding.signupPassword
        confirmPassword = binding.signupConfirmPassword
        btnSignup = binding.btnSignup
        btnToGoLogin = binding.btnGotoLogin
        errMessageLabel = binding.errMsgLabel

        btnSignup.setOnClickListener {
            try {
                val valFullname = fullname.text.toString().trim().lowercase()
                val valEmail = email.text.toString().trim().lowercase()
                val valPassword = password.text.toString().trim()
                val valConfirmPassword = confirmPassword.text.toString().trim()

                if(valFullname.isEmpty() || !isFullNameValid(valFullname)){
                    throw Exception(resources.getText(R.string.err_signup_msg_invalid_fullname).toString())

                }

                else if(valEmail.isEmpty() || !isEmailValid(valEmail)){
                    throw Exception(resources.getText(R.string.err_signup_msg_invalid_email).toString())

                }

                else if(valPassword.isEmpty() || valPassword.length < 7){
                    throw Exception(resources.getText(R.string.err_signup_msg_invalid_password).toString())

                }

                else if(valConfirmPassword.isEmpty() || (valConfirmPassword != valPassword)){
                    throw Exception(resources.getText(R.string.err_signup_msg_invalid_confirm_password).toString())

                }

                else{
                    errMessageLabel.visibility = View.INVISIBLE
                }


            }catch (e:Exception){
                errMessageLabel.text = e.message
                errMessageLabel.visibility = View.VISIBLE
            }finally {

            }
        }




        btnToGoLogin.setOnClickListener {
            val intent = Intent(this@SignupActivity,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}