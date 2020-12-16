package com.example.appphim;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link thongtinFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class thongtinFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public thongtinFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment thongtinFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static thongtinFragment newInstance(String param1, String param2) {
        thongtinFragment fragment = new thongtinFragment();
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

    private RecyclerView rcvUser;
    private View mView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView=inflater.inflate(R.layout.fragment_thongtin, container, false);
        rcvUser=(mView).findViewById(R.id.recycler_thongtin);


        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());

        rcvUser.setLayoutManager(linearLayoutManager);

        PhimAdapter userAdapter=new PhimAdapter();
        userAdapter.setData(getListUser());

        rcvUser.setAdapter(userAdapter);
        return mView;
//        return inflater.inflate(R.layout.fragment_thongtin, container, false);
    }
    private List<chitiet_phim> getListUser(){
        List<chitiet_phim> list=new ArrayList<>();
        //list.add(new user(R.drawable.a2,"zoro","Kiếm sĩ"));
        list.add(new chitiet_phim(R.drawable.a01,"Phim: Mắt biếc",
                "Điểm: 8.9",
                "Độ tuổi: 18+",
                "Thể loại: Tình cảm, hết hồn",
                "Mắt biếc xoay quanh mối tình đơn phương của Ngạn với Hà Lan, cô bạn gái có cặp mắt hút hồn nhưng cá tính bướng bỉnh. Một chuyện tình nhiều cung bậc, từ ngộ nghĩnh trẻ con, rồi tình yêu thuở học trò trong sáng, trải qua bao biến cố, trở thành một cuộc “đuổi hình bắt bóng” buồn da diết nhưng không nguôi hi vọng. Câu chuyện càng trở nên éo le hơn khi Trà Long - con gái của Hà Lan lớn lên lại nhen nhóm một tình yêu như thế với Ngạn.\n" +
                        "\n" +
                        "Phim Mắt biếc xoay quanh mối tình đơn phương của Ngạn với Hà Lan, cô bạn gái có cặp mắt hút hồn nhưng cá tính bướng bỉnh. Một chuyện tình nhiều cung bậc, từ ngộ nghĩnh trẻ con, rồi tình yêu thuở học trò trong sáng, trải qua bao biến cố, trở thành một cuộc “đuổi hình bắt bóng” buồn da diết nhưng không nguôi hi vọng. Câu chuyện càng trở nên éo le hơn khi Trà Long - con gái của Hà Lan lớn lên lại nhen nhóm một tình yêu như thế với Ngạn.\\n\" +\n" +
                        "                \"\\n\" +\n" +
                        "                \"Phim lấy bối cảnh ở thập niên 1960 và 1970. Nhân vật chính là Ngạn, cậu bé sinh ra và lớn lên tại ngôi làng Đo Đo, tỉnh Quảng NamMắt biếc xoay quanh mối tình đơn phương của Ngạn với Hà Lan, cô bạn gái có cặp mắt hút hồn nhưng cá tính bướng bỉnh. Một chuyện tình nhiều cung bậc, từ ngộ nghĩnh trẻ con, rồi tình yêu thuở học trò trong sáng, trải qua bao biến cố, trở thành một cuộc “đuổi hình bắt bóng” buồn da diết nhưng không nguôi hi vọng. Câu chuyện càng trở nên éo le hơn khi Trà Long - con gái của Hà Lan lớn lên lại nhen nhóm một tình yêu như thế với Ngạn.\\n\" +\n" +
                        "                \"\\n\" +\n" +
                        "                \"Phim lấyMắt biếc xoay quanh mối tình đơn phương của Ngạn với Hà Lan, cô bạn gái có cặp mắt hút hồn nhưng cá tính bướng bỉnh. Một chuyện tình nhiều cung bậc, từ ngộ nghĩnh trẻ con, rồi tình yêu thuở học trò trong sáng, trải qua bao biến cố, trở thành một cuộc “đuổi hình bắt bóng” buồn da diết nhưng không nguôi hi vọng. Câu chuyện càng trở nên éo le hơn khi Trà Long - con gái của Hà Lan lớn lên lại nhen nhóm một tình yêu như thế với Ngạn.\\n\" +\n" +
                        "                \"\\n\" +\n" +
                        "                \"Phim lấy bối cảnh ở thập niên 1960 và 1970. Nhân vật chính là Ngạn, cậu bé sinh ra và lớn lên tại ngôi làng Đo Đo, tỉnh Quảng Nam bối cảnh ở thập niên 1960 và 1970. Nhân vật chính là Ngạn, cậu bé sinh ra và lớn lên tại ngôi làng Đo Đo, tỉnh Quảng Namlấy bối cảnh ở thập niên 1960 và 1970. Nhân vật chính là Ngạn, cậu bé sinh ra và lớn lên tại ngôi làng Đo Đo, tỉnh Quảng Nam (cũng là nguyên quán của tác giả Nguyễn Nhật Ánh). Cậu yêu mến cô bạn tên Hà Lan, người có đôi mắt đẹp tuyệt trần mà Ngạn tự gọi là \"mắt biếc\". Cả hai cùng trải qua biết bao nhiêu kỷ niệm tại làng quê nghèo này, dần dần trong Ngạn nảy sinh một tình yêu thầm lặng dành cho Hà Lan. Khi lớn lên, cả hai đều đi học trên thành phố Huế. Hà Lan ở chung nhà với người cô trong khi Ngạn ở chung nhà với cậu Huấn." +
                        "",
                "dddddd"));

        return list;
    }
}