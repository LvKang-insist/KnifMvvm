package com.example.module_home.navigation.one

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.view.View
import androidx.navigation.Navigation
import com.example.module_home.*
import com.hjq.toast.ToastUtils
import com.standalone.core.base.ui.frag.BaseLayoutFragment
import com.standalone.core.ui.dp2px
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
                .ofFloat(custom,"topFlip",0f,90f)
                .setDuration(1500)
                .start()
            val topFlip = ObjectAnimator
                .ofFloat(custom,"bottomFlip",45f)
            val Rotation = ObjectAnimator
                .ofFloat(custom,"flipRotation",45f)

        }
    }
}