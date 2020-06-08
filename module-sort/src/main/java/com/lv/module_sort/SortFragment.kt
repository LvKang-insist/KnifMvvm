package com.lv.module_sort

import android.view.View
import com.lv.library_core.base.ui.frag.BaseLayoutFragment
import com.lv.library_core.utils.storage.CacheDataBase
import com.lv.module_sort.dao.SortDataBase
import com.lv.module_sort.dao.UserDao
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

    override fun createViewModel(): Class<SortViewModel> = SortViewModel::class.java

    override fun layout(): Int {
        return R.layout.sort_frag
    }

    override fun bindView(rootView: View) {

        val dao = SortDataBase.get().getDao<UserDao>()
        dao.save(User(1, "234", 34))
    }


}