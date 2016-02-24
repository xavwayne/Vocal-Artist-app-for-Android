/*
 * Andrew ID: xiaoyuw
 */
package com.xiaoyuw.vocal_artist_app.ui;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.xiaoyuw.vocal_artist_app.R;

/**
 *  A avtivity to play the selected video
 */
public class VideoActivity extends Activity {

    private VideoView vv;
    private int vid;
    private String uri;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        Bundle bundle=getIntent().getExtras();
        vid = bundle.getInt("vid");

        vv= (VideoView) findViewById(R.id.videoView);
        tv=(TextView)findViewById(R.id.tvVidTitle);

        MediaController mc=new MediaController(this);
        vv.setMediaController(mc);

        switch (vid){
            case 1:
                tv.setText("Bad Blood is playing now");
                uri="android.resource://"+getPackageName()+"/"+R.raw.bad_blood_v;
                break;
            case 2:
                tv.setText("Blank Space is playing now");
                uri="android.resource://"+getPackageName()+"/"+R.raw.blank_space_v;
                break;
        }

        vv.setVideoURI(Uri.parse(uri));
        vv.start();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_video, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
