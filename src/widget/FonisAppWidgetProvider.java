package widget;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.ListView;
import android.widget.RemoteViews;

import com.fonis.MainActivity;
import com.fonis.R;
import com.fonis.VestiActivity;

import domen.Vesti;

public class FonisAppWidgetProvider extends AppWidgetProvider {
	
	public static final String DEBUG_TAG = "TutWidgetProvider";
	public Vesti[] nizVesti = new Vesti[5];
	public ListView lwLista;

	
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
    	
    	try {
    		lwLista = new ListView(context);
    		cekajuciVesti();
            updateWidgetContent(context, appWidgetManager, appWidgetIds);
         } catch (Exception e) {
            Log.e(DEBUG_TAG, "Failed", e);
         }
    	
        //final int N = appWidgetIds.length;

        // Perform this loop procedure for each App Widget that belongs to this provider
        /*for (int i=0; i<N; i++) {
            int appWidgetId = appWidgetIds[i];

            // Create an Intent to launch ExampleActivity
            Intent intent = new Intent(context, ExampleActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

            // Get the layout for the App Widget and attach an on-click listener
            // to the button
            //RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.appwidget_provider_layout);
            //views.setOnClickPendingIntent(R.id.button, pendingIntent);

            // Tell the AppWidgetManager to perform an update on the current app widget
            //appWidgetManager.updateAppWidget(appWidgetId, views);
             }
             */
        
    }

	private void updateWidgetContent(Context context,
			AppWidgetManager appWidgetManager, int[] appWidgetIds) {
		// TODO Auto-generated method stub
		for (int i = 0; i < appWidgetIds.length; i++) {

	        Intent intent = new Intent(context, MainActivity.class);
	        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,
	                appWidgetIds[i]);
	        intent.setData(Uri.parse(intent.toUri(Intent.URI_INTENT_SCHEME)));

	        RemoteViews rv = new RemoteViews(context.getPackageName(),
	                R.layout.fonis_appwidget);

	        rv.setRemoteAdapter(appWidgetIds[i], R.id.lwVestiWidget, intent);

	        appWidgetManager.updateAppWidget(appWidgetIds[i], rv);
	    }
		/*
		RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.fonis_appwidget);
		ListActivityVesti listViewWidget = new ListActivityVesti(context, nizVesti);
		lwLista.setAdapter(listViewWidget);
		
		Intent intent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        remoteViews.setOnClickPendingIntent(R.id.flWidgetView, pendingIntent);
        ComponentName componentName = new ComponentName(context,FonisAppWidgetProvider.class);
        appWidgetManager.updateAppWidget(componentName, remoteViews);*/
	}
	//inspirisano devojkom koja cita Cekajuci Godoa sa svojim iPhoneom i crvenim lakom...SAMA! U Costa Coffee (posto jelte, samo ljudi sa parama idu tamo, ukljucujuci i nas tim)!
	private void cekajuciVesti(){
		
		try{
		URL url = new URL("http://ajax.googleapis.com/ajax/services/feed/load?v=1.0&num=100&q=http://feeds.feedburner.com/fonis");
		URLConnection urlConnection = url.openConnection();
		
				BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				String ishod = br.readLine();
				br.close();
				JSONObject obj1 = new JSONObject(ishod);
				JSONObject obj2 = obj1.getJSONObject("responseData");
				JSONObject obj3 = obj2.getJSONObject("feed");
				JSONArray jsonNiz = obj3.getJSONArray("entries");
			
				
					for(int i = 0; i < 1;i++){
						  						
						JSONObject objekat = jsonNiz.getJSONObject(i);
						Log.d("VestiActivity", objekat.getString("title"));
						Log.d("VestiActivity", objekat.getString("content"));
						Log.i(VestiActivity.class.getName(), objekat.toString());
						Vesti vesti = new Vesti(objekat.getString("link"),objekat.getString("title"),objekat.getString("contentSnippet"));
						nizVesti[i] = vesti;
						//novosti.append(objekat.getString("title")+" \n"+objekat.getString("updated_at")+" \n"+objekat.getString("content"));
					}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				Log.d("VestiActivity", "Ne valja.");
			e.printStackTrace();
			}
	}
}
