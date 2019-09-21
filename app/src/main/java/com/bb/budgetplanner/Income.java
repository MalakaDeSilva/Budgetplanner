package com.bb.budgetplanner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;


public class Income extends AppCompatActivity {

    private ImageButton imageButton;
    private ImageButton imageButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);

        getSupportActionBar().setTitle("Income");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imageButton = (ImageButton) findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addincome();
            }
        });

        imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incomeView();
            }
        });
    }

    public void addincome() {
        Intent intent = new Intent(this, Add_income.class);
        startActivity(intent);
    }

    public void incomeView(){
        Intent intent1 = new Intent(this, View_income.class);
        startActivity(intent1);
    }
}