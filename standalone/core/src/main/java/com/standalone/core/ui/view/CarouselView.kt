package com.standalone.core.ui.view

import android.content.Context
import android.os.Handler
import android.os.Message
import android.util.AttributeSet
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ViewSwitcher
import androidx.appcompat.widget.AppCompatTextView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.standalone.core.R
import java.lang.ref.WeakReference
import java.util.*

/**
 * @author 345 QQ:1831712732
 * @name CarSteward
 * @class name：com.standalone.core.ui.view
 * @time 2019/11/12 21:46
 * @description 轮播 View
 * LifecycleObserver ：生命周期观察者，对 activity 的生命周期进行观察
 */
class CarouselView @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null
) : ViewSwitcher(context, attrs), LifecycleObserver {
    private var mCutItem = 0

    /**
     * 循环时间
     */
    private var loopTime = 0
    private lateinit var myHandler: MyHandler
    private lateinit var listString: ArrayList<String>


    init {
        initData()
        initAnimation()
    }

    /**
     * 初始化一些变量
     */
    private fun initData() {
        listString = ArrayList()
        myHandler = MyHandler(this)
    }

    /**
     * 初始化进入和出去动画
     */
    private fun initAnimation() {
        inAnimation = AnimationUtils.loadAnimation(
            context,
            R.anim.translate_in
        )
        outAnimation = AnimationUtils.loadAnimation(
            context,
            R.anim.translate_out
        )
    }

    /**
     * 设置数据源并展示view，外部调用
     *
     * @param mList
     * @param time
     */
    fun upDataListAndView(mList: ArrayList<String>?, time: Int) {
        mCutItem = -1
        loopTime = time
        if (null == mList) {
            return
        }
        listString.clear()
        listString.addAll(mList)
        showNextView()
    }

    /**
     * 展示下一条广告
     */
    fun showNextView() {
        if (listString.size < 2) {
            return
        }
        mCutItem = if (mCutItem == listString.size - 1) 0 else mCutItem + 1
        updataView(listString[mCutItem], nextView, mCutItem)
        showNext()
    }

    /**
     * 启动轮播
     */
    fun startLooping() {
        if (listString.size < 2) {
            return
        }
        myHandler.removeMessages(0)
        if (loopTime > 0) {
            myHandler.sendEmptyMessageDelayed(0, loopTime.toLong())
        }
    }

    /**
     * 停止轮播
     */
    fun stopLooping() {
        myHandler.removeMessages(0)
    }

    /**
     * 在当前view上设置数据
     *
     * @param text
     * @param view
     */
    private fun updataView(
        text: String,
        view: View,
        mCutItem: Int
    ) {
        val textView = view as AppCompatTextView
        textView.text = text
        textView.setOnClickListener {
            if (null != onClickItemListener) {
                onClickItemListener!!.onClick(mCutItem)
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private fun onPause() {
        stopLooping()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private fun onResume() {
        startLooping()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun onDestroy() {
        myHandler.removeMessages(0)
    }

    /**
     * @description 主线程Handler
     * @note 因为存在定时任务，并且TextSwitcherView持有Activity的引用
     * 所以这里采用弱引用，主要针对内存回收的时候Activity泄露
     */
    private class MyHandler(view: CarouselView?) : Handler() {
        private val mRef: WeakReference<*>
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            val mView = mRef.get() as CarouselView?
            if (mView != null) {
                mView.showNextView() //展示下一条广告，会调用shownext方法展示下一条广告
                mView.startLooping() //启动轮播，间隔后展示下一条
            } else {
                //如果 mView 为空，表示当前 mView 被回收，清除 handler中的所有任务
                removeCallbacksAndMessages(null)
            }
        }

        init {
            mRef = WeakReference<Any?>(view)
        }
    }

    private var onClickItemListener: OnClickItemListener? = null

    /**
     * 定义一个接口回调
     */
    interface OnClickItemListener {
        /**
         * 回调方法
         *
         * @param position 位置
         */
        fun onClick(position: Int)
    }

    /**
     * 接口
     *
     * @param onClickListener
     */
    fun setOnItemClickListener(onClickListener: OnClickItemListener?) {
        onClickItemListener = onClickListener
    }


}