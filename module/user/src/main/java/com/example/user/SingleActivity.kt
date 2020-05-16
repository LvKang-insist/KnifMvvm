package com.example.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.lv.library_core.base.single.BaseSingleActivity
import com.lv.module_user.UserFragment

class SingleActivity : BaseSingleActivity() {


    override fun setFragment(): Fragment {
        return UserFragment()
    }
}
