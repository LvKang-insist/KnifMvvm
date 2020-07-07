package com.example.module_home.navigation.one

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.view.View
import com.example.module_home.*
import com.hjq.toast.ToastUtils
import com.standalone.core.base.ui.frag.BaseLayoutFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.frag_one.*
import javax.inject.Inject

@AndroidEntryPoint
class FragmentOne : BaseLayoutFragment<FragOneViewModel>() {

    @A
    @Inject
    lateinit var userA: User

    @B
    @Inject
    lateinit var userB: User


    override fun createViewModel(): Class<FragOneViewModel>? = FragOneViewModel::class.java

    override fun layout(): Int {
        return R.layout.frag_one
    }

    override fun bindView(rootView: View) {

//        ToastUtils.show("${userA.getName()} -- ${userB.getName()}")

        one.setOnClickListener {
////            val bundle = Bundle()
////            bundle.putString("name", "345")
            ToastUtils.show("动")
//            Navigation.findNavController(rootView).navigate(R.id.fragmentThree)
            /*
             one.animate()
                 .translationY(dp2px(80f))
                 .setStartDelay(1000)
                 .start()*/


            /* val anim = ObjectAnimator
                 .ofFloat(sport, "ScrollPos", 0f, 270f, 360f)
                 .setDuration(1000)
             val proAnim = ObjectAnimator
                 .ofInt(sport, "Process", 0, 100)
                 .setDuration(1000)

             val animSet = AnimatorSet()
             animSet.playTogether(anim, proAnim)
             animSet.start()*/


            val bottomFlip = ObjectAnimator
                .ofFloat(custom, "bottomFlip", 0f, 45f)
            val rotation = ObjectAnimator
                .ofFloat(custom, "flipRotation", 0f, 270f)

            val topFlip = ObjectAnimator
                .ofFloat(custom, "topFlip", 0f, -45f)

            val animatorSet = AnimatorSet()
            animatorSet.duration = 2000
            animatorSet.playSequentially(bottomFlip, rotation, topFlip)
            animatorSet.start()




            bottomFlip.addListener(object : Animator.AnimatorListener {
                override fun onAnimationRepeat(animation: Animator?) {

                }

                override fun onAnimationEnd(animation: Animator?) {
                    val set = AnimatorSet()

//                    val bottom = ObjectAnimator
//                        .ofFloat(custom, "bottomFlip", 90f, 0f)
//
//                    val ro = ObjectAnimator
//                        .ofFloat(custom, "flipRotation", 0f, 45f)
//                    val top = ObjectAnimator
//                        .ofFloat(custom, "topFlip", 0f, -90f, 0f)
//                        .setDuration(1500)
//                    set.duration = 2000
//                    set.playTogether( ro, top)
//                    set.start()
                }

                override fun onAnimationCancel(animation: Animator?) {

                }

                override fun onAnimationStart(animation: Animator?) {

                }

            })


        }
    }
}