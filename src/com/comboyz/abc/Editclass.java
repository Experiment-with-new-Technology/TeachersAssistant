package com.comboyz.abc;





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


public class Editclass extends Activity {
	SQLiteDatabase db;
	String w="";
	Button editclass;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editclass);
       
 
        editclass=(Button) findViewById(R.id.buttoneditclass);
        try{
            db=openOrCreateDatabase("Teachersassistance",SQLiteDatabase.CREATE_IF_NECESSARY,null);
            }catch(SQLException e)
            {
            }
            
     
            
            
            editclass.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					EditText jtitle=(EditText) findViewById(R.id.text_field_course_title);
			        EditText jnumber=(EditText)findViewById(R.id.text_field_course_number);
			        
			           ContentValues values=new ContentValues();
			           values.put("title", jtitle.getText().toString());
			           values.put("number", jnumber.getText().toString());
			           
			           Cursor c=db.rawQuery("SELECT * FROM allclass where title='"+jtitle.getText().toString()+"'",null);
				        c.moveToFirst();
				        while(!c.isAfterLast())
				        {
				        	w=c.getString(c.getColumnIndex("title"));
				        	c.moveToNext();
				        }
				        c.close(); 
				        
			           
			           
			        	   if(((db.update("allclass", values, "title='"+jtitle.getText().toString()+"'", null))!=-1)&&!w.equals(""))
			           {
			        		   Toast.makeText(Editclass.this, "Record Successfully updated", 2000).show();
			           
			           }
			        	   else
			        		   Toast.makeText(Editclass.this, "update Error,Please input correct information and try again", 2000).show();
			           

			           jtitle.setText("");
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