package com.example.appphim;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.appphim.commentUser;
import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link binhluanFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class binhluanFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment binhluanFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static binhluanFragment newInstance(String param1, String param2) {
        binhluanFragment fragment = new binhluanFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public binhluanFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private RecyclerView rcvComment;
    private View mview;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mview=inflater.inflate(R.layout.fragment_binhluan, container, false);
        rcvComment =mview.findViewById(R.id.recycler_binhluan);

        LinearLayoutManager linearLayout=new LinearLayoutManager(getActivity());
        rcvComment.setLayoutManager(linearLayout);

        BinhluanAdapter binhluanAdapter=new BinhluanAdapter();
        binhluanAdapter.commentData(getComment());

        rcvComment.setAdapter(binhluanAdapter);

        return mview;
    }
    private List<commentUser> getComment(){
        List<commentUser> list=new ArrayList<>();
        list.add(new commentUser(R.drawable.a2,"abs","kjljlkjdajsldasj",1));
        list.add(new commentUser(R.drawable.a2,"Trung giấu tên","Như thằng dưới",1));
        list.add(new commentUser(R.drawable.a4,"Tên như thằng trên","Phim khá quằng",1));
        list.add(new commentUser(R.drawable.a3,"Vẫn là Trung nhưng khá hình","Như trên",1));
        list.add(new commentUser(R.drawable.a3,"Vẫn là Trung nhưng khá hình","Như trên",1));
        list.add(new commentUser(R.drawable.a3,"Vẫn là Trung nhưng khá hình","Như trên",1));
        list.add(new commentUser(R.drawable.a2,"Trung giấu tên","Như thằng dưới",1));
        list.add(new commentUser(R.drawable.a4,"Tên như thằng trên","Phim khá quằng",1));
        list.add(new commentUser(R.drawable.a2,"Trung giấu tên","Như thằng dưới",1));
        list.add(new commentUser(R.drawable.a4,"Tên như thằng trên","Phim khá quằng",1));
        list.add(new commentUser(R.drawable.a2,"Trung giấu tên","Như thằng dưới",1));
        list.add(new commentUser(R.drawable.a4,"Tên như thằng trên","Phim khá quằng",1));
        list.add(new commentUser(R.drawable.a2,"Trung giấu tên","Như thằng dưới",1));
        list.add(new commentUser(R.drawable.a4,"Tên như thằng trên","Phim khá quằng",1));
        return list;
    }
}