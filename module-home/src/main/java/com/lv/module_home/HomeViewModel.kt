package com.lv.module_home

import androidx.lifecycle.SavedStateHandle
import com.lv.library_core.base.model.BaseRepository
import com.lv.library_core.base.model.DefaultRepository
import com.lv.library_core.base.viewmodel.BaseViewModel

/**
 * @name HomeViewModel
 * @package com.lv.module_home
 * @author 345 QQ:1831712732
 * @time 2020/5/19 23:03
 * @description
 */

class HomeViewModel : BaseViewModel {
//
    constructor() : super()
    constructor(state: SavedStateHandle) : super(state)
}