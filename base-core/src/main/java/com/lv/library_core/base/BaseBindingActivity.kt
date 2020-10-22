package com.lv.library_core.base

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.standalone.core.base.ui.activity.KnifeBindingActivity

/**
 * @author 345 QQ:1831712732
 * @package : com.example.library_core.base
 * @time : 2020/10/15  23:11
 * @description : 应用层的 BaseBindingActivity，可进行一些自定义操作
 */

abstract class BaseBindingActivity<V : ViewDataBinding> : KnifeBindingActivity<V>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //友盟应用数据统计接口
//        PushAgent.getInstance(this).onAppStart()
    }
}