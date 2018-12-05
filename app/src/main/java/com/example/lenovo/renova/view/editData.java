package com.example.lenovo.renova.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lenovo.renova.R;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import de.hdodenhof.circleimageview.CircleImageView;

public class editData extends AppCompatActivity {
    CircleImageView circleImageView;
    Bitmap SelectedPhoto;
    Button edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data);
        editImage();
        onclick();
    }
    public void editImage()
    {
        circleImageView=(CircleImageView)findViewById(R.id.editimg);
        circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(Intent.createChooser(i, "Select Your Photo"), 1);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
// if(resultCode == RESULT_OK) تعني ان كان قد تم الحصول على البيانات بدون مشاكل
        if (resultCode == RESULT_OK){
            if (requestCode == 1 ){
                Uri selectedImage = data.getData();
                InputStream imageStream = null;
                try {
                    imageStream = getContentResolver().openInputStream(selectedImage);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                SelectedPhoto = BitmapFactory.decodeStream(imageStream );
                ByteArrayOutputStream os = new ByteArrayOutputStream();
                SelectedPhoto.compress(Bitmap.CompressFormat.PNG,100,os);
                circleImageView.setImageBitmap(SelectedPhoto);
            }
}}
public void onclick()
{
    edit=(Button)findViewById(R.id.edit);
    edit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(editData.this,profileMem.class));
        }
    });

}


}
