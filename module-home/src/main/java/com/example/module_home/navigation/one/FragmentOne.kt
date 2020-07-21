package com.example.module_home.navigation.one

import android.animation.*
import android.graphics.Point
import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.navigation.Navigation
import com.example.module_home.*
import com.hjq.toast.ToastUtils
import com.standalone.core.base.ui.frag.BaseLayoutFragment
import com.standalone.core.ui.dp2px
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.frag_one.*
import javax.inject.Inject

@AndroidEntryPoint
class FragmentOne : BaseLayoutFragment<FragOneViewModel>() {

    override fun createViewModel(): Class<FragOneViewModel>? = FragOneViewModel::class.java


    override fun layout(): Int {
        return R.layout.frag_one
    }


    override fun bindView() {
        one.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.fragmentThree)
        }
    }
}
