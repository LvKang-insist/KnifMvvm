package com.lv.module_home.navigation.one

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.elvishew.xlog.XLog
import com.lv.module_home.HiltTest
import com.lv.module_home.R
import com.standalone.core.base.ui.frag.BaseLayoutFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.frag_one.*
import javax.inject.Inject

@AndroidEntryPoint
class FragmentOne : BaseLayoutFragment<FragOneViewModel>() {

    @Inject
    lateinit var hiltTest: HiltTest

    override fun createViewModel(): Class<FragOneViewModel>? = FragOneViewModel::class.java

    override fun layout(): Int {
        return R.layout.frag_one
    }

    override fun bindView(rootView: View) {

        one.text = hiltTest.hiltTest()

        one.setOnClickListener {
//            val bundle = Bundle()
//            bundle.putString("name", "345")
            Navigation.findNavController(rootView).navigate(R.id.fragmentThree)
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        XLog.e("FragmentOne  onCreateView")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onDestroyView() {
        XLog.e("FragmentOne onDestroyView")
        super.onDestroyView()
    }


}