package com.example.module_home.navigation.two

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.elvishew.xlog.XLog
import com.example.library_core.storage.dao.UserDao
import com.example.module_home.R
import com.standalone.core.base.ui.frag.BaseLayoutFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.frag_two.*
import javax.inject.Inject

@AndroidEntryPoint
class FragmentTwo : BaseLayoutFragment<FragTwoViewModel>() {

    @Inject
    lateinit var userDao: UserDao

    override fun createViewModel(): Class<FragTwoViewModel>? = FragTwoViewModel::class.java

    override fun isImmersionBar(): Boolean {
        return true
    }


    override fun layout(): Int {
        return R.layout.frag_two
    }

    override fun bindView() {

        val adapter = RvAdapter()
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = adapter



    }

}