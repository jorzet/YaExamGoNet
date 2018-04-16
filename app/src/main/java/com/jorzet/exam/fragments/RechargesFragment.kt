package com.jorzet.exam.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.GridView
import com.jorzet.exam.R
import com.jorzet.exam.adapters.RechargesItemAdapter
import com.jorzet.exam.fragments.content.BaseContentFragment
import com.jorzet.exam.models.RechargeItem
import com.jorzet.exam.ui.activities.RechargeActivity

/**
 * Created by Jorge Zepeda Tinoco on 14/04/18.
 * jorzet.94@gmail.com
 */

class RechargesFragment : BaseContentFragment(), AdapterView.OnItemClickListener {

    private lateinit var mRechargesGridView : GridView
    private var adapter: RechargesItemAdapter? = null
    private var recharges = ArrayList<RechargeItem>()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        if (container == null)
            return null

        val rootView = inflater?.inflate(R.layout.recharges_fragment, container, false)!!

        mRechargesGridView = rootView.findViewById(R.id.gv_recharges)

        // load foods
        recharges.add(RechargeItem(context.resources.getString(R.string.air_time_text), R.drawable.ic_claro))
        recharges.add(RechargeItem(context.resources.getString(R.string.megas_text), R.drawable.ic_claro))
        recharges.add(RechargeItem(context.resources.getString(R.string.megas_text), R.drawable.ic_claro))
        recharges.add(RechargeItem(context.resources.getString(R.string.air_time_text),R.drawable.ic_tuenti))
        recharges.add(RechargeItem(context.resources.getString(R.string.air_time_text), R.drawable.ic_tuenti))
        recharges.add(RechargeItem(context.resources.getString(R.string.air_time_text), R.drawable.ic_tuenti))
        recharges.add(RechargeItem(context.resources.getString(R.string.air_time_text),R.drawable.ic_entel))
        recharges.add(RechargeItem(context.resources.getString(R.string.air_time_text), R.drawable.ic_entel))
        recharges.add(RechargeItem(context.resources.getString(R.string.air_time_text), R.drawable.ic_entel))
        adapter = RechargesItemAdapter(context, recharges)

        mRechargesGridView.adapter = adapter
        mRechargesGridView.onItemClickListener = this

        return rootView
    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        val intent = Intent(activity, RechargeActivity::class.java)
        activity.startActivity(intent)
    }
}