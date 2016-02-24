/*
 * Andrew ID: xiaoyuw
 */
package com.xiaoyuw.vocal_artist_app.ui;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.xiaoyuw.vocal_artist_app.R;

/**
 * Main activity to show as the first page
 */
public class MainActivity extends Activity {

    private Fragment frag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setBackgroundDrawableResource(R.mipmap.taylor_1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void changeFragment(View view){

        switch (view.getId()){
            case R.id.btHome:
                frag=new FragmentHome();
                FragmentManager fm =getFragmentManager();
                FragmentTransaction ft= fm.beginTransaction();
                ft.replace(R.id.right,frag);
                ft.commit();
                break;
            case R.id.btInfo:
                frag=new FragmentInfo();
                FragmentManager fm2 =getFragmentManager();
                FragmentTransaction ft2= fm2.beginTransaction();
                ft2.replace(R.id.right,frag);
                ft2.commit();
                break;
            case R.id.btSong:
                frag=new FragmentSong();
                FragmentManager fm3 =getFragmentManager();
                FragmentTransaction ft3= fm3.beginTransaction();
                ft3.replace(R.id.right,frag);
                ft3.commit();
                break;
            case R.id.btVideo:
                frag=new FragmentVideo();
                FragmentManager fm4 =getFragmentManager();
                FragmentTransaction ft4= fm4.beginTransaction();
                ft4.replace(R.id.right,frag);
                ft4.commit();
                break;
            case R.id.btWall:
                frag=new FragmentWall();
                FragmentManager fm5 =getFragmentManager();
                FragmentTransaction ft5= fm5.beginTransaction();
                ft5.replace(R.id.right,frag);
                ft5.commit();
                break;
            case R.id.btMailist:
                Intent intent = new Intent(this,MailList.class);
                startActivity(intent);
                break;
        }
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
