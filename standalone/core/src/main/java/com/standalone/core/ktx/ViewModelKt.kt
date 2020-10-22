@file:Suppress("UNCHECKED_CAST")

package com.standalone.core.ktx

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import com.standalone.core.latte.Latte
import java.lang.reflect.ParameterizedType

/**
 * @author 345 QQ:1831712732
 * @package : com.standalone.core.ktx
 * @time : 2020/10/6  18:49
 * @description :
 */


private  val appViewModelProvider  by lazy {
    ViewModelProvider(
        ViewModelStore(),
        ViewModelProvider.AndroidViewModelFactory.getInstance(Latte.getAppContext())
    )
}


/**
 * 获取当前类绑定的泛型 ViewMode
 */
fun <VM> getVmClazz(any: Any):VM{
    return (any.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as VM
}

/**
 * 获取指定类的 ViewModel
 */
fun <VM> getVmClazz(clazz: Class<*>):VM{
    return (clazz.genericSuperclass as ParameterizedType).actualTypeArguments[0] as VM
}