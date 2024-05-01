package com.example.Mypratice_mix_1_coroutine_gson_recyclerview.MyRecyclerViewManager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mypratice_mix_1_coroutine_viewmodel_room_gson_recyclerview.databinding.MyrecyclerViewLayoutBinding

class MyAdapter(var myList: MyList): RecyclerView.Adapter<MyAdapter.MyHolder>() {
    inner class MyHolder(binding: MyrecyclerViewLayoutBinding): RecyclerView.ViewHolder(binding.root){
        var reportNo = binding.TVReportNo
        var reportType = binding.TVReportType
        var reportContent = binding.TVReportContent
        var reportColor = binding.TVReportColor
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(MyrecyclerViewLayoutBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
        return myList.getLength()
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.apply {
            reportColor.text = myList.getReport("reportColor", position)
            reportContent.text = myList.getReport("reportContent", position)
            reportNo.text = myList.getReport("reportNo", position)
            reportType.text = myList.getReport("reportType", position)
        }
    }
}