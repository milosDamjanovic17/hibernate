package model;

import javax.persistence.Entity;

@Entity
public class Ebank extends Banka {
	
	private String brojNaloga;
	
	public String getBrojNaloga() {
		return brojNaloga;
	}

	public void setBrojNaloga(String brojNaloga) {
		this.brojNaloga = brojNaloga;
	}

	

}
