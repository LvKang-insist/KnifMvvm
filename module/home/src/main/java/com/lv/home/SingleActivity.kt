package com.lv.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lv.module_home.HomeFragment
import kotlinx.android.synthetic.main.activity_single.*

class SingleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single)



        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout, HomeFragment())
            .commit()

    }
}
