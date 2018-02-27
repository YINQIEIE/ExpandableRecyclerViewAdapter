package com.yq.collapsible_recyclerview_adapter.expandable_adapter_library;

import java.util.List;

/**
 * Created by Administrator on 2018/2/26.
 * GroupModel 包装类
 */

public class ExpandableGroupModel<GroupModel, T extends ExpandableChildModel> {
    public GroupModel groupModel;
    public List<T> childList;
    public boolean isExpanded;

    public ExpandableGroupModel(GroupModel groupModel, List<T> childList) {
        this.groupModel = groupModel;
        this.childList = childList;
        this.isExpanded = false;
    }

    public List<T> getChildList() {
        return childList;
    }

    public boolean isExpanded() {
        return isExpanded;
    }
}
