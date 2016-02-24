/*
 * Andrew ID: xiaoyuw
 */
package com.xiaoyuw.vocal_artist_app.ui;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.xiaoyuw.vocal_artist_app.R;

/**
 *  A fragment showing wall papers to set
 */
public class FragmentWall extends Fragment {

    private ImageView display,tay1,tay2;
    private View view;
    private Button bt;
    private int bg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_fragment_wall, container, false);

        display=(ImageView)view.findViewById(R.id.ivDisplay);
        tay1=(ImageView)view.findViewById(R.id.ivT1);
        tay2=(ImageView)view.findViewById(R.id.ivT2);
        bt=(Button)view.findViewById(R.id.btSetWall);


        tay1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        display.setImageResource(R.mipmap.taylor_1);
                        bg=R.mipmap.taylor_1;
                    }
                }
        );

        tay2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        display.setImageResource(R.mipmap.taylor_2);
                        bg=R.mipmap.taylor_2;
                    }
                }
        );

        bt.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        FragmentWall.this.getActivity().getWindow().setBackgroundDrawableResource(bg);
                    }
                }
        );

        return view;

    }



}
