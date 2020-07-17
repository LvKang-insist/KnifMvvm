package com.example.module_home.navigation.one

import android.animation.*
import android.graphics.Point
import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import com.example.module_home.*
import com.hjq.toast.ToastUtils
import com.standalone.core.base.ui.frag.BaseLayoutFragment
import com.standalone.core.ui.dp2px
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.frag_one.*
import javax.inject.Inject

@AndroidEntryPoint
class FragmentOne : BaseLayoutFragment<FragOneViewModel>() {

    override fun createViewModel(): Class<FragOneViewModel>? = FragOneViewModel::class.java

    override fun layout(): Int {
        return R.layout.frag_one
    }

    override fun bindView(rootView: View) {
        touch.setOnClickListener {
            ToastUtils.show("点击")
        }
    }
}


@RequiresApi(Build.VERSION_CODES.HONEYCOMB)
class PointEvaluator : TypeEvaluator<Point> {
    override fun evaluate(fraction: Float, startValue: Point, endValue: Point): Point {
        // 初始值 (1,1) ,最后值(5,5) ， 执行到 0.2 ，x = 1+(5-1)*0.2 y = 1+(5-1)*0.2
        val point = Point()
        point.x = (startValue.x + (endValue.x - startValue.x) * fraction).toInt()
        point.y = (startValue.y + (endValue.y - startValue.y) * fraction).toInt()
        return point
    }

}