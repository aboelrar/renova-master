package com.example.lenovo.renova.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.lenovo.renova.R;

public class profileMem extends AppCompatActivity {
    LinearLayout myproducts,myappoienments,editData;
    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_mem);
        bottomNav();
        onclick();
    }

    public void bottomNav() {
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.products) {
                    startActivity(new Intent(profileMem.this, products.class));
                } else if (item.getItemId() == R.id.profile) {
                    startActivity(new Intent(profileMem.this, profileMem.class));

                }else if(item.getItemId()==R.id.searchnav)
                {
                    startActivity(new Intent(profileMem.this, searchActivity.class));

                }
                return true;
            }
        });
    }
    public void onclick()
    {
        myproducts=(LinearLayout)findViewById(R.id.myproducts);
        myproducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(profileMem.this,products.class));
            }
        });
        logout=(Button)findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(profileMem.this,Login.class));

            }
        });
        myappoienments=(LinearLayout)findViewById(R.id.myappoienments);
        myappoienments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(profileMem.this,appoienments.class));

            }
        });
        editData=(LinearLayout)findViewById(R.id.editdata);
        editData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(profileMem.this,editData.class));
            }
        });
    }
}