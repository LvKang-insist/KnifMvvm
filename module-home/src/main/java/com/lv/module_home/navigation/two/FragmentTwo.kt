package com.lv.module_home.navigation.two

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.elvishew.xlog.XLog
import com.lv.module_home.R
import com.standalone.core.base.ui.frag.BaseLayoutFragment
import kotlinx.android.synthetic.main.frag_two.*

class FragmentTwo : BaseLayoutFragment<FragTwoViewModel>() {
    override fun createViewModel(): Class<FragTwoViewModel>? = FragTwoViewModel::class.java
    override fun layout(): Int {
        return R.layout.frag_two
    }

    override fun bindView(rootView: View) {
//        two.text = arguments?.getString("name")
        two.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.fragmentThree)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        XLog.e("FragmentTwo  onCreateView")
        return super.onCreateView(inflater, container, savedInstanceState)
    }


    override fun onDestroyView() {
        XLog.e("FragmentTwo onDestroyView")
        super.onDestroyView()
    }
}