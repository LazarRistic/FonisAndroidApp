package com.fonis;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends TabActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_fonis);
	    Resources res = getResources(); 
	    TabHost tabHost = getTabHost(); 
	    TabHost.TabSpec spec;
	    Intent intent;

	   
	    intent = new Intent().setClass(this, VestiActivity.class);

	   
	    spec = tabHost.newTabSpec("vesti").setIndicator("Vesti")
	                  .setContent(intent);
	    tabHost.addTab(spec);
	    
	  //Onama
	    intent = new Intent().setClass(this, Onama.class);
	    spec = tabHost.newTabSpec("onama").setIndicator("O nama")
	                  .setContent(intent);
	    tabHost.addTab(spec);
	   
	    //projekti
	    intent = new Intent().setClass(this, Projekti.class);
	    spec = tabHost.newTabSpec("projekti").setIndicator("Projekti")
	                  .setContent(intent);
	    tabHost.addTab(spec);
	    
	    //kontakt
	    intent = new Intent().setClass(this, Kontakt.class);
	    spec = tabHost.newTabSpec("kontakt").setIndicator("Kontakt")
	                  .setContent(intent);
	    tabHost.addTab(spec);

	    //Studentski servisi
	    intent = new Intent().setClass(this, StudentskiServisi.class);
	    spec = tabHost.newTabSpec("studentskiservisi").setIndicator("Studentski servisi")
	                  .setContent(intent);
	    tabHost.addTab(spec);
	    
	    
	    tabHost.setCurrentTab(0);
	} 

}
