package com.practice.demo1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class SignUpActivity extends AppCompatActivity {
    EditText name;
    EditText emil;
    EditText mobileNm;
    EditText passwrd;
    Button reg;
    EditText dob;
    private static final String CALENDAR_TAG="Picked date";
     ImageView cView;
     private int mDate,mMonth,mYear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        name =findViewById(R.id.editPersonName);
        mobileNm=findViewById(R.id.editMobile);
        emil=findViewById(R.id.editEmail);
        passwrd=findViewById(R.id.editPassword);
        dob =findViewById(R.id.dobView);
        cView= findViewById(R.id.dobCalPick);
        cView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
    final Calendar cal=Calendar.getInstance();
    mDate=cal.get(Calendar.DATE);
    mMonth=cal.get(Calendar.MONTH);
    mYear=cal.get(Calendar.YEAR);
    DatePickerDialog dpDia=new DatePickerDialog(SignUpActivity.this,
            android.R.style.Theme_DeviceDefault_Dialog,
            new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int mon, int date) {
                    dob.setText(date+"/"+mon+"/"+year);
                }
            },mDate,mMonth,mYear);
    dpDia.show();
            }
        });

        reg=findViewById(R.id.register);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkData();
            }
        });



    }
    boolean isEmpty(EditText txt) {
        CharSequence str = txt.getText().toString();
        return TextUtils.isEmpty(str);
    }
    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
    private void checkData() {
        if (isEmpty(name)) {
            Toast t = Toast.makeText(this, "You must enter first name to register!", Toast.LENGTH_SHORT);
            t.show();
        }
        if (isEmpty(mobileNm)) {
            mobileNm.setError("Mobile Number is required!");
        }
        if (isEmail(emil) == false) {
            emil.setError("Enter valid email!");
        }
    }


}