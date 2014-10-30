package com.comboyz.abc;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomArrayAdapter extends ArrayAdapter<String> {
	private final Context context;
	private final String[] values;

	public CustomArrayAdapter(Context context, String[] values) {
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

		if (s.equals("Classes")) {
			imageView.setImageResource(R.drawable.classes);
		} else if (s.equals("Event")) {
			imageView.setImageResource(R.drawable.event);
		} else if (s.equals("Lab")) {
			imageView.setImageResource(R.drawable.lab);
		} else if (s.equals("Others")){
			imageView.setImageResource(R.drawable.others);
		}
		else if (s.equals("")){
			imageView.setImageResource(R.drawable.a);
		}
		

		return rowView;
	}
}
