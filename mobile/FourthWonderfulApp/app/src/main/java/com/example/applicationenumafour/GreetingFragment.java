package com.example.applicationenumafour;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GreetingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GreetingFragment extends Fragment {

    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;


    public GreetingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param mPage Parameter mPage
     * @return A new instance of fragment fragment_page.
     */
    // TODO: Rename and change types and number of parameters
    public static GreetingFragment newInstance(int mPage) {
        GreetingFragment fragment = new GreetingFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, mPage);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPage = getArguments().getInt(ARG_PAGE);
        }

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_greeting, container, false);

        return view;
    }
}