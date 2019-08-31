package com.bb.budgetplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private LinearLayout income, cred_limit, history_reports, expenses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        income = findViewById(R.id.income);
        cred_limit = findViewById(R.id.spend_limit);
        history_reports = findViewById(R.id.history_reports);
        expenses = findViewById(R.id.expenses);

        income.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.bounce);
                income.startAnimation(animation);

                Toast.makeText(MainActivity.this, "You clicked Add Income.", Toast.LENGTH_LONG).show();
            }
        });

        cred_limit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.bounce);
                cred_limit.startAnimation(animation);

                Toast.makeText(MainActivity.this, "You clicked Set Credit Limit.", Toast.LENGTH_LONG).show();
            }
        });

        history_reports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.bounce);
                history_reports.startAnimation(animation);

                Intent histnrep = new Intent(MainActivity.this, HistoryandReports.class);
                startActivity(histnrep);
            }
        });

        expenses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.bounce);
                expenses.startAnimation(animation);

                Toast.makeText(MainActivity.this, "You clicked Add Expenses.", Toast.LENGTH_LONG).show();
            }
        });
    }
}
