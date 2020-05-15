package com.lv.module_main.main

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import com.lv.module_main.R
import kotlinx.android.synthetic.main.frag.*
import kotlin.random.Random

/**
 * @name Frag
 * @package com.lv.module_main.main
 * @author 345 QQ:1831712732
 * @time 2020/5/11 22:42
 * @description
 */

class Frag : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.frag, container, false)
        val tv = view.findViewById<AppCompatTextView>(R.id.frag_tv)
        tv.text = "${Random(10)}"
        return view
    }

}