package com.devhouse.roomexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val database by lazy { UserRoomDatabase.getDatabase(this) }
    val repository by lazy { DataRepository(database.wordDao()) }

    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel =
            ViewModelProvider(this, UserViewModelFactory(repository)).get(UserViewModel::class.java)

        viewModel.allUsers.observe(this, { users ->
            val sb = StringBuilder()
            if (users.isNotEmpty()) {
                for (user in users) {
                    sb.append("${user.name},")
                }
            }
            users_text.text = sb
        })

        btn_insert.setOnClickListener {
            val user = User(0, et_user_name.text.toString())
            viewModel.insertUser(user)
            viewModel.getAllUsers()
        }

        btn_delete.setOnClickListener {
            viewModel.deleteAllUsers()
            viewModel.getAllUsers()
        }

    }
}