package com.yq.collapsible_recyclerview_adapter.expandable_adapter_library;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/2/24.
 * This is a base Expandable RecyclerView adapter
 */

public abstract class ExpandableBaseAdapter<GroupModel> extends RecyclerView.Adapter<BaseViewHolder> {

    private final int itemTypeParent = 1;
    private final int itemTypeChild = 2;

    protected Context mContext;
    //转换成包装类的数据集
    protected List<ExpandableGroupModel> expandableGroupList = new ArrayList<>();
    //adapter 数据源
    protected List data;
    //二级菜单点击监听
    private OnChildClicklistener onChildClickListener;

    public ExpandableBaseAdapter(Context mContext, List<GroupModel> groupList) {
        this.mContext = mContext;
        initData(groupList);
        data = new ArrayList();
        data.addAll(expandableGroupList);
    }

    /**
     * 将数据集转换成符合要求的包装类数据集
     *
     * @param groupList 原始数据集
     */
    protected abstract void initData(List<GroupModel> groupList);

    @Override
    public int getItemCount() {
        int size = expandableGroupList.size();
        for (int i = 0; i < expandableGroupList.size(); i++) {
            size += expandableGroupList.get(i).isExpanded ? expandableGroupList.get(i).getChildList().size() : 0;
        }
        return size;
    }

    @Override
    public int getItemViewType(int position) {
        if (data.get(position) instanceof ExpandableGroupModel)
            return itemTypeParent;
        else if (data.get(position) instanceof ExpandableChildModel)
            return itemTypeChild;
        return super.getItemViewType(position);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == itemTypeParent)
            return onCreateParentViewHolder(parent, viewType);
        else if (viewType == itemTypeChild)
            return onCreateChildViewHOlder(parent, viewType);
        else
            throw new RuntimeException("itemType is not defined!");
    }

    protected abstract BaseViewHolder onCreateParentViewHolder(ViewGroup parent, int viewType);

    protected abstract BaseViewHolder onCreateChildViewHOlder(ViewGroup parent, int viewType);


    @Override
    public void onBindViewHolder(final BaseViewHolder holder, final int position) {
        holder.onBindViewHolder(position);
        if (getItemViewType(position) == itemTypeParent) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                Object obj = data.get(position);

                @Override
                public void onClick(View v) {
                    onGroupItemClick();
                }

                private void onGroupItemClick() {
                    ExpandableGroupModel groupModel = (ExpandableGroupModel) obj;
                    if (!groupModel.isExpanded) {//菜单未展开，插入对应子菜单集合，并 notify
                        //从点击位置的下一个位置插入数据
                        data.addAll(position + 1, groupModel.getChildList());
                        holder.onExpand();
                        //通知 adapter 更新
                        notifyItemRangeInserted(position + 1, groupModel.getChildList().size());
                        groupModel.isExpanded = true;
                    } else {//菜单已展开,移除对应子菜单集合，并notify
                        data.removeAll(groupModel.getChildList());
                        holder.onCollapse();
                        notifyItemRemoved(position + 1);
                        groupModel.isExpanded = false;
                    }
                    //更新位置信息，否则后面的位置信息不会变
                    //注；不能设置为(0,data.size())，会引起数据错乱
                    notifyItemRangeChanged(position, data.size() - position);
                    holder.onGroupClick(position);
                }
            });

        } else if (getItemViewType(position) == itemTypeChild) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        holder.onChildClick(position);
                        if (null != onChildClickListener)
                            onChildClickListener.onChildClick((ExpandableChildModel) data.get(position));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    /**
     * 子菜单点击监听回调接口
     */
    public interface OnChildClicklistener {
        void onChildClick(ExpandableChildModel model);
    }

    public void setOnChildClickListener(OnChildClicklistener onchildClickListener) {
        this.onChildClickListener = onchildClickListener;
    }

}
