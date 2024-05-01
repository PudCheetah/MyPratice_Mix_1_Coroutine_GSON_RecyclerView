package com.example.Mypratice_mix_1_coroutine_gson_recyclerview.MyRecyclerViewManager

import com.example.Mypratice_mix_1_coroutine_gson_recyclerview.MyDatabase.MyJsonData
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.net.URL

class MyList {
    private lateinit var myJsonData: MyJsonData
    private lateinit var myJob: Job
    init {
        myJob = CoroutineScope(Dispatchers.IO).launch {
            val myURL = URL("https://opendata.cwa.gov.tw/api/v1/rest/datastore/E-A0014-001?Authorization=CWA-1394A705-AF6D-4DD6-9D2A-28ABBA9CF3B6&format=JSON").readText()
            myJsonData = Gson().fromJson(myURL, MyJsonData::class.java)
        }
    }
    fun getJob(): Job{
        return myJob
    }
    fun getLength(): Int{
        return myJsonData.records.tsunami.size
    }
    fun getReport(report: String, indext: Int): String{
        var result = when(report){
            "reportColor" -> myJsonData.records.tsunami[indext].reportColor
            "reportContent" -> myJsonData.records.tsunami[indext].reportContent
            "reportNo" -> myJsonData.records.tsunami[indext].reportNo
            "reportType" -> myJsonData.records.tsunami[indext].reportType
            else -> {""}
        }
        return result
    }
}