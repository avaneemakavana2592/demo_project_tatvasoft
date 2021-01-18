package com.demo.practical.ui.Utility.advance_adapter;

import androidx.annotation.UiThread;

public interface OnSelectionChangeListener<T> {

    @UiThread
    void onSelectionChange(T t, boolean isSelected);
}
