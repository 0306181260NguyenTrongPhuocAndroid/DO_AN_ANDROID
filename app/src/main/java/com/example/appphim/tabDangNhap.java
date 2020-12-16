package com.example.appphim;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class tabDangNhap extends Fragment {
    public tabDangNhap()
    {

    }

    EditText Email,Pass;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_tabdangnhap,container,false);

        Email = (EditText)v.findViewById(R.id.txtEmail);
        Pass = (EditText) v.findViewById(R.id.txtMatKhau);

        InputStream inputStream = getActivity().getResources().openRawResource(R.raw.info);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        String json;

        while(true){
            try{
                if((line = bufferedReader.readLine())==null)break;
            }
            catch (IOException e){
                e.printStackTrace();
            }
            stringBuilder.append(line);
            stringBuilder.append("\n");
        }

        json = stringBuilder.toString();
        try{
            JSONObject jsonRoot = new JSONObject(json);
            JSONObject ob = jsonRoot.getJSONObject("infodangnhap");
            Email.setText(ob.getString("email"));
            Pass.setText(ob.getString("pass"));

        }
        catch (JSONException e){
            e.printStackTrace();
        }


        return v;
    }
}

