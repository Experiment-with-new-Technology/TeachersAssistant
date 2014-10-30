package com.comboyz.abc;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AddRepresentative extends Activity {
	SQLiteDatabase db;
	String w="",event;
	Cursor c;
	Button editclass;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.representative);
		Intent intent = getIntent();
		event=intent.getStringExtra("event");       
 
        editclass=(Button) findViewById(R.id.b);
        try{
            db=openOrCreateDatabase("Teachersassistance",SQLiteDatabase.CREATE_IF_NECESSARY,null);
            }catch(SQLException e)
            {
            }
            
     
            
            
            editclass.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					EditText jcourse_number=(EditText) findViewById(R.id.text_course_number);
			        EditText jcr_number=(EditText)findViewById(R.id.text_phone);
			        
			   if(event.equals("ClassRoutine"))        
					   c=db.rawQuery("SELECT * FROM tblcr where cr_type='Class' and cr_course_no='"+jcourse_number.getText().toString()+"'",null);			           
			 
			   if(event.equals("LabSchedule"))        
				   c=db.rawQuery("SELECT * FROM tblcr where cr_type='Lab' and cr_course_no='"+jcourse_number.getText().toString()+"'",null);			                   
				
			   if(event.equals("ExaminationSchedue"))        
				   c=db.rawQuery("SELECT * FROM tblcr where cr_type='Exam' and cr_course_no='"+jcourse_number.getText().toString()+"'",null);			           
			
			   if(event.equals("ClassTestSchedule"))        
				   c=db.rawQuery("SELECT * FROM tblcr where cr_type='Class_Test' and cr_course_no='"+jcourse_number.getText().toString()+"'",null);			           
		
				  c.moveToFirst();
			        while(!c.isAfterLast())
			        {
			        	w=c.getString(c.getColumnIndex("cr_course_no"));
			        	c.moveToNext();
			        }
			        c.close();
			   
			   ContentValues values=new ContentValues();
			           values.put("cr_phone", jcr_number.getText().toString());
			           
			           
			        	   if(((db.update("tblcr", values, "cr_course_no='"+jcourse_number.getText().toString()+"'", null))!=-1)&&!w.equals(""))
			           {
			        		   Toast.makeText(AddRepresentative.this, "Record Successfully updated", 2000).show();
			           
			           }
			        	   else
			        		   Toast.makeText(AddRepresentative.this, "update Error,Please input correct information and try again", 2000).show();
			           

			           jcourse_number.setText("");
			           jcr_number.setText("");
					
					
					
					
					
				}
			});
            
        
    }
    
    
    protected void onStop() {
        // TODO Auto-generated method stub
        db.close();
        super.onStop();
      }
    
   
}