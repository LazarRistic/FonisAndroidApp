package com.fonis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import domen.Vesti;

import alati.ListActivityVesti;
import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class VestiActivity extends ListActivity{

	//static String JSONvrednosti = "http://gnu.fon.rs/~fonis2/index.php/api/v1/news/";
	
	TextView tvNaslov; 
	TextView tvSadrzaj;
	
	private ArrayList<Vesti> listaVesti;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_vesti);
        
        listaVesti = new ArrayList<Vesti>();
        

    	new AsyncTask<URL, Void, ArrayList<Vesti>>() {
    		protected ArrayList<Vesti> doInBackground(URL... urls) {
    		// TODO Auto-generated method stub
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
    				
    					for(int i = 0; i < jsonNiz.length();i++){
    						  						
    						JSONObject objekat = jsonNiz.getJSONObject(i);
    						Log.d("VestiActivity", objekat.getString("title"));
    						Log.d("VestiActivity", objekat.getString("content"));
    						Log.i(VestiActivity.class.getName(), objekat.toString());
    						Vesti vesti = new Vesti(objekat.getString("link"),objekat.getString("title"),objekat.getString("contentSnippet"));
    						listaVesti.add(vesti);
    						//novosti.append(objekat.getString("title")+" \n"+objekat.getString("updated_at")+" \n"+objekat.getString("content"));
    					}
    			} catch (Exception e) {
    				// TODO Auto-generated catch block
    				Log.d("VestiActivity", "Ne valja.");
    			e.printStackTrace();
    			}
    		return listaVesti;
    		}
    		 protected void onPostExecute(ArrayList<Vesti> listaVesti) {
    			ListActivityVesti laVesti = new ListActivityVesti(VestiActivity.this, listaVesti);
    			setListAdapter(laVesti);
    	     }
    	}.execute();
    	
    	getListView().setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Intent i = new Intent("android.intent.action.VIEW",Uri.parse(listaVesti.get(arg2).getLink()));
				startActivity(i);
			}
    		
		});
    }
	/*
	 * Stari nacin parsiranja JSON-a
	private void vratiVesti() throws JSONException, ClientProtocolException, IOException{
		
		HttpClient klijent = new DefaultHttpClient();
		HttpGet request = new HttpGet(JSONvrednosti);
		
		try{
				HttpResponse odgovor = klijent.execute(request);
				BufferedReader br = new BufferedReader(new InputStreamReader(odgovor.getEntity().getContent()));
				String ishod = br.readLine();
					
					odgovor.getEntity().consumeContent();
					br.close();
					
					JSONArray jsonNiz = new JSONArray(ishod);
					for(int i = 0; i < jsonNiz.length();i++){
						JSONObject objekat = jsonNiz.getJSONObject(i);
						Log.i(VestiActivity.class.getName(), objekat.toString());
						Vesti vesti = new Vesti(objekat.getString("title"),objekat.getString("content"));
						listaVesti.add(vesti);
						//novosti.append(objekat.getString("title")+" \n"+objekat.getString("updated_at")+" \n"+objekat.getString("content"));
					}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				Log.d("VestiActivity", "Ne valja.");
			e.printStackTrace();
			}
	}*/
}
