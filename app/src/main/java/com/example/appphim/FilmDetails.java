package com.example.appphim;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FilmDetails#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FilmDetails extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RatingBar ratingBar;
    private TextView txtDiem;
    private Button btnDanhGia;
    private List<Float> allRatings = new ArrayList<Float>();
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FilmDetails() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FilmDetails.
     */
    // TODO: Rename and change types and number of parameters
    public static FilmDetails newInstance(String param1, String param2) {
        FilmDetails fragment = new FilmDetails();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ratingBar = getView().findViewById(R.id.ratingBar_yours);
        txtDiem = (TextView) getView().findViewById(R.id.Diem);
        btnDanhGia = getView().findViewById(R.id.btnDanhGia);
        btnDanhGia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float rating = ratingBar.getRating();
                if(rating==0)
                {
                    txtDiem.setText("0");
                }
                         allRatings.add(rating+rating);
                         int ratingCount = allRatings.size();
                         float ratingSum = 0f;
                         for(Float r: allRatings)  {
                             ratingSum += r;
                         }
                         float TB = ratingSum / ratingCount;
                         float LT = ((float)Math.ceil(TB * 100) / 100);
                         txtDiem.setText("" +LT);
            }

        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_film_details, container, false);
    }
}