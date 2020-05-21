package com.lv.module_sort

import android.view.View
import com.hjq.toast.ToastUtils
import com.lv.library_core.base.ui.frag.BaseLayoutFragment
import com.tencent.rtmp.TXLivePushConfig
import com.tencent.rtmp.TXLivePusher
import com.xiaojinzi.component.anno.FragmentAnno
import kotlinx.android.synthetic.main.sort_frag.*


/**
 * @name HomeFragment
 * @package com.lv.module_home
 * @author 345 QQ:1831712732
 * @time 2020/5/12 21:51
 * @description
 */

@FragmentAnno("sort-fragment")
class SortFragment : BaseLayoutFragment<SortViewModel>() {

    override fun setViewModel(): Class<SortViewModel> = SortViewModel::class.java

    override fun layout(): Int {
        return R.layout.sort_frag
    }

    override fun bindView(rootView: View) {



        //关闭时调用
//        txLivePusher.stopPusher();
//        txLivePusher.stopCameraPreview(true); //如果已经启动了摄像头预览，请在结束推流时将其关闭。

    }


}