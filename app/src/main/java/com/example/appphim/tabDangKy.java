package com.example.appphim;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class tabDangKy extends Fragment {
    public tabDangKy(){

    }

    EditText ngaySinh;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.actitity_tabdangky,container,false);

        ngaySinh = (EditText) v.findViewById(R.id.txt_Date);
        ngaySinh.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                chonNgay();
            }
        });

        return  v;
    }

    private void chonNgay(){
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DATE);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this.getActivity(), new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day){
                c.set(year,month,day);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                ngaySinh.setText(simpleDateFormat.format(c.getTime()));
            }
        },year,month,day);
        datePickerDialog.show();
    }

}
