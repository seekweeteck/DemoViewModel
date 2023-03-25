package my.edu.tarc.demoviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import my.edu.tarc.demoviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    //Create an instance of View Model
    val userViewModel : UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Create a LiveData observer
        val userObserver = Observer<User> {newUser ->
            binding.myUser = newUser
        }
        //Observe LiveData
        userViewModel.user.observe( this, userObserver)

        binding.buttonSet.setOnClickListener {
            val myUser = User("SeeKT", "seekt@tarc.edu.my")
            userViewModel.setUser(myUser)
            binding.myUser = myUser

            val myUser2 = User("SeeKT2", "seekt@tarc.edu.my")
            binding.myUser2 = myUser2
        }

    }

}