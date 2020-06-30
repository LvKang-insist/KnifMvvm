package com.lv.library_core.base.ui.frag;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H&J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001a\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001bH\u0016J\u0010\u0010\u001c\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001bH\u0016J\u0012\u0010\u001d\u001a\u00020\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH&J\b\u0010 \u001a\u00020!H&J\b\u0010\"\u001a\u00020\u0014H\u0016J&\u0010#\u001a\u0004\u0018\u00010\u00162\u0006\u0010$\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010%\u001a\u00020\u0014H\u0016J\u001a\u0010&\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001c\u0010\'\u001a\u00020\u00142\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00140)2\u0006\u0010\'\u001a\u00020*J\r\u0010\u0010\u001a\u00028\u0000H\u0002\u00a2\u0006\u0002\u0010\u000fJ\u001a\u0010+\u001a\u00020\u0014\"\u0004\b\u0001\u0010,2\f\u0010-\u001a\b\u0012\u0004\u0012\u0002H,0\u001bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001c\u0010\r\u001a\u00028\u0000X\u0086.\u00a2\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006."}, d2 = {"Lcom/lv/library_core/base/ui/frag/BaseFragment;", "VM", "Lcom/lv/library_core/base/viewmodel/BaseViewModel;", "Landroidx/fragment/app/Fragment;", "()V", "isLazyLoad", "", "mLayoutInflater", "Landroid/view/LayoutInflater;", "getMLayoutInflater", "()Landroid/view/LayoutInflater;", "mLayoutInflater$delegate", "Lkotlin/Lazy;", "viewModel", "getViewModel", "()Lcom/lv/library_core/base/viewmodel/BaseViewModel;", "setViewModel", "(Lcom/lv/library_core/base/viewmodel/BaseViewModel;)V", "Lcom/lv/library_core/base/viewmodel/BaseViewModel;", "bindView", "", "rootView", "Landroid/view/View;", "view", "savedInstanceState", "Landroid/os/Bundle;", "createStateViewModel", "Ljava/lang/Class;", "createViewModel", "initView", "container", "Landroid/view/ViewGroup;", "layout", "", "lazyLoad", "onCreateView", "inflater", "onResume", "onViewCreated", "permission", "block", "Lkotlin/Function0;", "", "startActivity", "T", "clazz", "library-core_debug"})
public abstract class BaseFragment<VM extends com.lv.library_core.base.viewmodel.BaseViewModel> extends androidx.fragment.app.Fragment {
    private boolean isLazyLoad;
    @org.jetbrains.annotations.NotNull()
    public VM viewModel;
    @org.jetbrains.annotations.Nullable()
    private final kotlin.Lazy mLayoutInflater$delegate = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final VM getViewModel() {
        return null;
    }
    
    public final void setViewModel(@org.jetbrains.annotations.NotNull()
    VM p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.view.LayoutInflater getMLayoutInflater() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract android.view.View initView(@org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container);
    
    @java.lang.Override()
    public void onResume() {
    }
    
    public final <T extends java.lang.Object>void startActivity(@org.jetbrains.annotations.NotNull()
    java.lang.Class<T> clazz) {
    }
    
    public final void permission(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> block, @org.jetbrains.annotations.NotNull()
    java.lang.String permission) {
    }
    
    private final VM setViewModel() {
        return null;
    }
    
    /**
     * 设置 ViewModel
     */
    @org.jetbrains.annotations.Nullable()
    public java.lang.Class<VM> createViewModel() {
        return null;
    }
    
    /**
     * 带数据恢复的 ViewModel，可通过 savedStateHandler 进行设置
     */
    @org.jetbrains.annotations.Nullable()
    public java.lang.Class<VM> createStateViewModel() {
        return null;
    }
    
    /**
     * 加载布局
     */
    public abstract int layout();
    
    /**
     * 逻辑处理
     */
    public abstract void bindView(@org.jetbrains.annotations.NotNull()
    android.view.View rootView);
    
    public void bindView(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * 懒加载
     */
    public void lazyLoad() {
    }
    
    public BaseFragment() {
        super();
    }
}