package com.aceplus.kunyi.adapter

import android.content.Context
import android.view.ViewGroup
import com.aceplus.kunyi.R
import com.aceplus.kunyi.data.vo.JobsVO
import com.aceplus.kunyi.viewholder.ListItemViewHolder

/**
 * Created by kkk on 8/1/2018.
 */
class ListItemAdapter(context: Context) : BaseRecyclerAdapter<String>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        val view = mLayoutInflater!!.inflate(R.layout.list_item, parent, false)
        return ListItemViewHolder(view)
    }
}