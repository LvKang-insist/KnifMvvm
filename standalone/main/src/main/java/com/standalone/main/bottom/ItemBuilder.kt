package com.standalone.main.bottom

import androidx.fragment.app.Fragment

/**
 * @name ItemBuilder
 * @package com.lv.module_main.activity.base
 * @author 345 QQ:1831712732
 * @time 2020/5/8 23:26
 * @description 构建页面导航
 */
class ItemBuilder {


    var mItems = LinkedHashMap<BottomTabBean, Fragment>()

    companion object {
        @JvmStatic
        fun builder(): ItemBuilder {
            return ItemBuilder()
        }
    }

    fun addItem(map: LinkedHashMap<BottomTabBean, Fragment>) {
        mItems.clear()
        mItems.putAll(map)
    }

    fun addItem(tabBean: BottomTabBean, fragment: Fragment) {
        mItems[tabBean] = fragment
    }

    fun build(): LinkedHashMap<BottomTabBean, Fragment> {
        return mItems
    }

}