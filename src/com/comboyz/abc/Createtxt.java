package com.comboyz.abc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;



public class Createtxt extends Activity 
{

SQLiteDatabase db;
String yy,name;
ImageButton create_txt;
Double avmark[]=new Double[5000];
int number_of_row=0;
int serial_number[]=new int[5000];    
	@Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createtxt);
        Intent intent = getIntent();
        yy=intent.getStringExtra("KeyToAccessData");
        name=intent.getStringExtra("name");
        super.onCreate(savedInstanceState);
        
        create_txt=(ImageButton) findViewById(R.id.imageButton1);
        
		  try{
		      db=openOrCreateDatabase("Teachersassistance",SQLiteDatabase.CREATE_IF_NECESSARY,null);
		      }catch(SQLException e){
		    	  
		      }
   
		      create_txt.setOnClickListener(new OnClickListener() {
		    		
		    		@Override
		    		public void onClick(View v)
		    		{
		    			
		    			//dialog after clicking the save button
		    			
		    			
		    			AlertDialog.Builder builder=new AlertDialog.Builder(Createtxt.this);
		    			builder.setTitle("conformation");
		    			builder.setMessage("Are you sure you want to create .txt file?");
		    			builder.setCancelable(false);
		    			
		    			// specify the yes dialog with its listener
		    			builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
		    				
		    				@Override
		    				public void onClick(DialogInterface dialog, int which) {
		    					
		    					
		    					
		    					
		    					
		    					
		    					
		    					 if(name.equals("Attendence")){
		    				    	  Cursor c=db.rawQuery("SELECT * FROM '"+yy+"'",null);
			    				      try {
		    						    	
		    								File myFile = new File("/sdcard/TeachersAssistant/"+yy+"/Attendence.txt");
		    								myFile.createNewFile();
		    								new FileOutputStream(myFile);
		    								 
		    							
		    								 BufferedWriter bw = new BufferedWriter(new FileWriter(myFile, true));
		    								 bw.write("ID  Attendence\r\n");
		    							     
		  		    				        c.moveToFirst();
		  		    				        while(!c.isAfterLast())
		  		    				        {
			    				        	String aab=c.getString(c.getColumnIndex("id"));
			    				        String aa=c.getString(c.getColumnIndex("attendence"));
			    				        bw.write(aab+"      "+aa+"\r\n");
			    				        c.moveToNext();
			    				        }

			    				      bw.flush();
		    					         bw.close();
		    					         
		    					         Toast.makeText(getBaseContext(),
		    										"/sdcard/TeachersAssistant/"+yy+"/Attendence.txt",
		    										Toast.LENGTH_SHORT).show();
		    							} catch (Exception e) {
		    								Toast.makeText(getBaseContext(), e.getMessage(),
		    										Toast.LENGTH_SHORT).show();
		    							}
		    						    c.close();   
		    				      
		    				      }
		    				      
		    				      
		    				      
		    				      
		    				      if(name.equals("ct1")){
		    				    	  
		    				    	  Cursor c=db.rawQuery("SELECT * FROM '"+yy+"'",null);
			    				      try {
		    						    	
		    								File myFile = new File("/sdcard/TeachersAssistant/"+yy+"/ct1.txt");
		    								myFile.createNewFile();
		    								new FileOutputStream(myFile);
		    								 
		    							
		    								 BufferedWriter bw = new BufferedWriter(new FileWriter(myFile, true));
		    								 bw.write("ID  Ct1_Mark\r\n");
		    							     
		  		    				        c.moveToFirst();
		  		    				        while(!c.isAfterLast())
		  		    				        {
			    				        	String aab=c.getString(c.getColumnIndex("id"));
			    				        String aa=c.getString(c.getColumnIndex("ct1"));
			    				        bw.write(aab+"      "+aa+"\r\n");
			    				        c.moveToNext();
			    				        }

			    				      bw.flush();
		    					         bw.close();
		    					         
		    					         Toast.makeText(getBaseContext(),
		    										"/sdcard/TeachersAssistant/"+yy+"/ct1.txt",
		    										Toast.LENGTH_SHORT).show();
		    							} catch (Exception e) {
		    								Toast.makeText(getBaseContext(), e.getMessage(),
		    										Toast.LENGTH_SHORT).show();
		    							}
		    						    c.close();  
		    				      
		    				      }
		    				      
		    				      
		    				      if(name.equals("ct2")){
		    				    	 
		    				    	  Cursor c=db.rawQuery("SELECT * FROM '"+yy+"'",null);
			    				      try {
		    						    	
		    								File myFile = new File("/sdcard/TeachersAssistant/"+yy+"/ct2.txt");
		    								myFile.createNewFile();
		    								new FileOutputStream(myFile);
		    								 
		    							
		    								 BufferedWriter bw = new BufferedWriter(new FileWriter(myFile, true));
		    								 bw.write("ID  Ct2_Mark\r\n");
		    							     
		  		    				        c.moveToFirst();
		  		    				        while(!c.isAfterLast())
		  		    				        {
			    				        	String aab=c.getString(c.getColumnIndex("id"));
			    				        String aa=c.getString(c.getColumnIndex("ct2"));
			    				        bw.write(aab+"      "+aa+"\r\n");
			    				        c.moveToNext();
			    				        }

			    				      bw.flush();
		    					         bw.close();
		    					         
		    					         Toast.makeText(getBaseContext(),
		    										"/sdcard/TeachersAssistant/"+yy+"/ct2.txt",
		    										Toast.LENGTH_SHORT).show();
		    							} catch (Exception e) {
		    								Toast.makeText(getBaseContext(), e.getMessage(),
		    										Toast.LENGTH_SHORT).show();
		    							}
		    						    c.close(); 
		    				      
		    				      }
		    				      
		    				      
		    				      
		    				      
		    				      
		    				      if(name.equals("ct3")){
		    				    	  Cursor c=db.rawQuery("SELECT * FROM '"+yy+"'",null);
			    				      try {
		    						    	
		    								File myFile = new File("/sdcard/TeachersAssistant/"+yy+"/ct3.txt");
		    								myFile.createNewFile();
		    								new FileOutputStream(myFile);
		    								 
		    							
		    								 BufferedWriter bw = new BufferedWriter(new FileWriter(myFile, true));
		    								 bw.write("ID  Ct3_Mark\r\n");
		    							     
		  		    				        c.moveToFirst();
		  		    				        while(!c.isAfterLast())
		  		    				        {
			    				        	String aab=c.getString(c.getColumnIndex("id"));
			    				        String aa=c.getString(c.getColumnIndex("ct3"));
			    				        bw.write(aab+"      "+aa+"\r\n");
			    				        c.moveToNext();
			    				        }

			    				      bw.flush();
		    					         bw.close();
		    					         
		    					         Toast.makeText(getBaseContext(),
		    										"/sdcard/TeachersAssistant/"+yy+"/ct3.txt",
		    										Toast.LENGTH_SHORT).show();
		    							} catch (Exception e) {
		    								Toast.makeText(getBaseContext(), e.getMessage(),
		    										Toast.LENGTH_SHORT).show();
		    							}
		    						    c.close(); 
		    				      
		    				      }
		    				      
		    				      
		    				      
		    				      
		    				      if(name.equals("ct4")){
		    				    	 
		    				    	  Cursor c=db.rawQuery("SELECT * FROM '"+yy+"'",null);
			    				      try {
		    						    	
		    								File myFile = new File("/sdcard/TeachersAssistant/"+yy+"/ct4.txt");
		    								myFile.createNewFile();
		    								new FileOutputStream(myFile);
		    								 
		    							
		    								 BufferedWriter bw = new BufferedWriter(new FileWriter(myFile, true));
		    								 bw.write("ID  Ct4_Mark\r\n");
		    							     
		  		    				        c.moveToFirst();
		  		    				        while(!c.isAfterLast())
		  		    				        {
			    				        	String aab=c.getString(c.getColumnIndex("id"));
			    				        String aa=c.getString(c.getColumnIndex("ct4"));
			    				        bw.write(aab+"      "+aa+"\r\n");
			    				        c.moveToNext();
			    				        }

			    				      bw.flush();
		    					         bw.close();
		    					         
		    					         Toast.makeText(getBaseContext(),
		    										"/sdcard/TeachersAssistant/"+yy+"/ct4.txt",
		    										Toast.LENGTH_SHORT).show();
		    							} catch (Exception e) {
		    								Toast.makeText(getBaseContext(), e.getMessage(),
		    										Toast.LENGTH_SHORT).show();
		    							}
		    						    c.close(); 		 
		    				      
		    				      }
		    				      
		    				      
		    				      
		    				      
		    				      if(name.equals("ct5")){
		    				    	  
		    				    	  Cursor c=db.rawQuery("SELECT * FROM '"+yy+"'",null);
			    				      try {
		    						    	
		    								File myFile = new File("/sdcard/TeachersAssistant/"+yy+"/ct5.txt");
		    								myFile.createNewFile();
		    								new FileOutputStream(myFile);
		    								 
		    							
		    								 BufferedWriter bw = new BufferedWriter(new FileWriter(myFile, true));
		    								 bw.write("ID  Ct5_Mark\r\n");
		    							     
		  		    				        c.moveToFirst();
		  		    				        while(!c.isAfterLast())
		  		    				        {
			    				        	String aab=c.getString(c.getColumnIndex("id"));
			    				        String aa=c.getString(c.getColumnIndex("ct5"));
			    				        bw.write(aab+"      "+aa+"\r\n");
			    				        c.moveToNext();
			    				        }
			    				     
			    				      
			    				    
			    				      bw.flush();
		    					         bw.close();
		    					         
		    					         Toast.makeText(getBaseContext(),
		    										"/sdcard/TeachersAssistant/"+yy+"/ct5.txt",
		    										Toast.LENGTH_SHORT).show();
		    							} catch (Exception e) {
		    								Toast.makeText(getBaseContext(), e.getMessage(),
		    										Toast.LENGTH_SHORT).show();
		    							}
		    						    c.close(); 		    				      
		    				      }
		    				  
		    				      
		    				      
		    				      
		    				      
		    				      if(name.equals("assignment")){
		    				    	  
		    				    	  Cursor c=db.rawQuery("SELECT * FROM '"+yy+"'",null);
			    				      try {
		    						    	
		    								File myFile = new File("/sdcard/TeachersAssistant/"+yy+"/assignment.txt");
		    								myFile.createNewFile();
		    								new FileOutputStream(myFile);
		    								 
		    							
		    								 BufferedWriter bw = new BufferedWriter(new FileWriter(myFile, true));
		    								 bw.write("ID  Assignment_Mark\r\n");
		    							     
		  		    				        c.moveToFirst();
		  		    				        while(!c.isAfterLast())
		  		    				        {
			    				        	String aab=c.getString(c.getColumnIndex("id"));
			    				        String aa=c.getString(c.getColumnIndex("assignment"));
			    				        bw.write(aab+"      "+aa+"\r\n");
			    				        c.moveToNext();
			    				        }
			    				     
			    				      
			    				    
			    				      bw.flush();
		    					         bw.close();
		    					         
		    					         Toast.makeText(getBaseContext(),
		    										"/sdcard/TeachersAssistant/"+yy+"/assignment.txt",
		    										Toast.LENGTH_SHORT).show();
		    							} catch (Exception e) {
		    								Toast.makeText(getBaseContext(), e.getMessage(),
		    										Toast.LENGTH_SHORT).show();
		    							}
		    						    c.close(); 
		    				      }
		    				      
		    				   
		    				 
		    				      
		    				      
		    				      if(name.equals("labfinal")){
		    				    	  
		    				    	  Cursor c=db.rawQuery("SELECT * FROM '"+yy+"'",null);
			    				      try {
		    						    	
		    								File myFile = new File("/sdcard/TeachersAssistant/"+yy+"/labfinal.txt");
		    								myFile.createNewFile();
		    								new FileOutputStream(myFile);
		    								 
		    							
		    								 BufferedWriter bw = new BufferedWriter(new FileWriter(myFile, true));
		    								 bw.write("ID  Labfinal_Mark\r\n");
		    							     
		  		    				        c.moveToFirst();
		  		    				        while(!c.isAfterLast())
		  		    				        {
			    				        	String aab=c.getString(c.getColumnIndex("id"));
			    				        String aa=c.getString(c.getColumnIndex("labfinal"));
			    				        bw.write(aab+"      "+aa+"\r\n");
			    				        c.moveToNext();
			    				        }
			    				     
			    				      
			    				    
			    				      bw.flush();
		    					         bw.close();
		    					         
		    					         Toast.makeText(getBaseContext(),
		    										"/sdcard/TeachersAssistant/"+yy+"/labfinal.txt",
		    										Toast.LENGTH_SHORT).show();
		    							} catch (Exception e) {
		    								Toast.makeText(getBaseContext(), e.getMessage(),
		    										Toast.LENGTH_SHORT).show();
		    							}
		    						    c.close(); 
		    				      }			      
		    				      
		    				      
		    				      
		    				      
		    				      
		    				      
		    				      if(name.equals("labperformance")){
		    				    	  
		    				    	  Cursor c=db.rawQuery("SELECT * FROM '"+yy+"'",null);
			    				      try {
		    						    	
		    								File myFile = new File("/sdcard/TeachersAssistant/"+yy+"/labperformance.txt");
		    								myFile.createNewFile();
		    								new FileOutputStream(myFile);
		    								 
		    							
		    								 BufferedWriter bw = new BufferedWriter(new FileWriter(myFile, true));
		    								 bw.write("ID  Labperformance_Mark\r\n");
		    							     
		  		    				        c.moveToFirst();
		  		    				        while(!c.isAfterLast())
		  		    				        {
			    				        	String aab=c.getString(c.getColumnIndex("id"));
			    				        String aa=c.getString(c.getColumnIndex("labperformance"));
			    				        bw.write(aab+"      "+aa+"\r\n");
			    				        c.moveToNext();
			    				        }
			    				     
			    				      
			    				    
			    				      bw.flush();
		    					         bw.close();
		    					         
		    					         Toast.makeText(getBaseContext(),
		    										"/sdcard/TeachersAssistant/"+yy+"/labperformance.txt",
		    										Toast.LENGTH_SHORT).show();
		    							} catch (Exception e) {
		    								Toast.makeText(getBaseContext(), e.getMessage(),
		    										Toast.LENGTH_SHORT).show();
		    							}
		    						    c.close(); 
		    				      }  
		    				      
		    				      
		    				      
		    				      
		    				      
		    				      
		    				      
		    				      if(name.equals("exam")){
		    				    	
		    				      Cursor c=db.rawQuery("SELECT * FROM '"+yy+"'",null);
		    				      try {
	    						    	
	    								File myFile = new File("/sdcard/TeachersAssistant/"+yy+"/exam.txt");
	    								myFile.createNewFile();
	    								new FileOutputStream(myFile);
	    								 
	    							
	    								 BufferedWriter bw = new BufferedWriter(new FileWriter(myFile, true));
	    								 bw.write("ID  Exam_Mark\r\n");
	    							     
	  		    				        c.moveToFirst();
	  		    				        while(!c.isAfterLast())
	  		    				        {
		    				        	String aab=c.getString(c.getColumnIndex("id"));
		    				        String aa=c.getString(c.getColumnIndex("exam"));
		    				        bw.write(aab+"      "+aa+"\r\n");
		    				        c.moveToNext();
		    				        }
		    				     
		    				      
		    				    
		    				      bw.flush();
	    					         bw.close();
	    					         
	    					         Toast.makeText(getBaseContext(),
	    										"/sdcard/TeachersAssistant/"+yy+"/exam.txt",
	    										Toast.LENGTH_SHORT).show();
	    							} catch (Exception e) {
	    								Toast.makeText(getBaseContext(), e.getMessage(),
	    										Toast.LENGTH_SHORT).show();
	    							}
	    						    c.close(); 
                                   } 
		    				      
		    				      
		    				      
		    				      if(name.equals("ct")){
		    				    	  Cursor c=db.rawQuery("SELECT * FROM '"+yy+"'",null);
		    							try {
		    						    	
		    								File myFile = new File("/sdcard/TeachersAssistant/"+yy+"/ct.txt");
		    								myFile.createNewFile();
		    								new FileOutputStream(myFile);
		    								 
		    							
		    								 BufferedWriter bw = new BufferedWriter(new FileWriter(myFile, true));
		    								 bw.write("ID  CT1  CT2  CT3  CT4  CT5  Avg\r\n");
		    							     
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
		  		    				     
		  		    				      bw.write(aab+"      "+ct1+"   "+ct2+"   "+ct3+"   "+ct4+"   "+ct5+"   "+average+"\r\n");
		  		    				        
		  		    				        number_of_row++;
		  		    				        c.moveToNext();
		  		    				        }
		    									

		    								bw.flush();
		    					         bw.close();
		    											
		    								Toast.makeText(getBaseContext(),
		    										"/sdcard/TeachersAssistant/"+yy+"/ct.txt",
		    										Toast.LENGTH_SHORT).show();
		    							} catch (Exception e) {
		    								Toast.makeText(getBaseContext(), e.getMessage(),
		    										Toast.LENGTH_SHORT).show();
		    							}
   				       
		    				        ContentValues values=new ContentValues();		       		        
		    				        for(int i=0;i<number_of_row;i++){
		    				        
		    				           values.put("avg", avmark[i]);
		    				           
		    				     db.update(yy, values, "serial="+serial_number[i]+"", null);
		    				        	
		    				      
		    				        }
		    				  
		    				        
		    				        c.close(); 
		    				  
		    				      }   			    					
		    				}
		    			}); 
		    			
		    			
		    			builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
		    				
		    				@Override
		    				public void onClick(DialogInterface dialog, int which) {
		    					dialog.cancel();
		    			
		    					
		    				}
		    			});
		    			
		    			
		    			AlertDialog alert =builder.create();
		    			alert.show();
		    			
		    	           
		    	           
		    	           
		    			
		    		}
		    	});
		      
      
     
    }

	 protected void onStop() {
	        // TODO Auto-generated method stub
	        db.close();
	        super.onStop();
	      }


}