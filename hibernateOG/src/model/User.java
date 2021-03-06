package model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "user_name")
	private String username;
	
	@Embedded
	private Adresa adresa;
	
	@Enumerated
	private UserType userType;
	
	@ElementCollection(fetch = FetchType.LAZY)
	private List<Contact> kontakti = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.PERSIST)
	private List <Card> kartice = new ArrayList<Card>();
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public UserType getUserType() {
		return userType;
	}
	public List<Card> getKartice() {
		return kartice;
	}
	public void setKartice(List<Card> kartice) {
		this.kartice = kartice;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	public Adresa getAdresa() {
		return adresa;
	}
	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}
	public List<Contact> getKontakti() {
		return kontakti;
	}
	public void setKontakti(List<Contact> kontakti) {
		this.kontakti = kontakti;
	}
	
	
}
