package com.example.enozomtask.view.view_model.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.enozomtask.model.MyTaskRemoteSource
import com.example.enozomtask.view.view_model.MainViewModel

class MainViewModelFactory (private var source: MyTaskRemoteSource ): ViewModelProvider.Factory  {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(source) as T
        } else {
            throw IllegalArgumentException("Error")
        }
    }
}