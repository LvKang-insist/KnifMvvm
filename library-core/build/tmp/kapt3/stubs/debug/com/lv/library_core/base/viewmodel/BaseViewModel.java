package com.lv.library_core.base.viewmodel;

import java.lang.System;

/**
 * @name BaseViewModel
 * @package com.lv.library_core.model
 * @author 345 QQ:1831712732
 * @time 2020/5/12 22:44
 * @description BaseViewModel ，
 */
@kotlin.Suppress(names = {"UNCHECKED_CAST"})
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001b\u0010\u0013\u001a\u0004\u0018\u0001H\u0014\"\u0004\b\u0000\u0010\u00142\u0006\u0010\u0015\u001a\u00020\t\u00a2\u0006\u0002\u0010\u0016J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0017J\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0017\"\u0004\b\u0000\u0010\u00142\u0006\u0010\u0015\u001a\u00020\tJ\b\u0010\u0019\u001a\u00020\u001aH\u0007J!\u0010\u001b\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u00142\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u001c\u001a\u0002H\u0014\u00a2\u0006\u0002\u0010\u001dR!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/lv/library_core/base/viewmodel/BaseViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/LifecycleObserver;", "()V", "state", "Landroidx/lifecycle/SavedStateHandle;", "(Landroidx/lifecycle/SavedStateHandle;)V", "finally", "Landroidx/lifecycle/MutableLiveData;", "", "getFinally", "()Landroidx/lifecycle/MutableLiveData;", "finally$delegate", "Lkotlin/Lazy;", "mDefaultRepository", "Lcom/lv/library_core/base/model/BaseRepository;", "getMDefaultRepository", "()Lcom/lv/library_core/base/model/BaseRepository;", "savedStateHandler", "getCurrentValue", "T", "key", "(Ljava/lang/String;)Ljava/lang/Object;", "Landroidx/lifecycle/LiveData;", "getSaveStateLiveData", "onDestroy", "", "saveCurrentValue", "t", "(Ljava/lang/String;Ljava/lang/Object;)V", "library-core_debug"})
public abstract class BaseViewModel extends androidx.lifecycle.ViewModel implements androidx.lifecycle.LifecycleObserver {
    
    /**
     * ViewModel 在内存不足时被干掉后的数据恢复
     * 包括在页面转屏的时候都会通知对应的观察者
     */
    private androidx.lifecycle.SavedStateHandle savedStateHandler;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy finally$delegate = null;
    private com.lv.library_core.base.model.BaseRepository mDefaultRepository;
    
    @org.jetbrains.annotations.NotNull()
    protected final androidx.lifecycle.MutableLiveData<java.lang.String> getFinally() {
        return null;
    }
    
    private final com.lv.library_core.base.model.BaseRepository getMDefaultRepository() {
        return null;
    }
    
    /**
     * 可在数据处理完成时调用，用于弹出一些提示
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getFinally() {
        return null;
    }
    
    /**
     * 保存数据到 savedStateHandler
     */
    public final <T extends java.lang.Object>void saveCurrentValue(@org.jetbrains.annotations.NotNull()
    java.lang.String key, T t) {
    }
    
    /**
     * 从 savedStateHandler 取出数据
     */
    @org.jetbrains.annotations.Nullable()
    public final <T extends java.lang.Object>T getCurrentValue(@org.jetbrains.annotations.NotNull()
    java.lang.String key) {
        return null;
    }
    
    /**
     * 获取指定 savedStateHandler key 的 liveData
     */
    @org.jetbrains.annotations.NotNull()
    public final <T extends java.lang.Object>androidx.lifecycle.LiveData<T> getSaveStateLiveData(@org.jetbrains.annotations.NotNull()
    java.lang.String key) {
        return null;
    }
    
    @androidx.lifecycle.OnLifecycleEvent(value = androidx.lifecycle.Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
    }
    
    public BaseViewModel() {
        super();
    }
    
    public BaseViewModel(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.SavedStateHandle state) {
        super();
    }
}