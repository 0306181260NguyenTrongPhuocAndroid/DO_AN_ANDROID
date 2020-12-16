package com.example.appphim;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class FragmentTrangGiaoDich extends Fragment {

    public FragmentTrangGiaoDich()
    {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_trang_giao_dich,container,false);
        ArrayList<String> data= new ArrayList<>();
        LinkedList<Ve_TrangCaNhan> dsVe= new LinkedList<>();
//        data.add("Vé phim 1 , giá 50000");
//        data.add("Vé phim 2 , giá 50000");
//        data.add("Vé phim 3 , giá 50000");
//        data.add("Vé phim 4 , giá 50000");
//        data.add("Vé phim 5 , giá 50000");
//        data.add("Vé phim 6 , giá 50000");
//        data.add("Vé phim 7 , giá 50000");
        InputStream is=getActivity().getResources().openRawResource(R.raw.thongtin);
        BufferedReader br= new BufferedReader(new InputStreamReader(is));
        StringBuilder sb= new StringBuilder();
        String line = null;
        String jSon;
        while(true)
        {
            try{
                if((line=br.readLine())==null)break;
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            sb.append(line);
            sb.append("\n");
        }
        jSon=sb.toString();

        try {
            JSONObject jsonRoot= new JSONObject(jSon);
            JSONArray jsonArray= jsonRoot.getJSONArray("ttgd");
            int len=jsonArray.length();
            for(int i=0;i<len;i++)
            {
//                Ve ve=new Ve(jsonArray.getJSONObject(i).getString("TenVe"),jsonArray.getJSONObject(i).getInt("Gia"));
//                dsVe.addLast(ve);
                data.add("Ten ve:"+jsonArray.getJSONObject(i).getString("TenVe")+"--Gia ve:"+jsonArray.getJSONObject(i).getInt("Giave"));
            }
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item,data);
        ListView listviewlichsu=(ListView) view.findViewById(R.id.listviewlichsu);
        listviewlichsu.setAdapter(adapter);

        return  view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}
