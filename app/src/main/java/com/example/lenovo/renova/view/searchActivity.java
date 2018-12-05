package com.example.lenovo.renova.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.lenovo.renova.R;

public class searchActivity extends AppCompatActivity {
    Button search;
    LinearLayout skip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        goToSearchResult();
    }

    public void goToSearchResult()
    {
        search=(Button)findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(searchActivity.this,search.class));
            }
        });
        skip=(LinearLayout)findViewById(R.id.skip);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(searchActivity.this,search.class));
                }
        });
    }
}
