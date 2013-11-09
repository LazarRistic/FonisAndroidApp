package com.fonis;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Onama extends Activity{
	
	public TextView naslov1;
	public TextView txtSadrzaj1;
	public TextView naslov2;
	public TextView txtSadrzaj2;
	public TextView naslov3;
	public TextView txtSadrzaj3;
	public TextView naslov4;
	public TextView txtSadrzaj4;
	public TextView naslov5;
	public TextView txtSadrzaj5;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onama);
        naslov1 = (TextView) this.findViewById(R.id.naslov1);
        txtSadrzaj1 = (TextView) this.findViewById(R.id.txtSadrzaj1);
        naslov2 = (TextView) this.findViewById(R.id.naslov2);
        txtSadrzaj2 = (TextView) this.findViewById(R.id.txtSadrzaj2);
        naslov3 = (TextView) this.findViewById(R.id.naslov3);
        txtSadrzaj3 = (TextView) this.findViewById(R.id.txtSadrzaj3);
        naslov4 = (TextView) this.findViewById(R.id.naslov4);
        txtSadrzaj4 = (TextView) this.findViewById(R.id.txtSadrzaj4);
        naslov5 = (TextView) this.findViewById(R.id.naslov5);
        txtSadrzaj5 = (TextView) this.findViewById(R.id.txtSadrzaj5);
        
        naslov1.setText("Šta je FONIS? \n");
        txtSadrzaj1.setText("Udruženje studenata informatike “FONIS” je studentska nevladina i neprofitna organizacija koja " + 
        		"okuplja buduće IT stručnjake u cilju učestvovanja na stručnim predavanjima, kursevima, takmičenjima i " + 
        		"seminarima,rada na projektima, ostvarivanje stručnih praksi u IT oblastima. \n" + " “FONIS” " + 
        		"predstavlja jedinu organizaciju fakulteta usko specijalizovanu za oblast informacionih tehnologija. " +
        		"Kao takav, on nastoji da promoviše IT, smer Informacioni sistemi i tehnologije na Fakultetu " +
        		"organizacionih nauka, kao i svoje članove, koji se angažuju na raznim projektima u oblasti informatike " +
        		"i menadžmenta u IT.) \n");
        naslov2.setText("Osnivanje udruženja \n");
        txtSadrzaj2.setText("Udruženje “FONIS” je nastalo januara 2001. godine. Osnovala ga je grupa studenata smera " +
        		"ISIT, na čelu sa Predragom Mašićem, koji je postao prvi predsednik Udruženja, sa ciljem naučnog " +
        		"istraživanja IT tehnologija, predavanja i usavršavanja svojih članova. Tokom narednih godina, “FONIS” " +
        		"je bio organizator mnogih manifestacija na fakultetu kao što je “Dan informatike”. Članovi “FONIS”-a i " +
        		"saradnici održali su studentima fakulteta veliki broj interaktivnih kurseva iz oblasti IT. Ostvarena je " +
        		"saradnja sa mnogim IT kompanijama i drugim nastavnim i vannastavnim organizcijama. \n");
       naslov3.setText("Reorganizacija \n");
       txtSadrzaj3.setText("Svoju reorganizaciju “FONIS” je doživeo je u novembru 2008. godine, na čelu sa " +
    		   "Milošem Đekićem, kada je došlo do redefinisanja ciljeva, formiranje jasne organizacione strukture, " +
    		   "uspostavljanja nekoliko aktivnih timova, projekata i saradnji.) \n");
       naslov4.setText("FONIS Danas \n");
       txtSadrzaj4.setText("Danas je “FONIS” jedna nova i stabilna organizacija, sa tendencijom da vremenom postane " +
    		   "nosilac studiranja na smeru ISIT. Svi članovi Udruženja su studenti Fakulteta organizacionih nauka, " +
    		   "na različitim godinama studija i sa različitih smerova. Oni se bave kreativnim istraživanjima, učenjem " +
    		   "novih tehnologija, usavršavanjem postojećih znanja i radom na ozbiljnim projektima. Udruženje prati " +
    		   "novine u IT svetu i ne zaostaje po znanju i mogućnostima za drugim organizacijama ostalih tehničkih " +
    		   "fakulteta. Sve svoje aktivnosti, “FONIS” realizuje kroz rad svojih timova. \n");
       naslov5.setText("Ciljevi \n");
       txtSadrzaj5.setText("Koordinacija aktivnosti studenata na FON-u iz IT oblasti \n \n" + 
    		   "- uspostavljanje “FONIS”-a kao jedinstveno jezgro fakultetskih, nastavnih i vannastavnih projekata, " +
    		   "koje bi profesorima i asistentima pružilo mogućnost da obezbede raznovrsnost projekata uz minimalan " +
    		   "napor za koordinaciju sa studentima, a studentima maksimalnu pomoć i podršku u realizaciji tih projekata.\n \n" +
    		   "Promocija fakulteta na seminarima i takmičenjima \n \n" +
    		   "- putovanja, seminari, marketing aktivnosti u cilju promocije Fakulteta Organizacionih Nauka, samog " +
    		   "udruženja i studenata. Članovi udruženja uspešno su učestvovali na nekoliko domaćih i međunarodnih " +
    		   "takmičenja i manifestacija iz oblasti IT i menadžment (Pet dana na Javi, Belgrade International Games, " +
    		   "Balkan Case Challenge, Menadžerijada, Case Study Show). \n \n" +
    		   "Unapređenje stručnosti studenata Fakulteta organizacionih nauka \n \n" +
    		   "- koordinacija svih prethodno pomenutih aktivnosti u cilju unapređenja kvaliteta nastave na " +
    		   "Fakultetu organizacionih nauka, širine dobijenog znanja i povećanje stručnosti studenata \n \n" +
    		   "- saradnja sa stručnim kadrom fakulteta u cilju osvežavanja nastave i većeg učešća studenata u samom " +
    		   "procesu nastave kao demonstratora i saradnika u projektima");
        
        
    }
	
}
