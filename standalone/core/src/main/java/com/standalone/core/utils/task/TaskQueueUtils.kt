package com.standalone.core.utils.task

import java.util.*
import kotlin.collections.HashMap

object TaskQueueUtils {


    private val queue = LinkedList<OnTaskRunnable>()


    fun addRun(run: OnTaskRunnable, isExecute: Boolean) {
        if (!isExecute) {
            queue.offer(run)
        }
    }


    fun execute() {
        while (queue.isNotEmpty()) {
            queue.pop().run()
        }
    }
}