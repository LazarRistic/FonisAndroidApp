package com.fonis;


import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Kontakt extends Activity {
	ListView list;
	String [] uoTitles;
	String [] uoDescriptions;
	int [] images = {R.drawable.zorana, R.drawable.misa, R.drawable.djordje, R.drawable.goran, R.drawable.marija, R.drawable.vlada};



	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.kontakt_activity);
	Resources res = getResources();
	uoDescriptions = res.getStringArray(R.array.titles);
	uoTitles = res.getStringArray(R.array.titles);
	list = (ListView) findViewById(R.id.listView1);
	VivzAdapter adapter = new VivzAdapter(this,uoTitles, uoDescriptions, images);
	list.setAdapter(adapter);
	}

	String [] data = {"Zorana Krstic", "Vladimir Stoiljkovic", "Djordje Petrovic","Misa Lazovic", "Marija Markovic","Goran Militarov"};
ListView lw = (ListView) findViewById(R.id.listView1);;
	
			
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.jedan_red, R.id.textView1, data);
	//	lw.setAdapter(adapter);	
		
		}
		
		
	

class VivzAdapter extends ArrayAdapter<String>{
	Context context;
	int [] images;
	String [] titleArray;
	String [] descriptionArray;
	VivzAdapter(Context c, String [] titles,String [] descriptionArray, int[] images)
	{
		
		super(c, R.layout.jedan_red, R.id.textView1,titles);
		this.context=c;
		this.images=images;
		titleArray= titles;
	this.descriptionArray=descriptionArray;
	}
	
public View GetView (int position, View convertView, ViewGroup parent){
	
	LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	View row = inflater.inflate(R.layout.jedan_red, parent, false);
	
	ImageView myImage = (ImageView) row.findViewById(R.id.imageView1);
	TextView myTitle = (TextView) row.findViewById(R.id.textView1);
	TextView myDescription = (TextView) row.findViewById(R.id.textView2);
	
	myImage.setImageResource(images[position]);
	myTitle.setText(position);
    myDescription.setText(position);
	
	return row;
}
}
