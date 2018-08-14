package com.app.retrofitparsing.utils;

import android.app.ProgressDialog;
import android.content.Context;

public class CommonUtils {

    private static ProgressDialog dialog;

    public static void startProgressDialog(Context context) {
        /**
         * Progress Dialog for User Interaction
         */
        dialog = new ProgressDialog(context);
        dialog.setTitle("Process");
        dialog.setMessage("Please Wait..");
        dialog.show();
    }

    public static void dismissProgressDialog(Context context) {
        if (dialog.isShowing()) {
            dialog.dismiss();
        }
    }
}
