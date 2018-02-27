package com.yq.collapsible_recyclerview_adapter;

import java.util.List;

/**
 * Created by Administrator on 2018/2/26.
 */

public class Classs {

    private String name;
    private List<Student> studentList;

    public Classs(String name, List<Student> studentList) {
        this.name = name;
        this.studentList = studentList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
