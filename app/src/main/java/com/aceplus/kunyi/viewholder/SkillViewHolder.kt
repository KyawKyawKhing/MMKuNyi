package com.aceplus.kunyi.viewholder

import android.view.View
import com.aceplus.kunyi.data.vo.RequiredSkillVO
import kotlinx.android.synthetic.main.list_item.view.*

/**
 * Created by kkk on 8/1/2018.
 */
class SkillViewHolder(itemView: View) : BaseViewHolder<RequiredSkillVO>(itemView) {

    override fun setData(data: RequiredSkillVO) {
        itemView.listItemName.text = data.skillName
    }

}