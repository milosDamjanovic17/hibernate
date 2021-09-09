package model;

import javax.persistence.Entity;

@Entity
public class PremiumRacun extends Racun{

	private double extraPopust;

	public double getExtraPopust() {
		return extraPopust;
	}

	public void setExtraPopust(double extraPopust) {
		this.extraPopust = extraPopust;
	}
	
	
}
