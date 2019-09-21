package com.bb.budgetplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

public class Expenses extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    ImageButton selectDate,viewexe;
    Button saveb;
    EditText editdate,editamount,editcomments,editbill;
    Spinner sspinpurpose,sspinpayment;
    DatePickerDialog datePickerDialog;
    int year;
    int month;
    int dayOfMonth;
    Calendar calendar;
    DatabaseHelper myDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses);

        myDb = new DatabaseHelper(this);

        editamount = findViewById(R.id.txtamount);
        editcomments = findViewById(R.id.txtcomment);
        editbill = findViewById(R.id.txtbill);

        saveb = findViewById(R.id.btnsave);

        viewexe = findViewById(R.id.viewbtn);

        selectDate = findViewById(R.id.calimgbtn);
        editdate = findViewById(R.id.txtdate);

        selectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(Expenses.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                editdate.setText(day + "/" + (month+1) + "/" + year);
                            }
                        }, year, month, dayOfMonth);
                datePickerDialog.show();
            }
        });

        sspinpurpose = findViewById(R.id.spinpurpose);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.purpose, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sspinpurpose.setAdapter(adapter);
        sspinpurpose.setOnItemSelectedListener(this);

        sspinpayment = findViewById(R.id.spinpayment);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,R.array.payment_method, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sspinpayment.setAdapter(adapter1);
        sspinpayment.setOnItemSelectedListener(this);

        AddData();
        ViewAll();
    }

    public void AddData(){
        saveb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDb.insertData(editdate.getText().toString(),
                        editamount.getText().toString(),
                        sspinpurpose.getSelectedItem().toString(),
                        sspinpayment.getSelectedItem().toString(),
                        editcomments.getText().toString(),
                        editbill.getText().toString());
                if(isInserted = true)
                    Toast.makeText(Expenses.this,"Data Inserted",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Expenses.this,"Data not Inserted",Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void ViewAll(){
        viewexe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = myDb.getAllData();
                if (res.getCount() == 0) {
                    showMessage("Error","Nothing found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("Id :" + res.getString(0) + "\n");
                    buffer.append("Date :" + res.getString(1) + "\n");
                    buffer.append("Amount :" + res.getString(2) + "\n");
                    buffer.append("Purpose :" + res.getString(3) + "\n");
                    buffer.append("Payment :" + res.getString(4) + "\n");
                    buffer.append("Comments :" + res.getString(5) + "\n");
                    buffer.append("Bill :" + res.getString(6) + "\n\n");
                }

                showMessage("Expences",buffer.toString());
            }
        });
    }

    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
