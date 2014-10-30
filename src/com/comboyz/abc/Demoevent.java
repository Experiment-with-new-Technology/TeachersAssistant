package com.comboyz.abc;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.view.View;

public class Demoevent extends ListActivity {
String option;
	static final String[] clas = new String[] { "All Class", "Add Class",
			"Edit Class", "Delete Class","Add Representative","","","","","","","","","","","",""};
	
	static final String[] lab = new String[] { "All Lab", "Add Lab",
		"Edit Lab", "Delete Lab","Add Representative","","","","","","","","","","","",""};
	
	static final String[] exam = new String[] { "All exam", "Add exam",
		"Edit exam", "Delete exam","Add Representative","","","","","","","","","","","",""};
	
	static final String[] ct = new String[] { "All Class Test", "Add Class Test",
		"Edit Class test", "Delete Class Test","Add Representative","","","","","","","","","","","",""};
	String event;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		  Intent intent = getIntent();
	      event=intent.getStringExtra("event");
	      
	      if(event.equals("ClassRoutine")){
		setListAdapter(new Customclass(this, clas));}
	      else if(event.equals("LabSchedule")){
	  		setListAdapter(new Customclass(this, lab));}
	      else if(event.equals("ExaminationSchedue")){
		  		setListAdapter(new Customclass(this, exam));}
	      else if(event.equals("ClassTestSchedule")){
		  		setListAdapter(new Customclass(this, ct));}
	      
	      

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {

		//get selected items
		String selectedValue = (String) getListAdapter().getItem(position);
		
		if(selectedValue.equals("All Class")||selectedValue.equals("All Lab")||selectedValue.equals("All exam")||selectedValue.equals("All Class Test"))
			option="All";
		
        if(selectedValue.equals("Add Class")||selectedValue.equals("Add Lab")||selectedValue.equals("Add exam")||selectedValue.equals("Add Class Test"))
        option="Add";
        
        if(selectedValue.equals("Edit Class")||selectedValue.equals("Edit Lab")||selectedValue.equals("Edit exam")||selectedValue.equals("Edit Class Test"))
       option="Edit";
        
        if(selectedValue.equals("Delete Class")||selectedValue.equals("Delete Lab")||selectedValue.equals("Delete exam")||selectedValue.equals("Delete Class Test"))
        option="Delete";
        
        if(selectedValue.equals("Add Representative"))
        option="AddRepresentative";
        
		if(!selectedValue.equals("")){
		try{
    	    @SuppressWarnings("rawtypes")
			Class ourClass=Class.forName("com.comboyz.abc."+option);
    		Intent ourIntent=new Intent(Demoevent.this,ourClass);
    		ourIntent.putExtra("option", selectedValue);
    		ourIntent.putExtra("event", event);
    		startActivity(ourIntent);
    		}catch(ClassNotFoundException e){
    			e.printStackTrace();
    		}  

	}}

}