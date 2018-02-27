package com.yq.collapsible_recyclerview_adapter.expandable_adapter_library;

/**
 * Created by Administrator on 2018/2/26.
 * ChildModel 包装类
 */

public class ExpandableChildModel<T> {
    public T childModel;
    public boolean isChecked;

    public ExpandableChildModel(T childModel) {
        this.childModel = childModel;
        this.isChecked = false;
    }

}
