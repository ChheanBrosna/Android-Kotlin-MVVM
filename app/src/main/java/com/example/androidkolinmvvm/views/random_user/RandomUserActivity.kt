package com.example.androidkolinmvvm.views.random_user

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import coil.load
import com.example.androidkolinmvvm.R
import com.example.androidkolinmvvm.core.services.ApiService
import com.example.androidkolinmvvm.core.services.RetrofitClient
import com.example.androidkolinmvvm.databinding.ActivityRandomUserBinding

class RandomUserActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityRandomUserBinding
    private lateinit var userProfileImageView: ImageView

    // Random user
    private lateinit var apiService: ApiService
    private lateinit var randomUserRepository: RandomUserRepository
    private lateinit var randomUserViewModelFactory: RandomUserViewModelFactory
    private val randomUserViewModel: RandomUserViewModel by viewModels<RandomUserViewModel> { randomUserViewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        viewBinding = ActivityRandomUserBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        onInit()
    }

    private fun onInit() {
        setupUI()
        fetchRandomUser()
    }

    private fun setupUI() {
        userProfileImageView = viewBinding.ivUserProfile
        userProfileImageView.load("https://rukminim2.flixcart.com/image/850/1000/kxkqavk0/poster/h/c/j/medium-lisa-blackpink-singer-celebrity-matte-finish-poster-original-imagayyz84kuqjff.jpeg?q=90&crop=false")
    }

    private fun fetchRandomUser() {
        apiService = RetrofitClient().apiService
        randomUserRepository = RandomUserRepository(apiService)
        randomUserViewModelFactory = RandomUserViewModelFactory(randomUserRepository)

        randomUserViewModel.getRandomUser()
        randomUserViewModel.randomUserLiveData.observe(this) { randomUser ->
            println("Random User Response : $randomUser")
        }
    }
}