package com.example.lenovo.renova.model;

import com.example.lenovo.renova.interfacee.MVP;
import com.example.lenovo.renova.list.reserveList;

import java.util.ArrayList;

public class reservationModel implements MVP.interfaces.Model {
    @Override
    public ArrayList getdata() {
        ArrayList<reserveList>arrayList=new ArrayList<reserveList>();
        arrayList.add(new reserveList("اليوم","5.00 م","9.00 م"));
        arrayList.add(new reserveList("غدا","5.00 م","9.00 م"));
        arrayList.add(new reserveList("الجمعه 2/11","3.00 م","9.00 م"));
        arrayList.add(new reserveList("السبت 3/11","5.00 م","9.00 م"));
        arrayList.add(new reserveList("اليوم 4/11","5.00 م","9.00 م"));
        arrayList.add(new reserveList("اليوم 5/11","5.00 م","9.00 م"));
         return arrayList;
    }
}
