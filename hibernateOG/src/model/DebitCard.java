package model;

import javax.persistence.Entity;

@Entity
public class DebitCard extends Card{

	private String valuta;

	public String getValuta() {
		return valuta;
	}

	public void setValuta(String valuta) {
		this.valuta = valuta;
	}
	
	
	
}
