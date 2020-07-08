package com.example.module_home.navigation.one

import android.animation.*
import android.graphics.Point
import android.view.View
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

//        ToastUtils.show("${userA.getName()} -- ${userB.getName()}")

        one.setOnClickListener {
////            val bundle = Bundle()
////            bundle.putString("name", "345")
//            ToastUtils.show("动")
//            Navigation.findNavController(rootView).navigate(R.id.fragmentThree)

            /* val length = dp2px(400f)
             val keyframe1 = Keyframe.ofFloat(0f, 0f * length)
             val keyframe2 = Keyframe.ofFloat(0.2f, 0.8f * length)
             val keyframe3 = Keyframe.ofFloat(0.8f, 1.3f * length)
             val keyframe4 = Keyframe.ofFloat(1f, 1f * length)

             val holder = PropertyValuesHolder.ofKeyframe(
                 "translationY",
                 keyframe1,
                 keyframe2,
                 keyframe3,
                 keyframe4
             )
             val animator = ObjectAnimator.ofPropertyValuesHolder(one, holder)
             animator.setDuration(2000)
                 .start()*/

//             val anim = ObjectAnimator
//                 .ofFloat(sport, "ScrollPos", 0f, 270f, 360f)
//                 .setDuration(1000)
//             val proAnim = ObjectAnimator
//                 .ofInt(sport, "Process", 0, 100)
//                 .setDuration(1000)
//
//             val animSet = AnimatorSet()
//             animSet.playTogether(anim, proAnim)
//             animSet.start()


//            val bottomFlip = ObjectAnimator
//                .ofFloat(custom, "bottomFlip", 0f, 45f)
//            val rotation = ObjectAnimator
//                .ofFloat(custom, "flipRotation", 0f, 270f)
//
//            val topFlip = ObjectAnimator
//                .ofFloat(custom, "topFlip", 0f, -45f)
//
//            val animatorSet = AnimatorSet()
//            animatorSet.duration = 2000
//            animatorSet.playSequentially(bottomFlip, rotation, topFlip)
//            animatorSet.start()

//            val targetPoint = Point(100, 100)
//
//            val animator = ObjectAnimator.ofObject(point, "point", PointEvaluator(), targetPoint)
//            animator.duration = 2000
//            animator.start()


        }
    }
}



class PointEvaluator : TypeEvaluator<Point> {
    override fun evaluate(fraction: Float, startValue: Point, endValue: Point): Point {
        // 初始值 (1,1) ,最后值(5,5) ， 执行到 0.2 ，x = 1+(5-1)*0.2 y = 1+(5-1)*0.2
        val point = Point()
        point.x = (startValue.x + (endValue.x - startValue.x) * fraction).toInt()
        point.y = (startValue.y + (endValue.y - startValue.y) * fraction).toInt()
        return point
    }

}