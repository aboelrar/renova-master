package com.example.lenovo.renova.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.lenovo.renova.R;
import com.example.lenovo.renova.library.savedId;
import com.example.lenovo.renova.list.doctorlist;
import com.example.lenovo.renova.view.doctorDetails;
import com.example.lenovo.renova.view.search;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class doctorAdapter extends RecyclerView.Adapter<doctorAdapter.doctorHolder> {
    Context context;
    ArrayList<doctorlist>mylist;
    int resource;
    public static final String deleteFav="http://webdesign.be4em.info/renova_en/User/deleteFavoriteDoctor/54732964/259743/";
    public static final String addFav="http://webdesign.be4em.info/renova_en/User/addFavoriteDoctor/54732964/259743/";
    savedId savedId;
    String id;

    public doctorAdapter(Context context, ArrayList<doctorlist> mylist,int resource) {
        this.context = context;
        this.mylist = mylist;
        this.resource=resource;
    }

    @NonNull
    @Override
    public doctorHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(resource,viewGroup,false);
        doctorHolder doctorHolder=new doctorHolder(view);
        return doctorHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final doctorHolder viewHolder, final int i) {
        if(resource==R.layout.searchitem){
     viewHolder.name.setText(mylist.get(i).getName().toString());
     viewHolder.spechlist.setText(mylist.get(i).getSpeclist().toString());
     viewHolder.fees.setText(mylist.get(i).getFees().toString());
     viewHolder.address.setText(mylist.get(i).getLocation().toString());
     viewHolder.profileImg.setImageResource(mylist.get(i).getProfileImage());
     viewHolder.profile.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Bundle b = new Bundle();
             Intent intent=new Intent(context,doctorDetails.class);
             String name = viewHolder.name.getText().toString();
             String fees = viewHolder.fees.getText().toString();
             String address = viewHolder.address.getText().toString();
             b.putString("fees", fees);
             b.putString("name", name);
             b.putString("address", address);
             intent.putExtras(b);
             v.getContext().startActivity(intent);
         }
     });
     viewHolder.searchitem.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Bundle b = new Bundle();
             Intent intent=new Intent(context,doctorDetails.class);
             String name = viewHolder.name.getText().toString();
             String fees = viewHolder.fees.getText().toString();
             String address = viewHolder.address.getText().toString();
             b.putString("fees", fees);
             b.putString("name", name);
             b.putString("address", address);
             intent.putExtras(b);
             v.getContext().startActivity(intent);

         }
     });
            savedId=new savedId();
          final   String id =savedId.getId(context);
            viewHolder.fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mylist.get(i).getFav()==false){
                    viewHolder.fav.setImageResource(R.drawable.ic_favorite_red_24dp);
                    addDeleteFav(id,addFav);
                    mylist.get(i).setFav(true);
                }else{
                    viewHolder.fav.setImageResource(R.drawable.ic_favorite_black_24dp);
                    addDeleteFav(id,deleteFav);
                    mylist.get(i).setFav(false);
                }
            }
        });}

    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }

    public class doctorHolder extends RecyclerView.ViewHolder {
        TextView name,address,fees,spechlist;
        ImageView profileImg,fav;
        LinearLayout searchitem;
        Button profile;
        public doctorHolder(@NonNull View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.doctorName);
            address=(TextView)itemView.findViewById(R.id.locaation);
            fees=(TextView)itemView.findViewById(R.id.fees);
            spechlist=(TextView)itemView.findViewById(R.id.speclist);
            profileImg=(ImageView)itemView.findViewById(R.id.prfileImage);
            searchitem=(LinearLayout)itemView.findViewById(R.id.searchitem);
            fav=(ImageView)itemView.findViewById(R.id.fav);
            profile=(Button) itemView.findViewById(R.id.profile);
        }
    }

    public void addDeleteFav(final String id,final String Url)
    {
        String AddFavourite="";
        StringRequest addFav=new StringRequest(Request.Method.GET, Url+savedId.getId(context)+"/"+id, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    if(jsonObject.getString("status").equals("1")) {
                        Toast.makeText(context, "" + jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                    }else if(jsonObject.getString("status").equals("2"))
                    {
                        Toast.makeText(context,""+jsonObject.getString("message") , Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    Toast.makeText(context, "catch", Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "error", Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(addFav);
    }
}
