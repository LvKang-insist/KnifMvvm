package com.standalone.core.ui.camera

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.view.Gravity
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.content.FileProvider
import com.standalone.core.R
import com.standalone.core.ui.dialog.base.FastDialog
import java.io.File

/**
 * @author 345 QQ:1831712732
 * @name Android Business Toos
 * @class name：com.fengtong.core.ui.camera
 * @time 2019/12/11 23:18
 * @description
 */
class CameraHandler internal constructor(private val activity: Activity) : View.OnClickListener {


    private var mFastDialog: FastDialog = FastDialog.Builder(activity)
        .setWidth(LinearLayoutCompat.LayoutParams.MATCH_PARENT)
        .setContentView(R.layout.dialog_camera_panel)
        .setGravity(Gravity.BOTTOM)
        .addDefaultAnimation()
        .build()

    fun beginCameraDialog() {
        mFastDialog.show()
        mFastDialog.getView<View>(R.id.photodialog_btn_cancel)?.setOnClickListener(this)
        mFastDialog.getView<View>(R.id.photodialog_btn_native)?.setOnClickListener(this)
        mFastDialog.getView<View>(R.id.photodialog_btn_take)?.setOnClickListener(this)
    }

    /**
     * 打开相机
     */
    private fun takePhoto() {
        //获取一个 名字,
        val currentPhotoName =
            "CaiFu" + System.currentTimeMillis() + ".png"
        //拍照意图
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        val uri: Uri

        //兼容10.0
        uri = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            FileQUtils.saveImageWithAndroidQ(
                activity,
                currentPhotoName,
                "CaiFu"
            )
        } else {
            // 注意7.0及以上与之前获取的uri不一样了，返回的是provider路径，需在清单中注册
            //创建一个文件，路径为系统相册，第二个参数为名字
            val tempFile = File(
                FileUtils.CAMERA_PHOTO_DIR,
                currentPhotoName
            )
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                FileProvider.getUriForFile(
                    activity,
                    "com.standalone.core.provider", tempFile
                )
            } else {
                Uri.fromFile(tempFile)
            }
        }
        CameraImageBean.mUri = uri
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri)
        activity.startActivityForResult(intent, RequestCode.TAKE_PHOTO)
        mFastDialog.cancel()
    }

    /**
     * 打开 选择图片
     */
    private fun pickPhoto() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        //打开相册
        activity.startActivityForResult(intent, RequestCode.PICK_PHOTO)
        mFastDialog.cancel()
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    override fun onClick(v: View) {
        when (v.id) {
            R.id.photodialog_btn_take -> {
                takePhoto()
            }
            R.id.photodialog_btn_native -> {
                pickPhoto()
            }
            R.id.photodialog_btn_cancel -> {
                mFastDialog.cancel()
            }
        }
    }


}