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


public class Deletestudent extends Activity {
	SQLiteDatabase db;
	Button deletestudent;
	String yy;String w="";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deletestudent);
        Intent intent = getIntent();
        yy=intent.getStringExtra("KeyToAccessData");
 
        deletestudent=(Button) findViewById(R.id.buttondeletestudent);
        try{
            db=openOrCreateDatabase("Teachersassistance",SQLiteDatabase.CREATE_IF_NECESSARY,null);
           
        }catch(SQLException e)
            {
            }
            deletestudent.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
			        EditText jid=(EditText)findViewById(R.id.text_field_student_id);
			        
			        Cursor c1=db.rawQuery("SELECT * FROM '"+yy+"' where id='"+jid.getText().toString()+"'",null);
			        c1.moveToFirst();
			        while(!c1.isAfterLast())
			        {
			        	w=c1.getString(c1.getColumnIndex("id"));
			        	c1.moveToNext();
			        }
			        c1.close();	
			        
			        
			        
			           if(((db.delete(yy, "id='"+jid.getText().toString()+"'", null))!=-1)&&!w.equals(""))
			           {
			           Toast.makeText(Deletestudent.this, "Student Id: "+jid.getText().toString()+" is Deleted Successfully", 2000).show();
			           }
			           else
			           {
			           Toast.makeText(Deletestudent.this, "Delete Error,Please input correct information and try again", 2000).show();
			           }
			           jid.setText("");
					
				}
			});
            
        
    }
    
    
    protected void onStop() {
        // TODO Auto-generated method stub
        db.close();
        super.onStop();
      }
    
   
}