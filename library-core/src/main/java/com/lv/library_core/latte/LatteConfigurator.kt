package com.lv.library_core.latte

import android.widget.Toast
import com.elvishew.xlog.LogConfiguration
import com.elvishew.xlog.XLog
import com.hjq.toast.ToastUtils
import com.lv.library_core.net.ApiServices
import com.www.net.LvHttp
import com.www.net.error.ErrorKey
import com.www.net.error.ErrorValue
import com.xiaojinzi.component.Component
import com.xiaojinzi.component.Config
import com.xiaojinzi.component.impl.BuildConfig
import com.xiaojinzi.component.impl.application.ModuleManager

/**
 * @name LatteConfigurator
 * @package com.lv.library_core.latte
 * @author 345 QQ:1831712732
 * @time 2020/5/15 21:15
 * @description
 */
object LatteConfigurator {

    private val LATTE_CONFIG = LinkedHashMap<LatteConfigKeys, Any>()


    /**
     * 配置完成时调用
     */
    fun configure() {
        LATTE_CONFIG[LatteConfigKeys.CONFIG_READER] = true
    }


    /**
     * 初始化 Toast
     */
    fun withToastUtils(): LatteConfigurator {
        ToastUtils.init(Latte.getAppContext())
        return this
    }

    /**
     * 初始化 Log
     */
    fun withLog(): LatteConfigurator {
        XLog.init(
            LogConfiguration.Builder()
                .t() //允许打印线程信息
                .tag("345")
                .build()
        )
        return this
    }

    fun withComponent(): LatteConfigurator {
        Component.init(
            BuildConfig.DEBUG,
            Config.with(getConfigurator(LatteConfigKeys.APP_CONTEXT))
                // 使用内置的路由重复检查的拦截器, 如果为 true,
                // 那么当两个相同的路由发生在指定的时间内后一个路由就会被拦截
                .useRouteRepeatCheckInterceptor(true)
                // 1000 是默认的, 表示相同路由拦截的时间间隔
                .routeRepeatCheckDuration(1000)
                // 是否打印日志提醒你哪些路由使用了 Application 为 Context 进行跳转
                .tipWhenUseApplication(true)
                // 这里表示使用 ASM 字节码技术加载模块, 默认是 false
                // 如果是 true 请务必配套使用 Gradle 插件, 下一步就是可选的配置 Gradle 插件
                // 如果是 false 请直接略过下一步 Gradle 的配置
                .optimizeInit(true)
                // 自动加载所有模块, 打开此开关后下面无需手动注册了
                // 但是这个依赖 optimizeInit(true) 才会生效
                .autoRegisterModule(true)
                .build()
        )
        // 如果你依赖了 rx 版本,需要配置这句代码,否则删除这句
        // RxErrorIgnoreUtil.ignoreError();
        // 注册其他业务模块,注册的字符串是上面各个业务模块配置在 build.gradle 中的 HOST
        ModuleManager.getInstance()
            .registerArr("app", "main", "moduleHome", "moduleDiscover", "moduleSort", "moduleUser");
        // 自动加载所有模块, 此功能需要打开开关 optimizeInit(true).
        // 如果你同时也打开了开关 autoRegisterModule(true), 那么这句代码也可省略了, 因为初始化的时候自动帮你注册了
        // ModuleManager.getInstance().autoRegister(); // 1.7.9+
        // 你也可以让框架
        if (BuildConfig.DEBUG) {
            // 框架还带有检查重复的路由和重复的拦截器等功能,在 `debug` 的时候开启它
            ModuleManager.getInstance().check();
        }
        return this
    }

    fun withLvHttp(): LatteConfigurator {
        LvHttp.Builder()
            .setApplication(getConfigurator(LatteConfigKeys.APP_CONTEXT))
            .setBaseUrl("https://api.github.com/")
            //是否开启缓存
            .isCache(false)
            //是否打印 log
            .isLoging(true)
            //初始化请求接口
            .setService(ApiServices::class.java)
            //对 Code 异常的处理，可自定义,参考 ResponseData 类
            .setErrorDispose(ErrorKey.ErrorCode, ErrorValue {
                Toast.makeText(getConfigurator(LatteConfigKeys.APP_CONTEXT), "Code 错误", Toast.LENGTH_SHORT).show()
            })
            //全局异常处理，参考 Launch.kt ，可自定义异常处理，参考 ErrorKey 即可
            .setErrorDispose(ErrorKey.AllEexeption, ErrorValue {
                it.printStackTrace()
                Toast.makeText(getConfigurator(LatteConfigKeys.APP_CONTEXT), "网络错误", Toast.LENGTH_SHORT).show()
            })
            .build()
        return this
    }


    /**
     * @return 返回全部配置
     */
    fun getLatteConfigs(): LinkedHashMap<LatteConfigKeys, Any> {
        return LATTE_CONFIG
    }

    /**
     * 返回某一项配置
     */
    fun <T> getConfigurator(key: LatteConfigKeys): T {
        val o = LATTE_CONFIG[key] ?: throw NullPointerException(key.toString() + "is NULL")
        return o as T
    }

}