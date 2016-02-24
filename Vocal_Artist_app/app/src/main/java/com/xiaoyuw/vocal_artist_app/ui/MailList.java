/*
 * Andrew ID: xiaoyuw
 */
package com.xiaoyuw.vocal_artist_app.ui;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.xiaoyuw.vocal_artist_app.R;
import com.xiaoyuw.vocal_artist_app.model.Audience;
import com.xiaoyuw.vocal_artist_app.util.DbHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 *  A activity to get on mailing list, register the input data to database
 */
public class MailList extends Activity {

    private EditText name,mail;
    private DbHelper db;
    private Audience aud;
    private ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail_list);
        db=new DbHelper(this);
        lv=(ListView)findViewById(R.id.lvDb);
        this.name=(EditText)findViewById(R.id.etName);
        this.mail=(EditText)findViewById(R.id.etEmail);
    }

    public void save(View view){
        String name=this.name.getText().toString();
        String email=this.mail.getText().toString();
        aud=new Audience(name,email);

        boolean flag=db.insertData(aud);

        if(flag==true){
            Toast.makeText(this, "Data Inserted", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"Data Not Inserted.\n Duplicate student ID detected.",Toast.LENGTH_LONG ).show();
        }
    }

    public void show(View view){
        Cursor cs=null;
        try {
             cs = db.getAllData();
        }catch (Exception e){
            Toast.makeText(this,"No Table Found.",Toast.LENGTH_LONG ).show();
            return;
        }
        ArrayList<HashMap<String,Object>> items=new ArrayList<HashMap<String, Object>>();
        while(cs.moveToNext()){
            HashMap<String,Object> item=new HashMap<String, Object>();
            item.put("id",cs.getInt(0)+"");
            item.put("name",cs.getString(1));
            item.put("email",cs.getString(2));
            items.add(item);
        }

        SimpleAdapter aa=new SimpleAdapter(this,items,R.layout.db_layout,
                new String[]{"id","name","email"},
                new int[]{R.id.tvID,R.id.tvName,R.id.tvEmail});

        lv.setAdapter(aa);
    }

    public void clear(View view){
        db.delTab();
        Toast.makeText(this,"Data Cleared",Toast.LENGTH_LONG ).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mail_list, menu);
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
