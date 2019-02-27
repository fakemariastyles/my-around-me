package com.workshop.aroundme.app.ui.signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.workshop.aroundme.R

class SignUpActivityWrapper : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.beginTransaction()
            .replace(R.id.signUpFragmentWrapper,SignUpFragment())
            .commit()
        setContentView(R.layout.activity_sign_up_wrapper)
    }
}
