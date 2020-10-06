package com.standalone.core.ui

/**
 * @author 345 QQ:1831712732
 * @package : com.standalone.core.ui
 * @time : 2020/10/6  20:26
 * @description : EventBus 事件
 */
class EventMessage {

    enum class Type {
        /**
         * 首页按钮点击事件
         */
        CLICK_HOME,
        /**
         * 发现按钮点击事件
         */
        CLICK_DISCOVER,
        /**
         * 分类按钮点击事件
         */
        CLICK_SORT,
        /**
         * 用户按钮点击事件
         */
        CLICK_USER
    }

    lateinit var type: Type
    var any: Any? = null
    var any1: Any? = null
    var any2: Any? = null
    var arg:String?= null
    var arg1:String?= null
    var arg2:String?= null

    constructor(type: Type) {
        this.type = type
    }

    constructor(type: Type, any: Any){
        this.type = type
        this.any = any
    }

    constructor(type: Type, any1: Any, any2: Any){
        this.type = type
        this.any1 = any1
        this.any2 = any2
    }

    constructor(type: Type, arg: String){
        this.type = type
        this.arg  = arg
    }

    constructor(type: Type, arg1: String,arg2: String){
        this.type = type
        this.arg1  = arg1
        this.arg2 = arg2
    }

    constructor(type: Type, arg: String, any: Any){
        this.type = type
        this.arg = arg
        this.any = any
    }

    constructor(type: Type, arg1: String, arg2: String, any: Any){
        this.type = type
        this.arg1 = arg1
        this.arg2 = arg2
        this.any = any
    }

}