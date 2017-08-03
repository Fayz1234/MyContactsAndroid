package com.example.mycontacts.mycontacts;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AddContactsActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contacts);

        initHeader();
    }

    private void initHeader() {

        TextView tv_heading = (TextView) findViewById(R.id.tv_heading);
        ImageView iv_back = (ImageView) findViewById(R.id.iv_back);
        FloatingActionButton btn_add = (FloatingActionButton) findViewById(R.id.btn_add);
        TextInputLayout til_dob = (TextInputLayout) findViewById(R.id.til_dob);

        tv_heading.setText(getString(R.string.label_addContact));
        iv_back.setOnClickListener(this);
        btn_add.setOnClickListener(this);
        til_dob.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.iv_back:
                finish();
                break;

            case R.id.btn_add:

                nextPhasePopup();
                break;
        }
    }

    private void nextPhasePopup() {

        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("It will be implemented in next phase");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                getString(R.string.ok),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });


        AlertDialog alert11 = builder1.create();
        alert11.show();
    }
}
