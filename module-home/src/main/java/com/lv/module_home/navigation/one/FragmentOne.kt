package com.lv.module_home.navigation.one

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.elvishew.xlog.XLog
import com.hjq.toast.ToastUtils
import com.lv.module_home.*
import com.standalone.core.base.ui.frag.BaseLayoutFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.frag_one.*
import javax.inject.Inject

@AndroidEntryPoint
class FragmentOne : BaseLayoutFragment<FragOneViewModel>() {

    @A
    @Inject
    lateinit var userA: User

    @B
    @Inject
    lateinit var userB: User


    override fun createViewModel(): Class<FragOneViewModel>? = FragOneViewModel::class.java

    override fun layout(): Int {
        return R.layout.frag_one
    }

    override fun bindView(rootView: View) {

//        ToastUtils.show("${userA.getName()} -- ${userB.getName()}")

        one.setOnClickListener {
//            val bundle = Bundle()
//            bundle.putString("name", "345")
            Navigation.findNavController(rootView).navigate(R.id.fragmentThree)
        }
    }
}