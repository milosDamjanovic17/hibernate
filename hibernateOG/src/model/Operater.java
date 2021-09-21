package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Operater {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idOperater;
	private String sifraOperatera;
	@OneToOne
	private Podrska podrska;
	
	public int getIdOperater() {
		return idOperater;
	}
	public void setIdOperater(int idOperater) {
		this.idOperater = idOperater;
	}
	public String getSifraOperatera() {
		return sifraOperatera;
	}
	public void setSifraOperatera(String sifraOperatera) {
		this.sifraOperatera = sifraOperatera;
	}
	public Podrska getPodrska() {
		return podrska;
	}
	public void setPodrska(Podrska podrska) {
		this.podrska = podrska;
	}
}
