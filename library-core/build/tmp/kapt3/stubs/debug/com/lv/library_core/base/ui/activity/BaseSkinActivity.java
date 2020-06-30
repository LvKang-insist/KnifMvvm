package com.lv.library_core.base.ui.activity;

import java.lang.System;

/**
 * @name BaseSkinActivity
 * @class name：com.lv.module_main.activity.base
 * @author 345 QQ:1831712732
 * @time 2020/5/8 22:57
 * @description 换肤
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u00042\u00020\u0005B\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J0\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010\u0014\u001a\u00020\u00152\b\b\u0001\u0010\u0016\u001a\u00020\u0017H\u0003J\b\u0010\u0018\u001a\u00020\fH\u0002J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0012\u0010\u001c\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J,\u0010\u001f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\"\u0010\u001f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010 \u001a\u00020\fH\u0014J\u0012\u0010!\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002R\u0010\u0010\u0007\u001a\u00020\b8\u0002X\u0083\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/lv/library_core/base/ui/activity/BaseSkinActivity;", "VM", "Lcom/lv/library_core/base/viewmodel/BaseViewModel;", "Lcom/lv/library_core/base/ui/activity/BaseActivity;", "Landroid/view/LayoutInflater$Factory2;", "Lcom/lv/library_core/base/ui/activity/skin/callback/ISkinChangeListener;", "()V", "lollipop", "", "mAppCompatViewInflater", "Lcom/lv/library_core/base/ui/activity/skin/support/SkinAppCompatViewInflater;", "changeSkin", "", "skinResource", "Lcom/lv/library_core/base/ui/activity/skin/SkinResource;", "createView", "Landroid/view/View;", "parent", "name", "", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "intercept", "managerSkinView", "skinView", "Lcom/lv/library_core/base/ui/activity/skin/attr/SkinView;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "onDestroy", "shouldInheritContext", "viewParent", "Landroid/view/ViewParent;", "library-core_debug"})
public abstract class BaseSkinActivity<VM extends com.lv.library_core.base.viewmodel.BaseViewModel> extends com.lv.library_core.base.ui.activity.BaseActivity<VM> implements android.view.LayoutInflater.Factory2, com.lv.library_core.base.ui.activity.skin.callback.ISkinChangeListener {
    private com.lv.library_core.base.ui.activity.skin.support.SkinAppCompatViewInflater mAppCompatViewInflater;
    @android.annotation.SuppressLint(value = {"ObsoleteSdkInt"})
    private final boolean lollipop = false;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * 拦截 View 的创建
     */
    private final void intercept() {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.util.AttributeSet attrs) {
        return null;
    }
    
    /**
     * 拦截 View 后，创建 View 会走下面这个方法
     * 这个方法在一个页面中会被调用多次
     */
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.Nullable()
    android.view.View parent, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.util.AttributeSet attrs) {
        return null;
    }
    
    /**
     * 统一管理 SkinView
     */
    private final void managerSkinView(com.lv.library_core.base.ui.activity.skin.attr.SkinView skinView) {
    }
    
    /**
     * 子类如果需要可重写此方法，该方法会在换肤的时候调用
     * skinResources 是资源包的资源
     */
    @java.lang.Override()
    public void changeSkin(@org.jetbrains.annotations.NotNull()
    com.lv.library_core.base.ui.activity.skin.SkinResource skinResource) {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    /**
     * --------------------------------------------------------------------------------------
     * 因为创建 View 需要进行兼容，所以这里直接 copy 系统源码
     * 下面代码都是 AppCompatDelegateImpl 中的
     * AppCompatDelegateImpl 中拦截了 View ，进行了兼容
     * 这里直接 copy 过来使用
     */
    @android.annotation.SuppressLint(value = {"Recycle", "PrivateResource", "RestrictedApi"})
    private final android.view.View createView(android.view.View parent, java.lang.String name, @androidx.annotation.NonNull()
    android.content.Context context, @androidx.annotation.NonNull()
    android.util.AttributeSet attrs) {
        return null;
    }
    
    private final boolean shouldInheritContext(android.view.ViewParent viewParent) {
        return false;
    }
    
    public BaseSkinActivity() {
        super();
    }
}