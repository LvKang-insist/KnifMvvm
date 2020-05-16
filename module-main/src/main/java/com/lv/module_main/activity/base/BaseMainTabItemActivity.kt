package com.lv.module_main.activity.base

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.lv.library_core.base.activity.BaseBindingActivity
import com.lv.library_core.base.activity.BaseLayoutActivity
import com.lv.library_core.base.activity.BaseSkinActivity
import com.lv.library_core.model.BaseViewModel
import com.lv.library_core.utils.GlideUtils
import com.lv.module_main.R
import com.lv.module_main.activity.bottom.BottomTabBean
import com.lv.module_main.activity.bottom.ItemBuilder
import com.lv.module_main.activity.bottom.MainContentAdapter
import kotlinx.android.synthetic.main.bottom_activity.*

/**
 * @name BaseMainTabItemActivity
 * @package com.lv.module_main.activity.base
 * @author 345 QQ:1831712732
 * @time 2020/5/8 23:03
 * @description tab 管理类
 */
abstract class BaseMainTabItemActivity<V : ViewDataBinding, VM : BaseViewModel> :
    BaseBindingActivity<V, VM>(), View.OnClickListener {

    /**
     * 导航 Fragment
     */
    private val mFragments = mutableListOf<Fragment>()


    /**
     * 导航 Bean
     */
    private val mTabBeans = mutableListOf<BottomTabBean>()

    /**
     * 保存 导航 + Fragment
     */
    private var mItems = LinkedHashMap<BottomTabBean, Fragment>()

    /**
     * 默认显示的 fragment
     */
    private var mIndexPos = 0

    /**
     * 是否开启滑动模式
     */
    private var isScroll = false

    /**
     * 默认选中的颜色
     */
    private var mSelectColor = Color.RED

    private var isVpScroll = false

    private val mLayoutInflater by lazy { LayoutInflater.from(this) }
    private val mainContentAdapter by lazy {
        MainContentAdapter(supportFragmentManager, lifecycle, mFragments)
    }


    override fun layout(): Int {
        return R.layout.bottom_activity
    }

    override fun bindView() {
        isScroll = isScroll()
        initItem()
        val size = mItems.size
        for (i in 0 until size) {
            mLayoutInflater.inflate(R.layout.layout_bottom_item, bottom_bar)
            val item = bottom_bar.getChildAt(i) as LinearLayoutCompat
            item.setOnClickListener(this)
            item.tag = i
            val itemIcon = item.getChildAt(0) as AppCompatImageView
            val itemTitle = item.getChildAt(1) as AppCompatTextView
            val bottomTabBean = mTabBeans[i]
            GlideUtils.load(itemIcon, bottomTabBean.icon)
            itemTitle.text = bottomTabBean.title
            itemTitle.setTextColor(Color.GRAY)
            if (i == mIndexPos) {
                GlideUtils.load(itemIcon, bottomTabBean.selectIcon)
                itemTitle.setTextColor(mSelectColor)
            }
        }
        bottom_vp_content.offscreenPageLimit = size - 1
        bottom_vp_content.adapter = mainContentAdapter
        bottom_vp_content.currentItem = mIndexPos
        bottom_vp_content.isUserInputEnabled = isScroll
//        bottom_vp_content.setPagerEnabled(isScroll)

        bottom_vp_content.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                if (isVpScroll) {
                    isVpScroll = false
                    return
                }
                setScrollTab(position)
            }
        })
    }

    private fun initItem() {
        mIndexPos = setIndexPos()
        mSelectColor = setSelectColor()
        mItems = setItems(ItemBuilder.builder())
        mItems.forEach {
            mTabBeans.add(it.key)
            mFragments.add(it.value)
        }
    }


    abstract fun setItems(builder: ItemBuilder): LinkedHashMap<BottomTabBean, Fragment>

    abstract fun setIndexPos(): Int

    abstract fun setSelectColor(): Int

    open fun isScroll(): Boolean = false

    override fun onClick(v: View) {
        val pos = v.tag as Int
        setTab(pos)
    }

    private fun setScrollTab(pos: Int) {
        defaultTab()
        val item = bottom_bar.getChildAt(pos) as LinearLayoutCompat
        val itemIcon = item.getChildAt(0) as AppCompatImageView
        val itemTitle = item.getChildAt(1) as AppCompatTextView
        val bottomTabBean = mTabBeans[pos]
        GlideUtils.load(itemIcon, bottomTabBean.selectIcon)
        itemTitle.setTextColor(mSelectColor)
    }


    private fun setTab(pos: Int) {
        isVpScroll = true
        setScrollTab(pos)
        bottom_vp_content.setCurrentItem(pos, false)
    }

    private fun defaultTab() {
        val size = mItems.size
        for (i in 0 until size) {
            val item = bottom_bar.getChildAt(i) as LinearLayoutCompat
            val itemIcon = item.getChildAt(0) as AppCompatImageView
            val itemTitle = item.getChildAt(1) as AppCompatTextView
            val bottomTabBean = mTabBeans[i]
            GlideUtils.load(itemIcon, bottomTabBean.icon)
            itemTitle.setTextColor(Color.GRAY)
        }
    }
}