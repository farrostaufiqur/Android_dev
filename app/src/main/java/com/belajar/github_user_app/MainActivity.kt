package com.belajar.github_user_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.belajar.github_user_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val list = ArrayList<User>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvUser.setHasFixedSize(true)
        list.addAll(listUser)
        showRecyclerList()
    }
    private val listUser: ArrayList<User>
        get() {
            val dataUsername = resources.getStringArray(R.array.username)
            val dataName = resources.getStringArray(R.array.name)
            val dataLocation = resources.getStringArray(R.array.location)
            val dataRepo = resources.getStringArray(R.array.repository)
            val dataCompany = resources.getStringArray(R.array.company)
            val dataFollowers = resources.getStringArray(R.array.followers)
            val dataFollowing = resources.getStringArray(R.array.following)
            val dataAvatar = resources.obtainTypedArray(R.array.avatar)
            val listUser = ArrayList<User>()
            for (i in dataName.indices) {
                val user = User(dataUsername[i], dataName[i],dataLocation[i] ,dataRepo[i] ,dataCompany[i], dataFollowers[i],dataFollowing[i] ,dataAvatar.getResourceId(i, -1))
                listUser.add(user)
            }
            return listUser
        }
    private fun showRecyclerList() {
        binding.rvUser.layoutManager = LinearLayoutManager(this)
        val listUserAdapter = ListUserAdapter(list)
        binding.rvUser.adapter = listUserAdapter

        listUserAdapter.setOnItemClickCallback(object : ListUserAdapter.OnItemClickCallback {
            override fun onItemClicked(data: User) {
                val (username, name, location, repository, company, followers, following, getAvatar) = data
                val user = User(
                    username, name, location, repository,
                    company, followers, following, getAvatar
                )
                val sendIntent = Intent(this@MainActivity, Profile::class.java)
                sendIntent.putExtra(Profile.EXTRA_USER, user)
                startActivity(sendIntent)
            }
        })
    }
}