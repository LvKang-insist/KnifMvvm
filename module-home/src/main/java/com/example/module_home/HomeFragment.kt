package com.example.module_home

import android.content.Intent
import android.view.View
import androidx.lifecycle.Observer
import com.hjq.toast.ToastUtils
import com.standalone.core.base.ui.frag.BaseBindingFragment
import com.example.module_home.databinding.HomeFragBinding
import com.example.module_home.navigation.HomeContentActivity
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
//@EntryPoint
//@AndroidEntryPoint
class HomeFragment : BaseBindingFragment<HomeFragBinding,HomeViewModel>() {

//    @Inject
//    lateinit var hiltTest: HiltTest

//    val mViewModel by viewModels<HomeViewModel>()

    override fun createViewModel(): Class<HomeViewModel>? = HomeViewModel::class.java

    override fun layout(): Int {
        return R.layout.home_frag
    }


    override fun bindView(rootView: View) {

//        home.text = hiltTest.hiltTest()
//
        home.setOnClickListener {
            /*  //深层链接，利用 uri 直接跳转到 FragmentThree 中
               val intent = Intent(ACTION_VIEW)
              intent.data = "home://www/frag3".toUri()*/
            startActivity(Intent(context, HomeContentActivity::class.java))
//            Navigation.findNavController(rootView).navigate(Uri.parse("home://frag3"))
        }


        request.setOnClickListener {
            viewModel.login()
        }
        viewModel.loginLiveData.observe(this, Observer {
            ToastUtils.show(it)
            binding.data = it
        })
    }

}