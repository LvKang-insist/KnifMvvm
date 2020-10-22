package com.lv.module_sort

import androidx.fragment.app.viewModels
import com.lv.library_core.storage.DBManager
import com.lv.library_core.storage.bean.UserEntity
import com.lv.library_core.storage.dao.UserDao
import com.standalone.core.base.ui.frag.KnifeLayoutFragment
import com.xiaojinzi.component.anno.FragmentAnno
import kotlinx.android.synthetic.main.sort_frag.*
import java.lang.StringBuilder
import kotlin.random.Random


/**
 * @name HomeFragment
 * @package com.lv.module_home
 * @author 345 QQ:1831712732
 * @time 2020/5/12 21:51
 * @description
 */

@FragmentAnno("sort-fragment")
class SortFragment : KnifeLayoutFragment() {


    lateinit var userDao: UserDao

    val sortViewModel by viewModels<SortViewModel>()

    override fun isImmersionBar(): Boolean = true

    override fun isBarDark(): Boolean = false

    override fun layout(): Int {
        return R.layout.sort_frag
    }

    override fun bindView() {


            //深层链接，利用 uri 直接跳转到 FragmentThree 中
//            val intent = Intent(ACTION_VIEW)
//            intent.data = "home://www/frag3".toUri()
//            startActivity(intent)


        tvInsist.setOnClickListener {
            DBManager.insertUser(UserEntity(0,"夏军 ${Random(10).nextInt()}",20,"足球","殺殺殺","男"))
        }

        tvGetData.setOnClickListener {
            val str = StringBuilder()
            DBManager.queryUser().forEach {
                str.append(it.toString())
                    .append("\n")
            }
            tvGetData.text = str
        }

    }


}