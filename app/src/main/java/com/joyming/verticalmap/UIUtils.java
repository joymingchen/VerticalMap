package com.joyming.verticalmap;

/**
 * Created by JoymingChen on 2018/11/26.
 * Email：joymingchen@foxmail.com
 * If you have any question , you can send email to me .Thanks!
 */

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

public class UIUtils {
    public UIUtils() {
    }

    public static int a(float var0) {
        Display var1 = ((WindowManager)BaseApp.a().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics var2 = new DisplayMetrics();
        var1.getMetrics(var2);
        return (int)(var2.density * var0 + 0.5F);
    }

    public static int a(Activity var0) {
        int var1;
        if(var0 == null) {
            var1 = 0;
        } else {
            DisplayMetrics var2 = new DisplayMetrics();
            var0.getWindowManager().getDefaultDisplay().getMetrics(var2);
            var1 = var2.widthPixels;
        }

        return var1;
    }

    public static int a(Context var0, float var1) {
        return (int)(var0.getResources().getDisplayMetrics().density * var1 + 0.5F);
    }

    public static int b(float var0) {
        Display var1 = ((WindowManager)BaseApp.a().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics var2 = new DisplayMetrics();
        var1.getMetrics(var2);
        float var3 = var2.density;
        return (int)(var0 / var3 + 0.5F);
    }

    public static int b(Activity var0) {
        int var1;
        if(var0 == null) {
            var1 = 0;
        } else {
            DisplayMetrics var2 = new DisplayMetrics();
            var0.getWindowManager().getDefaultDisplay().getMetrics(var2);
            var1 = var2.heightPixels;
        }

        return var1;
    }

    public static int b(Context var0, float var1) {
        float var2 = var0.getResources().getDisplayMetrics().density;
        return (int)(var1 / var2 + 0.5F);
    }

    public static void c(Activity var0) {
        if(var0 != null) {
            InputMethodManager var1 = (InputMethodManager)var0.getSystemService("input_method");
            if(var0.getCurrentFocus() != null) {
                IBinder var2 = var0.getCurrentFocus().getWindowToken();
                var1.hideSoftInputFromWindow(var2, 0);
            }
        }
    }
}
