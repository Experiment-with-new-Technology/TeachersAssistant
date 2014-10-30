package com.comboyz.abc;

import java.util.ArrayList;



import android.app.Activity;

import android.content.ContentValues;
import android.content.Intent;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;



public class Show extends Activity 
{
ArrayList<String> all = new ArrayList<String>();
SQLiteDatabase db;
String yy,name;
private ListView lvCheckBox;
Double avmark[]=new Double[5000];
int number_of_row=0;
int serial_number[]=new int[5000];
    
	@Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_listview);
        Intent intent = getIntent();
        yy=intent.getStringExtra("KeyToAccessData");
        name=intent.getStringExtra("name");
        super.onCreate(savedInstanceState);
		  try{
		      db=openOrCreateDatabase("Teachersassistance",SQLiteDatabase.CREATE_IF_NECESSARY,null);
		      }catch(SQLException e){
		    	  
		      }
		      
		      
		      
		      
		      if(name.equals("Attendence")){
		    	  all.add("             Attendence");
		      all.add("Student ID :Total Attendence");
		      Cursor c=db.rawQuery("SELECT * FROM '"+yy+"'",null);
		        c.moveToFirst();
		        while(!c.isAfterLast())
		        {
		        	String aab=c.getString(c.getColumnIndex("id"));
		        String aa=c.getString(c.getColumnIndex("attendence"));
		        all.add(aab+"    :   "+aa);
		        c.moveToNext();
		        }
		        c.close();  
		      
		      }
		      
		      
		      
		      
		      if(name.equals("ct1")){
		    	  all.add("              Class Test 1");
		      all.add("Student ID :  Mark");
		      Cursor c=db.rawQuery("SELECT * FROM '"+yy+"'",null);
		        c.moveToFirst();
		        while(!c.isAfterLast())
		        {
		        	String aab=c.getString(c.getColumnIndex("id"));
		        String aa=c.getString(c.getColumnIndex("ct1"));
		        all.add(aab+"    :   "+aa);
		        c.moveToNext();
		        }
		        c.close(); 
		      
		      }
		      
		      
		      if(name.equals("ct2")){
		    	  all.add("              Class Test 2");
		      all.add("Student ID :  Mark");
		      Cursor c=db.rawQuery("SELECT * FROM '"+yy+"'",null);
		        c.moveToFirst();
		        while(!c.isAfterLast())
		        {
		        	String aab=c.getString(c.getColumnIndex("id"));
		        String aa=c.getString(c.getColumnIndex("ct2"));
		        all.add(aab+"    :   "+aa);
		        c.moveToNext();
		        }
		        c.close(); 
		      
		      }
		      
		      
		      
		      
		      
		      if(name.equals("ct3")){
		    	  all.add("              Class Test 3");
		      all.add("Student ID :  Mark");
		      Cursor c=db.rawQuery("SELECT * FROM '"+yy+"'",null);
		        c.moveToFirst();
		        while(!c.isAfterLast())
		        {
		        	String aab=c.getString(c.getColumnIndex("id"));
		        String aa=c.getString(c.getColumnIndex("ct3"));
		        all.add(aab+"    :   "+aa);
		        c.moveToNext();
		        }
		        c.close(); 
		      
		      }
		      
		      
		      
		      
		      if(name.equals("ct4")){
		    	  all.add("              Class Test 4");
		      all.add("Student ID :  Mark");
		      Cursor c=db.rawQuery("SELECT * FROM '"+yy+"'",null);
		        c.moveToFirst();
		        while(!c.isAfterLast())
		        {
		        	String aab=c.getString(c.getColumnIndex("id"));
		        String aa=c.getString(c.getColumnIndex("ct4"));
		        all.add(aab+"    :   "+aa);
		        c.moveToNext();
		        }
		        c.close(); 
		      
		      }
		      
		      
		      
		      
		      if(name.equals("ct5")){
		    	  all.add("              Class Test 5");
		      all.add("Student ID :  Mark");
		      Cursor c=db.rawQuery("SELECT * FROM '"+yy+"'",null);
		        c.moveToFirst();
		        while(!c.isAfterLast())
		        {
		        	String aab=c.getString(c.getColumnIndex("id"));
		        String aa=c.getString(c.getColumnIndex("ct5"));
		        all.add(aab+"    :   "+aa);
		        c.moveToNext();
		        }
		        c.close(); 
		      
		      }
		      
		      
		      if(name.equals("assignment")){
		    	  all.add("               Assignment");
		      all.add("Student ID :  Mark");
		      Cursor c=db.rawQuery("SELECT * FROM '"+yy+"'",null);
		        c.moveToFirst();
		        while(!c.isAfterLast())
		        {
		        	String aab=c.getString(c.getColumnIndex("id"));
		        String aa=c.getString(c.getColumnIndex("assignment"));
		        all.add(aab+"    :   "+aa);
		        c.moveToNext();
		        }
		        c.close(); 
		      
		      }
		      
		      
		      if(name.equals("labfinal")){
		    	  all.add("            Labfinal");
		      all.add("Student ID : labfinal_Mark");
		      Cursor c=db.rawQuery("SELECT * FROM '"+yy+"'",null);
		        c.moveToFirst();
		        while(!c.isAfterLast())
		        {
		        	String aab=c.getString(c.getColumnIndex("id"));
		        String aa=c.getString(c.getColumnIndex("labfinal"));
		        all.add(aab+"    :   "+aa);
		        c.moveToNext();
		        }
		        c.close(); 
		      
		      }
		      
		      
		      if(name.equals("labperformance")){
		    	  all.add("         Labperformance");
		      all.add("Student ID :labperformance_Mark");
		      Cursor c=db.rawQuery("SELECT * FROM '"+yy+"'",null);
		        c.moveToFirst();
		        while(!c.isAfterLast())
		        {
		        	String aab=c.getString(c.getColumnIndex("id"));
		        String aa=c.getString(c.getColumnIndex("labperformance"));
		        all.add(aab+"    :   "+aa);
		        c.moveToNext();
		        }
		        c.close(); 
		      
		      }
		      
		      
		      
		      if(name.equals("exam")){
		    	  all.add("                Exam");
		      all.add("Student ID :  Mark");
		      Cursor c=db.rawQuery("SELECT * FROM '"+yy+"'",null);
		        c.moveToFirst();
		        while(!c.isAfterLast())
		        {
		        	String aab=c.getString(c.getColumnIndex("id"));
		        String aa=c.getString(c.getColumnIndex("exam"));
		        all.add(aab+"    :   "+aa);
		        c.moveToNext();
		        }
		        c.close(); 
		      
		      }
		      
		      if(name.equals("ct")){
		    	  all.add("          All Class Test");
		      all.add("ID:Ct1:ct2:ct3:ct4:ct5:Avg_best3");
		      
		      Cursor c=db.rawQuery("SELECT * FROM '"+yy+"'",null);
		        c.moveToFirst();
		        while(!c.isAfterLast())
		        {
		        String aab=c.getString(c.getColumnIndex("id"));
		        String ct1=c.getString(c.getColumnIndex("ct1"));
		        String ct2=c.getString(c.getColumnIndex("ct2"));
		        String ct3=c.getString(c.getColumnIndex("ct3"));
		        String ct4=c.getString(c.getColumnIndex("ct4"));
		        String ct5=c.getString(c.getColumnIndex("ct5"));

		        Double ctmark[]=new Double[10];
		        	ctmark[0]=Double.parseDouble(ct1);
		        	ctmark[1]=Double.parseDouble(ct2);
		        	ctmark[2]=Double.parseDouble(ct3);
		        	ctmark[3]=Double.parseDouble(ct4);
		        	ctmark[4]=Double.parseDouble(ct5);
		        	for(int i=0;i<=3;i++)
		        		for(int j=0;j<=3;j++)
		        		{
		        		if(ctmark[j]<ctmark[j+1])
		        		{
		        		double x=ctmark[j+1];
		        		ctmark[j+1]=ctmark[j];
		        		ctmark[j]=x;}}
		        
		        double average=(ctmark[0]+ctmark[1]+ctmark[2])/3.0;
		        avmark[number_of_row]=average;
		     
		        all.add(aab+":"+ct1+": "+ct2+": "+ct3+": "+ct4+":"+ct5+": "+average);
		        
		        number_of_row++;
		        c.moveToNext();
		        }
		       
		       
		        ContentValues values=new ContentValues();		       		        
		        for(int i=0;i<number_of_row;i++){
		        
		           values.put("avg", avmark[i]);
		           
		     db.update(yy, values, "serial="+serial_number[i]+"", null);
		        	
		      
		        }
		  
		        
		        c.close(); 
		  
		      }   
		      
		      
		      
		      
		      
		      
		      
		       
		      
lvCheckBox = (ListView)findViewById(R.id.lvCheckBox);
        lvCheckBox.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        lvCheckBox.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, all));


        
        
    }
	
	
	
	
    public boolean onCreateOptionsMenu(Menu menu) {
    	MenuInflater inflater=getMenuInflater();
    	inflater.inflate(R.menu.print, menu);
    	return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
     if(item.getItemId()==R.id.item1){
    	 
    	 
    	 ///.txt file make
    	 
    	 
    	 
    	 
     }

     
     
     
     
    	return super.onOptionsItemSelected(item);
    }
	
	
	
	 protected void onStop() {
	        // TODO Auto-generated method stub
	        db.close();
	        super.onStop();
	      }


	
	
	
	

}