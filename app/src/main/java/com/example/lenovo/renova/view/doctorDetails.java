package com.example.lenovo.renova.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.renova.R;
import com.example.lenovo.renova.adapter.doctorAdapter;
import com.example.lenovo.renova.adapter.reservationAdapter;
import com.example.lenovo.renova.interfacee.MVP;
import com.example.lenovo.renova.presenter.reservationPresenter;

import java.util.ArrayList;

public class doctorDetails extends AppCompatActivity implements MVP.interfaces.View{
RecyclerView reservationList;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    reservationPresenter reservationPresenter;
    ImageView fav;
    Boolean isfav=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        reservationPresenter=new reservationPresenter(this);
        reservationPresenter.getData();
        getData();
        bottomNav();
        isFav();

    }

    @Override
    public void element() {
        reservationList=(RecyclerView)findViewById(R.id.reservationList);
    }

    @Override
    public void setviewdata(ArrayList data) {
        layoutManager=new LinearLayoutManager(doctorDetails.this,LinearLayoutManager.HORIZONTAL,false);
        reservationList.setLayoutManager(layoutManager);
        adapter=new reservationAdapter(doctorDetails.this,data);

        reservationList.setAdapter(adapter);
    }
    public void getData()
    {
        Bundle b = getIntent().getExtras();
        final String receivingdata = b.getString("name");
        final String receivingdetails = b.getString("fees");
        final String addresss = b.getString("address");

        TextView name = (TextView) findViewById(R.id.name);
        TextView fees = (TextView) findViewById(R.id.fees);
        TextView address = (TextView) findViewById(R.id.address);

        name.setText(receivingdata);
        fees.setText(receivingdetails);
        address.setText(addresss);
    }
    public void bottomNav()
        {
            BottomNavigationView bottomNavigationView=(BottomNavigationView)findViewById(R.id.nav);
            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    if(item.getItemId()==R.id.products)
                    {
                        startActivity(new Intent(doctorDetails.this,products.class));
                    }else if(item.getItemId()==R.id.profile)
                    {
                        startActivity(new Intent(doctorDetails.this,profileMem.class));

                    }
                    else if(item.getItemId()==R.id.searchnav)
                    {
                        startActivity(new Intent(doctorDetails.this, searchActivity.class));

                    }
                    return true;
                }
            });

    }

    public void isFav() {
        fav = (ImageView) findViewById(R.id.fav);
        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isfav == false) {
                    fav.setImageResource(R.drawable.ic_favorite_red_24dp);
                    Toast.makeText(doctorDetails.this, "Added Successfully", Toast.LENGTH_SHORT).show();
                    isfav = true;
                } else {
                    fav.setImageResource(R.drawable.ic_favorite_black_24dp);
                    Toast.makeText(doctorDetails.this, "item Deleted", Toast.LENGTH_SHORT).show();
                    isfav = false;
                }
            }
        });

    }
}
