package com.fastebro.androidrgbtool.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fastebro.androidrgbtool.R;

public class ColorSampleFragment extends Fragment {

    private static final String ARG_RGB_COLOR = "arg_rgb_color";
    private short[] rgbaValues;


    public ColorSampleFragment() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameter.
     *
     * @param rgbaValues
     * @return A new instance of fragment ColorSampleFragment.
     */
    public static ColorSampleFragment newInstance(short[] rgbaValues) {
        ColorSampleFragment fragment = new ColorSampleFragment();
        Bundle args = new Bundle();
        args.putShortArray(ARG_RGB_COLOR, rgbaValues);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            rgbaValues = getArguments().getShortArray(ARG_RGB_COLOR);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_color_sample, container, false);
    }
}
