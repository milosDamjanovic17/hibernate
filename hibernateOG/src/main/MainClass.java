package main;

import java.util.ArrayList;
import java.util.List;

import dao.CRUDmethods;
import model.Adresa;
import model.Card;
import model.Contact;
import model.Racun;
import model.User;
import model.UserType;

public class MainClass {

	public static void main(String[] args) {
	
		CRUDmethods crud = new CRUDmethods();
		
		Card card = new Card();
		Racun racun = new Racun();
		/*
			racun.setBrojRacuna("0567692213");
			racun.setBanka("JUBMES Banka");
			racun.setStanje(1000);
		
		card.setPan("9989 2716 5526 0073");
		card.setCardType("VISA");
		*/
		//card.setRacun(racun);
		
		//racun.setCard(card);
		
		/*crud.insertRacunInDB(racun);
		Racun racunfromDB = crud.returnRacunFromID(4);
			System.out.println("BANKA: " +racunfromDB.getBanka());
			System.out.println("Broj racuna: " +racunfromDB.getBrojRacuna());
			System.out.println("PAN: " +racunfromDB.getCard().getPan());
			System.out.println("CARD: " +racunfromDB.getCard().getCardType());
			*/
		
		/*User user = crud.returnUserFromID("2");
		Card card1 = crud.returnCardFromID(1);
		Card card2 = crud.returnCardFromID(2);
		Card card3 = crud.returnCardFromID(3);
		
		List <Card> teparineKartice = new ArrayList<Card>();
			teparineKartice.add(card1);
			teparineKartice.add(card2);
			teparineKartice.add(card3);
			
		user.setKartice(teparineKartice);
		
		crud.insertUserInDB(user);
		*/
		List <Card> teparineKartice = new ArrayList<Card>();
		User user = crud.returnUserFromID("3");
		System.out.println("ime: " +user.getUsername());
		
		teparineKartice = user.getKartice();
		for(Card c: teparineKartice) {
			
			System.out.println("Card type: " +c.getCardType());
			System.out.println("PAN: " +c.getPan());
		}
	}

}
