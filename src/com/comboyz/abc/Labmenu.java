package com.comboyz.abc;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.view.View;

public class Labmenu extends ListActivity {

	static final String[] MOBILE_OS = new String[] { "All Lab", "Add Lab",
			"Edit Lab", "Delete Lab","","","","","","","","","","","",""};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);


		
		setListAdapter(new Customclass(this, MOBILE_OS));
		

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {

		//get selected items
		String selectedValue = (String) getListAdapter().getItem(position);
		if(selectedValue.equals("All Lab"))selectedValue="Lab";
        if(selectedValue.equals("Add Lab"))selectedValue="Addlab";
        if(selectedValue.equals("Edit Lab"))selectedValue="Editlab";
        if(selectedValue.equals("Delete Lab"))selectedValue="Deletelab";
		if(!selectedValue.equals("")){
		try{
    	    @SuppressWarnings("rawtypes")
			Class ourClass=Class.forName("com.comboyz.abc."+selectedValue);
    		Intent ourIntent=new Intent(Labmenu.this,ourClass);
    		ourIntent.putExtra("option", selectedValue);
    		startActivity(ourIntent);
    		}catch(ClassNotFoundException e){
    			e.printStackTrace();
    		}  

	}}

}