package com.example.module_home.navigation.two

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.elvishew.xlog.XLog
import com.example.library_core.storage.dao.UserDao
import com.example.module_home.R
import com.standalone.core.base.ui.frag.BaseLayoutFragment


class FragmentTwo : BaseLayoutFragment<FragTwoViewModel>() {


    override fun createViewModel(): Class<FragTwoViewModel>? = FragTwoViewModel::class.java

    override fun isImmersionBar(): Boolean {
        return true
    }


    override fun layout(): Int {
        return R.layout.frag_two
    }

    override fun bindView() {

        val adapter = RvAdapter()

    }

}