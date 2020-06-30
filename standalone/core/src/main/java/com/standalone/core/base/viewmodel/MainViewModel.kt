package com.standalone.core.base.viewmodel

import androidx.lifecycle.SavedStateHandle
import com.standalone.core.base.viewmodel.BaseViewModel

/**
 * @name MainViewModel
 * @package com.lv.module_main.activity
 * @author 345 QQ:1831712732
 * @time 2020/5/12 22:59
 * @description
 */

class MainViewModel : BaseViewModel {
    constructor() : super()
    constructor(state: SavedStateHandle) : super(state)
}