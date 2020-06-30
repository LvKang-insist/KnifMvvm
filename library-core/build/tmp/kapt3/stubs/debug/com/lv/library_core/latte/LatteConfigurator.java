package com.lv.library_core.latte;

import java.lang.System;

/**
 * @name LatteConfigurator
 * @package com.lv.library_core.latte
 * @author 345 QQ:1831712732
 * @time 2020/5/15 21:15
 * @description
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\u0019\u0010\b\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u000bJ\"\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001`\rJ\u0006\u0010\u000e\u001a\u00020\u0000J\u0006\u0010\u000f\u001a\u00020\u0000J\u0006\u0010\u0010\u001a\u00020\u0000J\u0006\u0010\u0011\u001a\u00020\u0000R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/lv/library_core/latte/LatteConfigurator;", "", "()V", "LATTE_CONFIG", "Ljava/util/LinkedHashMap;", "Lcom/lv/library_core/latte/LatteConfigKeys;", "configure", "", "getConfigurator", "T", "key", "(Lcom/lv/library_core/latte/LatteConfigKeys;)Ljava/lang/Object;", "getLatteConfigs", "Lkotlin/collections/LinkedHashMap;", "withComponent", "withLog", "withLvHttp", "withToastUtils", "library-core_debug"})
public final class LatteConfigurator {
    private static final java.util.LinkedHashMap<com.lv.library_core.latte.LatteConfigKeys, java.lang.Object> LATTE_CONFIG = null;
    public static final com.lv.library_core.latte.LatteConfigurator INSTANCE = null;
    
    /**
     * 配置完成时调用
     */
    public final void configure() {
    }
    
    /**
     * 初始化 Toast
     */
    @org.jetbrains.annotations.NotNull()
    public final com.lv.library_core.latte.LatteConfigurator withToastUtils() {
        return null;
    }
    
    /**
     * 初始化 Log
     */
    @org.jetbrains.annotations.NotNull()
    public final com.lv.library_core.latte.LatteConfigurator withLog() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.lv.library_core.latte.LatteConfigurator withComponent() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.lv.library_core.latte.LatteConfigurator withLvHttp() {
        return null;
    }
    
    /**
     * @return 返回全部配置
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.LinkedHashMap<com.lv.library_core.latte.LatteConfigKeys, java.lang.Object> getLatteConfigs() {
        return null;
    }
    
    /**
     * 返回某一项配置
     */
    public final <T extends java.lang.Object>T getConfigurator(@org.jetbrains.annotations.NotNull()
    com.lv.library_core.latte.LatteConfigKeys key) {
        return null;
    }
    
    private LatteConfigurator() {
        super();
    }
}