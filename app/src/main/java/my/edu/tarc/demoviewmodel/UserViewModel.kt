package my.edu.tarc.demoviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel: ViewModel() {
    private val _user : MutableLiveData<User> by lazy {
        MutableLiveData<User>(User())
    }

    val user : LiveData<User>
        get() = _user

    fun setUser(user: User){
        if(this.user.isInitialized){
            this.user.value!!.name = user.name
            this.user.value!!.email = user.email
        }
    }

    fun getUser(): User{
        val newUser = User(user.value!!.name, user.value!!.email)
        return newUser
    }
}