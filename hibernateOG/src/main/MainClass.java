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
import model.Podrska;
import model.PremiumRacun;
import model.Racun;
import model.StandardBank;

public class MainClass {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		CRUDmethods crud = new CRUDmethods();
		HQLmethods hql = new HQLmethods();
		
		System.out.println("Unesi ID:");
		int id = s.nextInt();
		
		String ime = hql.vratiNamePoID(id);
			
			
		if(ime == null) {
			System.out.println("vise imena ili nema tog imena");
			
		}else {
			System.out.println("Ime je: " +ime);
		}	
	}


}
