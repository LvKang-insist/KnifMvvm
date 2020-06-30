package com.lv.library_core.base.ui.activity;

import java.lang.System;

/**
 * @name BaseBindingActivity
 * @package com.lv.library_core.base.activity
 * @author 345 QQ:1831712732
 * @time 2020/5/14 22:39
 * @description BaseBindingActivity：如果需要使用 DataBinding，可以继承自此类。
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\b\u0012\u0004\u0012\u0002H\u00030\u0005B\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u001c\u0010\u0007\u001a\u00028\u0000X\u0086.\u00a2\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/lv/library_core/base/ui/activity/BaseBindingActivity;", "V", "Landroidx/databinding/ViewDataBinding;", "VM", "Lcom/lv/library_core/base/viewmodel/BaseViewModel;", "Lcom/lv/library_core/base/ui/activity/BaseSkinActivity;", "()V", "binding", "getBinding", "()Landroidx/databinding/ViewDataBinding;", "setBinding", "(Landroidx/databinding/ViewDataBinding;)V", "Landroidx/databinding/ViewDataBinding;", "immersion", "", "initView", "", "library-core_debug"})
public abstract class BaseBindingActivity<V extends androidx.databinding.ViewDataBinding, VM extends com.lv.library_core.base.viewmodel.BaseViewModel> extends com.lv.library_core.base.ui.activity.BaseSkinActivity<VM> {
    @org.jetbrains.annotations.NotNull()
    public V binding;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final V getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    V p0) {
    }
    
    @java.lang.Override()
    public void initView() {
    }
    
    /**
     * 沉浸式状态栏的适配
     */
    public int immersion() {
        return 0;
    }
    
    public BaseBindingActivity() {
        super();
    }
}