package com.example.androidkolinmvvm.views.onboarding

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidkolinmvvm.R
import com.example.androidkolinmvvm.databinding.ActivityOnboardingBinding
import com.example.androidkolinmvvm.views.random_user.RandomUserActivity

class OnboardingActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityOnboardingBinding
    private lateinit var getStartedButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        viewBinding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupUI()
        setupListeners()
    }

    private fun setupUI() {
        getStartedButton = viewBinding.btnGetStarted
    }

    private fun setupListeners() {
        getStartedButton.setOnClickListener {
            val intent: Intent = Intent(this, RandomUserActivity::class.java)
            startActivity(intent)
        }
    }
}