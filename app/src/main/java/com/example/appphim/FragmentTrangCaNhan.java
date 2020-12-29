package com.example.appphim;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link  FragmentTrangCaNhan#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentTrangCaNhan extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Activity v;

    public  FragmentTrangCaNhan() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TrangCaNhan.
     */
    // TODO: Rename and change types and number of parameters
    public static  FragmentTrangCaNhan newInstance(String param1, String param2) {
        FragmentTrangCaNhan fragment = new  FragmentTrangCaNhan();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
   /* private  void GetData(String url)
    {
        RequestQueue requestQueue=Volley.newRequestQueue(getActivity());
        JsonArrayRequest jsonArrayRequest= new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                       // Toast.makeText(getActivity(),response.toString(),Toast.);

                    }
                });
    }*/
    EditText editDate;
    EditText editHoten;
    EditText editSDT;
    EditText editEmail;
    Button btnupdate1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragmnet_trang_ca_nhan, container, false);


        String [] values =
                {"TPHCM","Long An","Tien Giang","Binh Phuoc","Binh Duong","Vung Tau","Dak-Lak","Ca Mau",};
        Spinner spinner = (Spinner) v.findViewById(R.id.spinnertinh);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, values);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
        String [] value =
                {"TPHCM","Long An","Tien Giang","Binh Phuoc","Binh Duong","Hà Nội","Bình Thuận","Vũng Tàu",};
        Spinner spinnerhuyen = (Spinner) v.findViewById(R.id.spinnerhuyen);
        ArrayAdapter<String> adapterhuyen = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, value);
        adapterhuyen.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinnerhuyen.setAdapter(adapterhuyen);
        String [] valuexa =
                {"TPHCM","Long An","Tien Giang","Binh Phuoc","Binh Duong","Phước Đông","Cần Đước","Phước Tuy",};
        Spinner spinnerxa = (Spinner) v.findViewById(R.id.spinnerxa);
        ArrayAdapter<String> adapterxa = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, valuexa);
        adapterxa.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinnerxa.setAdapter(adapterxa);
        editHoten= (EditText) v.findViewById(R.id.editHoTen);


        editSDT=(EditText)v.findViewById(R.id.editSDT);
        editDate=(EditText) v.findViewById(R.id.editNgaySinh);
        btnupdate1=(Button)v.findViewById(R.id.update);
        editEmail=(EditText)v.findViewById(R.id.editEmail);
        editDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chonngay();
            }
        });
        btnupdate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getContext(), EditProfile.class);
                intent.putExtra("HoTen",editHoten.getText().toString());
                intent.putExtra("Email",editEmail.getText().toString());
                intent.putExtra("SDT",editSDT.getText().toString());
                intent.putExtra("NgaySinh",editDate.getText().toString());
                startActivity(intent);
            }
        });

        InputStream is=getActivity().getResources().openRawResource(R.raw.thongtin);
        BufferedReader br=new BufferedReader(new InputStreamReader(is));
        StringBuilder sb= new StringBuilder();
        String line=null;
        String json;
        while (true)
        {
            try {
                if((line=br.readLine())==null)break;
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            sb.append(line);
            sb.append("\n");

        }
        json=sb.toString();
        try {
            JSONObject jsonRoot= new JSONObject(json);
            JSONObject ob= jsonRoot.getJSONObject("tttk");
            editHoten.setText(ob.getString("Hoten"));
            editSDT.setText(ob.getString("SDT"));

        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }



        return  v;

        // Inflate the layout for this fragment

    }
    private void chonngay()
    {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DATE);


        DatePickerDialog datePickerDialog= new DatePickerDialog(this.getActivity(), new DatePickerDialog.OnDateSetListener() {


            @Override



            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                c.set(i,i1,i2);
                SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd/MM/yyyy");
                editDate.setText(simpleDateFormat.format(c.getTime()));





            }
        },year,month,day);
        datePickerDialog.show();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

}
