package com.lv.library_core.base.ui.activity.skin.support;

import java.lang.System;

/**
 * 皮肤属性解析的支持类
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/lv/library_core/base/ui/activity/skin/support/SkinAttrSupport;", "", "()V", "Companion", "library-core_debug"})
public final class SkinAttrSupport {
    public static final com.lv.library_core.base.ui.activity.skin.support.SkinAttrSupport.Companion Companion = null;
    
    public SkinAttrSupport() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fJ\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0002\u00a8\u0006\u0010"}, d2 = {"Lcom/lv/library_core/base/ui/activity/skin/support/SkinAttrSupport$Companion;", "", "()V", "getResName", "", "context", "Landroid/content/Context;", "attrValue", "getSkinAttrs", "", "Lcom/lv/library_core/base/ui/activity/skin/attr/SkinAttr;", "attr", "Landroid/util/AttributeSet;", "getSkinType", "Lcom/example/core/base/skin/attr/SkinType;", "attrName", "library-core_debug"})
    public static final class Companion {
        
        /**
         * 获取 SkinAttr 的属性
         */
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.lv.library_core.base.ui.activity.skin.attr.SkinAttr> getSkinAttrs(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        android.util.AttributeSet attr) {
            return null;
        }
        
        /**
         * 获取资源名称
         */
        private final java.lang.String getResName(android.content.Context context, java.lang.String attrValue) {
            return null;
        }
        
        /**
         * 通过名称获取 SkinType
         */
        private final com.example.core.base.skin.attr.SkinType getSkinType(java.lang.String attrName) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}