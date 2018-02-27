package com.yq.collapsible_recyclerview_adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yq.collapsible_recyclerview_adapter.expandable_adapter_library.BaseViewHolder;
import com.yq.collapsible_recyclerview_adapter.expandable_adapter_library.ExpandableBaseAdapter;
import com.yq.collapsible_recyclerview_adapter.expandable_adapter_library.ExpandableChildModel;
import com.yq.collapsible_recyclerview_adapter.expandable_adapter_library.ExpandableGroupModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/2/26.
 */

public class TestAdapter extends ExpandableBaseAdapter<Classs> {

    public TestAdapter(Context mContext, List<Classs> groupList) {
        super(mContext, groupList);
    }

    @Override
    protected void initData(List<Classs> groupList) {
        for (int i = 0; i < groupList.size(); i++) {
            Classs cls = groupList.get(i);
            List<Student> list = cls.getStudentList();
            List<ExpandableChildModel> extStudentList = new ArrayList<>();
            for (int j = 0; j < list.size(); j++) {
                ExpandableChildModel<Student> exStudent = new ExpandableChildModel<>(list.get(i));
                extStudentList.add(exStudent);
            }
            ExpandableGroupModel<Classs, ExpandableChildModel> exCls = new ExpandableGroupModel<>(cls, extStudentList);
            expandableGroupList.add(exCls);
        }
    }

    @Override
    protected BaseViewHolder onCreateParentViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_common, parent, false);
        return new GroupHolder(itemView);
    }

    @Override
    protected BaseViewHolder onCreateChildViewHOlder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_common, parent, false);
        return new ChildHolder(itemView);
    }

    /**
     * 父菜单 ViewHolder
     */
    public class GroupHolder extends BaseViewHolder {

        TextView tv;

        public GroupHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv_content);
        }

        @Override
        public void onBindViewHolder(int pos) {
            ExpandableGroupModel exGroupModel = (ExpandableGroupModel) data.get(pos);
            tv.setText(((Classs) exGroupModel.groupModel).getName());
        }
    }

    /**
     * 子菜单 ViewHolder
     */
    public class ChildHolder extends BaseViewHolder {

        TextView tv;

        public ChildHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv_content);
        }

        @Override
        public void onBindViewHolder(int pos) {
            ExpandableChildModel exChildModel = (ExpandableChildModel) data.get(pos);
            tv.setText(((Student) exChildModel.childModel).getName());
        }
    }


}
