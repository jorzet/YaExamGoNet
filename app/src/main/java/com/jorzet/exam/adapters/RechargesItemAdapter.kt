package com.jorzet.exam.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.jorzet.exam.R
import com.jorzet.exam.models.RechargeItem
import kotlinx.android.synthetic.main.recharge_item.view.*
/**
 * Created by Jorge Zepeda Tinoco on 14/04/18.
 * jorzet.94@gmail.com
 */

class RechargesItemAdapter : BaseAdapter {
    var recharges = ArrayList<RechargeItem>()
    var context: Context? = null

    constructor(context: Context, recharges: ArrayList<RechargeItem>) : super() {
        this.context = context
        this.recharges = recharges
    }

    override fun getCount(): Int {
        return recharges.size
    }

    override fun getItem(position: Int): Any {
        return recharges[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val recharge = this.recharges[position]

        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var foodView = inflator.inflate(R.layout.recharge_item, null)
        foodView.iv_icon.setImageResource(recharge.image!!)
        foodView.tv_name.text = recharge.name!!

        return foodView
    }

}