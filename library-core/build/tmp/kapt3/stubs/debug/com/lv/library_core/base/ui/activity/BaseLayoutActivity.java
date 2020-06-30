package com.lv.library_core.base.ui.activity;

import java.lang.System;

/**
 * @name BaseLayoutActivity
 * @package com.lv.library_core.base.activity
 * @author 345 QQ:1831712732
 * @time 2020/5/14 23:16
 * @description
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/lv/library_core/base/ui/activity/BaseLayoutActivity;", "VM", "Lcom/lv/library_core/base/viewmodel/BaseViewModel;", "Lcom/lv/library_core/base/ui/activity/BaseSkinActivity;", "()V", "immersion", "", "initView", "", "library-core_debug"})
public abstract class BaseLayoutActivity<VM extends com.lv.library_core.base.viewmodel.BaseViewModel> extends com.lv.library_core.base.ui.activity.BaseSkinActivity<VM> {
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    public void initView() {
    }
    
    /**
     * 沉浸式状态栏的适配
     */
    public int immersion() {
        return 0;
    }
    
    public BaseLayoutActivity() {
        super();
    }
}