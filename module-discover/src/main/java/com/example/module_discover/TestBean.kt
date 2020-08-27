package com.example.module_discover

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableField

class TestBean : BaseObservable() {


    val sum = ObservableField<Int>()


    fun addSum() {
        val s = sum.get()!!
        sum.set(s + 1)
    }
}