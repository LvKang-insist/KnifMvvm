package com.lv.module_home.test

import com.elvishew.xlog.XLog
import com.lv.library_core.base.model.BaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * @name TestModel
 * @package com.lv.module_home.test
 * @author 345 QQ:1831712732
 * @time 2020/5/19 22:03
 * @description
 */

class TestModel : BaseModel() {


    fun request(block: (TestBean) -> Unit) {
        GlobalScope.launch {
            delay(5000)
            launch(Dispatchers.Main) {
                XLog.e("----------------")
                block(TestBean("345", 21))
            }
        }
    }

}