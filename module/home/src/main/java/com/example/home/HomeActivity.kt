package com.example.home

import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import com.example.library_core.single.BaseSingleActivity
import com.example.module_home.HomeFragment
import java.util.concurrent.Executors

class HomeActivity : BaseSingleActivity() {

    override fun setFragment(): Fragment {
        return HomeFragment()
    }

}
