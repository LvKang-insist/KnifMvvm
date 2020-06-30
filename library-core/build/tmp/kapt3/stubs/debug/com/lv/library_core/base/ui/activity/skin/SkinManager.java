package com.lv.library_core.base.ui.activity.skin;

import java.lang.System;

@android.annotation.SuppressLint(value = {"StaticFieldLeak"})
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tJ\b\u0010\u000f\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J\u0006\u0010\u0016\u001a\u00020\u000bJ\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\u0007J\u000e\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0004J\u0010\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u0012H\u0002J\u0010\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u0012H\u0002J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010\u0015\u001a\u00020\u0012J\u001c\u0010!\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00072\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u0006\u0010#\u001a\u00020 J\u0010\u0010$\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J\u000e\u0010%\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/lv/library_core/base/ui/activity/skin/SkinManager;", "", "()V", "mContext", "Landroid/content/Context;", "mSkinViews", "", "Lcom/lv/library_core/base/ui/activity/skin/callback/ISkinChangeListener;", "", "Lcom/lv/library_core/base/ui/activity/skin/attr/SkinView;", "skinResource", "Lcom/lv/library_core/base/ui/activity/skin/SkinResource;", "checkChangeSkin", "", "skinView", "checkSkin", "copyCache", "cacheDir", "", "equalsSkinPath", "", "skinPath", "getSkinResource", "getSkinViews", "changeListener", "init", "context", "isFile", "filePath", "isPackageName", "currentSkinPath", "loadSkin", "", "register", "skinViews", "restoreDefault", "saveSkinStatus", "unregister", "library-core_debug"})
public final class SkinManager {
    private static android.content.Context mContext;
    private static final java.util.Map<com.lv.library_core.base.ui.activity.skin.callback.ISkinChangeListener, java.util.List<com.lv.library_core.base.ui.activity.skin.attr.SkinView>> mSkinViews = null;
    private static com.lv.library_core.base.ui.activity.skin.SkinResource skinResource;
    public static final com.lv.library_core.base.ui.activity.skin.SkinManager INSTANCE = null;
    
    public final void init(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    /**
     * 加载新皮肤
     */
    public final int loadSkin(@org.jetbrains.annotations.NotNull()
    java.lang.String skinPath) {
        return 0;
    }
    
    private final void copyCache(java.lang.String cacheDir) {
    }
    
    /**
     * 恢复默认
     */
    public final int restoreDefault() {
        return 0;
    }
    
    /**
     * 判断是否需要换肤，如果需要则进行换肤
     */
    public final void checkChangeSkin(@org.jetbrains.annotations.NotNull()
    com.lv.library_core.base.ui.activity.skin.attr.SkinView skinView) {
    }
    
    /**
     * 换肤
     */
    private final void checkSkin() {
    }
    
    /**
     * 判断皮肤地址是否相同
     */
    private final boolean equalsSkinPath(java.lang.String skinPath) {
        return false;
    }
    
    /**
     * 文件是否存在，true 表示存在
     */
    private final boolean isFile(java.lang.String filePath) {
        return false;
    }
    
    /**
     * 保存当前使用的皮肤
     */
    private final void saveSkinStatus(java.lang.String skinPath) {
    }
    
    /**
     * 包名是否为空，true 表示不为空
     */
    private final boolean isPackageName(java.lang.String currentSkinPath) {
        return false;
    }
    
    /**
     * 获取 List<SkinView> 通过 activity
     */
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.lv.library_core.base.ui.activity.skin.attr.SkinView> getSkinViews(@org.jetbrains.annotations.NotNull()
    com.lv.library_core.base.ui.activity.skin.callback.ISkinChangeListener changeListener) {
        return null;
    }
    
    /**
     * 注册
     */
    public final void register(@org.jetbrains.annotations.NotNull()
    com.lv.library_core.base.ui.activity.skin.callback.ISkinChangeListener changeListener, @org.jetbrains.annotations.NotNull()
    java.util.List<com.lv.library_core.base.ui.activity.skin.attr.SkinView> skinViews) {
    }
    
    /**
     * 获取当前皮肤资源
     */
    @org.jetbrains.annotations.NotNull()
    public final com.lv.library_core.base.ui.activity.skin.SkinResource getSkinResource() {
        return null;
    }
    
    public final void unregister(@org.jetbrains.annotations.NotNull()
    com.lv.library_core.base.ui.activity.skin.callback.ISkinChangeListener changeListener) {
    }
    
    private SkinManager() {
        super();
    }
}