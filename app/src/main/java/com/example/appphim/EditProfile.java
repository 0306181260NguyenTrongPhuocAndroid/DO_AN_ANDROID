package com.example.appphim;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;



import java.util.HashMap;
import java.util.Map;

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