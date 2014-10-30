package com.comboyz.abc;



import java.io.File;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Addclass extends Activity {
	SQLiteDatabase db;
	String aa;
	Button insertclass;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addclass);
        insertclass=(Button) findViewById(R.id.buttoninsertclass);
        
        
        
        
        
        try{
            db=openOrCreateDatabase("Teachersassistance",SQLiteDatabase.CREATE_IF_NECESSARY,null);
           db.execSQL("Create Table if not exists allclass(title text,number text)");
           // db.execSQL(ssql);
            }catch(SQLException e)
            {
            }
            insertclass.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					EditText jtitle=(EditText) findViewById(R.id.text_field_course_title);
			        EditText jnumber=(EditText)findViewById(R.id.text_field_course_number);
			        db.execSQL("Create Table if not exists '"+jtitle.getText().toString()+"'(serial INTEGER PRIMARY KEY AUTOINCREMENT,id text,name text,attendence integer,ct1 real,ct2 real,ct3 real,ct4 real,ct5 real,avg real,assignment real,exam real,total real,grad text)");
			        
			        Cursor c=db.rawQuery("SELECT * FROM allclass where title='"+jtitle.getText().toString()+"'",null);
			        c.moveToFirst();
			        while(!c.isAfterLast())
			        {
			        aa =c.getString(c.getColumnIndex("title")); 
			        c.moveToNext();
			        }
			        c.close();
			        if(jtitle.getText().toString().equals(aa))
			        	Toast.makeText(Addclass.this, "This Course is already token", 2000).show();
			        else{
	           ContentValues values=new ContentValues();
			           values.put("title", jtitle.getText().toString());
			           values.put("number", jnumber.getText().toString());
			           
			           if((db.insert("allclass", null, values))!=-1)
			           {
			        	   
			        	   
			        	   
			        	   Toast.makeText(Addclass.this, "Successfully "+jtitle.getText().toString()+" Inserted", 2000).show();
			        	  
			        	   
			        	   
			        	   File dir = new File("/sdcard/TeachersAssistant/"+jtitle.getText().toString()); 
			               if (!dir.exists() ){
			                    if (!dir.mkdir()){ 
			                  	  Toast.makeText(Addclass.this, "Unable to create directory", 1000).show();
			                       return; 
			                   } 
			               } 
			        	   
			        	   
			        	  
			               
			               
			           }
			           else
			           {
			           Toast.makeText(Addclass.this, "Insert Error,Please input correct information and try again", 2000).show();
			           }
			           jtitle.setText("");
			           jnumber.setText("");
					
					
			        }
					
					
				}
			});
            
        
    }
    
    
    protected void onStop() {
        // TODO Auto-generated method stub
        db.close();
        super.onStop();
      }
    
   
}