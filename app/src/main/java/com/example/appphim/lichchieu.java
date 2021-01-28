package com.example.appphim;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.LinkedList;

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        lview=inflater.inflate(R.layout.fragment_lichchieu, container, false);

        rcvLichchieu =lview.findViewById(R.id.rcvLichChieu);

        LinearLayoutManager linearLayout=new LinearLayoutManager(getActivity());
        rcvLichchieu.setLayoutManager(linearLayout);

        LichchieuAdapter mlca = new LichchieuAdapter();
        mlca.setDataLichChieu(createData(),getActivity());
        rcvLichchieu.setAdapter(mlca);

        return lview;
    }

    public LinkedList<ThongTinLichChieu> createData(){
        LinkedList<ThongTinLichChieu> LC = new LinkedList<ThongTinLichChieu>();

        for (int i = 0; i<4;i++)
        {
            ThongTinLichChieu l = new ThongTinLichChieu();
            l.setCinemaName("Lê Quý Đôn");
            //l.setNgayChieu(new Date(2021,1,4));
            l.setRoomId(1);
            LinkedList<SuatChieu> sc = new LinkedList<SuatChieu>();
            for (int j = 0;j<i+3;j++)
            {
                SuatChieu s = new SuatChieu(j+1,new Date(2021,1,4),(j+1)*2,1);
                sc.add(s);
            }
            l.setDsSuatChieu(sc);
            LC.add(l);
        }
        return LC;
    }
}