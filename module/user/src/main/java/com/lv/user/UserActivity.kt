package com.lv.user

import androidx.fragment.app.Fragment
import com.lv.library_core.single.BaseSingleActivity
import com.lv.module_user.UserFragment

class UserActivity : BaseSingleActivity() {


    override fun setFragment(): Fragment {
        return UserFragment()
    }
}
