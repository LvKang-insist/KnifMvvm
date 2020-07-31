package com.example.module_home.navigation.one

import android.annotation.SuppressLint
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.navigation.Navigation
import com.example.module_home.*
import com.standalone.core.base.ui.frag.BaseLayoutFragment
import com.standalone.core.ui.view.text.PageAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.frag_one.*

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

//        scroll.adapter = ScrollAdapter(R.layout.layout)
    }

    class ScrollAdapter(layoutRes: Int) : PageAdapter(layoutRes) {
        override fun count(): Int {
            return 50
        }

        @SuppressLint("SetTextI18n")
        override fun view(view: View, position: Int) {
            val textView = view as AppCompatTextView;
            textView.text = "---- $position"
        }

    }
}
