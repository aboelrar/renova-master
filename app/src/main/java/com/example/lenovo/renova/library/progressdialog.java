package com.example.lenovo.renova.library;

import android.app.ProgressDialog;
import android.content.Context;

public class progressdialog {

    public void progressDialog(Context context)
    {
        final ProgressDialog pd = new ProgressDialog(context);
        pd.setMessage("Loading...");
        pd.show();
    }
}
