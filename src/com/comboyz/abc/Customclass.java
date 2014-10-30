package com.comboyz.abc;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Customclass extends ArrayAdapter<String> {
	private final Context context;
	private final String[] values;

	public Customclass(Context context, String[] values) {
		super(context, R.layout.list_mobile, values);
		this.context = context;
		this.values = values;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.list_mobile, parent, false);
		TextView textView = (TextView) rowView.findViewById(R.id.label);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.logo);
		textView.setText(values[position]);

		// Change icon based on name
		String s = values[position];

		System.out.println(s);

		if (s.equals("All Class")||s.equals("All Lab")||s.equals("All exam")||s.equals("All Class Test")) {
			imageView.setImageResource(R.drawable.allclass);
		} else if (s.equals("Add Class")||s.equals("Add Lab")||s.equals("Add exam")||s.equals("Add Class Test")) {
			imageView.setImageResource(R.drawable.add);
		} else if (s.equals("Edit Class")||s.equals("Edit Lab")||s.equals("Edit exam")||s.equals("Edit Class test")) {
			imageView.setImageResource(R.drawable.edit);
		} else if (s.equals("Delete Class")||s.equals("Delete Lab")||s.equals("Delete exam")||s.equals("Delete Class Test")){
			imageView.setImageResource(R.drawable.delete);
		}
		else if (s.equals("")){
			imageView.setImageResource(R.drawable.a);
		}
		
		

		return rowView;
	}
}
