package com.lv.admin.startup

import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.startup.Initializer
import com.lv.admin.Api
import com.www.net.LvHttp
import com.www.net.error.ErrorKey
import com.www.net.error.ErrorValue
import java.util.*

/**
 * @name LvHttpInitializer
 * @package com.lv.admin
 * @author 345 QQ:1831712732
 * @time 2020/6/30 23:27
 * @description 初始化 LvHttp
 */
class LvHttpInitializer : Initializer<LvHttpInit> {
    override fun create(context: Context): LvHttpInit {
        LvHttpInit.init(context.applicationContext as Application)
        return LvHttpInit
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return Collections.emptyList()
    }
}

object LvHttpInit {
    private const val TAG = "LvHttpInit"
    fun init(application: Application) {
        LvHttp.Builder()
            .setApplication(application)
            .setBaseUrl("https://api.github.com/")
            //是否开启缓存
            .isCache(false)
            .setService(Api::class.java)
            //是否打印 log
            .isLoging(true)
            //对 Code 异常的处理，可自定义,参考 ResponseData 类
            .setErrorDispose(ErrorKey.ErrorCode, ErrorValue {
                Toast.makeText(application, "Code 错误", Toast.LENGTH_SHORT).show()
            })
            //全局异常处理，参考 Launch.kt ，可自定义异常处理，参考 ErrorKey 即可
            .setErrorDispose(ErrorKey.AllEexeption, ErrorValue {
                it.printStackTrace()
                Toast.makeText(application, "网络错误", Toast.LENGTH_SHORT).show()
            })
            .build()
        Log.e(TAG, "init: 完成")
    }

}