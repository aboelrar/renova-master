package com.example.lenovo.renova.view;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.renova.R;
import com.example.lenovo.renova.adapter.imageAdapter;

import me.relex.circleindicator.CircleIndicator;

public class productDetails extends AppCompatActivity {
    ViewPager viewPager;
    imageAdapter viewimage;
    CircleIndicator circleIndicator;
    ImageView back,fav;
    TextView productDetails;
Boolean IsFav=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        viewPager();
        getData();
        buy();
        appBar();
        isFav();
    }

    public void viewPager()
    {

        String[] image = {"https://upload.wikimedia.org/wikipedia/commons/thumb/d/d5/Bayer_Aspirin_Pills.jpg/220px-Bayer_Aspirin_Pills.jpg", "https://cdn1.medicalnewstoday.com/content/images/articles/301/301766/bottle-of-aspirin.jpg"
                ,"https://images.yaoota.com/lRoBjVMWBs49y6mezOfvsS3woRQ=/trim/yaootaweb-production/media/crawledproductimages/1500779ab251778b6db558b199b70607a98179a7.jpg", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/42/Regular_strength_enteric_coated_aspirin_tablets.jpg/290px-Regular_strength_enteric_coated_aspirin_tablets.jpg"};
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewimage = new imageAdapter(productDetails.this, image);
        viewPager.setAdapter(viewimage);
        circleIndicator=(CircleIndicator)findViewById(R.id.indicator);
        circleIndicator.setViewPager(viewPager);
    }
    public void getData()
    {
        Bundle b = getIntent().getExtras();
        final String receivingdata = b.getString("name");
        final String receivingdetails = b.getString("productPrice");

        TextView name = (TextView) findViewById(R.id.title);
        TextView price = (TextView) findViewById(R.id.price);

        name.setText(receivingdata);
        price.setText(receivingdetails);
    }
    public void buy()
    {
        Button buy=(Button)findViewById(R.id.buy);
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(productDetails.this,Login.class));

            }
        });
    }
    public void appBar()
    {
        productDetails=(TextView)findViewById(R.id.products);
        productDetails.setText("تفاصيل المنتج");
        back=(ImageView)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void isFav() {
        fav = (ImageView) findViewById(R.id.favicon);
        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (IsFav == false) {
                    fav.setImageResource(R.drawable.ic_favorite_red_24dp);
                    Toast.makeText(productDetails.this, "Added Successfully", Toast.LENGTH_SHORT).show();
                    IsFav = true;
                } else {
                    fav.setImageResource(R.drawable.ic_favorite_border_black_24dp);
                    Toast.makeText(productDetails.this, "item Deleted", Toast.LENGTH_SHORT).show();
                    IsFav = false;
                }
            }
        });

    }

}
