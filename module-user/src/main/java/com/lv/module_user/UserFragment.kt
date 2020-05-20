package com.lv.module_user

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment
import com.hjq.toast.ToastUtils
import com.lv.library_core.base.model.DefaultModel
import com.lv.library_core.base.ui.activity.skin.SkinManager
import com.lv.library_core.base.ui.activity.skin.config.SkinPreUtils
import com.lv.library_core.base.ui.frag.BaseLayoutFragment
import com.xiaojinzi.component.anno.FragmentAnno
import kotlinx.android.synthetic.main.user_frag.*

/**
 * @name HomeFragment
 * @package com.lv.module_home
 * @author 345 QQ:1831712732
 * @time 2020/5/12 21:51
 * @description
 */

@FragmentAnno("user-fragment")
class UserFragment : BaseLayoutFragment<UserViewModel>() {

    override fun setViewModel(): Class<UserViewModel> = UserViewModel::class.java

    override fun layout(): Int {
        return R.layout.user_frag
    }

    override fun bindView(rootView: View) {

        main_Skin.setOnClickListener {
            if (SkinPreUtils.getTag()) {
                SkinManager.restoreDefault()
                SkinPreUtils.setTag(false)
                main_Skin.setImageResource(R.drawable.main_daytime)
            } else {
                val code = SkinManager.loadSkin(context?.cacheDir?.path + "/knif.skin")
                SkinPreUtils.setTag(true)
                main_Skin.setImageResource(R.drawable.main_night)
            }
        }
    }


}