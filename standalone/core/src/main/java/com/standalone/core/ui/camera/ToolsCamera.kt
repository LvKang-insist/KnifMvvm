package com.standalone.core.ui.camera

import android.app.Activity

/**
 * @author 345 QQ:1831712732
 * @name Android Business Toos
 * @class name：com.business.toos.camera
 * @time 2019/12/11 23:14
 * @description
 */
object ToolsCamera {
    fun start(activity: Activity?) {
        CameraHandler(activity!!).beginCameraDialog()
    }
}