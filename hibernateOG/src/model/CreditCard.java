package model;

import javax.persistence.Entity;

@Entity
public class CreditCard extends Card{

	private double dozvoljenMinus;

	public double getDozvoljenMinus() {
		return dozvoljenMinus;
	}

	public void setDozvoljenMinus(double dozvoljenMinus) {
		this.dozvoljenMinus = dozvoljenMinus;
	}
	
	
	
}
