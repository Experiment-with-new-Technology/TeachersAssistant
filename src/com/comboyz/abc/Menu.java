package com.comboyz.abc;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.view.View;

public class Menu extends ListActivity {

	static final String[] MOBILE_OS = new String[] { "Classes", "Event",
			"Lab", "Others","","","","","","","","","","","",""};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);


		
		setListAdapter(new CustomArrayAdapter(this, MOBILE_OS));
		

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {

		//get selected items
		String selectedValue = (String) getListAdapter().getItem(position);
		if(selectedValue.equals("Classes"))selectedValue="Classmenu";
		if(selectedValue.equals("Lab"))selectedValue="Labmenu";
		if(!selectedValue.equals("")){
		try{
    	    @SuppressWarnings("rawtypes")
			Class ourClass=Class.forName("com.comboyz.abc."+selectedValue);
    		Intent ourIntent=new Intent(Menu.this,ourClass);
    		startActivity(ourIntent);
    		}catch(ClassNotFoundException e){
    			e.printStackTrace();
    		}  

	}}

}