package com.comboyz.abc;





import java.io.File;

import android.app.Activity;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Deleteclass extends Activity {
	SQLiteDatabase db;
	Button deleteclass;
	String w="";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deleteclass);
       
 
        deleteclass=(Button) findViewById(R.id.buttondeleteclass);
        try{
            db=openOrCreateDatabase("Teachersassistance",SQLiteDatabase.CREATE_IF_NECESSARY,null);
            }catch(SQLException e)
            {
            }
            
  
            
            
            
            
            
            deleteclass.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
			        EditText jnumber=(EditText)findViewById(R.id.text_field_course_number);
			        
			        Cursor c1=db.rawQuery("SELECT * FROM allclass where number='"+jnumber.getText().toString()+"'",null);
			        c1.moveToFirst();
			        while(!c1.isAfterLast())
			        {
			        	w=c1.getString(c1.getColumnIndex("number"));
			        	c1.moveToNext();
			        }
			        c1.close(); 
			        
			        
			           if(((db.delete("allclass", "number='"+jnumber.getText().toString()+"'", null))!=-1)&&!w.equals(""))
			           {
			        	   Cursor c=db.rawQuery("SELECT * FROM allclass where number='"+jnumber.getText().toString()+"'",null);
	    			        c.moveToFirst();
	    			        while(!c.isAfterLast())
	    			        {
	    			        String aa =c.getString(c.getColumnIndex("title")); 
	    			       db.execSQL("DROP TABLE '"+aa+"'");	    			       
	    			       File file = new File("/sdcard/TeachersAssistant/"+aa);
	    			       if(file.exists()){
	    			    	   boolean success = deleteNon_EmptyDir(file);
	    			    	   if(!success)
				        		   Toast.makeText(Deleteclass.this, "Delete Error,Please input correct information and try again", 2000).show();}
	    			        c.moveToNext();
	    			        }
	    			        c.close();
			        	   
			        	   
			        	   
			        	   
			        	   
			           Toast.makeText(Deleteclass.this, "Course number: "+jnumber.getText().toString()+" is Deleted Successfully", 2000).show();
			           }
			           else
			
			        		   Toast.makeText(Deleteclass.this, "Delete Error,Please input correct information and try again", 2000).show();
			           
			           jnumber.setText("");

					
				}
			});

    }
    
    
    protected void onStop() {
        // TODO Auto-generated method stub
        db.close();
        super.onStop();
      }
    
    
	public static boolean deleteNon_EmptyDir(File dir) {
	    if (dir.isDirectory()) {
	        String[] children = dir.list();
	        for (int i=0; i<children.length; i++) {
	            boolean success = deleteNon_EmptyDir(new File(dir, children[i]));
	            if (!success) {
	                return false;
	            }
	        }
	    }
	    return dir.delete();
	}


    
   
}