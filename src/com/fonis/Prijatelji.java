package com.fonis;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Prijatelji extends Activity{
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textview = new TextView(this);
        textview.setText("Ovde su prijatelji");
        setContentView(textview);
    }

}
