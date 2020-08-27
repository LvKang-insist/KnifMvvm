package com.example.module_home.navigation.three

import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.module_home.R
import com.standalone.core.base.ui.frag.BaseLayoutFragment
import kotlinx.android.synthetic.main.frag_three.*

class FragmentThree : BaseLayoutFragment() {

    val vm by viewModels<FragThreeViewModel>()


    override fun isImmersionBar(): Boolean {
        return true
    }

    override fun isDark(): Boolean {
        return false
    }

    override fun layout(): Int {
        return R.layout.frag_three
    }

    override fun bindView() {
        three.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.fragmentTwo)
        }
    }

}