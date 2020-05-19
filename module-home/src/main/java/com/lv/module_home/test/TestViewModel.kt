package com.lv.module_home.test

import androidx.lifecycle.MutableLiveData
import com.lv.library_core.base.model.BaseModel
import com.lv.library_core.base.model.DefaultModel
import com.lv.library_core.base.viewmodel.BaseViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TestViewModel : BaseViewModel() {

    val testData by lazy { MutableLiveData<TestBean>() }

    fun request() {
        getModel<TestModel>()?.request {
            testData.value = it
        }
    }

    override fun setModel(): TestModel {
        return TestModel()
    }


}