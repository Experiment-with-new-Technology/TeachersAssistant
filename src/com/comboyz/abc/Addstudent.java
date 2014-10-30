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


public class Addstudent extends Activity {
	SQLiteDatabase db;
	Button insertstudent;
	String yy,aa,name;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addstudent);
        Intent intent = getIntent();
        yy=intent.getStringExtra("KeyToAccessData");
        name=intent.getStringExtra("name");
        
        insertstudent=(Button) findViewById(R.id.buttoninsertstudent);
        try{
            db=openOrCreateDatabase("Teachersassistance",SQLiteDatabase.CREATE_IF_NECESSARY,null);
        }catch(SQLException e)
            {
            }
            insertstudent.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					EditText jname=(EditText) findViewById(R.id.text_field_student_name);
			        EditText jid=(EditText)findViewById(R.id.text_field_student_id);
					
					Cursor c=db.rawQuery("SELECT * FROM '"+yy+"' where id='"+jid.getText().toString()+"'",null);
			        c.moveToFirst();
			        while(!c.isAfterLast())
			        {
			        aa =c.getString(c.getColumnIndex("id")); 
			        c.moveToNext();
			        }
			        c.close();
			        if(jid.getText().toString().equals(aa))
			        	Toast.makeText(Addstudent.this, "This Id is already token", 2000).show();
			        else{
					
					
					if(name.equals("Democlass")){
						
						ContentValues values=new ContentValues(); 
				           values.put("id", jid.getText().toString());
				           values.put("name", jname.getText().toString());
				           values.put("attendence", 0);
				           values.put("ct1", 0.00);
				           values.put("ct2", 0.00);
				           values.put("ct3", 0.00);
				           values.put("ct4", 0.00);
				           values.put("ct5", 0.00);
				           values.put("avg", 0.00);
				           values.put("assignment", 0.00);
				           values.put("exam", 0.00);
				           values.put("total", 0.00);
				           values.put("grad", "F");
				           
				           if((db.insert(yy, null, values))!=-1)
				           {
				           Toast.makeText(Addstudent.this, "Record Successfully Inserted", 2000).show();
				           }
				           else
				           {
				           Toast.makeText(Addstudent.this, "Insert Error", 2000).show();
				           }
				           jid.setText("");
				           jname.setText("");	
				
					}
					else{
					
					
					
			           ContentValues values=new ContentValues(); 
			           values.put("id", jid.getText().toString());
			           values.put("name", jname.getText().toString());
			           values.put("attendence", 0);
			           values.put("assignment", 0.00);
			           values.put("labperformance", 0.00);
			           values.put("labfinal", 0.00);
			           
			           if((db.insert(yy, null, values))!=-1)
			           {
			           Toast.makeText(Addstudent.this, "Record Successfully Inserted", 2000).show();
			           }
			           else
			           {
			           Toast.makeText(Addstudent.this, "Insert Error", 2000).show();
			           }
			           jid.setText("");
			           jname.setText("");
					
					}
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