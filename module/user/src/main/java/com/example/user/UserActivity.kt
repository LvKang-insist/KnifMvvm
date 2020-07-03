package com.example.user

import androidx.fragment.app.Fragment
import com.example.library_core.single.BaseSingleActivity
import com.example.module_user.UserFragment

class UserActivity : BaseSingleActivity() {


    override fun setFragment(): Fragment {
        return UserFragment()
    }
}
