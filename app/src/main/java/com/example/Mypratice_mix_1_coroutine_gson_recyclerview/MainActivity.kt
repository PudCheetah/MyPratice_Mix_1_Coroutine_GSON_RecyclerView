package com.example.Mypratice_mix_1_coroutine_gson_recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.Mypratice_mix_1_coroutine_gson_recyclerview.MyRecyclerViewManager.MyAdapter
import com.example.Mypratice_mix_1_coroutine_gson_recyclerview.MyRecyclerViewManager.MyList
import com.example.mypratice_mix_1_coroutine_viewmodel_room_gson_recyclerview.databinding.ActivityMainBinding
import com.example.mypratice_mix_1_coroutine_viewmodel_room_gson_recyclerview.databinding.MyrecyclerViewLayoutBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var bindingMainActivity: ActivityMainBinding
    var myList = MyList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.Main).launch {
            bindingMainActivity = ActivityMainBinding.inflate(layoutInflater)
            joinAll(myList.getJob())
                bindingMainActivity.apply {
                    myRV1Main.layoutManager = LinearLayoutManager(this@MainActivity)
                    myRV1Main.setHasFixedSize(true)
                    myRV1Main.addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))
                    myRV1Main.adapter = MyAdapter(myList)
                    this.root.invalidate()
                    setContentView(this.root)
                }
            }
        }
    }