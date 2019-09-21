package com.bb.budgetplanner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class View_income extends AppCompatActivity {

    private Button button2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_income);
        openFrontApp();

    }

    public void openFrontApp(){
        button2 = (Button) findViewById(R.id.button15);


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(View_income.this, Update_income.class);
                startActivity(intent);
            }
        });
    }


}

