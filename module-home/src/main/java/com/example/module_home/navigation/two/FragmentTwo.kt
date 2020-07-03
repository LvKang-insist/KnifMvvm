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
    override fun layout(): Int {
        return R.layout.frag_two
    }

    override fun bindView(rootView: View) {

        val adapter = RvAdapter()
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = adapter


        val queryUser = userDao.queryUser(10)

        XLog.e("${queryUser.id} --- ${queryUser.name} --${queryUser.age}")
//
//        //创建 DataSource.Factory
//        val factory = userDao.queryUser()
//
//        //2,通过 LivePageListBuild 配置工厂和 pageSize，对 users 进行实例化
//        val valus = LivePagedListBuilder(factory, 30).build().value
//        ToastUtils.show(valus?.size)
//        adapter.submitList(valus)


//        viewModel.user.observe(this, Observer {
//
//        })
//        viewModel.request()


//https://juejin.im/post/5db06bb6518825646d79070b#heading-23

//            for (i in 0..40) {
//                val save = userDao.save(User(i, "LvKang", 26))
//                XLog.e(save)
//            }

    }

}