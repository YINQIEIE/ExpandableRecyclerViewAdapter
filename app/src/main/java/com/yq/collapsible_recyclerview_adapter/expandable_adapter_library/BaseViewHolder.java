package com.yq.collapsible_recyclerview_adapter.expandable_adapter_library;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Administrator on 2018/2/26.
 */

public abstract class BaseViewHolder extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    /**
     * 子类重写此方法进行 item 信息的设置
     *
     * @param pos 当前位置
     */
    public abstract void onBindViewHolder(int pos);

    /**
     * 父菜单展开时的回调
     * 不使用可以不重写
     */
    public void onExpand() {
    }

    /**
     * 父菜单折叠时的回调
     * 不使用可以不重写
     */
    public void onCollapse() {
    }

    /**
     * 父菜单点击回调
     * 不使用可以不重写
     *
     * @param position 位置
     */
    public void onGroupClick(int position) {
    }

    /**
     * 在快速展开关闭二级菜单时会因为 recyclerview 内部机制问题（可以理解为其内部的数据集还未来得及更新完）
     * 导致一些问题
     * 如一般的一级菜单和二级菜单数据类型是不同的
     *
     * @param position 位置
     * @throws Exception
     */
    public void onChildClick(int position) throws Exception {
    }

}
