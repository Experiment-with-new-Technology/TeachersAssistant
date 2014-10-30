package com.comboyz.abc;



import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class DemoClassTest extends Activity {
	SQLiteDatabase db;
	Button insertmark;
	String classname,ctname,aa;
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

			       
					
			           ContentValues values=new ContentValues(); 
                     values.put(ctname, Double.parseDouble(jmark.getText().toString()));
			           
			           if((db.update(classname, values,"id='"+jid.getText().toString()+"'", null))!=-1)
			           {
			           Toast.makeText(DemoClassTest.this, "Record Successfully Inserted", 2000).show();
			           }
			           else
			           {
			           Toast.makeText(DemoClassTest.this, "update Error,Please input correct information and try again", 2000).show();
			           }
			           jid.setText("");
			           jmark.setText("");
					
					
			        
					
					
				}
			});
            
        
    }
    
    public boolean onCreateOptionsMenu(Menu menu) {
    	MenuInflater inflater=getMenuInflater();
    	inflater.inflate(R.menu.editmark, menu);
    	return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
     if(item.getItemId()==R.id.item1){
    	 try{
 		    Class<?> ourClass=Class.forName("com.comboyz.abc.DemoEditClassTest");
 			Intent ourIntent=new Intent(DemoClassTest.this,ourClass);
 			ourIntent.putExtra("KeyToAccessData", classname);
    		ourIntent.putExtra("column_name", ctname);
 			startActivity(ourIntent);
 			}catch(ClassNotFoundException e){
 				e.printStackTrace();
 			}
     }
     
     
     if(item.getItemId()==R.id.item2){
    	 try{
    		 
 		    Class<?> ourClass=Class.forName("com.comboyz.abc.Show");
 			Intent ourIntent=new Intent(DemoClassTest.this,ourClass);
 			ourIntent.putExtra("KeyToAccessData", classname);
    		ourIntent.putExtra("name", ctname);
 			startActivity(ourIntent);
 			}catch(ClassNotFoundException e){
 				e.printStackTrace();
 			}
     }
     
     if(item.getItemId()==R.id.item3){
    	 try{
    		 
    		 Class<?> ourClass=Class.forName("com.comboyz.abc.Createtxt");
 			Intent ourIntent=new Intent(DemoClassTest.this,ourClass);
 			ourIntent.putExtra("KeyToAccessData", classname);
    		ourIntent.putExtra("name", ctname);
 			startActivity(ourIntent);
 			}catch(ClassNotFoundException e){
 				e.printStackTrace();
 			}
     }
     
     
     
  
     
    	return super.onOptionsItemSelected(item);
    }
    
    protected void onStop() {
        // TODO Auto-generated method stub
        db.close();
        super.onStop();
      }
    
   
}