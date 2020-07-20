package com.example.module_home.navigation.three

import android.view.View
import androidx.navigation.Navigation
import com.example.module_home.R
import com.standalone.core.base.ui.frag.BaseLayoutFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.frag_three.*

@AndroidEntryPoint
class FragmentThree : BaseLayoutFragment<FragThreeViewModel>() {
    override fun createViewModel(): Class<FragThreeViewModel>? = FragThreeViewModel::class.java

    override fun layout(): Int {
        return R.layout.frag_three
    }

    override fun bindView() {
        three.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.fragmentTwo)
        }
    }

}