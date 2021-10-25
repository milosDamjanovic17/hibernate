package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.CRUDmethods;
import dao.HQLmethods;
import model.Adresa;
import model.Banka;
import model.Card;
import model.Contact;
import model.CreditCard;
import model.Ebank;
import model.Operater;
import model.OperaterWrapper;
import model.Podrska;
import model.PremiumRacun;
import model.Racun;
import model.StandardBank;

public class MainClass {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		CRUDmethods crud = new CRUDmethods();
		HQLmethods hql = new HQLmethods();
		
		
		List <OperaterWrapper> listaOperatera = new ArrayList<>();
		listaOperatera = hql.dajSveOperaterSQL();
		System.out.println("Lista operatera u main klasi ima: " +listaOperatera.size());
		
		for(OperaterWrapper o: listaOperatera) {
			System.out.println("uso u for" +"\n");
			
			System.out.println("Id: " +o.getId());
			System.out.println("Sifra: " +o.getSifra());
			System.out.println("Podrska name: " +o.getName());
			System.out.println("Podrska broj telefona: " +o.getContact() +"\n");
		}
		
		List<Card> listaKartica = new ArrayList<>();
		listaKartica = hql.sveKartice();
		
		for (Card c : listaKartica) {
			
			System.out.println("\nID: " +c.getIdCard());
			System.out.println("Type: " +c.getCardType());
			System.out.println("PAN: " +c.getPan());
			
		}
		
			
	}


}
