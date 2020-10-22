package com.lv.module_home.navigation.three

import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.lv.module_home.R
import com.standalone.core.base.ui.frag.KnifeLayoutFragment
import kotlinx.android.synthetic.main.frag_three.*

class FragmentThree : KnifeLayoutFragment() {

    val vm by viewModels<FragThreeViewModel>()


    override fun isImmersionBar(): Boolean {
        return true
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