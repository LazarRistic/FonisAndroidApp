package com.fonis;


import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.os.Bundle;
import android.view.View;
import android.app.NotificationManager;
import android.content.Intent;


public class NotificationsActivity  extends Activity{
int notificationID=1;

	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_drugi_deo);
	}
		public void onClick (View view){
			displayNotification();
			
		}
		
	protected void displayNotification() {
		Intent i = new Intent(this, NotificationView.class);
		i.putExtra("notificationID", notificationID);
		
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, i, 0);
		NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		Notification notif = new Notification(R.drawable.ic_launcher, "Reminder: Pogledati sajt", System.currentTimeMillis());
	CharSequence from= "System Alarm";
	CharSequence message = "FONIS Sastanak";
	notif.setLatestEventInfo(this, from, message, pendingIntent);
	notif.vibrate= new  long[] {100, 250,100,500 }	;
	nm.notify(notificationID, notif);
	
	}
}
