package com.example.module_sort

import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.view.View
import androidx.core.net.toUri
import com.example.library_core.storage.dao.UserDao
import com.standalone.core.base.ui.frag.BaseLayoutFragment
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


    lateinit var userDao: UserDao

    override fun createViewModel(): Class<SortViewModel> = SortViewModel::class.java

    override fun isDark(): Boolean {
        return false
    }

    override fun layout(): Int {
        return R.layout.sort_frag
    }

    override fun bindView() {


        recycler.setOnClickListener {
            //深层链接，利用 uri 直接跳转到 FragmentThree 中
            val intent = Intent(ACTION_VIEW)
            intent.data = "home://www/frag3".toUri()

            startActivity(intent)

        }

    }


}