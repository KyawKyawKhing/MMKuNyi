package com.aceplus.kunyi.viewholder

import android.view.View
import kotlinx.android.synthetic.main.list_item.view.*

/**
 * Created by kkk on 8/1/2018.
 */
class ListItemViewHolder(itemView: View) : BaseViewHolder<String>(itemView) {
    override fun setData(data: String) {
        itemView.listItemName.text = data
    }
}