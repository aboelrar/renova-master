package com.example.lenovo.renova.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.lenovo.renova.R;
import com.example.lenovo.renova.adapter.doctorAdapter;
import com.example.lenovo.renova.adapter.tasneefAdapter;
import com.example.lenovo.renova.interfacee.MVP;
import com.example.lenovo.renova.presenter.appoienmentsPresenter;
import com.example.lenovo.renova.presenter.doctorPresenter;

import java.util.ArrayList;

public class appoienments extends AppCompatActivity implements MVP.interfaces.View{
   RecyclerView appoientmentList;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    com.example.lenovo.renova.presenter.appoienmentsPresenter appoienmentsPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appoienments);
        appoienmentsPresenter=new appoienmentsPresenter(this);
        appoienmentsPresenter.getData();

    }

    @Override
    public void element() {
        appoientmentList=(RecyclerView)findViewById(R.id.appoienmentslist);
    }

    @Override
    public void setviewdata(ArrayList data) {
        layoutManager=new LinearLayoutManager(appoienments.this);
        appoientmentList.setLayoutManager(layoutManager);
        adapter=new doctorAdapter(appoienments.this,data,R.layout.appoientmentitem);
        appoientmentList.setAdapter(adapter);
    }
}
