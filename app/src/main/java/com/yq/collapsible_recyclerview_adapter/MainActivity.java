package com.yq.collapsible_recyclerview_adapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.yq.collapsible_recyclerview_adapter.expandable_adapter_library.ExceptionLinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    private List<Classs> clsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = (RecyclerView) findViewById(R.id.rv);
        LinearLayoutManager linearLayoutManager = new ExceptionLinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);
        initData();
        TestAdapter adapter = new TestAdapter(this, clsList);
        rv.setAdapter(adapter);
    }

    private void initData() {
        clsList = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            List<Student> list = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                Student student = new Student("张三" + j);
                list.add(student);
            }
            Classs cls = new Classs(i + "班", list);
            clsList.add(cls);
        }

    }
}
