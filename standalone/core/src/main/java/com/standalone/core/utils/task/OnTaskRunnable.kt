package com.standalone.core.utils.task

interface OnTaskRunnable {
    var key: String
    fun run()
}