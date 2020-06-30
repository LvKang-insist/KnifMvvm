package com.lv.library_core.base.ui.activity.skin.callback;

import java.lang.System;

/**
 * 换肤的回调
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/lv/library_core/base/ui/activity/skin/callback/ISkinChangeListener;", "", "changeSkin", "", "skinResource", "Lcom/lv/library_core/base/ui/activity/skin/SkinResource;", "library-core_debug"})
public abstract interface ISkinChangeListener {
    
    public abstract void changeSkin(@org.jetbrains.annotations.NotNull()
    com.lv.library_core.base.ui.activity.skin.SkinResource skinResource);
}