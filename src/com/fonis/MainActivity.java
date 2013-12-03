package com.fonis;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TextView;

public class MainActivity extends TabActivity{

	public static void setTabColor(TabHost tabhost) {
	    for(int i=0;i<tabhost.getTabWidget().getChildCount();i++)
	    {
	    	tabhost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.tab_fonis);
	    	//TextView tv = (TextView) tabhost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
	        //tv.setText;
	    }
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_fonis); 
	    Resources res = getResources(); 
	    final TabHost tabHost = getTabHost(); 
	    TabHost.TabSpec spec; 
	    Intent intent; 
	    tabHost.getTabWidget().setStripEnabled(false);
	   
	    intent = new Intent().setClass(this, VestiActivity.class);

	   
	    spec = tabHost.newTabSpec("vesti").setIndicator("VESTI")
	                  .setContent(intent);
	    tabHost.addTab(spec);
	    
	    //Onama
	    intent = new Intent().setClass(this, Onama.class);
	    spec = tabHost.newTabSpec("onama").setIndicator("O NAMA")
	                  .setContent(intent);
	    tabHost.addTab(spec);
	   
	    //projekti
	    intent = new Intent().setClass(this, Projekti.class);
	    spec = tabHost.newTabSpec("projekti").setIndicator("PROJEKTI")
	                  .setContent(intent);
	    tabHost.addTab(spec);
	    
	    //kontakt
	    intent = new Intent().setClass(this, Kontakt.class);
	    spec = tabHost.newTabSpec("kontakt").setIndicator("KONTAKT")
	                  .setContent(intent);
	    tabHost.addTab(spec);

	    //Studentski servisi
	    intent = new Intent().setClass(this, StudentskiServisi.class);
	    spec = tabHost.newTabSpec("studentskiservisi").setIndicator("SERVISI")
	                  .setContent(intent);
	    tabHost.addTab(spec);
	    
	    setTabColor(tabHost);
	    
	    //tabHost.setCurrentTab(0);
	    
	    tabHost.setOnTabChangedListener(new OnTabChangeListener() {
			
			@Override
			public void onTabChanged(String tabId) {
				// TODO Auto-generated method stub
				
				tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundColor(Color.parseColor("#FFBF00"));
				for(int i=0;i<tabHost.getTabWidget().getChildCount();i++){
					if(i != tabHost.getCurrentTab()){
						tabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.tab_fonis);		
					}
				}
			}
		});
	} 
}
