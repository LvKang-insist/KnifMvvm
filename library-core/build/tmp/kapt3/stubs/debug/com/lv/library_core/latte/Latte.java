package com.lv.library_core.latte;

import java.lang.System;

/**
 * @name Latte
 * @package com.lv.library_core.latte
 * @author 345 QQ:1831712732
 * @time 2020/5/15 21:14
 * @description 获取配置信息
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J$\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001`\bH\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\u0019\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\u0006\u0010\r\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\u000eJ\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0004\u00a8\u0006\u0011"}, d2 = {"Lcom/lv/library_core/latte/Latte;", "", "()V", "getAppContext", "Landroid/app/Application;", "getConfiguration", "Ljava/util/LinkedHashMap;", "Lcom/lv/library_core/latte/LatteConfigKeys;", "Lkotlin/collections/LinkedHashMap;", "getInstance", "Lcom/lv/library_core/latte/LatteConfigurator;", "getValue", "T", "key", "(Lcom/lv/library_core/latte/LatteConfigKeys;)Ljava/lang/Object;", "init", "context", "library-core_debug"})
public final class Latte {
    public static final com.lv.library_core.latte.Latte INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.lv.library_core.latte.LatteConfigurator init(@org.jetbrains.annotations.NotNull()
    android.app.Application context) {
        return null;
    }
    
    /**
     * @return 返回一个 全局Context
     */
    @org.jetbrains.annotations.NotNull()
    public final android.app.Application getAppContext() {
        return null;
    }
    
    /**
     * 获取一个 Value
     */
    public final <T extends java.lang.Object>T getValue(@org.jetbrains.annotations.NotNull()
    com.lv.library_core.latte.LatteConfigKeys key) {
        return null;
    }
    
    private final java.util.LinkedHashMap<com.lv.library_core.latte.LatteConfigKeys, java.lang.Object> getConfiguration() {
        return null;
    }
    
    private final com.lv.library_core.latte.LatteConfigurator getInstance() {
        return null;
    }
    
    private Latte() {
        super();
    }
}