package com.computer.inu.readit_appjam.Activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import com.computer.inu.readit_appjam.Adapter.MainPagerAdapter
import com.computer.inu.readit_appjam.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var sharedText = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //공유하기 테스트 입니다.
        val intent = intent
        val action = intent.action
        val type = intent.type

// 인텐트 정보가 있는 경우 실행
        if (Intent.ACTION_SEND == action && type != null) {
            if ("text/plain" == type) {
                sharedText = intent.getStringExtra(Intent.EXTRA_TEXT)
                AlertDialog.Builder(this)
                    .setTitle("리딧")
                    .setMessage(sharedText)
                    .setPositiveButton(android.R.string.ok, null)
                    .setCancelable(false)
                    .create()
                    .show()
            }
        }
        //공유하기 테스트 끝

        configureMainTab()
    }

    private fun configureMainTab() {
        vp_main.adapter = MainPagerAdapter(supportFragmentManager, 2)
        vp_main.offscreenPageLimit = 2
        tl_main_categoty.setupWithViewPager(vp_main)

        val navCategoryMainLayout: View =
            (this.getSystemService(android.content.Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(
                R.layout.navaigation_category,
                null,
                false
            )
        tl_main_categoty.getTabAt(0)!!.customView =
            navCategoryMainLayout.findViewById(R.id.rl_category_main) as RelativeLayout
        tl_main_categoty.getTabAt(1)!!.customView =
            navCategoryMainLayout.findViewById(R.id.rl_category_mypage) as RelativeLayout
    }

}