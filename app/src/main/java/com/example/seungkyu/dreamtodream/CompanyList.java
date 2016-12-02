package com.example.seungkyu.dreamtodream;


import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Fragment;

public class CompanyList extends AppCompatActivity {

    private ListView mDrawerList;
    private DrawerLayout mDrawerLayout;
    private ArrayAdapter<String> mAdapter;
    private ActionBarDrawerToggle mDrawerToggle;
    private String mActivityTitle;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_list);

        mDrawerList = (ListView)findViewById(R.id.navList);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mActivityTitle = getTitle().toString();

        addDrawerItems();
        setupDrawer();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);




        ListView listview ;
        ListViewAdapter adapter;


        // Adapter 생성
        adapter = new ListViewAdapter() ;

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.listview1);
        listview.setAdapter(adapter);



    // 첫 번째 아이템 추가.
    adapter.addItem(ContextCompat.getDrawable(this,R.drawable.ic_oldman),
            "Box","Account Box Black 36dp");
    // 두 번째 아이템 추가.
    adapter.addItem(ContextCompat.getDrawable(this,R.drawable.ic_man),
            "Circle","Account Circle Black 36dp");
    // 세 번째 아이템 추가.
    adapter.addItem(ContextCompat.getDrawable(this,R.drawable.ic_boy),
            "Ind","Assignment Ind Black 36dp");
    // 기본 생성 코드 및 ListView와 Adapter 생성 코드
    // ...
    adapter.addItem(ContextCompat.getDrawable(this,R.drawable.ic_boy),
            "Ind","Assignment Ind Black 36dp");
    // 기본 생성 코드 및 ListView와 Adapter 생성 코드
    adapter.addItem(ContextCompat.getDrawable(this,R.drawable.ic_boy),
            "Ind","Assignment Ind Black 36dp");
    // 기본 생성 코드 및 ListView와 Adapter 생성 코드
    adapter.addItem(ContextCompat.getDrawable(this,R.drawable.ic_boy),
            "Ind","Assignment Ind Black 36dp");
    // 기본 생성 코드 및 ListView와 Adapter 생성 코드
    adapter.addItem(ContextCompat.getDrawable(this,R.drawable.ic_boy),
            "Ind","Assignment Ind Black 36dp");
    // 기본 생성 코드 및 ListView와 Adapter 생성 코드
    adapter.addItem(ContextCompat.getDrawable(this,R.drawable.ic_boy),
            "Ind","Assignment Ind Black 36dp");
    // 기본 생성 코드 및 ListView와 Adapter 생성 코드
    adapter.addItem(ContextCompat.getDrawable(this,R.drawable.ic_boy),
            "Ind","Assignment Ind Black 36dp");
    // 기본 생성 코드 및 ListView와 Adapter 생성 코드
    adapter.addItem(ContextCompat.getDrawable(this,R.drawable.ic_boy),
            "Ind","Assignment Ind Black 36dp");
    // 기본 생성 코드 및 ListView와 Adapter 생성 코드
    adapter.addItem(ContextCompat.getDrawable(this,R.drawable.ic_boy),
            "Ind","Assignment Ind Black 36dp");
    // 기본 생성 코드 및 ListView와 Adapter 생성 코드
    adapter.addItem(ContextCompat.getDrawable(this,R.drawable.ic_boy),
            "Ind","Assignment Ind Black 36dp");
    // 기본 생성 코드 및 ListView와 Adapter 생성 코드
    adapter.addItem(ContextCompat.getDrawable(this,R.drawable.ic_boy),
            "Ind","Assignment Ind Black 36dp");
    // 기본 생성 코드 및 ListView와 Adapter 생성 코드


    // 위에서 생성한 listview에 클릭 이벤트 핸들러 정의.
    listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView parent, View v, int position, long id) {
            // get item
            ListViewCompany item = (ListViewCompany) parent.getItemAtPosition(position);


            String titleStr = item.getTitle();
            String descStr = item.getDesc();
            Drawable iconDrawable = item.getIcon();

            Intent intent = new Intent(getApplicationContext(), CompanyViewPage.class);
            startActivity(intent);


            String toastMessage = item.getTitle().toString() + " is selected.";
            Toast.makeText(
                    getApplicationContext(),
                    toastMessage,
                    Toast.LENGTH_SHORT
            ).show();



        }
    });
    }


    private void addDrawerItems(){
        String[] osArray = {"Android","ios","Windows"};
        mAdapter = new ArrayAdapter<String>(CompanyList.this, android.R.layout.simple_list_item_1,osArray);
        mDrawerList.setAdapter(mAdapter);

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(CompanyList.this, "Time for an upgrade!", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void setupDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("Navigation!");
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(mActivityTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.action_settings){

            return true;}

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);


        }


        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        /*int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        // Activate the navigation drawer toggle
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);*/



}