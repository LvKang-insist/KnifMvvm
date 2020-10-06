package com.example.module_home

import android.content.Intent
import android.graphics.Paint
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.elvishew.xlog.XLog
import com.hjq.toast.ToastUtils
import com.standalone.core.base.ui.frag.BaseBindingFragment
import com.example.module_home.databinding.HomeFragBinding
import com.example.module_home.databinding.HomeFragBindingImpl
import com.example.module_home.navigation.HomeContentActivity
import com.example.module_home.navigation.one.FragOneViewModel
import com.standalone.core.base.viewmodel.MainViewModel
import com.standalone.core.ktx.getVmClazz
import com.standalone.core.ui.EventMessage
import com.standalone.core.ui.view.text.PageAdapter
import com.standalone.core.utils.DataBindingConfig
import com.xiaojinzi.component.anno.FragmentAnno
import kotlinx.android.synthetic.main.home_frag.*


/**
 * @name HomeFragment
 * @package com.lv.module_home
 * @author 345 QQ:1831712732
 * @time 2020/5/12 21:51
 * @description
 */

@FragmentAnno("HomeFragment")
class HomeFragment : BaseBindingFragment<HomeFragBindingImpl>() {


    val homeViewModel by viewModels<HomeViewModel>()

    override fun isImmersionBar(): Boolean  = true

    override fun isBarDark(): Boolean  = true


    override fun setDataBindingConfig(): DataBindingConfig {
        return DataBindingConfig(R.layout.home_frag)
            .addParams(BR.data, "点击")
            .addParams(BR.vm, homeViewModel)
    }

    override fun bindView() {
        lifecycle.addObserver(homeViewModel)
        home.setOnClickListener {
            /*  //深层链接，利用 uri 直接跳转到 FragmentThree 中
               val intent = Intent(ACTION_VIEW)
              intent.data = "home://www/frag3".toUri()*/
            startActivity(Intent(requireActivity(), HomeContentActivity::class.java))
        }

        homeViewModel.loginObserver.observe(this, Observer {
            ToastUtils.show(it)
            binding.data = it
        })

        scroll.adapter = ScrollAdapter()
    }

    override fun onEventMessage(event: EventMessage) {
        if (event.type == EventMessage.Type.CLICK_HOME){
            XLog.e("home")
        }
    }


    class ScrollAdapter : PageAdapter(R.layout.sort_rv_item) {
        override fun count(): Int {
            return 10
        }

        override fun view(view: View, position: Int) {
            val tv:AppCompatTextView = view as AppCompatTextView

            tv.text = "$position"
        }
    }

}