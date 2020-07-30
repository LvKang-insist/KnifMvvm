package com.example.module_home.navigation.one

import android.animation.*
import android.annotation.SuppressLint
import android.graphics.Point
import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.AppCompatTextView
import androidx.navigation.Navigation
import com.business.tools.views.page.ScrollerLayout
import com.example.module_home.*
import com.hjq.toast.ToastUtils
import com.standalone.core.base.ui.frag.BaseLayoutFragment
import com.standalone.core.ui.dp2px
import com.standalone.core.ui.view.text.PageAdapter
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
