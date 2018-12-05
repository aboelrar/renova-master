package com.example.lenovo.renova.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.lenovo.renova.R;
import com.example.lenovo.renova.adapter.productAdapter;
import com.example.lenovo.renova.adapter.reservationAdapter;
import com.example.lenovo.renova.interfacee.MVP;
import com.example.lenovo.renova.presenter.productPresrenter;

import java.util.ArrayList;

public class products extends AppCompatActivity implements MVP.interfaces.View {
    RecyclerView productList;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    productPresrenter productPresrenter;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        productPresrenter=new productPresrenter(this);
        productPresrenter.getData();
        appBar();
    }

    @Override
    public void element() {
        productList=(RecyclerView)findViewById(R.id.productList);
    }

    @Override
    public void setviewdata(ArrayList data) {
        layoutManager=new LinearLayoutManager(products.this);
        productList.setLayoutManager(layoutManager);
        adapter=new productAdapter(products.this,data);
        productList.setAdapter(adapter);
    }
public void appBar()
{
  back=(ImageView)findViewById(R.id.back);
  back.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          finish();
      }
  });
}
}
