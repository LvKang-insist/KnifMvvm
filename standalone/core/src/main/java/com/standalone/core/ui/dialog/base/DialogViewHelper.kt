package com.standalone.core.ui.dialog.base

import android.content.Context
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import java.lang.ref.WeakReference

/**
 * @name DialogVieHelper
 * @package com.standalone.core.ui.dialog.base
 * @author 345 QQ:1831712732
 * @time 2020/5/18 21:46
 * @description Dialog View 的辅助处理类
 */
class DialogViewHelper {

    var mContentView: View

    //缓存 ,软引用，防止内存泄露
    private val mCacheViews = SparseArray<WeakReference<View>>()

    constructor(mContext: Context, mViewLayoutResId: Int) {
        mContentView = LayoutInflater.from(mContext).inflate(mViewLayoutResId, null, false)
    }

    constructor(view: View) {
        mContentView = view
    }

    /**
     * 设置文本
     */
    fun setText(viewId: Int, text: CharSequence) {
        val tv = getView<View>(viewId)
        if (tv is AppCompatTextView) {
            tv.text = text
        } else if (tv is AppCompatButton) {
            tv.text = text
        }
    }

    /**
     * 设置事件
     */
    fun setOnClickListener(
        viewId: Int,
        onClick: WeakReference<(Pair<View, FastDialog>) -> Unit>,
        alertDialog: FastDialog
    ) {
        getView<View>(viewId)?.setOnClickListener {
            val parent: ((Pair<View, FastDialog>) -> Unit)? = onClick.get()
            if (parent != null) parent(Pair(it, alertDialog))
        }
    }

    /**
     * 获取 View
     */
    fun <T : View> getView(viewId: Int): T? {
        val viewReference = mCacheViews[viewId]
        if (viewReference != null) return viewReference.get() as T
        var view: View? = null
        if (view == null) view = mContentView.findViewById(viewId)
        if (view != null) mCacheViews.put(viewId, WeakReference(view))
        return view as T
    }

}