package com.jdm5908_bw.ist402.levic_curve;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;

public class FractalView extends View{

    private float x1, x2, y1, y2;
    public int level;
    private Fractal fractal;
    private ColorDrawable colorDrawable;

    public FractalView(Context context){
        super(context);
        level = 2;
        fractal = new Fractal();
    }

    protected void onDraw(Canvas canvas){
        x1 = canvas.getWidth() / 3;
        y1 = canvas.getHeight() / 4;
        x2 = canvas.getWidth() - x1;
        y2 = y1;
        canvas.drawColor(Color.BLACK); // Background
        fractal.drawCCurve(canvas, x1, y1, x2, y2, level);
    }
}
