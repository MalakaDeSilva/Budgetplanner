package com.bb.budgetplanner;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Add_income extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button button3;
        EditText editText;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_income);

        getSupportActionBar().setTitle("Add Income");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        button3 = (Button) findViewById(R.id.button3);
        editText = (EditText) findViewById(R.id.editText2);
        editText = (EditText) findViewById(R.id.editText8);
        editText = (EditText) findViewById(R.id.editText7);
        editText = (EditText) findViewById(R.id.editText9);
        editText = (EditText) findViewById(R.id.editText10);


        final EditText EditText = editText;
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(EditText.getText().toString())) {
                    Toast.makeText(Add_income.this, "Field is empty", Toast.LENGTH_LONG).show();
                } else {

                    Toast.makeText(Add_income.this, "Succesfully Saved to DB", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

}
