package com.fonis;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Projekti extends Activity{

	TextView textView;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.projekat);
        textView = (TextView) findViewById(R.id.projekat);
        textView.setText("FONIS, kao organizacija koja okuplja studente informatike FON-a, raspolaže velikim brojem mladih i kvalitetnih kadrova koji svoje umeće i kreativnost prikazuju kroz projekte na kojim ih FONIS okuplja. Kroz različite aktivnosti, članovima se nudi produbljivanje praktičnog znanja, povećanje organizacionih sposobnosti i osećaj za timski rad. Najbitiniji aspekt projekata je iskustvo koje članovi stiču.\n\nSvaki student FON-a ima mogućnost da predloži svoju ideju projekta, koju će FONIS saslušati i, ukoliko postoje realne mogućnosti, ponuditi mentorstvo ili učešće i, ono što je najvažnije, potrebne resurse za ostvarenje projekta.\n\nDrugi način dolaženja do projekata jeste preko naših saradnika i kompanija kojima je potrebna redovna saradnja. Na ovoj stranici možete videti neke aktuelne projekte i uverite se u sposobnosti naših timova.\n\nTrenutno dostupni projekti:\n- Sajt FONIS-a\n- Studenti Studentima 09\n- Studenti Studentima 10\n- FONIS Starter Kit 2009\n- Promene odmah!\n- jStorming radionica\n- Studenti Studentima 10 - 2. deo\n- fText\n- Sajt studentskog parlamenta\n- Microsoft Student Tech Club 2009/2010\n- PHP Radionica\n- Equilibrio multimedijalni disk");
        
    }

}
