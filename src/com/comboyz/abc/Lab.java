package com.comboyz.abc;

import java.util.ArrayList;
import java.util.StringTokenizer;



import android.app.Activity;
import android.content.Intent;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;



public class Lab extends Activity 
{
ArrayList<String> all = new ArrayList<String>();
SQLiteDatabase db;
private ListView lvCheckBox;
    
	@Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_listview);
        
        super.onCreate(savedInstanceState);
		  try{
		      db=openOrCreateDatabase("Teachersassistance",SQLiteDatabase.CREATE_IF_NECESSARY,null);
		      }catch(SQLException e){
		    	  
		      }
        
		      Cursor c=db.rawQuery("SELECT * FROM lab",null);
		        c.moveToFirst();
		        while(!c.isAfterLast())
		        {
		        	String aab=c.getString(c.getColumnIndex("number"));
		        String aa=c.getString(c.getColumnIndex("title"));
		        all.add(aa+": "+aab);
		        c.moveToNext();
		        }
		        c.close();     
		      
lvCheckBox = (ListView)findViewById(R.id.lvCheckBox);
        lvCheckBox.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        lvCheckBox.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, all));
       lvCheckBox.setOnItemClickListener(
    	        new OnItemClickListener()
    	        {

    	            public void onItemClick(AdapterView<?> arg0, View view,
    	                    int position, long id) {

    	                Object o = lvCheckBox.getItemAtPosition(position);
    	                String cheese = o.toString();
    	                StringTokenizer st = new StringTokenizer(cheese,":");
    	                cheese=(String) st.nextElement();
    	               
    	                try{
    	            	    @SuppressWarnings("rawtypes")
    	            	    Class ourClass=Class.forName("com.comboyz.abc.Demolab");
    	            		Intent ourIntent=new Intent(Lab.this,ourClass);
    	            		ourIntent.putExtra("KeyToAccessData", cheese);
    	            		startActivity(ourIntent);
    	            		}catch(ClassNotFoundException e){
    	            			e.printStackTrace();
    	            		}    
    	               
    	               
    	            }

					   
    	        }       
    	);
        
        
    }
	
	
	
	
    
	
	
	 protected void onStop() {
	        // TODO Auto-generated method stub
	        db.close();
	        super.onStop();
	      }


	
	
	
	

}