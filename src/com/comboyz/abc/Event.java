package com.comboyz.abc;
import java.util.ArrayList;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;



public class Event extends Activity 
{
ArrayList<String> all = new ArrayList<String>();

private ListView lvCheckBox;
SQLiteDatabase db;
	@Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_listview);
      
        all.add("Class Routine");
        all.add("Lab Schedule");
        all.add("Meeting Schedule");
        all.add("Examination Schedue");
        all.add("Class Test Schedule");
        all.add("Others");
  
		        
		      
lvCheckBox = (ListView)findViewById(R.id.lvCheckBox);
        lvCheckBox.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        lvCheckBox.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, all));
       lvCheckBox.setOnItemClickListener(
    	        new OnItemClickListener()
    	        {

    	            public void onItemClick(AdapterView<?> arg0, View view,
    	                    int position, long id) {
    	                // TODO Auto-generated method stub
    	                Object o = lvCheckBox.getItemAtPosition(position);
    	                String cheese = o.toString();
    	                if(cheese.equals("Others"))cheese="Others"; 
    	                else if(cheese.equals("Class Test Schedule")) cheese="ClassTestSchedule";
    	                else if(cheese.equals("Class Routine"))cheese="ClassRoutine";
    	                else if(cheese.equals("Lab Schedule"))cheese="LabSchedule";
    	                else if(cheese.equals("Meeting Schedule"))cheese="MeetingSchedule";
    	                else if(cheese.equals("Examination Schedue"))cheese="ExaminationSchedue";
    	                try{
    	            	    
    	            	    if(!cheese.equals("MeetingSchedule")){
    	            	    @SuppressWarnings("rawtypes")
							Class ourClass=Class.forName("com.comboyz.abc.Demoevent");
                            Intent ourIntent=new Intent(Event.this,ourClass);
    	            	    ourIntent.putExtra("event",cheese);
    	            		startActivity(ourIntent);
    	            	    }
    	            	    
    	            	    else if(cheese.equals("MeetingSchedule")){
    	            	    	
    	            	    	
    	            	    	
    	            	    }
    	            		
    	            		}catch(ClassNotFoundException e){
    	            			e.printStackTrace();
    	            		}
    	               
    	            }

					   
    	        }       
    	);
       
       
       
       
       
        
        
    }
	
	
	

	 public boolean onCreateOptionsMenu(Menu menu) {
	    	MenuInflater inflater=getMenuInflater();
	    	inflater.inflate(R.menu.mainmenu, menu);
	    	return true;
	    }
	    
	    @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	     if(item.getItemId()==R.id.item1){
	    	 try{
	    		    Class<?> ourClass=Class.forName("com.comboyz.abc.Startschedule");
	    			Intent ourIntent=new Intent(Event.this,ourClass);
	    			startActivity(ourIntent);
	    			}catch(ClassNotFoundException e){
	    				e.printStackTrace();
	    			}
	    	 
	     }
	     
	     if(item.getItemId()==R.id.item2){
		        try{
				      db=openOrCreateDatabase("Teachersassistance",SQLiteDatabase.CREATE_IF_NECESSARY,null);
				      db.execSQL("Create Table if not exists tblcrw(cr_serial INTEGER PRIMARY KEY AUTOINCREMENT,cr_type text, cr_course_no text,cr_course_name text,room text, cr_batch text,cr_hour integer,cr_minute integer,cr_day integer,mss text,s_mss text,cr_phone text)");
				      Cursor c=db.rawQuery("SELECT * FROM tblcrw",null);
				      
				      ContentValues values=new ContentValues();
				      c.moveToFirst();
				      while(!c.isAfterLast())
				        {
				      values.put("cr_type",c.getString(c.getColumnIndex("cr_type")));
					   values.put("cr_course_no",c.getString(c.getColumnIndex("cr_course_no")));
			           values.put("cr_course_name",c.getString(c.getColumnIndex("cr_course_name")) );
			           values.put("room",c.getString(c.getColumnIndex("room")));
			           values.put("cr_batch",c.getString(c.getColumnIndex("cr_batch"))); 
			           values.put("cr_hour",Integer.parseInt(c.getString(c.getColumnIndex("cr_hour"))));
			           values.put("cr_minute",Integer.parseInt(c.getString(c.getColumnIndex("cr_minute"))));
			           values.put("cr_day",Integer.parseInt(c.getString(c.getColumnIndex("cr_day"))));
			           values.put("mss",c.getString(c.getColumnIndex("mss")));
			           values.put("s_mss",c.getString(c.getColumnIndex("s_mss")));
			           values.put("cr_phone",c.getString(c.getColumnIndex("cr_phone")));
			           db.insert("tblcr", null, values);
			           c.moveToNext();
				        }
				        c.close();
				      db.execSQL("delete from tblcrw") ;
				      Toast.makeText(getApplicationContext(), "Schedule is updated for next week", Toast.LENGTH_SHORT).show();
		        
		        }catch(SQLException e){
				    	  
				      }	}
	     
	    	return super.onOptionsItemSelected(item);
	    }


	
	
	
	

}