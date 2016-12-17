package com.example.seungkyu.dreamtodream;

import java.io.InputStream;
import java.net.URL;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;



public class CompanyViewPage extends FragmentActivity {
    ImageButton startSleep;
    ImageView mImgTrans;
    Bitmap mBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {   //상태바 색
            getWindow().setStatusBarColor(Color.parseColor("#FF48D1CC"));}


        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_company_start_view);






        startSleep = (ImageButton) findViewById(R.id.startSleep);
        mImgTrans = (ImageView) findViewById(R.id.imgTranslate);


        startSleep.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                Intent intent =  new Intent(getApplicationContext(),StartCharity.class);
                startActivity(intent);

            }
        });

        new LoadImage().execute("http://52.78.129.84:3000/images/test2.png");
    }



    private class LoadImage extends AsyncTask<String, String, Bitmap> {

        ProgressDialog pDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(CompanyViewPage.this);
            pDialog.setMessage("이미지 로딩중입니다...");
            pDialog.show();
        }

        protected Bitmap doInBackground(String... args) {
            try {
                mBitmap = BitmapFactory
                        .decodeStream((InputStream) new URL(args[0])
                                .getContent());

            } catch (Exception e) {
                e.printStackTrace();
            }
            return mBitmap;
        }

        protected void onPostExecute(Bitmap image) {

            if (image != null) {
                mImgTrans.setImageBitmap(image);
                pDialog.dismiss();

            } else {
                pDialog.dismiss();
                Toast.makeText(CompanyViewPage.this, "이미지가 존재하지 않습니다.",
                        Toast.LENGTH_SHORT).show();

            }
        }
    }
}
