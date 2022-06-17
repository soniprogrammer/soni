package com.example.retrofitmvvm.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.retrofitmvvm.R
import com.example.retrofitmvvm.model.DummyDataItem
import de.hdodenhof.circleimageview.CircleImageView

class PostItemAdapter(var context: Context,var arrayList: ArrayList<DummyDataItem>) : BaseAdapter() {
    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(p0: Int): Any {
       return arrayList.get(p0)
    }

    override fun getItemId(p0: Int): Long {
      return p0.toLong()
    }

   public fun filterList(filterListData:ArrayList<DummyDataItem>){
        arrayList=filterListData
        notifyDataSetChanged()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        val view:View=View.inflate(context,R.layout.card_view_item_layout,null)

        var circleImageView:CircleImageView=view.findViewById(R.id.img)
        var titleName:TextView=view.findViewById(R.id.title_name)
        var dummyDataItem:DummyDataItem = arrayList.get(p0)
         titleName.text=dummyDataItem.title

        return view
    }


}