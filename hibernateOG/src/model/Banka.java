package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Banka {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBank;
	private String naziv;
	
	public int getIdBank() {
		return idBank;
	}
	public void setIdBank(int idBank) {
		this.idBank = idBank;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

}
