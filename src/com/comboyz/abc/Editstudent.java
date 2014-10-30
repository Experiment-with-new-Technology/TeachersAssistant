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


public class Editstudent extends Activity {
	SQLiteDatabase db;
	Button editstudent;
	String yy;String w="",x="";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editstudent);
        Intent intent = getIntent();
        yy=intent.getStringExtra("KeyToAccessData");
 
        editstudent=(Button) findViewById(R.id.buttoneditstudent);
        try{
            db=openOrCreateDatabase("Teachersassistance",SQLiteDatabase.CREATE_IF_NECESSARY,null);            
        }catch(SQLException e)
            {
            }
            editstudent.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {

					
					EditText jname=(EditText) findViewById(R.id.text_field_student_name);
			        EditText jid=(EditText)findViewById(R.id.text_field_student_id);
			        
			        Cursor c=db.rawQuery("SELECT * FROM '"+yy+"' where id='"+jid.getText().toString()+"'",null);
			        c.moveToFirst();
			        while(!c.isAfterLast())
			        {
			        	w=c.getString(c.getColumnIndex("id"));
			        	c.moveToNext();
			        }
			        c.close();
			        
			        
			           ContentValues values=new ContentValues(); 
			           values.put("id", jid.getText().toString());
			           values.put("name", jname.getText().toString());
			           
			           if(((db.update(yy, values, "id='"+jid.getText().toString()+"'", null))!=-1)&&!w.equals(""))
                            Toast.makeText(Editstudent.this, "Record Successfully updated", 2000).show();
			              else
			        		   Toast.makeText(Editstudent.this, "update Error,Please input correct information and try again", 2000).show();
			        		   
			           jid.setText("");
			           jname.setText("");
					
					
				
					
					
				}
			});
            
        
    }
    
    
    protected void onStop() {
        // TODO Auto-generated method stub
        db.close();
        super.onStop();
      }
    
   
}