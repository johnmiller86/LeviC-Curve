package com.jdm5908_bw.ist402.levic_curve;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView levelsTV;
    private Integer level;
    private RelativeLayout relativeLayout;
    private FractalView fractalView;
    static ColorDrawable colorDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        fractalView = new FractalView(this);
        relativeLayout.addView(fractalView, 0);
        level = 1;
        levelsTV = (TextView) findViewById(R.id.textView1);
        colorDrawable = new ColorDrawable(ContextCompat.getColor(this, R.color.colorAccent));

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        levelsTV.setTextColor(colorDrawable.getColor());
        actionBar.setDisplayOptions(actionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.actionbar_layout);
        actionBar.setBackgroundDrawable(colorDrawable);
        actionBar.setTitle(Html.fromHtml("<font color='#000000'><center>" + getString(R.string.app_name) + "</center></font>"));
    }

    public void drawFractal(View view){
        fractalView.level = level;
        fractalView.invalidate();
    }

    public void stepUp(View view){
        if (level < 14){
            level++;
            levelsTV.setText(level.toString());
        }
    }

    public void stepDown(View view){
        if (level > 1){
            level--;
            levelsTV.setText(level.toString());
        }
    }
}
