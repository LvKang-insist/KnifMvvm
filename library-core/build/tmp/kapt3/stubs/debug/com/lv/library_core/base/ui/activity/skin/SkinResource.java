package com.lv.library_core.base.ui.activity.skin;

import java.lang.System;

/**
 * 皮肤的资源管理器
 */
@android.annotation.SuppressLint(value = {"DiscouragedPrivateApi"})
@kotlin.Suppress(names = {"RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS"})
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0005J\u0010\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\f\u001a\u00020\u0005J$\u0010\u000f\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0012H\u0082\b\u00a2\u0006\u0002\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/lv/library_core/base/ui/activity/skin/SkinResource;", "", "context", "Landroid/content/Context;", "skinPath", "", "(Landroid/content/Context;Ljava/lang/String;)V", "mPackageName", "mSkinResource", "Landroid/content/res/Resources;", "getColorByName", "Landroid/content/res/ColorStateList;", "resName", "getDrawableByName", "Landroid/graphics/drawable/Drawable;", "tryCatch", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "library-core_debug"})
public final class SkinResource {
    
    /**
     * 资源通过这个对象获取
     */
    private android.content.res.Resources mSkinResource;
    private java.lang.String mPackageName;
    private final android.content.Context context = null;
    private final java.lang.String skinPath = null;
    
    /**
     * 通过名字获取 Drawable
     */
    @org.jetbrains.annotations.Nullable()
    public final android.graphics.drawable.Drawable getDrawableByName(@org.jetbrains.annotations.NotNull()
    java.lang.String resName) {
        return null;
    }
    
    /**
     * 通过名字获取颜色
     */
    @org.jetbrains.annotations.Nullable()
    public final android.content.res.ColorStateList getColorByName(@org.jetbrains.annotations.NotNull()
    java.lang.String resName) {
        return null;
    }
    
    private final <T extends java.lang.Object>T tryCatch(kotlin.jvm.functions.Function0<? extends T> block) {
        return null;
    }
    
    public SkinResource(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String skinPath) {
        super();
    }
}