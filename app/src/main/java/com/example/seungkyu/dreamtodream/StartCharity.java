package com.example.seungkyu.dreamtodream;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import sincntx.appboard.Appboard;

public class StartCharity extends FragmentActivity {
    Button startCharity;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

            if (Build.VERSION.SDK_INT >= 21) {   //상태바 색
                getWindow().setStatusBarColor(Color.parseColor("#FF48D1CC"));}


        requestWindowFeature(Window.FEATURE_NO_TITLE);



        setContentView(R.layout.activity_charity_page);

        startCharity = (Button) findViewById(R.id.startCharity);

        Drawable alpha = ((ImageView)findViewById(R.id.give_page)).getDrawable();
        alpha.setAlpha(50);


        startCharity.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                Intent intent =  new Intent(getApplicationContext(),CharityRanking.class);
                startActivity(intent);

            }
        });

    }
}
