
/*
 * Andrew ID: xiaoyuw
 */
package com.xiaoyuw.vocal_artist_app.ui;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;

import com.xiaoyuw.vocal_artist_app.R;

/**
 *  A fragment showing available videos to choose
 */
public class FragmentVideo extends Fragment {
    private View view;
    private RadioButton rb1,rb2;
    private Button bt;

    private int vid;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =inflater.inflate(R.layout.fragment_fragment_video, container, false);
        rb1=(RadioButton) view.findViewById(R.id.rb1);
        rb2=(RadioButton)view.findViewById(R.id.rb2);
        bt=(Button)view.findViewById(R.id.btWatch);

        rb1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        vid=1;
                    }
                }
        );

        rb2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        vid=2;
                    }
                }
        );

        bt.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(FragmentVideo.this.getActivity(),VideoActivity.class);
                        Bundle bundle=new Bundle();
                        bundle.putInt("vid",vid);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                }
        );

        return view;
    }




}
