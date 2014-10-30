package com.comboyz.abc;

import java.util.ArrayList;



import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class Attendence extends Activity 
{
ArrayList<String> allstudent = new ArrayList<String>();
SQLiteDatabase db;
String yy,ppp;
int a[]=new int[5000];
public String roll_number;
private ListView lvCheckBox;
    
	@Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_listview);
        Intent intent = getIntent();
        yy=intent.getStringExtra("KeyToAccessData");
        for(int i=0;i<4999;i++)
        a[i]=0;
        try{
		      db=openOrCreateDatabase("Teachersassistance",SQLiteDatabase.CREATE_IF_NECESSARY,null);
		      db.execSQL("Create Table if not exists '"+yy+"'(serial INTEGER PRIMARY KEY,id text,name text,attendence integer,ct1 real,ct2 real,ct3 real,ct4 real,ct5 real,avg real,assignment real,exam real,total real,grad text)");		   
		      }catch(SQLException e){
		    	  
		      }
        
		      Cursor c=db.rawQuery("SELECT * FROM '"+yy+"'",null);
		        c.moveToFirst();
		        while(!c.isAfterLast())
		        {
		      roll_number=c.getString(c.getColumnIndex("id"));
		        String aab=c.getString(c.getColumnIndex("name"));
		        allstudent.add("Roll: "+roll_number+"\n Name: "+aab);
		        c.moveToNext();
		        }
		        c.close();
		        
		        
lvCheckBox = (ListView)findViewById(R.id.lvCheckBox);
        lvCheckBox.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        lvCheckBox.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice, allstudent));
       lvCheckBox.setOnItemClickListener(
    	        new OnItemClickListener()
    	        {

    	            public void onItemClick(AdapterView<?> arg0, View view,
    	                    int position, long id) {
    	             
    	                
    	                Cursor c=db.rawQuery("SELECT * FROM '"+yy+"' where id='"+roll_number+"'",null);
    			        c.moveToFirst();
    			        int aa=0,b=0;
    			        while(!c.isAfterLast())
    			        {
    			        aa =Integer.parseInt(c.getString(c.getColumnIndex("attendence"))); 
    			        b =Integer.parseInt(c.getString(c.getColumnIndex("serial"))); 
    			        c.moveToNext();
    			        }
    			        c.close();
    	                if(a[b]==0){
    	                aa++;a[b]=1;}
    	                else
    	                {aa--;a[b]=0;}
    	                db.execSQL("update '"+yy+"' set attendence="+aa+" where id='"+roll_number+"'");		   
    	                Toast.makeText(Attendence.this, "Attendence::: "+aa, 2000).show();
    	            }

					   
    	        }       
    	);
        
        
    }
	
	
	
	
    public boolean onCreateOptionsMenu(Menu menu) {
    	MenuInflater inflater=getMenuInflater();
    	inflater.inflate(R.menu.show, menu);
    	return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
     if(item.getItemId()==R.id.item1){
    	 try{
    		 String thisclassname="Attendence";
 		    Class<?> ourClass=Class.forName("com.comboyz.abc.Show");
 			Intent ourIntent=new Intent(Attendence.this,ourClass);
 			ourIntent.putExtra("KeyToAccessData", yy);
 			ourIntent.putExtra("name", thisclassname);
 			startActivity(ourIntent);
 			}catch(ClassNotFoundException e){
 				e.printStackTrace();
 			}
     }
     
     if(item.getItemId()==R.id.item2){
    	 try{
    		 String thisclassname="Attendence";
 		    Class<?> ourClass=Class.forName("com.comboyz.abc.Createtxt");
 			Intent ourIntent=new Intent(Attendence.this,ourClass);
 			ourIntent.putExtra("KeyToAccessData", yy);
 			ourIntent.putExtra("name", thisclassname);
 			startActivity(ourIntent);
 			}catch(ClassNotFoundException e){
 				e.printStackTrace();
 			}
     }
     

    	return super.onOptionsItemSelected(item);
    }	


	
	
	
	protected void onStop() {
        // TODO Auto-generated method stub
        db.close();
        super.onStop();
      }

}