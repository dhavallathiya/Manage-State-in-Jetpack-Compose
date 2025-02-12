package com.example.statemanagedemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StateTestViewModel : ViewModel() {
    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name


    private val _surname = MutableLiveData<String>()
    val surname: LiveData<String> = _surname

    fun onNameChange(newName: String) {
        _name.value = newName
    }


    fun onSurNameChange(newName: String) {
        _surname.value = newName
    }
}