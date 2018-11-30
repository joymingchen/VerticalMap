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

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class PlayIndicatorBar extends View {
    private int a;
    private int b;
    private List<Boolean> c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private Paint n;
    private Paint o;
    private Paint p;
    private Paint q;
    private Paint r;
    private Bitmap s;
    private Bitmap t;
    private Canvas u;

    public PlayIndicatorBar(Context var1) {
        this(var1, (AttributeSet)null);
    }

    public PlayIndicatorBar(Context var1, @Nullable AttributeSet var2) {
        this(var1, var2, -1);
    }

    public PlayIndicatorBar(Context var1, @Nullable AttributeSet var2, int var3) {
        super(var1, var2, var3);
        this.a = 7;
        this.b = 2;
        int var4 = UIUtils.a(10.0F);
        this.d = var4;
        int var5 = UIUtils.a(15.0F);
        this.e = var5;
        int var6 = UIUtils.a(7.5F);
        this.f = var6;
        int var7 = UIUtils.a(3.0F);
        this.g = var7;
        int var8 = UIUtils.a(2.5F);
        this.h = var8;
        this.i = -2695450;
        this.j = -167107;
        this.k = -1;
        this.l = -1;
        int var9 = UIUtils.a(12.0F);
        this.m = var9;
        this.a();
    }

    private void a() {
        ArrayList var1 = new ArrayList();
        this.c = var1;
        Paint var2 = new Paint(1);
        this.n = var2;
        Paint var3 = this.n;
        Paint.Style var4 = Paint.Style.FILL;
        var3.setStyle(var4);
        Paint var5 = this.n;
        int var6 = this.i;
        var5.setColor(var6);
        Paint var7 = new Paint(1);
        this.o = var7;
        Paint var8 = this.o;
        Paint.Style var9 = Paint.Style.FILL;
        var8.setStyle(var9);
        Paint var10 = this.o;
        int var11 = this.j;
        var10.setColor(var11);
        Paint var12 = new Paint(1);
        this.p = var12;
        Paint var13 = this.p;
        Paint.Style var14 = Paint.Style.STROKE;
        var13.setStyle(var14);
        Paint var15 = this.p;
        int var16 = this.k;
        var15.setColor(var16);
        Paint var17 = this.p;
        float var18 = (float)this.h;
        var17.setStrokeWidth(var18);
        Paint var19 = new Paint(1);
        this.q = var19;
        Paint var20 = this.q;
        float var21 = (float)this.m;
        var20.setTextSize(var21);
        Paint var22 = this.q;
        int var23 = this.l;
        var22.setColor(var23);
        Paint var24 = this.q;
        Paint.Align var25 = Paint.Align.CENTER;
        var24.setTextAlign(var25);
        Paint var26 = new Paint(1);
        this.r = var26;
        Resources var27 = this.getResources();
        int var28 = R.drawable.exercise_pk_indicator_right_icon;
        Bitmap var29 = ((BitmapDrawable)var27.getDrawable(var28)).getBitmap();
        this.s = var29;
        Resources var30 = this.getResources();
        int var31 = R.drawable.exercise_pk_indicator_wrong_icon;
        Bitmap var32 = ((BitmapDrawable)var30.getDrawable(var31)).getBitmap();
        this.t = var32;
    }

    private void a(float var1, float var2, float var3, float var4, String var5) {
        int var6 = (int)var1;
        int var7 = (int)var2;
        int var8 = (int)(var1 + var3);
        int var9 = (int)(var2 + var4);
        Rect var10 = new Rect(var6, var7, var8, var9);
        Paint.FontMetricsInt var11 = this.q.getFontMetricsInt();
        int var12 = var10.bottom;
        int var13 = var10.top;
        int var14 = var12 + var13;
        int var15 = var11.bottom;
        int var16 = var14 - var15;
        int var17 = var11.top;
        float var18 = (float)(var16 - var17) * 1.0F / 2.0F;
        Canvas var19 = this.u;
        float var20 = (float)var10.centerX();
        Paint var21 = this.q;
        var19.drawText(var5, var20, var18, var21);
    }

    public void a(int var1, List<Boolean> var2) {
        this.c = var2;
        this.setCurrentIndex(var1);
    }

    protected void onDraw(Canvas var1) {
        super.onDraw(var1);
        this.u = var1;
        float var2 = (float)this.e;
        float var3 = (float)this.g * 1.0F / 2.0F;
        float var4 = var2 - var3;
        float var5 = (float)this.d;
        int var6 = this.d * 2;
        int var7 = this.a + -1;
        int var8 = var6 * var7;
        int var9 = this.e * 2;
        int var10 = var8 + var9;
        int var11 = this.f;
        int var12 = this.a + -1;
        int var13 = var11 * var12;
        int var14 = var10 + var13;
        int var15 = this.d;
        float var16 = (float)(var14 - var15);
        float var17 = (float)this.g * 1.0F / 2.0F;
        float var18 = var4 + var17;
        Paint var19 = this.n;
        var1.drawRect(var5, var4, var16, var18, var19);
        int var20 = 0;

        while(true) {
            int var21 = this.a;
            if(var20 >= var21) {
                return;
            }

            int var22 = this.d * 2;
            int var23 = this.f;
            int var24 = (var22 + var23) * var20;
            int var25 = this.d;
            float var26 = (float)(var24 + var25);
            float var27 = (float)this.e;
            float var28 = (float)this.d;
            Paint var29 = this.n;
            int var30 = this.d * 2;
            int var31 = this.d * 2;
            Rect var32 = new Rect(0, 0, var30, var31);
            float var33 = (float)this.d;
            int var34 = (int)(var26 - var33);
            float var35 = (float)this.d;
            int var36 = (int)(var27 - var35);
            float var37 = (float)this.d;
            int var38 = (int)(var26 + var37);
            int var39 = (int)((float)this.d + var27);
            Rect var40 = new Rect(var34, var36, var38, var39);
            int var41 = this.b;
            if(var20 != var41) {
                int var42 = this.b;
                int var43 = this.c.size() + -1;
                if(var42 != var43) {
                    if(((Boolean)this.c.get(var20)).booleanValue()) {
                        Bitmap var44 = this.s;
                        Paint var45 = this.r;
                        var1.drawBitmap(var44, (Rect)null, var40, var45);
                    } else {
                        Bitmap var46 = this.t;
                        Paint var47 = this.r;
                        var1.drawBitmap(var46, (Rect)null, var40, var47);
                    }
                } else {
                    int var48 = this.d * 2;
                    int var49 = this.f;
                    int var50 = (var48 + var49) * var20;
                    int var51 = this.e;
                    float var52 = (float)(var50 + var51);
                    int var53 = this.e;
                    int var54 = this.h;
                    float var55 = (float)(var53 - var54);
                    Paint var56 = this.o;
                    Paint var57 = this.p;
                    var1.drawCircle(var52, var27, var55, var57);
                    var1.drawCircle(var52, var27, var55, var56);
                    float var58 = var52 - var55;
                    float var59 = var27 - var55;
                    float var60 = var55 * 2.0F;
                    float var61 = var55 * 2.0F;
                    StringBuilder var62 = new StringBuilder();
                    int var63 = var20 + 1;
                    String var64 = var62.append(var63).append("").toString();
                    this.a(var58, var59, var60, var61, var64);
                }
            } else {
                int var65 = this.b;
                if(var20 > var65) {
                    int var66 = this.d * 2;
                    int var67 = this.f;
                    int var68 = var66 + var67;
                    int var69 = var20 + -1;
                    int var70 = var68 * var69;
                    int var71 = this.e * 2;
                    int var72 = var70 + var71;
                    int var73 = this.f;
                    int var74 = var72 + var73;
                    int var75 = this.d;
                    float var76 = (float)(var74 + var75);
                    var1.drawCircle(var76, var27, var28, var29);
                    float var77 = var76 - var28;
                    float var78 = var27 - var28;
                    float var79 = var28 * 2.0F;
                    float var80 = var28 * 2.0F;
                    StringBuilder var81 = new StringBuilder();
                    int var82 = var20 + 1;
                    String var83 = var81.append(var82).append("").toString();
                    this.a(var77, var78, var79, var80, var83);
                } else {
                    int var84 = this.c.size();
                    if(var20 < var84) {
                        if(((Boolean)this.c.get(var20)).booleanValue()) {
                            Bitmap var85 = this.s;
                            Paint var86 = this.r;
                            var1.drawBitmap(var85, (Rect)null, var40, var86);
                        } else {
                            Bitmap var87 = this.t;
                            Paint var88 = this.r;
                            var1.drawBitmap(var87, (Rect)null, var40, var88);
                        }
                    } else {
                        Bitmap var89 = this.t;
                        Paint var90 = this.r;
                        var1.drawBitmap(var89, var32, var40, var90);
                    }
                }
            }

            ++var20;
        }
    }

    protected void onMeasure(int var1, int var2) {
        super.onMeasure(var1, var2);
        int var3 = this.d * 2;
        int var4 = this.a + -1;
        int var5 = var3 * var4;
        int var6 = this.e * 2;
        int var7 = var5 + var6;
        int var8 = this.f;
        int var9 = this.a + -1;
        int var10 = var8 * var9;
        int var11 = var7 + var10;
        int var12 = this.e * 2;
        this.setMeasuredDimension(var11, var12);
    }

    public void setCurrentIndex(int var1) {
        this.b = var1;
        this.postInvalidate();
    }

    public void setQuestionCount(int var1) {
        this.a = var1;
    }
}
