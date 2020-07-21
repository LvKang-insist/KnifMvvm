package com.standalone.core.ui.camera

import android.annotation.SuppressLint
import android.content.ContentResolver
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.media.MediaScannerConnection
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.webkit.MimeTypeMap
import java.io.*
import java.text.SimpleDateFormat
import java.util.*

/**
 * @author 345 QQ:1831712732
 * @name Android Business Tools
 * @class name：com.business.tools.file_utils
 * @time 2019/12/11 23:04
 * @description 文件工具类
 */
@Suppress(
    "DEPRECATION", "RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS",
    "NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS"
)
object FileUtils {
    /**
     * 获取文件的 MIME
     *
     * @param filePath 文件路径
     * @return MIME
     */
    fun getMimeType(filePath: String?): String? {
        val extension =
            getExtension(filePath)
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension)
    }


    /**
     * 格式化模板
     */
    private const val TIME_FORMAT = "_yyyyMMdd_HHmmss"


    private val SDCARD_DIR: String = Environment.getExternalStorageDirectory().path

    /**
     * 默认本地上传目录
     */
    val UPLOAD_PHOTO_DIR =
        Environment.getExternalStorageDirectory().path + "/a_upload_photos/"

    /**
     * 网页缓存地址
     */
    val WEB_CACHE_DIR =
        Environment.getExternalStorageDirectory().parent + "app_web_cache"

    /**
     * 系统相机目录
     */
    val CAMERA_PHOTO_DIR: String =
        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).parent
    const val DirName = "EasyToolss"
    private fun getTimeFormatName(timeFormatHeader: String): String {
        val date = Date(System.currentTimeMillis())
        //必须加上 单引号
        @SuppressLint("SimpleDateFormat") val dateFormat =
            SimpleDateFormat("'$timeFormatHeader'$TIME_FORMAT")
        return dateFormat.format(date)
    }

    /**
     * @param timeFormatHeader 格式化的头（除去时间部分）
     * @param extension        后缀名
     * @return 返回时间格式化后的文件名
     */
    private fun getFileNameByTime(
        timeFormatHeader: String,
        extension: String
    ): String {
        return getTimeFormatName(
            timeFormatHeader
        ) + "." + extension
    }

    private fun createDir(sdcarDirName: String): File {
        //拼接成 SD 卡中完整的dir
        val dir =
            "$SDCARD_DIR/$sdcarDirName/"
        val fileDir = File(dir)
        if (!fileDir.exists()) {
            fileDir.mkdir()
        }
        return fileDir
    }

    private fun createFile(sdcardDirName: String, fileName: String?): File {
        return File(
            createDir(
                sdcardDirName
            ), fileName
        )
    }

    /**
     * 根据时间来创建 相应的文件
     *
     * @param sdcardDirName    文件路径
     * @param timeFormatHeader 格式化的头（除去时间部分）
     * @param extension        后缀名
     * @return file
     */
    private fun createFileByTime(
        sdcardDirName: String,
        timeFormatHeader: String,
        extension: String
    ): File {
        val fileName =
            getFileNameByTime(
                timeFormatHeader,
                extension
            )
        return createFile(
            sdcardDirName,
            fileName
        )
    }

    /**
     * 获取文件的后缀名
     *
     * @param filePath 文件路径
     * @return 后缀名
     */
    private fun getExtension(filePath: String?): String {
        var suffix = ""
        val file = File(filePath)
        val name = file.name
        val idx = name.lastIndexOf(".")
        if (idx > 0) {
            suffix = name.substring(idx + 1)
        }
        return suffix
    }

    /**
     * @param mBitmap  Bitmap
     * @param dir      目录名，只需要写自己的相对目录名即可
     * @param compress 压缩比例，100是不压缩，值越小压缩率 越高
     * @return 返回该文件
     */
    fun saveBitmap(mBitmap: Bitmap, dir: String, compress: Int): File? {
        val sdStatus = Environment.getExternalStorageState()
        //检测sd是否可用
        if (sdStatus != Environment.MEDIA_MOUNTED) {
            return null
        }
        var fos: FileOutputStream? = null
        var bos: BufferedOutputStream? = null
        val fileName =
            createFileByTime(
                dir,
                "DOWN_LOAD",
                "jpg"
            )
        try {
            fos = FileOutputStream(fileName)
            bos = BufferedOutputStream(fos)

            //把数据写入到文件
            mBitmap.compress(Bitmap.CompressFormat.JPEG, compress, bos)
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } finally {
            try {
                bos?.flush()
                bos?.close()
                //关闭流
                fos?.flush()
                fos?.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return fileName
    }

    fun writeToDisk(
        `is`: InputStream,
        dir: String,
        name: String?
    ): File {
        val file =
            createFile(dir, name)
        var bis: BufferedInputStream? = null
        var fos: FileOutputStream? = null
        var bos: BufferedOutputStream? = null
        try {
            bis = BufferedInputStream(`is`)
            fos = FileOutputStream(file)
            bos = BufferedOutputStream(fos)
            val data = ByteArray(1024 * 4)
            var count: Int
            while (bis.read(data).also { count = it } != -1) {
                bos.write(data, 0, count)
            }
            bos.flush()
            fos.flush()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            try {
                bos?.close()
                fos?.close()
                bis?.close()
                `is`.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return file
    }

    fun writeToDisk(
        `is`: InputStream,
        dir: String,
        prefix: String,
        extension: String
    ): File {
        val file =
            createFileByTime(
                dir,
                prefix,
                extension
            )
        var bis: BufferedInputStream? = null
        var fos: FileOutputStream? = null
        var bos: BufferedOutputStream? = null
        try {
            bis = BufferedInputStream(`is`)
            fos = FileOutputStream(file)
            bos = BufferedOutputStream(fos)
            val data = ByteArray(1024 * 4)
            var count: Int
            while (bis.read(data).also { count = it } != -1) {
                bos.write(data, 0, count)
            }
            bos.flush()
            fos.flush()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            try {
                bos?.close()
                fos?.close()
                bis?.close()
                `is`.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return file
    }

    /**
     * 通知系统刷新系统相册，是照片展示出来
     */
    private fun refreshDCIM(context: Context) {
        if (Build.VERSION.SDK_INT >= 19) {
            //兼容android 4.4 版本，只扫描存放照面的目录
            MediaScannerConnection.scanFile(
                context, arrayOf(
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM)
                        .path
                ), null, null
            )
        } else {
            //扫明真个SD卡 来更新系统图库，当文件很多时，用户体验不佳，而不适合4.4以上版本
            context.sendBroadcast(
                Intent(
                    Intent.ACTION_MEDIA_MOUNTED,
                    Uri.parse("file://" + Environment.getExternalStorageDirectory())
                )
            )
        }
    }

    /**
     * 读取 raw目录中的文件，并返回为字符串
     */
    fun getRawFile(id: Int, context: Context): String {
        val `is` = context.resources.openRawResource(id)
        val bis = BufferedInputStream(`is`)
        val isr = InputStreamReader(bis)
        val br = BufferedReader(isr)
        val stringBuilder = StringBuilder()
        var str: String?
        try {
            while (br.readLine().also { str = it } != null) {
                stringBuilder.append(str)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            try {
                br.close()
                isr.close()
                bis.close()
                `is`.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return stringBuilder.toString()
    }

    /**
     * 读取assets 目录下的文件，并返回字符串
     */
    fun getAssetsFile(name: String?, context: Context): String? {
        var `is`: InputStream? = null
        var bis: BufferedInputStream? = null
        var isr: InputStreamReader? = null
        var br: BufferedReader? = null
        var stringBuilder: StringBuilder? = null
        val assetManager = context.assets
        try {
            `is` = assetManager.open(name!!)
            bis = BufferedInputStream(`is`)
            isr = InputStreamReader(bis)
            br = BufferedReader(isr)
            stringBuilder = StringBuilder()
            var str: String?
            while (br.readLine().also { str = it } != null) {
                stringBuilder.append(str)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            try {
                br?.close()
                isr?.close()
                bis?.close()
                `is`?.close()
                assetManager.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return stringBuilder?.toString()
    }

    /**
     * 这个方法是吧Uri 转换成真实路径，也就是photo的path
     */
    fun getRealFilePath(
        context: Context,
        uri: Uri?
    ): String? {
        if (uri == null) {
            return null
        }
        val scheme = uri.scheme
        var date: String? = null
        if (scheme == null) {
            date = uri.path
        } else if (ContentResolver.SCHEME_FILE == scheme) {
            date = uri.path
        } else if (ContentResolver.SCHEME_CONTENT == scheme) {
            //从内容提供器中 查询数据
            val cursor = context.contentResolver.query(
                uri, arrayOf(
                    MediaStore.Images.ImageColumns.DATA
                ), null, null, null
            )
            if (cursor != null) {
                if (cursor.moveToNext()) {
                    val index = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA)
                    if (index > -1) {
                        date = cursor.getString(index)
                    }
                }
                cursor.close()
            }
        }
        return date
    }

}