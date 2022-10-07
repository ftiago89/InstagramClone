package com.felipe.instagram.login.view

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.felipe.instagram.R
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val editTextEmail = findViewById<TextInputEditText>(R.id.login_edit_email)
        val editTextPassword = findViewById<TextInputEditText>(R.id.login_edit_password)

        editTextEmail.addTextChangedListener(watcher)
        editTextPassword.addTextChangedListener(watcher)

        val buttonEnter = findViewById<LoadingButton>(R.id.login_btn_enter)
        buttonEnter.setOnClickListener {
            buttonEnter.showProgress(true)
            findViewById<TextInputLayout>(R.id.login_edit_email_input).error = "E-mail inválido"
            findViewById<TextInputLayout>(R.id.login_edit_password_input).error = "Senha inválida"

            Handler(Looper.getMainLooper()).postDelayed({
                buttonEnter.showProgress(false)
            }, 2000)
        }
    }

    private val watcher = object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
            findViewById<LoadingButton>(R.id.login_btn_enter).isEnabled = s.toString().isNotEmpty()
        }

        override fun afterTextChanged(p0: Editable?) {
        }

    }
}

