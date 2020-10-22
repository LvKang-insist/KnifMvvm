package com.example.base_main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.base_main.main.MainActivity
import com.lv.library_core.base.BaseLayoutActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * @name LaunchActivity
 * @package com.example.base_main.activity
 * @author 345 QQ:1831712732
 * @time 2020/7/6 21:07
 * @description
 */
class LaunchActivity : BaseLayoutActivity() {
    override fun layout() = R.layout.activity_launch

    override fun bindView() {
        lifecycleScope.launch {
            delay(3000)
            launch(Dispatchers.Main) {
                startActivity(Intent(this@LaunchActivity, MainActivity::class.java))
            }
        }
    }
}