package com.example.appphim;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link lichchieu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class lichchieu extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public lichchieu() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment lichchieuFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static lichchieu newInstance(String param1, String param2) {
        lichchieu fragment = new lichchieu();
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
    private RecyclerView rcvLichchieu;
    private View lview;
    private List<ThongTinLichChieu> ds= new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        lview = inflater.inflate(R.layout.fragment_lichchieu, container, false);

        Context context = getActivity();
        rcvLichchieu = lview.findViewById(R.id.rcvLichChieu);

        LinearLayoutManager linearLayout = new LinearLayoutManager(context);
        rcvLichchieu.setLayoutManager(linearLayout);

        LichchieuAdapter mlca = new LichchieuAdapter();
        //mlca.setDataLichChieu(createData(),context);
        //List<ThongTinLichChieu> dsttlc = ((MainActivityChitiet) context).dsLC;
        List<LichChieuClass> dsttsc = ((MainActivityChitiet) context).dsLC;
        convertToLC(dsttsc);

        mlca.setDataLichChieu(ds, context);
        rcvLichchieu.setAdapter(mlca);

        return lview;
    }

    public List<ThongTinLichChieu> createData(){
        List<ThongTinLichChieu> LC = new ArrayList<>();

        for (int i = 0; i<4;i++)
        {
            ThongTinLichChieu l = new ThongTinLichChieu();
            l.setCinemaName("Lê Quý Đôn");
            //l.setNgayChieu(new Date(2021,1,4));
            List<SuatChieu> sc = new ArrayList<>();
            for (int j = 0;j<i+3;j++)
            {
                SuatChieu s = new SuatChieu();
                s.CinemaID=i+1;
                s.RoomId=j+1;
                s.suatChieuID=j+1;
                s.gioBatDau=(j+1)*2;
                s.trangThai=1;
                sc.add(s);
            }
            l.setDsSuatChieu(sc);
            LC.add(l);
        }
        return LC;
    }

    public void setDSRap(List<LichChieuClass> dsLC)
    {
        if(dsLC!=null)
        {
            ThongTinLichChieu t = new ThongTinLichChieu();
            LichChieuClass c = dsLC.get(0);
            t.setCinemaID(c.CinemaID);
            t.setCinemaName(c.CinemaName);
            ds.add(t);
            for (LichChieuClass l : dsLC)
            {
                boolean f = true;
                for (ThongTinLichChieu i : ds)
                {
                    if(l.CinemaID==i.getCinemaID())
                    {
                        f=false;break;
                    }
                }
                if(f)
                    ds.add(new ThongTinLichChieu(l.CinemaID,l.CinemaName));
            }
        }
    }
    public void convertToLC(List<LichChieuClass> l)
    {

        setDSRap(l);
        if(l!=null&&ds!=null)
        {
            for (ThongTinLichChieu tt : ds)
            {
                List<SuatChieu> s = new ArrayList<>();
                for (LichChieuClass lc : l)
                {
                    if(lc.CinemaID==tt.getCinemaID())
                    {
                        SuatChieu sc = new SuatChieu();
                        sc.CinemaID=lc.CinemaID;
                        sc.RoomId=lc.RoomId;
                        sc.suatChieuID=lc.suatChieuID;
                        sc.gioBatDau=lc.gioBatDau;
                        sc.ngayChieu=lc.ngayChieu;
                        sc.trangThai=lc.trangThai;
                        s.add(sc);
                    }
                }
                tt.setDsSuatChieu(s);
            }

        }
    }
}
