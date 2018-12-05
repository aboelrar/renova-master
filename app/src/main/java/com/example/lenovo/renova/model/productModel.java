package com.example.lenovo.renova.model;

import com.example.lenovo.renova.R;
import com.example.lenovo.renova.interfacee.MVP;
import com.example.lenovo.renova.interfacee.searchInterface;
import com.example.lenovo.renova.list.productList;

import java.util.ArrayList;

public class productModel implements MVP.interfaces.Model {
    @Override
    public ArrayList getdata() {
        ArrayList<productList>arrayList=new ArrayList<productList>();
        arrayList.add(new productList("علبه اسبرين","20 جنيه", R.drawable.asprine));
        arrayList.add(new productList("علبه كونجستال","30 جنيه", R.drawable.congestal));
        arrayList.add(new productList("علبه انتينال","15 جنيه", R.drawable.antinal));
        arrayList.add(new productList("علبه فلاجيل","20 جنيه", R.drawable.flagel));
        return arrayList;
    }


}
