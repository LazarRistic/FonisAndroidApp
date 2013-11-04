package domen;

public class Vesti {

	private String link;
	private String naslov;
	private String sadrzaj;
	
	public Vesti(String link, String naslov, String sadrzaj){
		this.link = link;
		this.naslov = naslov;
		this.sadrzaj = sadrzaj;
	}
	
	public String getNaslov() {
		return naslov;
	}
	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}
	public String getSadrzaj() {
		return sadrzaj;
	}
	public void setSadrzaj(String sadrzaj) {
		this.sadrzaj = sadrzaj;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
}
