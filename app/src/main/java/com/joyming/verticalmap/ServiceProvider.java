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


public class ServiceProvider {
    private static ServiceProvider a = null;
    private IServiceManager b = null;

    private ServiceProvider() {
    }

    public static ServiceProvider a() {
        if(a == null) {
            a = new ServiceProvider();
        }

        return a;
    }

    public void a(IServiceManager var1) {
        this.b = var1;
    }

    public IServiceManager b() {
        return this.b;
    }
}

