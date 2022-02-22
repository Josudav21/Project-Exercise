package com.example.projectexcercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectexcercise.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: UserAdapter
    private val viewModel: MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            viewModel.apply {
                initializeRecycleView()

                btnAdd.setOnClickListener {
                    insertUser(
                        User(
                            edtName.text.toString(),
                            edtEmail.text.toString()
                        )
                    )
                }

                users.observe(this@MainActivity, {
                    Log.i("USERS", "$it")
                    adapter.populateData(it)
                })
            }
        }
    }

    fun initializeRecycleView() {
        binding.apply {
            adapter = UserAdapter()
            rvUser.adapter = adapter
            rvUser.layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

}
