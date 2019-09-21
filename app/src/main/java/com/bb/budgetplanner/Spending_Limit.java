package com.bb.budgetplanner;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Spending_Limit extends AppCompatActivity {
    ImageButton viewdata,deletedata;
    Button saveb;
    EditText editmonth,edittravel,editshop,editfood,editrent,edittel,editother;
    TextView total;
    DBHelper myDb;
    String gtot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spending__limit);

        myDb = new DBHelper(this);



        viewdata = findViewById(R.id.btnview);
        deletedata = findViewById(R.id.btndel);
        saveb = findViewById(R.id.btnsave);
        editmonth = findViewById(R.id.txtmonthy);
        edittravel = findViewById(R.id.txttravel);
        editshop = findViewById(R.id.txtshop);
        editfood = findViewById(R.id.txtfood);
        editrent = findViewById(R.id.txtrent);
        edittel = findViewById(R.id.txttel);
        editother = findViewById(R.id.txtothers);
        total = findViewById(R.id.txttotal);

        AddData();
        ViewAll();
        DeleteAll();

    }

    public void AddData(){
        saveb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sum = 0;
                if(sum == -1) {
                    total.setText("You have overspend your monthly limit");
                }
                else {
                    int month = Integer.parseInt(editmonth.getText().toString());
                    int travel = Integer.parseInt(edittravel.getText().toString());
                    int food = Integer.parseInt(editfood.getText().toString());
                    int shop = Integer.parseInt(editshop.getText().toString());
                    int rent = Integer.parseInt(editrent.getText().toString());
                    int tel = Integer.parseInt(edittel.getText().toString());
                    int other = Integer.parseInt(editother.getText().toString());

                    sum = month - (travel + food + shop + rent + tel + other);
                    total.setText("Total :" + String.valueOf(sum));
                }
                boolean isInserted = myDb.insertData(editmonth.getText().toString(),
                        edittravel.getText().toString(),
                        editfood.getText().toString(),
                        editshop.getText().toString(),
                        editrent.getText().toString(),
                        edittel.getText().toString(),
                        editother.getText().toString(),
                        total.getText().toString());
                if(isInserted = true)
                    Toast.makeText(Spending_Limit.this,"Data Inserted",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Spending_Limit.this,"Data not Inserted",Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void ViewAll(){
        viewdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = myDb.getAllData();
                if (res.getCount() == 0) {
                    showMessage("Error","Nothing found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("ID :" + res.getString(0)+ "\n");
                    buffer.append("Monthly Limit :" + res.getString(1) + "\n");
                    buffer.append("Travel :" + res.getString(2) + "\n");
                    buffer.append("Food :" + res.getString(3) + "\n");
                    buffer.append("Shopping :" + res.getString(4) + "\n");
                    buffer.append("Rent :" + res.getString(5) + "\n");
                    buffer.append("Telephone Bill :" + res.getString(6) + "\n");
                    buffer.append("Others :" + res.getString(7) + "\n");
                    buffer.append("Total :" + res.getString(8) + "\n\n");
                }

                showMessage("Spending",buffer.toString());
            }
        });
    }

    public void DeleteAll(){
        deletedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer del = myDb.deleteData(10);
                Integer del2 = myDb.deleteData(9);
                Integer del3 = myDb.deleteData(8);
                Integer del8 = myDb.deleteData(11);
                Integer del9 = myDb.deleteData(12);
                Integer del10 = myDb.deleteData(13);
                Integer del11 = myDb.deleteData(14);
                Integer del12 = myDb.deleteData(15);
                Integer del13 = myDb.deleteData(16);
                Integer del14 = myDb.deleteData(17);
                Integer del15 = myDb.deleteData(18);
                Integer del16 = myDb.deleteData(19);
                Integer del17 = myDb.deleteData(20);
                Integer del18 = myDb.deleteData(21);
                Integer del19 = myDb.deleteData(22);
                Integer del20 = myDb.deleteData(23);
                Integer del21 = myDb.deleteData(24);
                Integer del22 = myDb.deleteData(25);
                Integer del23 = myDb.deleteData(26);
                Integer del24 = myDb.deleteData(27);

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
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
