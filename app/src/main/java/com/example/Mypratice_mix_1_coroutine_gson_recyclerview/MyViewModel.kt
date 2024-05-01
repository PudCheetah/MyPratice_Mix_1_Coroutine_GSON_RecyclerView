package com.example.Mypratice_mix_1_coroutine_gson_recyclerview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.Mypratice_mix_1_coroutine_gson_recyclerview.MyDatabase.MyJsonData
import com.example.Mypratice_mix_1_coroutine_gson_recyclerview.MyRecyclerViewManager.MyList
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL

class MyViewModel(var myList: MyList):ViewModel() {
    private lateinit var myJsonData: MyJsonData
    var reportColor = MutableLiveData<String>()
    var reportContent = MutableLiveData<String>()
    var reportNo = MutableLiveData<String>()
    var reportType = MutableLiveData<String>()

    init {
        CoroutineScope(Dispatchers.IO).launch {
            val myURL = URL("https://opendata.cwa.gov.tw/api/v1/rest/datastore/E-A0014-001?Authorization=CWA-1394A705-AF6D-4DD6-9D2A-28ABBA9CF3B6&format=JSON").readText()
            myJsonData = Gson().fromJson(myURL, MyJsonData::class.java)
        }
    }
}
