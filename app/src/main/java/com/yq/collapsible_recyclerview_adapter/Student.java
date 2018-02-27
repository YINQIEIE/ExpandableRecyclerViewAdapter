package com.yq.collapsible_recyclerview_adapter;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/2/26.
 */

public class Student implements Serializable {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
