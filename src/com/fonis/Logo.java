package com.fonis;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Logo extends Activity{

	ProgressBar progres;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.logo);
		progres = (ProgressBar) findViewById(R.id.pbImaKonekcije);
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Thread logoTimer = new Thread(){
			public void run(){
				try {
					int logoTimer = 0;
					while (logoTimer < 1500) {
						sleep(100);
						logoTimer = logoTimer + 100;
					}
					startActivity(new Intent(Logo.this, MainActivity.class));
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				} 
				finally {
					finish();
				}
			}
		};
		
		if (hasConnection(Logo.this)) {
			logoTimer.start();
		} else {
			Toast.makeText(Logo.this, getString(R.string.no_connection), Toast.LENGTH_LONG).show();
		}
		
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}
	
	public boolean hasConnection(Context context) {
		
		progres.setVisibility(View.VISIBLE);
		
		ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

	    NetworkInfo wifiNetwork = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
	    if (wifiNetwork != null && wifiNetwork.isConnected()) {
	    	progres.setVisibility(View.GONE);
	      return true;
	    }

	    NetworkInfo mobileNetwork = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
	    if (mobileNetwork != null && mobileNetwork.isConnected()) {
	    	progres.setVisibility(View.GONE);
	      return true;
	    }

	    NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
	    if (activeNetwork != null && activeNetwork.isConnected()) {
	    	progres.setVisibility(View.GONE);
	    	if (null == activeNetwork)
	    	    return false;
	    	return activeNetwork.isConnectedOrConnecting();
	    }
	    return false;
	  }

}
