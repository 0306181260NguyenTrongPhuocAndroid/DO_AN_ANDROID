package com.example.appphim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class EditProfile extends AppCompatActivity {

    public  static  final String TAG="TAG";
    EditText pfHoTen,pfEmail,pfSDT,pfNgaySinh;

    ImageView imageView;
    Button saveBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        Intent data=getIntent();

        String [] values =
                {"TPHCM","Long An","Tien Giang","Binh Phuoc","Binh Duong","Vung Tau","Dak-Lak","Ca Mau",};
        Spinner spinner = (Spinner) findViewById(R.id.spinnertinh);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, values);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
        String [] value =
                {"TPHCM","Long An","Tien Giang","Binh Phuoc","Binh Duong","Hà Nội","Bình Thuận","Vũng Tàu",};
        Spinner spinnerhuyen = (Spinner) findViewById(R.id.spinnerhuyen);
        ArrayAdapter<String> adapterhuyen = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, value);
        adapterhuyen.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinnerhuyen.setAdapter(adapterhuyen);
        String [] valuexa =
                {"TPHCM","Long An","Tien Giang","Binh Phuoc","Binh Duong","Phước Đông","Cần Đước","Phước Tuy",};
        Spinner spinnerxa = (Spinner) findViewById(R.id.spinnerxa);
        ArrayAdapter<String> adapterxa = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valuexa);
        adapterxa.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinnerxa.setAdapter(adapterxa);
        String SDT=data.getStringExtra("SDT");
        String NgaySinh=data.getStringExtra("NgaySinh");
        String HoTen=data.getStringExtra("HoTen");
        String Email=data.getStringExtra("Email");
        // firebaseAuth=FirebaseAuth.getInstance();
        //  fStore=FirebaseFirestore.getInstance();
//      user=firebaseAuth.getCurrentUser();
        pfHoTen=findViewById(R.id.editpfHoTen);
        pfEmail=findViewById(R.id.editEmail);
        pfSDT=findViewById(R.id.editpfSDT);
        pfNgaySinh=findViewById(R.id.editpfNgaySinh);
        imageView=findViewById(R.id.profileImage);
        saveBtn=findViewById(R.id.btnsave);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EditProfile.this,"Profile image clicked",Toast.LENGTH_LONG).show();
            }
        });
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pfHoTen.getText().toString().isEmpty() || pfEmail.getText().toString().isEmpty() || pfNgaySinh.getText().toString().isEmpty() || pfSDT.getText().toString().isEmpty()) {
                    Toast.makeText(EditProfile.this, "Gía trị không hợp lệ hoặc để trống", Toast.LENGTH_SHORT).show();
                    return;
                }

            }

        });
        pfHoTen.setText(HoTen);
        pfEmail.setText(Email);
        pfSDT.setText(SDT);
        pfNgaySinh.setText(NgaySinh);
        Log.d(TAG,"oncreate"+HoTen +" "+ Email +"  "+  SDT +" "+NgaySinh);
    }
}