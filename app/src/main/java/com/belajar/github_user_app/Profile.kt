package com.belajar.github_user_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.belajar.github_user_app.databinding.ActivityProfileBinding


class Profile : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    companion object{
        const val EXTRA_USER="extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val user=intent.getParcelableExtra<User>(EXTRA_USER) as User
        binding.tvProfileUsername.text= user.username
        binding.tvProfileName.text=user.name
        binding.tvProfileLocation.text=user.location
        binding.tvProfileRepo.text=user.repository
        binding.tvProfileCompany.text=user.company
        binding.tvProfileFollowers.text=user.followers
        binding.tvProfileFollowing.text=user.following
        binding.tvAvatar.setImageResource(user.avatar)
    }
}