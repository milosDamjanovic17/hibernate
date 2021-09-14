package main;

import java.util.ArrayList;
import java.util.List;

import dao.CRUDmethods;
import dao.HQLmethods;
import model.Adresa;
import model.Banka;
import model.Card;
import model.Contact;
import model.CreditCard;
import model.Ebank;
import model.PremiumRacun;
import model.Racun;
import model.StandardBank;

public class MainClass {

	public static void main(String[] args) {
	
		CRUDmethods crud = new CRUDmethods();
		HQLmethods hql = new HQLmethods();
		
		
		
		List<Card> kartice = new ArrayList<>();
		kartice = hql.sveKartice();
		
		for(Card c: kartice) {
			
			System.out.println("Id: " +c.getIdCard());
			System.out.println("Card type: " +c.getCardType());
			System.out.println("PAN: " +c.getPan());
			
		}
		
		
	}

}
