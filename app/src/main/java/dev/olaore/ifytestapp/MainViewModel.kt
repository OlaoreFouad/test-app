package dev.olaore.ifytestapp

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    var username = MutableLiveData("")
    var firstname = MutableLiveData("")
    var lastname = MutableLiveData("")

    private var user = MutableLiveData<User>()

    fun submit(): Boolean {
        user.value = User(
            username = username.value?.orNull(),
            firstname = firstname.value?.orNull(),
            lastname = lastname.value?.orNull(),
        )

        Log.d("MainViewModel", user.value.toString())

        return isUserProvidedValid(user.value!!)
    }

}
