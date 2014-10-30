package com.comboyz.abc;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Ct extends Activity 
{
ArrayList<String> all = new ArrayList<String>();
String yy;
private ListView lvCheckBox;
    
	@Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_listview);
        Intent intent = getIntent();
      all.add("Class Test 1");
      all.add("Class Test 2");
      all.add("Class Test 3");
      all.add("Class Test 4");
      all.add("Class Test 5");
      yy=intent.getStringExtra("KeyToAccessData");
      
  
		        
		      
lvCheckBox = (ListView)findViewById(R.id.lvCheckBox);
        lvCheckBox.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        lvCheckBox.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, all));
       lvCheckBox.setOnItemClickListener(
    	        new OnItemClickListener()
    	        {

    	            public void onItemClick(AdapterView<?> arg0, View view,
    	                    int position, long id) {

    	                Object o = lvCheckBox.getItemAtPosition(position);
    	                String cheese = o.toString();
    	               if(cheese.equals("Class Test 1"))cheese="ct1";
    	               if(cheese.equals("Class Test 2"))cheese="ct2";
    	               if(cheese.equals("Class Test 3"))cheese="ct3";
    	               if(cheese.equals("Class Test 4"))cheese="ct4";
    	               if(cheese.equals("Class Test 5"))cheese="ct5";
    	               
    	                try{
    	            	    @SuppressWarnings("rawtypes")
    	            	    Class ourClass=Class.forName("com.comboyz.abc.DemoClassTest");
    	            		Intent ourIntent=new Intent(Ct.this,ourClass);
    	            		ourIntent.putExtra("KeyToAccessData", yy);
    	            		ourIntent.putExtra("column_name", cheese);
    	            		startActivity(ourIntent);
    	            		}catch(ClassNotFoundException e){
    	            			e.printStackTrace();
    	            		}    
    	               
    	               
    	            }

					   
    	        }       
    	);
        
        
    }
	
	
  
    
	public boolean onCreateOptionsMenu(Menu menu) {
    	MenuInflater inflater=getMenuInflater();
    	inflater.inflate(R.menu.show, menu);
    	return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
     if(item.getItemId()==R.id.item1){
    	 try{
    		 String thisclass_name="ct";
  		    Class<?> ourClass=Class.forName("com.comboyz.abc.Show");
  			Intent ourIntent=new Intent(Ct.this,ourClass);
  			ourIntent.putExtra("KeyToAccessData", yy);
     		ourIntent.putExtra("name",thisclass_name);
  			startActivity(ourIntent);
  			}catch(ClassNotFoundException e){
  				e.printStackTrace();
  			}
     
     }
     
     if(item.getItemId()==R.id.item2){
    	 try{
    		 String thisclass_name="ct";
  		    Class<?> ourClass=Class.forName("com.comboyz.abc.Createtxt");
  			Intent ourIntent=new Intent(Ct.this,ourClass);
  			ourIntent.putExtra("KeyToAccessData", yy);
     		ourIntent.putExtra("name",thisclass_name);
  			startActivity(ourIntent);
  			}catch(ClassNotFoundException e){
  				e.printStackTrace();
  			}
     
     }
     
     
     
     
    	return super.onOptionsItemSelected(item);
    }	

     
     
     
     
    



	
	
	
	

}