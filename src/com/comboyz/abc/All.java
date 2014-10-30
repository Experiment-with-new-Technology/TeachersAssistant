package com.comboyz.abc;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;



public class All extends Activity 
{
ArrayList<String> all = new ArrayList<String>();
SQLiteDatabase db;
String option;
private ListView lvCheckBox;

    
	@Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_listview);
        Intent intent = getIntent();
        option=intent.getStringExtra("option");
 
        super.onCreate(savedInstanceState);
		  try{
		      db=openOrCreateDatabase("Teachersassistance",SQLiteDatabase.CREATE_IF_NECESSARY,null);
		      db.execSQL("Create Table if not exists tblcr(cr_serial INTEGER PRIMARY KEY AUTOINCREMENT,cr_type text, cr_course_no text,cr_course_name text,room text, cr_batch text,cr_hour integer,cr_minute integer,cr_day integer,mss text,s_mss text,cr_phone text)");
		      }catch(SQLException e){
		    	  
		      }
 
		      if(option.equals("All Class")){
		    	  all.add("Cr_name-Number-Batch-Time");
		      Cursor c=db.rawQuery("SELECT * FROM tblcr where cr_type='Class'",null);
		        c.moveToFirst();
		        while(!c.isAfterLast())
		        {
                String aab=c.getString(c.getColumnIndex("cr_course_name"));
		        String aa=c.getString(c.getColumnIndex("cr_course_no"));
                String aac=c.getString(c.getColumnIndex("cr_batch"));
                String h=c.getString(c.getColumnIndex("cr_hour"));
                String m=c.getString(c.getColumnIndex("cr_minute"));
                String d=c.getString(c.getColumnIndex("cr_day"));
		        all.add("Course Name: "+aab+"\nCourse Number: "+aa+"\nBatch Name: "+aac+"\nTime:"+h+":"+m+"/"+d);
		        c.moveToNext();
		        }
		        c.close(); 
		      
		      }
		      
		      if(option.equals("All Lab")){
		    	  all.add("Cr_name-Number-Batch-Time");
		      Cursor c=db.rawQuery("SELECT * FROM tblcr where cr_type='Lab'",null);
		        c.moveToFirst();
		        while(!c.isAfterLast())
		        {
                String aab=c.getString(c.getColumnIndex("cr_course_name"));
		        String aa=c.getString(c.getColumnIndex("cr_course_no"));
                String aac=c.getString(c.getColumnIndex("cr_batch"));
                String h=c.getString(c.getColumnIndex("cr_hour"));
                String m=c.getString(c.getColumnIndex("cr_minute"));
                String d=c.getString(c.getColumnIndex("cr_day"));
                all.add("Course Name: "+aab+"\nCourse Number: "+aa+"\nBatch Name: "+aac+"\nTime:"+h+":"+m+"/"+d);
		        c.moveToNext();
		        }
		        c.close(); 
		      
		      }
		      
		      
		      if(option.equals("All exam")){
		    	  all.add("Cr_name-Number-Batch-Time");
		      Cursor c=db.rawQuery("SELECT * FROM tblcr where cr_type='Exam'",null);
		        c.moveToFirst();
		        while(!c.isAfterLast())
		        {
                String aab=c.getString(c.getColumnIndex("cr_course_name"));
		        String aa=c.getString(c.getColumnIndex("cr_course_no"));
                String aac=c.getString(c.getColumnIndex("cr_batch"));
                String h=c.getString(c.getColumnIndex("cr_hour"));
                String m=c.getString(c.getColumnIndex("cr_minute"));
                String d=c.getString(c.getColumnIndex("cr_day"));
                all.add("Course Name: "+aab+"\nCourse Number: "+aa+"\nBatch Name: "+aac+"\nTime:"+h+":"+m+"/"+d);
		        c.moveToNext();
		        }
		        c.close(); 
		      
		      }
		      
		      
		      
		      if(option.equals("All Class Test")){
		    	  all.add("Cr_name-Number-Batch-Time");
		      Cursor c=db.rawQuery("SELECT * FROM tblcr where cr_type='Class_Test'",null);
		        c.moveToFirst();
		        while(!c.isAfterLast())
		        {
                String aab=c.getString(c.getColumnIndex("cr_course_name"));
		        String aa=c.getString(c.getColumnIndex("cr_course_no"));
                String aac=c.getString(c.getColumnIndex("cr_batch"));
                String h=c.getString(c.getColumnIndex("cr_hour"));
                String m=c.getString(c.getColumnIndex("cr_minute"));
                String d=c.getString(c.getColumnIndex("cr_day"));
                all.add("Course Name: "+aab+"\nCourse Number: "+aa+"\nBatch Name: "+aac+"\nTime:"+h+":"+m+"/"+d);
		        c.moveToNext();
		        }
		        c.close(); 
		      
		      }
		      
      	    
		      
lvCheckBox = (ListView)findViewById(R.id.lvCheckBox);
        lvCheckBox.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        lvCheckBox.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, all));
  
        
    }
	

	 protected void onStop() {
	        // TODO Auto-generated method stub
	        db.close();
	        super.onStop();
	      }


	
}