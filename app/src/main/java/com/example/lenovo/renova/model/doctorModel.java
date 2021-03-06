package com.example.lenovo.renova.model;

import com.example.lenovo.renova.R;
import com.example.lenovo.renova.interfacee.MVP;
import com.example.lenovo.renova.interfacee.searchInterface;
import com.example.lenovo.renova.list.doctorlist;
import com.example.lenovo.renova.list.tasneefList;

import java.util.ArrayList;

public class doctorModel implements searchInterface.interfaces.Model {
    @Override
    public ArrayList getdata() {
        ArrayList<doctorlist>arrayList=new ArrayList<doctorlist>();
        arrayList.add(new doctorlist("دكتور محمود عبدالحميد","150 ريال","الرياض ,المملكه العربيه السعوديه","استشارى جراحة التجميل والليزر",R.drawable.mahmoud));
        arrayList.add(new doctorlist("دكتور سعيد السيسى","140 ريال","الرياض ,المملكه العربيه السعوديه","استشارى جراحات التجميل",R.drawable.fathi));
        arrayList.add(new doctorlist("دكتور محمد السيد","160 ريال","الرياض ,المملكه العربيه السعوديه","أستاذ جراحة التجميل و الليزر و الوجة و الفكين",R.drawable.ibraheem));
        arrayList.add(new doctorlist("دكتور هانى محمد","100 ريال","الرياض ,المملكه العربيه السعوديه","اخصائي جراحة التجميل والحروق والليزر",R.drawable.dictor));
        return arrayList; }

    @Override
    public ArrayList getTasneefData() {
        ArrayList<tasneefList>arrayList=new ArrayList<tasneefList>();
        arrayList.add(new tasneefList("تصنيف"));
        arrayList.add(new tasneefList("الاعلى سعرا"));
        arrayList.add(new tasneefList("الاقل سعرا"));
        arrayList.add(new tasneefList("الاكثر تقييما"));
        return arrayList;
    }
}
