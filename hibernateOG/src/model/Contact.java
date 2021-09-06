package model;

import javax.persistence.Embeddable;

@Embeddable
public class Contact {

	private String brojTelefona;
	private String email;
	
	public String getBrojTelefona() {
		return brojTelefona;
	}
	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
