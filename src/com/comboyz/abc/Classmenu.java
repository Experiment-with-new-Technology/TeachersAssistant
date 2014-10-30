package com.comboyz.abc;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.view.View;

public class Classmenu extends ListActivity {

	static final String[] MOBILE_OS = new String[] { "All Class", "Add Class",
			"Edit Class", "Delete Class","","","","","","","","","","","",""};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);


		
		setListAdapter(new Customclass(this, MOBILE_OS));
		

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {

		//get selected items
		String selectedValue = (String) getListAdapter().getItem(position);
		if(selectedValue.equals("All Class"))selectedValue="Allclass";
        if(selectedValue.equals("Add Class"))selectedValue="Addclass";
        if(selectedValue.equals("Edit Class"))selectedValue="Editclass";
        if(selectedValue.equals("Delete Class"))selectedValue="Deleteclass";
		if(!selectedValue.equals("")){
		try{
    	    @SuppressWarnings("rawtypes")
			Class ourClass=Class.forName("com.comboyz.abc."+selectedValue);
    		Intent ourIntent=new Intent(Classmenu.this,ourClass);
    		ourIntent.putExtra("option", selectedValue);
    		startActivity(ourIntent);
    		}catch(ClassNotFoundException e){
    			e.printStackTrace();
    		}  

	}}

}