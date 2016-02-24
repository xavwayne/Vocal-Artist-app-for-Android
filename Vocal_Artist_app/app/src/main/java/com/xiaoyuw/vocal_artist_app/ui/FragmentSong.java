/*
 * Andrew ID: xiaoyuw
 */
package com.xiaoyuw.vocal_artist_app.ui;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.xiaoyuw.vocal_artist_app.R;

/**
 *  A fragment showing available songs to show
 */
public class FragmentSong extends Fragment {

    private Button start,pause,resume,stop;
    private ListView lv;
    private  int song;
    private View view;
    private MediaPlayer mp;
    private int backpos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view= inflater.inflate(R.layout.fragment_fragment_song, container, false);
        lv= (ListView) view.findViewById(R.id.lvSongs);

        ArrayAdapter aa=ArrayAdapter.createFromResource(this.getActivity(),R.array.songlist,android.R.layout.simple_list_item_single_choice);

        lv.setAdapter(aa);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        lv.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        song = position+1;
                        System.out.println("Song:  " + song);

                    }

                });

        start();
        pause();
        resume();
        stop();


        return view;
    }

    public void start(){

        start= (Button) view.findViewById(R.id.btStart);
        start.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(mp!=null)
                            return;
                        switch(song){
                            case 1:
                                mp= MediaPlayer.create(FragmentSong.this.getActivity(),R.raw.bad_blood);
                                mp.start();
                                break;
                            case 2:
                                mp= MediaPlayer.create(FragmentSong.this.getActivity(),R.raw.blank_space);
                                mp.start();
                                break;
                        }

                    }
                }
        );
    }

    public void pause(){
        pause= (Button) view.findViewById(R.id.btPause);
        pause.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(mp!=null) {
                            backpos = mp.getCurrentPosition();
                            mp.pause();
                        }
                    }
                }
        );
    }

    public void resume(){
        resume= (Button) view.findViewById(R.id.btResume);
        resume.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(mp!=null && !mp.isPlaying()) {
                            mp.seekTo(backpos);
                            mp.start();
                        }
                    }
                }
        );
    }

    public void stop(){
        stop= (Button) view.findViewById(R.id.btStop);
        stop.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(mp!=null){
                            mp.release();
                            mp=null;
                            song=0;
                        }
                    }
                }
        );
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mp!=null){
            mp.release();
            mp=null;
            song=0;
        }
    }
}
