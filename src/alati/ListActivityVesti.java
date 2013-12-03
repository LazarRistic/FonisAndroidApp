package alati;
import java.util.ArrayList;
import java.util.List;

import com.fonis.R;

import domen.Vesti;
import android.app.ListActivity;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class ListActivityVesti extends ArrayAdapter<Vesti>{

	Context context;
	ArrayList<Vesti> vesti;
	Vesti[] nizVesti = new Vesti[5];
	int layout;
	public ListActivityVesti(Context context,
			ArrayList<Vesti> vesti) {
		super(context, R.layout.vest, vesti);
		// TODO Auto-generated constructor stub
		this.context = context;
		this.vesti = vesti;
		layout = R.layout.vest;
	}
	public ListActivityVesti(Context context, Vesti[] nizVesti){
		super(context, R.layout.fonis_appwidget);
		this.context = context;
		this.nizVesti = nizVesti;
		layout = R.layout.fonis_appwidget;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		
		if(convertView == null)
			convertView = inflater.inflate(R.layout.vest, null);
		TextView tvNaslov = (TextView) convertView.findViewById(R.id.twNaslov);
		TextView tvSadrzaj = (TextView) convertView.findViewById(R.id.twSadrzaj);
		switch (layout) {
		case R.layout.fonis_appwidget:
			tvNaslov.setText(nizVesti[position].getNaslov());
			tvSadrzaj.setText(Html.fromHtml(nizVesti[position].getSadrzaj()).toString());
			//iwSlika.setImageBitmap(vesti.get(position).getSliku());
			break;

		default:
			tvNaslov.setText(vesti.get(position).getNaslov());
			tvSadrzaj.setText(Html.fromHtml(vesti.get(position).getSadrzaj()).toString());
			//iwSlika.setImageBitmap(vesti.get(position).getSliku());
			break;
		}
		
		return convertView;
	}
}
