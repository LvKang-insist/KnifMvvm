package com.lv.admin.startup

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.startup.Initializer
import com.xiaojinzi.component.Component
import com.xiaojinzi.component.Config
import com.xiaojinzi.component.impl.BuildConfig
import com.xiaojinzi.component.impl.application.ModuleManager
import java.util.*

/**
 * @name ComponentInitializer
 * @package com.lv.admin
 * @author 345 QQ:1831712732
 * @time 2020/6/30 23:11
 * @description 初始化
 */

/**
 * 泛型T为待初始化的Sdk对外提供的对象类型
 */
class ComponentInitializer : Initializer<ComponentInit> {
    private val tag = "ComponentInitializer"

    /**
     * Sdk初始化逻辑写入的地方，
     * 其参数context为Application Context，同时需要返回一个Sdk对外提供的对象实例。
     */
    override fun create(context: Context): ComponentInit {
        ComponentInit.init(context.applicationContext as Application)
        return ComponentInit
    }

    /**
     * 该方法则需要返回一个列表，这个列表需要给出一个该Sdk依赖的其它Sdk的初始化器，
     * 也就是这个列表决定了哪些sdk会在这个sdk之前初始化，
     * 如果这个sdk是独立的没有依赖与其它的sdk，可以将该方法返回一个空列表，如当前
     */
    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return Collections.emptyList()
    }

}

object ComponentInit {

    private const val TAG = "ComponentInit"

    fun init(context: Application) {
        Component.init(
            BuildConfig.DEBUG,
            Config.with(context)
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
        Log.e(TAG, "init: 完成")
    }

}