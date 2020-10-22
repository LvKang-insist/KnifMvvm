package com.lv.library_core.single

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.standalone.core.R

abstract class BaseSingleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout, setFragment())
            .commit()
    }
    abstract fun setFragment(): Fragment
}