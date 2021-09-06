package main;

import java.util.ArrayList;
import java.util.List;

import dao.CRUDmethods;
import model.Adresa;
import model.Card;
import model.Contact;
import model.User;
import model.UserType;

public class MainClass {

	public static void main(String[] args) {
	
		CRUDmethods crud = new CRUDmethods();
		
		Card card = new Card();
		User user = new User();
		Adresa adresa = new Adresa();
		Contact contact = new Contact();
		UserType usertype = UserType.PREMIUM_USER;
			/*card.setPan("9900 1010 4040 6712 2258");
			card.setCardType("Diners Club");
		
		crud.insertCardInDB(card);
		*/
		
		/*card = crud.returnCardFromID(5);
		System.out.println("PAN: " +card.getPan());
		System.out.println("TYPE: " +card.getCardType());
		*/
		
		//crud.updatePAN("9900 1010 4040 6712", "5");
		//crud.deleteCard("2");
		
		//user.setUsername("Rade Zagorac");
		//user.setUserType(usertype);
		
		//crud.insertUserInDB(user);
		
		/*Contact c1 = new Contact();
			c1.setBrojTelefona("0638814752");
			c1.setEmail("tepara@gmail.com");
			
		Contact c2 = new Contact();
			c2.setBrojTelefona("062695030");
			c2.setEmail("grbavimilenkopfc@gmail.com");
			
		Contact c3 = new Contact();
			c3.setBrojTelefona("069771582");
			c3.setEmail("milenkoptn@gmail.com");
			
		List <Contact> tepariniKontakti = new ArrayList<>();
			tepariniKontakti.add(c1);
			tepariniKontakti.add(c2);
			tepariniKontakti.add(c3);
			
		adresa.setDrzava("Srbija");
		adresa.setGrad("Beograd");
		adresa.setUlica("Narodnog Fronta");
			
		user.setUsername("Milenko Tepic");
		user.setUserType(usertype);
		user.setKontakti(tepariniKontakti);
		user.setAdresa(adresa);
		
		crud.insertUserInDB(user);
		*/
		
		user = crud.returnUserFromID("2");
		System.out.println("NAME: " +user.getUsername());
		System.out.println("STATE: " +user.getAdresa().getDrzava());
		System.out.println("USERTYPE: " +user.getUserType());
		
		List <Contact> tepariniKontakti = user.getKontakti();
		for(Contact c: tepariniKontakti) {
			System.out.println("Mob: " +c.getBrojTelefona());
			System.out.println("Mail: " +c.getEmail());
		}
	}

}
