package com.fonis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.TextView;

public class Vesti extends Activity{

	static String JSONvrednosti = "http://gnu.fon.rs/~fonis2/index.php/api/v1/news/";
	private FrameLayout tekstovi;
	private TextView novosti;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        novosti = new TextView(this);
        try {
			vratiVesti();
			setContentView(novosti);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	private void vratiVesti() throws JSONException, ClientProtocolException, IOException{
		HttpClient klijent = new DefaultHttpClient();
		
		HttpGet request = new HttpGet(JSONvrednosti);
		
			
				HttpResponse odgovor = klijent.execute(request);
				BufferedReader br = new BufferedReader(new InputStreamReader(odgovor.getEntity().getContent()));
				String ishod = br.readLine();
					
					odgovor.getEntity().consumeContent();
					br.close();
					
					JSONArray jsonNiz = new JSONArray(ishod);
					for(int i = 0; i < jsonNiz.length();i++){
						/*JSONObject objekat = jsonNiz.getJSONObject(i);
						Log.i(Vesti.class.getName(), msg);*/
						//String vesti = jsonNiz.getString(i);
						JSONObject objekat = jsonNiz.getJSONObject(i);
						Log.i(Vesti.class.getName(), objekat.toString());
						novosti.append(objekat.getString("title")+" \n"+objekat.getString("updated_at")+" \n"+objekat.getString("content"));
					}
			
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
	}
}
