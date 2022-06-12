package com.example.enozomtask.model

import android.util.Log
import com.example.enozomtask.networking.GetMyTaskService
import com.example.enozomtask.networking.RetrofitHelper
import com.example.enozomtask.pojo.MyTaskData
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import okhttp3.RequestBody

class MyTaskRemoteSource private constructor(){

    private val api: GetMyTaskService = RetrofitHelper.getInstance().create(GetMyTaskService::class.java)
    private val gson = Gson()

    companion object{
        private val myTaskRemoteSource: MyTaskRemoteSource? = null

        fun getInstance(): MyTaskRemoteSource {
            return myTaskRemoteSource ?: MyTaskRemoteSource()
        }

    }

    suspend fun getMyTaskData(): MyTaskData {
        val res = api.getMyTaskData()
        Log.i("getMyTaskData", "res : $res")
        return gson.fromJson(
            res.body() as JsonObject,
            object : TypeToken<MyTaskData>() {}.type
        )
    }

    suspend fun postResult(req:RequestBody) {
        val res = api.postResult(req)
        Log.e("postResult", "res : $res  ${res.body()}")
    }

}