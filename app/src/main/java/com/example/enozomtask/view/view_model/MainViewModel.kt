package com.example.enozomtask.view.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.enozomtask.model.MyTaskRemoteSource
import com.example.enozomtask.pojo.MyTaskData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONArray
import org.json.JSONObject

class MainViewModel(var source: MyTaskRemoteSource) : ViewModel() {

    private val _myTask = MutableLiveData<MyTaskData>()
    val myTask :LiveData<MyTaskData> = _myTask

    fun getMyTaskData(){
        viewModelScope.launch(Dispatchers.IO) {
            val res = source.getMyTaskData()
            withContext(Dispatchers.Main){
                _myTask.value = res
            }
        }
    }

    fun postResult(res: String){
        viewModelScope.launch(Dispatchers.IO) {
            source.postResult(getRequest(res))
        }
    }

    private fun getRequest(res: String): RequestBody {


        val jsonReq = JSONObject()

        jsonReq.put("Password",res)


        val requestBody = jsonReq.toString().toRequestBody("application/json".toMediaTypeOrNull())

        Log.i("getRequest", "string to Request:  $jsonReq ")

        return requestBody
    }



}


