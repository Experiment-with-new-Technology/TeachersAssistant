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

public class DemoEditClassTest extends Activity {
	SQLiteDatabase db;
	Button insertmark;
	String classname,ctname,aa;
	String w="";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.democlasstest);
        Intent intent = getIntent();
        classname=intent.getStringExtra("KeyToAccessData");
        ctname=intent.getStringExtra("column_name");   
 
        insertmark=(Button) findViewById(R.id.addmark);
        try{
            db=openOrCreateDatabase("Teachersassistance",SQLiteDatabase.CREATE_IF_NECESSARY,null);
        }catch(SQLException e)
            {
            }
        insertmark.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					EditText jmark=(EditText) findViewById(R.id.mark);
			        EditText jid=(EditText)findViewById(R.id.text_field_student_id);

			        Cursor c1=db.rawQuery("SELECT * FROM '"+classname+"' where id='"+jid.getText().toString()+"'",null);
			        c1.moveToFirst();
			        while(!c1.isAfterLast())
			        {
			        	w=c1.getString(c1.getColumnIndex("id"));
			        	c1.moveToNext();
			        }
			        c1.close();
			       
					
			           ContentValues values=new ContentValues(); 
                     values.put(ctname, Double.parseDouble(jmark.getText().toString()));

			           
			           if(((db.update(classname, values,"id='"+jid.getText().toString()+"'", null))!=-1)&&!w.equals(""))
			           {
			           Toast.makeText(DemoEditClassTest.this, "Record Successfully Inserted", 2000).show();
			           }
			           else
			           {
			           Toast.makeText(DemoEditClassTest.this, "update Error,Please input correct information and try again", 2000).show();
			           }
			           jid.setText("");
			           jmark.setText("");
					
					
			        
					
					
				}
			});
            
        
    }

    
    protected void onStop() {
        // TODO Auto-generated method stub
        db.close();
        super.onStop();
      }
    
   
}