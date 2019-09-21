package com.bb.budgetplanner;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Update_income extends AppCompatActivity {

    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_income);

        getSupportActionBar().setTitle("Update Income");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFrontApp();
            }
        });
    }

    public void openFrontApp() {
        Toast.makeText(Update_income.this, "Updated", Toast.LENGTH_LONG).show();
    }
}

