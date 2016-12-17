package com.example.seungkyu.dreamtodream;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by junyepoh on 2016. 12. 14..
 */

public class WriteBoardPage extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_board_page);

        ImageButton leftButton = (ImageButton) findViewById(R.id.stopWrite);
        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Board.class);
                startActivity(intent);
                Toast.makeText(WriteBoardPage.this, "게시판으로 이동", Toast.LENGTH_SHORT).show();

            }
        });

        //글쓰기 넣어야 하는 부분

        ImageButton writeButton = (ImageButton) findViewById(R.id.writeFinishButton);
        writeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Board.class);
                startActivity(intent);
                Toast.makeText(WriteBoardPage.this, "글쓰기 완료", Toast.LENGTH_SHORT).show();



            }
        });


        View myButtonLayout = getLayoutInflater().inflate(R.layout.board_test_page,null);
        ActionBar ab = getSupportActionBar();

        ab.setCustomView(myButtonLayout);
        ab.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME|
        ActionBar.DISPLAY_SHOW_TITLE|ActionBar.DISPLAY_SHOW_CUSTOM);
    }


    public void onBtnClicked(View view){
        LinearLayout ll = (LinearLayout) findViewById(R.id.body);
        switch (view.getId()){
            case R.id.white:
                ll.setBackgroundColor(Color.WHITE);
                break;
            case R.id.black:
                ll.setBackgroundColor(Color.BLACK);

        }
    }
}
