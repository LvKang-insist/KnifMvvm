package com.lv.module_discover

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.elvishew.xlog.XLog
import com.hjq.toast.ToastUtils
import com.lv.library_core.base.ui.frag.BaseBindingFragment
import com.lv.module_discover.databinding.DiscoverFragBinding
import com.tencent.rtmp.TXLivePlayer
import com.tencent.rtmp.TXLivePushConfig
import com.tencent.rtmp.TXLivePusher
import com.xiaojinzi.component.anno.FragmentAnno
import kotlinx.android.synthetic.main.discover_frag.*

/**
 * @name HomeFragment
 * @package com.lv.module_home
 * @author 345 QQ:1831712732
 * @time 2020/5/12 21:51
 * @description
 */

@FragmentAnno("discover-fragment")
class DiscoverFragment : BaseBindingFragment<DiscoverFragBinding, DiscoverViewModel>() {

    override fun setViewModel(): Class<DiscoverViewModel> = DiscoverViewModel::class.java

    override fun layout(): Int {
        return R.layout.discover_frag
    }

    override fun bindView(rootView: View) {
        val mLivePushConfig = TXLivePushConfig()

        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.image)

        mLivePushConfig.setPauseImg(bitmap)
        val mLivePusher = TXLivePusher(context)

        // 一般情况下不需要修改 config 的默认配置
        mLivePusher.config = mLivePushConfig
        mLivePusher.setBeautyFilter(2, 9, 9, 9)
        //启用本地摄像头预览
        mLivePusher.startCameraPreview(pusher_tx_cloud_view)
        mLivePusher.setRenderRotation(2)
        //开启直播
        start_pull.setOnClickListener {
            permission({
                //推流地址
                val rtmpURL =
                    "rtmp://98744.livepush.myqcloud.com/live/lvkang?txSecret=b3d425c2928a3914531137cc5a05a14a&txTime=5EC6A57F"

                val ret = mLivePusher.startPusher(rtmpURL.trim { it <= ' ' })
                if (ret == -5) {
                    ToastUtils.show("startRTMPPush: license 校验失败")
                }
            }, android.Manifest.permission.CAMERA)
        }
        //结束直播
        stop_pull.setOnClickListener {
            mLivePusher.stopPusher()
            //如果已经启动了摄像头预览，请在结束推流时将其关闭。
            mLivePusher.stopCameraPreview(true);
        }


        val mLivePlayer = TXLivePlayer(context)
        mLivePlayer.setPlayerView(video_view)
        //播放
        start_video.setOnClickListener {
            val flvUrl = "https://98744.livepush.myqcloud.com/KnifMvvm/live.flv"
            mLivePlayer.startPlay(flvUrl, TXLivePlayer.PLAY_TYPE_LIVE_FLV) //推荐 FLV
        }

        stop_video.setOnClickListener {
            // 暂停
            mLivePlayer.pause();
        }
    }


}