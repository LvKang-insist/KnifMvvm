package com.lv.library_core.base.ui.activity;

import java.lang.System;

/**
 * @name BaseActivity
 * @class name：com.lv.module_main.activity.base
 * @author 345 QQ:1831712732
 * @time 2020/5/8 22:52
 * @description Activity 基类
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH&J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H&J\u0012\u0010\u0012\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H&R\u001c\u0010\u0005\u001a\u00028\u0000X\u0086.\u00a2\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\u0014"}, d2 = {"Lcom/lv/library_core/base/ui/activity/BaseActivity;", "VM", "Lcom/lv/library_core/base/viewmodel/BaseViewModel;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "viewModel", "getViewModel", "()Lcom/lv/library_core/base/viewmodel/BaseViewModel;", "setViewModel", "(Lcom/lv/library_core/base/viewmodel/BaseViewModel;)V", "Lcom/lv/library_core/base/viewmodel/BaseViewModel;", "bindView", "", "savedInstanceState", "Landroid/os/Bundle;", "initView", "layout", "", "onCreate", "Ljava/lang/Class;", "library-core_debug"})
public abstract class BaseActivity<VM extends com.lv.library_core.base.viewmodel.BaseViewModel> extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    public VM viewModel;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final VM getViewModel() {
        return null;
    }
    
    public final void setViewModel(@org.jetbrains.annotations.NotNull()
    VM p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public void initView() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.Class<VM> setViewModel();
    
    public abstract int layout();
    
    public abstract void bindView();
    
    public void bindView(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public BaseActivity() {
        super();
    }
}