package com.lv.admin

import android.app.Application
import android.util.Log
import com.elvishew.xlog.XLog
import com.umeng.commonsdk.UMConfigure
import com.umeng.message.IUmengRegisterCallback
import com.umeng.message.PushAgent
import org.android.agoo.xiaomi.MiPushRegistar


/**
 * @name BaseApplication
 * @class name：com.lv.admin
 * @author 345 QQ:1831712732
 * @time 2020/5/7 22:53
 * @description
 */
class BaseApplication : Application() {

//    应用名称：Kinfe
//    平台：Android
//    Appkey：5f884d2280455950e4ab7012
//    SDK下载地址：https://developer.umeng.com/sdk

    override fun onCreate() {
        super.onCreate()
        // 参数一：当前上下文context； 参数二：应用申请的Appkey（需替换）； 参数三：渠道名称；
        // 参数四：设备类型，必须参数，传参数为UMConfigure.DEVICE_TYPE_PHONE则表示手机；传参数为UMConfigure.DEVICE_TYPE_BOX则表示盒子；默认为手机；
        // 参数五：Push推送业务的secret 填充Umeng Message Secret对应信息（需替换）
        UMConfigure.init(
            this, "5f884d2280455950e4ab7012", "Knife",
            UMConfigure.DEVICE_TYPE_PHONE, "2be6ceabc2891fbb713a62e482c1656a"
        )

        //获取消息推送代理示例
        val mPushAgent = PushAgent.getInstance(this)
        mPushAgent.resourcePackageName = "com.example.admin"
        //注册推送服务，每次调用register方法都会回调该接口
        mPushAgent.register(object : IUmengRegisterCallback {
            override fun onSuccess(deviceToken: String) {
                //注册成功会返回deviceToken deviceToken是推送消息的唯一标志
                Log.e("UM_PUSH", "onSuccess：deviceToken：-------->  $deviceToken")
            }

            override fun onFailure(s: String, s1: String) {
                XLog.e("UM_PUSH", " onFailure：-------->  s:$s,s1:$s1")
            }
        })


        MiPushRegistar.register(this, "2882303761518733918", "5731873374918")
    }
}