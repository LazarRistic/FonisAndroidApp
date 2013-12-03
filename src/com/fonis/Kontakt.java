package com.fonis;


import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
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
import domen.UO;

public class Kontakt extends ListActivity {
	ListView list;
	String [] uoTitles;
	String [] uoDescriptions;
	String [] uoEmail;
	int [] images = {R.drawable.zorana, R.drawable.misa, R.drawable.djordje, R.drawable.goran, R.drawable.marija, R.drawable.vlada};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.kontakt_activity);
	Resources res = getResources();
	uoDescriptions = res.getStringArray(R.array.descriptions);
	uoTitles = res.getStringArray(R.array.titles);
	uoEmail = res.getStringArray(R.array.email);
	list = getListView();
	VivzAdapter adapter = new VivzAdapter(this,uoTitles, uoDescriptions, images, uoEmail);
	list.setAdapter(adapter);
	}	
}
		
		
	

class VivzAdapter extends ArrayAdapter<UO>{
	Context context;
	int [] images;
	String [] titleArray;
	String [] descriptionArray;
	String [] email;
	List<UO> upravniOdbor;
	
	VivzAdapter(Context c, String [] titles,String [] descriptionArray, int[] images, String[] email)
	{
		
		super(c, R.layout.jedan_red, R.id.textView1);
		this.context=c;
		this.images=images;
		titleArray= titles;
		this.descriptionArray=descriptionArray;
		this.email=email;
		upravniOdbor = new ArrayList<UO>();
		
		for(int i=0;i<6;i++){
			UO uo = new UO();
			uo.setImage(images[i]);
			uo.setNaziv(titleArray[i]);
			uo.setTitle(descriptionArray[i]);
			uo.setEmail(email[i]);
			upravniOdbor.add(uo);
		}
	}
	
@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return upravniOdbor.size();
	}

@Override
public UO getItem(int position) {
	// TODO Auto-generated method stub
	return upravniOdbor.get(position);
}

@Override
public int getPosition(UO item) {
	// TODO Auto-generated method stub
	return upravniOdbor.indexOf(item);
}

@Override
public View getView (int position, View convertView, ViewGroup parent){
	
	LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	convertView = inflater.inflate(R.layout.jedan_red, parent, false);
	
	ImageView myImage = (ImageView) convertView.findViewById(R.id.imageView1);
	TextView myTitle = (TextView) convertView.findViewById(R.id.textView1);
	TextView myDescription = (TextView) convertView.findViewById(R.id.textView2);
	TextView myEmail = (TextView) convertView.findViewById(R.id.txtEmail);
	
	myImage.setImageResource(upravniOdbor.get(position).getImage());
	myTitle.setText(upravniOdbor.get(position).getNaziv());
    myDescription.setText(upravniOdbor.get(position).getTitle());
    myEmail.setText(upravniOdbor.get(position).getEmail());
	
	return convertView;
}
}
