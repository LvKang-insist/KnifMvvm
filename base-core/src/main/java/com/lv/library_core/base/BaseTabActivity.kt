package com.lv.library_core.base

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.standalone.main.bottom.base.KnifeMainTabItemActivity


/**
 * @author 345 QQ:1831712732
 * @package : com.example.library_core.base
 * @time : 2020/10/15  23:25
 * @description :应用层的 BaseTabActivity，可进行一些自定义操作
 */
abstract class BaseTabActivity<V : ViewDataBinding> : KnifeMainTabItemActivity<V>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //友盟应用数据统计接口
//        PushAgent.getInstance(this).onAppStart()
    }
}