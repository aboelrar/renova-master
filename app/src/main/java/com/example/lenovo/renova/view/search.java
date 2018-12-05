package com.example.lenovo.renova.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.lenovo.renova.R;
import com.example.lenovo.renova.adapter.doctorAdapter;
import com.example.lenovo.renova.adapter.tasneefAdapter;
import com.example.lenovo.renova.interfacee.MVP;
import com.example.lenovo.renova.interfacee.searchInterface;
import com.example.lenovo.renova.list.tasneefList;
import com.example.lenovo.renova.presenter.doctorPresenter;

import java.util.ArrayList;

public class search extends AppCompatActivity implements searchInterface.interfaces.View {
RecyclerView doctorList;
RecyclerView.Adapter adapter;
tasneefAdapter tasneefAdapter;
RecyclerView.LayoutManager layoutManager;
    doctorPresenter doctorPresenter;
    Spinner tasneef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchresult);
        doctorPresenter=new doctorPresenter(this);
        doctorPresenter.getData();
        getSpinner();
    }

    @Override
    public void element() {
        doctorList=(RecyclerView)findViewById(R.id.doctorlist);

    }

    @Override
    public void setviewdata(ArrayList data) {
        layoutManager=new LinearLayoutManager(search.this);
        doctorList.setLayoutManager(layoutManager);
        adapter=new doctorAdapter(search.this,data,R.layout.searchitem);
        doctorList.setAdapter(adapter);
    }

    @Override
    public void setViewtasneefData(ArrayList datas) {
        tasneefAdapter=new tasneefAdapter(search.this,R.layout.spinneritem,datas);
        tasneef.setAdapter(tasneefAdapter);
    }

    public ArrayList getData()
    {
        ArrayList<tasneefList>arrayList=new ArrayList<tasneefList>();
        arrayList.add(new tasneefList("تصنيف"));
        arrayList.add(new tasneefList("الاعلى سعرا"));
        arrayList.add(new tasneefList("الاقل سعرا"));
        arrayList.add(new tasneefList("الاكثر تقييما"));
        arrayList.add(new tasneefList("الاقرب اليك"));

        return arrayList;
    }
    public void getSpinner()
    {
        tasneef=(Spinner)findViewById(R.id.sortlist);
        tasneefAdapter=new tasneefAdapter(search.this,R.layout.spinneritem,getData());
        tasneef.setAdapter(tasneefAdapter);
    }

}
