package model;

import javax.persistence.Entity;

@Entity
public class StandardBank extends Banka {
	
	private String nazivFilijale;

	public String getNazivFilijale() {
		return nazivFilijale;
	}

	public void setNazivFilijale(String nazivFilijale) {
		this.nazivFilijale = nazivFilijale;
	}
	
	

}
