package com.example.prm391x_tourguide_ngoclptse00512x;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BusFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BusFragment extends Fragment {
    ListView busList;

    SearchView search;

    ArrayAdapter<String> adapter;

    ArrayAdapter<String> adapter1;

    String[] busNo = {"Tuyến 01", "Tuyến 02", "Tuyến 03A", "Tuyến 03B", "Tuyến 04", "Tuyến 05", "Tuyến 06", "Tuyến 07", "Tuyến 08"};
    String[] route = {"BX Gia Lâm - BX Yên Nghĩa", "Bác Cổ - BX Yên Nghĩa", "BX Giáp Bát - BX Gia Lâm", "BX Giáp Bát - Vincom- Phúc Lợi", "Long biên - BX Nước Ngầm", "Linh Đàm - Phú Diễn", "BX Giáp Bát - Phú Minh(Phú Xuyên)", "Cầu Giấy - Nội Bài", "Long Biên - Đông Mỹ"};

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BusFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BusFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BusFragment newInstance(String param1, String param2) {
        BusFragment fragment = new BusFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_bus, container,false);
        busList = (ListView) view.findViewById(R.id.busListID);
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_expandable_list_item_1, busNo);
        busList.setAdapter(adapter);

        return view;
    }
}