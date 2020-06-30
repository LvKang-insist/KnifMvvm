package com.lv.library_core.base.ui.frag;

import java.lang.System;

/**
 * @name BaseBindingFragment
 * @package com.lv.library_core.base.ui.frag
 * @author 345 QQ:1831712732
 * @time 2020/5/19 22:41
 * @description Fragment 使用 DataBinding
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\b\u0012\u0004\u0012\u0002H\u00030\u0005B\u0005\u00a2\u0006\u0002\u0010\u0006J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u001c\u0010\u0007\u001a\u00028\u0000X\u0086.\u00a2\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/lv/library_core/base/ui/frag/BaseBindingFragment;", "V", "Landroidx/databinding/ViewDataBinding;", "VM", "Lcom/lv/library_core/base/viewmodel/BaseViewModel;", "Lcom/lv/library_core/base/ui/frag/BaseFragment;", "()V", "binding", "getBinding", "()Landroidx/databinding/ViewDataBinding;", "setBinding", "(Landroidx/databinding/ViewDataBinding;)V", "Landroidx/databinding/ViewDataBinding;", "initView", "Landroid/view/View;", "container", "Landroid/view/ViewGroup;", "library-core_debug"})
public abstract class BaseBindingFragment<V extends androidx.databinding.ViewDataBinding, VM extends com.lv.library_core.base.viewmodel.BaseViewModel> extends com.lv.library_core.base.ui.frag.BaseFragment<VM> {
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
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View initView(@org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container) {
        return null;
    }
    
    public BaseBindingFragment() {
        super();
    }
}