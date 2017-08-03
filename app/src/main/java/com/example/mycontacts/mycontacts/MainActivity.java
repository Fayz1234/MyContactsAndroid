package com.example.mycontacts.mycontacts;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import fragments.ContactListFragment;
import fragments.FavoriteFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private View viewAll;
    private View viewFavorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initHeader();
        LinearLayout ll_all = (LinearLayout) findViewById(R.id.ll_all);
        LinearLayout ll_favorite = (LinearLayout) findViewById(R.id.ll_favorite);
        viewAll = findViewById(R.id.viewAll);
        viewFavorite = findViewById(R.id.viewFavorite);

        ll_all.setOnClickListener(this);
        ll_favorite.setOnClickListener(this);

        addAllFragment();
    }

    private void initHeader() {

        TextView tv_heading = (TextView) findViewById(R.id.tv_heading);
        ImageView iv_back = (ImageView) findViewById(R.id.iv_back);
        FloatingActionButton btn_add = (FloatingActionButton) findViewById(R.id.btn_add);

        tv_heading.setText(getString(R.string.label_contact));
        iv_back.setOnClickListener(this);
        btn_add.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.iv_back:
                finish();
                break;

            case R.id.ll_all:
                addAllFragment();
                break;

            case R.id.ll_favorite:
                addFavoriteFragment();
                break;

            case R.id.btn_add:
                Intent addContact = new Intent(MainActivity.this, AddContactsActivity.class);
                startActivity(addContact);
                break;
        }
    }

    /*
    * This method is used to switch fragment
    * Loads list fragment
    */
    private void addAllFragment() {

        Fragment fragment = new ContactListFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragment).commit();
        viewAll.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        viewFavorite.setBackgroundColor(getResources().getColor(R.color.text_color_light));
        viewAll.setMinimumHeight(5);
        viewFavorite.setMinimumHeight(2);
    }

    /*
    * This method is used to switch fragment
    * Loads Favourite fragment
    */
    private void addFavoriteFragment() {

        Fragment fragment = new FavoriteFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragment).commit();
        viewAll.setBackgroundColor(getResources().getColor(R.color.text_color_light));
        viewFavorite.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        viewAll.setMinimumHeight(2);
        viewFavorite.setMinimumHeight(5);
    }
}
