package main;

import java.util.ArrayList;
import java.util.List;

import dao.CRUDmethods;
import model.Adresa;
import model.Banka;
import model.Card;
import model.Contact;
import model.CreditCard;
import model.Ebank;
import model.PremiumRacun;
import model.StandardBank;

public class MainClass {

	public static void main(String[] args) {
	
		CRUDmethods crud = new CRUDmethods();
		
		//Card card = new Card();
		//Racun racun = new Racun();
		
		
		Banka banka = new Banka();
			banka.setNaziv("ASDF banka");
			
		Ebank eBank = new Ebank();
			eBank.setNaziv("eASDF banka");
			eBank.setBrojNaloga("15");
			
		StandardBank sbank = new StandardBank();
			sbank.setNaziv("sASDF banka");
			sbank.setNazivFilijale("ASDF filijala");
			
		crud.insertBankeInDB(banka, eBank, sbank);
		
	}

}
