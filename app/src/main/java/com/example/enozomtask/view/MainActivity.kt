package com.example.enozomtask.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.enozomtask.R
import com.example.enozomtask.model.MyTaskRemoteSource
import com.example.enozomtask.view.view_model.MainViewModel
import com.example.enozomtask.view.view_model.factory.MainViewModelFactory
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val factory =MainViewModelFactory(MyTaskRemoteSource.getInstance())

        val viewModel = ViewModelProvider(this,factory)[MainViewModel::class.java]
        viewModel.getMyTaskData()

        viewModel.myTask.observe(this){
            val indexes = it.Indexes
            val text = it.Text
            val myIndexes = indexes?.split(",")

            val myResult = StringBuilder()

            if (myIndexes != null) {
                for(index in myIndexes){
                    myResult.append(text?.get(index.toInt()))
                }
            }

            Log.e("myResult", "res : $myResult ")

            viewModel.postResult(myResult.toString())
        }

    }
}