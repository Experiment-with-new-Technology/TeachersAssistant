package com.comboyz.abc;

import android.app.Activity;
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

public class Delete extends Activity {
	SQLiteDatabase db;
	Button deleteclass;
	String option;
	String w="";
	Cursor c;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete);
        Intent intent = getIntent();
		option=intent.getStringExtra("option");
        deleteclass=(Button) findViewById(R.id.buttondeleteclass);
        
        try{
            db=openOrCreateDatabase("Teachersassistance",SQLiteDatabase.CREATE_IF_NECESSARY,null);
            }catch(SQLException e)
            {
            }
            
            deleteclass.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
			        EditText jnumber=(EditText)findViewById(R.id.text_field_course_number);
			        
			            if(option.equals("Delete Class")){
			            	
			            	c=db.rawQuery("SELECT * FROM tblcr where cr_type='Class' and cr_course_no='"+jnumber.getText().toString()+"'",null);     
			            	  c.moveToFirst();
						        while(!c.isAfterLast())
						        {
						        	w=c.getString(c.getColumnIndex("cr_course_no"));
						        	c.moveToNext();
						        }
						        c.close();
			            	
			           if(((db.delete("tblcr", "cr_course_no='"+jnumber.getText().toString()+"' and cr_type='Class'", null))!=-1)&&!w.equals(""))
			        	   Toast.makeText(Delete.this, "Course number: "+jnumber.getText().toString()+" is Deleted Successfully", 2000).show();
                       else
			             Toast.makeText(Delete.this, "Delete Error,Please input correct information and try again", 2000).show();
			            }
			            
			            
			            
			            if(option.equals("Delete Lab")){
			            	c=db.rawQuery("SELECT * FROM tblcr where cr_type='Lab' and cr_course_no='"+jnumber.getText().toString()+"'",null);     
			            	  c.moveToFirst();
						        while(!c.isAfterLast())
						        {
						        	w=c.getString(c.getColumnIndex("cr_course_no"));
						        	c.moveToNext();
						        }
						        c.close();
			            	
			            	
					           if(((db.delete("tblcr", "cr_course_no='"+jnumber.getText().toString()+"' and cr_type='Lab'", null))!=-1)&&!w.equals(""))
					        	   Toast.makeText(Delete.this, "Lab: Course number: "+jnumber.getText().toString()+" is Deleted Successfully", 2000).show();
		                       else
					             Toast.makeText(Delete.this, "Delete Error,Please input correct information and try again", 2000).show();
					            }
			            
			            
			            
			            
			            if(option.equals("Delete exam")){
			            	c=db.rawQuery("SELECT * FROM tblcr where cr_type='Exam' and cr_course_no='"+jnumber.getText().toString()+"'",null);     
			            	  c.moveToFirst();
						        while(!c.isAfterLast())
						        {
						        	w=c.getString(c.getColumnIndex("cr_course_no"));
						        	c.moveToNext();
						        }
						        c.close();
			            	
			            	
					           if(((db.delete("tblcr", "cr_course_no='"+jnumber.getText().toString()+"' and cr_type='Exam'", null))!=-1)&&!w.equals(""))
					        	   Toast.makeText(Delete.this, "Exam:Course number: "+jnumber.getText().toString()+" is Deleted Successfully", 2000).show();
		                       else
					             Toast.makeText(Delete.this, "Delete Error,Please input correct information and try again", 2000).show();
					            }
			            
			            
			            
			            
			            if(option.equals("Delete class Test")){
			            	c=db.rawQuery("SELECT * FROM tblcr where cr_type='Class_Test' and cr_course_no='"+jnumber.getText().toString()+"'",null);     
			            	  c.moveToFirst();
						        while(!c.isAfterLast())
						        {
						        	w=c.getString(c.getColumnIndex("cr_course_no"));
						        	c.moveToNext();
						        }
						        c.close();
			            	
			            	
					           if(((db.delete("tblcr", "cr_course_no='"+jnumber.getText().toString()+"' and cr_type='Class_Test'", null))!=-1)&&!w.equals(""))
					        	   Toast.makeText(Delete.this, "Class Test:Course number: "+jnumber.getText().toString()+" is Deleted Successfully", 2000).show();
		                       else
					             Toast.makeText(Delete.this, "Delete Error,Please input correct information and try again", 2000).show();
					            }
			           
			           
			           
			           jnumber.setText("");

				}
			});

    }
    
    
    protected void onStop() {
        // TODO Auto-generated method stub
        db.close();
        super.onStop();
      }
 
}