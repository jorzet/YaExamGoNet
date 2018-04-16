package com.jorzet.exam.ui.activities

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.jorzet.exam.R
import com.jorzet.exam.adapters.MainContainerViewPager

/**
 * Created by Jorge Zepeda Tinoco on 14/04/18.
 * jorzet.94@gmail.com
 */
class ContentActivity : BaseActivityLifeCycle(), TabLayout.OnTabSelectedListener {

    private lateinit var mToolbar : Toolbar
    private lateinit var mTabLayout : TabLayout
    private lateinit var mViewPager : ViewPager
    private lateinit var mAdapter : MainContainerViewPager
    private lateinit var mSettingsButton : ImageView

    private val PIN_TAG : String = "pin_tag"
    private val RECHARGES_TAG : String = "recharges_tag"
    private val COLLECTION_TAG : String = "collection_tag"
    private val ADMINISTRATION_TAG : String = "administration_tag"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)

        mSettingsButton = findViewById(R.id.iv_settings)

        mToolbar = findViewById(R.id.toolbar)
        //setSupportActionBar(mToolbar)

        mTabLayout = findViewById(R.id.tab_layout)
        mTabLayout.tabGravity = TabLayout.GRAVITY_FILL

        mTabLayout.addTab(mTabLayout.newTab().setTag(PIN_TAG))
        mTabLayout.addTab(mTabLayout.newTab().setTag(RECHARGES_TAG))
        mTabLayout.addTab(mTabLayout.newTab().setTag(COLLECTION_TAG))
        mTabLayout.addTab(mTabLayout.newTab().setTag(ADMINISTRATION_TAG))

        mViewPager = findViewById(R.id.pager)
        mAdapter = MainContainerViewPager(applicationContext, supportFragmentManager, mTabLayout.tabCount)

        mViewPager.setAdapter(mAdapter)
        mViewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(mTabLayout))
        mTabLayout.setupWithViewPager(mViewPager)
        mTabLayout.setSelectedTabIndicatorColor(Color.WHITE)

        setTabText()

        mTabLayout.setOnTabSelectedListener(this)

        mSettingsButton.setOnClickListener(mSettingsListener)
    }

    private fun setTabText() {
        mTabLayout.getTabAt(0)!!.setText(resources.getString(R.string.pin_text))
        mTabLayout.getTabAt(1)!!.setText(resources.getString(R.string.recharges_text))
        mTabLayout.getTabAt(2)!!.setText(resources.getString(R.string.collection_text))
        mTabLayout.getTabAt(3)!!.setText(resources.getString(R.string.administration_text))
    }

    override fun onTabReselected(tab: TabLayout.Tab?) {

    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {

    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        mViewPager.currentItem = tab!!.position
        mTabLayout.setSelectedTabIndicatorColor(Color.WHITE)
    }

    private val mSettingsListener : View.OnClickListener = View.OnClickListener {
        goSettingsActivity()
    }

    private fun goSettingsActivity() {
        val intent = Intent(this, SettingsActivity::class.java)
        this.startActivity(intent)
    }

}