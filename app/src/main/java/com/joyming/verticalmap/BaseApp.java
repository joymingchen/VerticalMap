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
import android.app.Application;
import android.content.Context;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

public class BaseApp extends Application {
    private static Context a;
    private static Context b;

    public BaseApp() {
    }

    public static Context a() {
        Context var0;
        if (a == null) {
            var0 = b;
        } else {
            var0 = a;
        }

        return var0;
    }


    public void a(Activity var1) {
    }


    public void c() {
    }

    public void d() {
    }

    public String[] e() {
        return null;
    }


    public Object getSystemService(String var1) {
        IServiceManager var2 = ServiceProvider.a().b();
        Object var3;
        if (var2 != null) {
            var3 = var2.a(var1);
            if (var3 != null) {
                return var3;
            }
        }

        var3 = super.getSystemService(var1);
        return var3;
    }

    public void onCreate() {
        super.onCreate();
        b = this;
        a = this;
        this.c();

    }
}
