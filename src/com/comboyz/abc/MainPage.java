package com.comboyz.abc;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

public class MainPage extends Activity{
SQLiteDatabase db;
	@Override
	protected void onCreate(Bundle abcd) {
		super.onCreate(abcd);
		setContentView(R.layout.mainpage);
		
		 File dir = new File("/sdcard/TeachersAssistant"); 
         if (!dir.exists() ){
              if (!dir.mkdir()){ 
            	  Toast.makeText(MainPage.this, "Unable to create directory", 1000).show();
                 return; 
             } 
         } 
		
		
		
		

		 db=openOrCreateDatabase("Teachersassistance",SQLiteDatabase.CREATE_IF_NECESSARY,null);
	    db.execSQL("Create table if not exists allclass(title text,number text)");
	    db.execSQL("Create table if not exists lab(title text,number text)");
	    db.close();
		Thread timer=new Thread(){
			public void run(){
				try{
					sleep(1000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}finally{
					Intent openStartingPoint=new Intent("com.comboyz.abc.MENU");
					startActivity(openStartingPoint);
				}
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	
	

}
