package dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import main.HibernateUtil;
import model.Banka;
import model.Card;
import model.CreditCard;
import model.DebitCard;
import model.Ebank;
import model.Operater;
import model.Podrska;
import model.PremiumRacun;
import model.Racun;
import model.StandardBank;
import model.User;

public class CRUDmethods {
	
	SessionFactory sf = HibernateUtil.getSessionFactory();
	
	public void insertCardInDB(Card card) {
		
		Session session = sf.openSession();
			session.beginTransaction();
			
		try {
			//ukoliko se ne doda anotacija cascade = persist mora se eksplicitno reci da se drugiFK entitet cuva
			//session.save(racun);
			session.persist(card);
			System.out.println("Saving card");
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Something went wrong.");
			e.printStackTrace();
			session.getTransaction().rollback();
		}	
		session.close();
	}
	
	public void insertRacunInDB(Racun racun) {
		
		Session session = sf.openSession();
			session.beginTransaction();
			
			try {
				
				session.persist(racun);
				System.out.println("Saving racun...");
				
				session.getTransaction().commit();
			} catch (Exception e) {
				System.out.println("Something went wrong...");
				e.printStackTrace();
				session.getTransaction().rollback();
			}
		session.close();
		
	}
	

	
	public Card returnCardFromID(int id) {
		
		Card card = null;
		
		Session session = sf.openSession();
			session.beginTransaction();
				
			try {
				//izvlacim objekat koji zelim da returnujem
				card = session.get(Card.class, id);
				System.out.println("Retrieving...");
				session.getTransaction().commit();
			} catch (Exception e) {
				System.out.println("Something went wrong");
				e.printStackTrace();
				session.getTransaction().rollback();
			}
			session.close();
		
		return card;
	}
	
	public Racun returnRacunFromID (int id) {
		
		Racun racun = null;
		
		Session session = sf.openSession();
			session.beginTransaction();
			
			try {
				
				racun = session.get(Racun.class, id);
				System.out.println("Retrieving racun...");
				
				session.getTransaction().commit();
			} catch (Exception e) {
				System.out.println("Something went wrong");
				e.printStackTrace();
				session.getTransaction().rollback();
			}
		session.close();
		
		
		return racun;
	}
	
	public void updatePAN(String pan, String id) {
		
		Session session = sf.openSession();
			session.beginTransaction();
			
			try {
				//izvlacim objekat ciji cu pan da updateujem
				Card card = session.get(Card.class, Integer.parseInt(id));
				//setovanje nove PAN vrednosti
				card.setPan(pan);
				//update
				session.update(card);
				System.out.println("Updating PAN...");
				session.getTransaction().commit();
			} catch (Exception e) {
				System.out.println("Something went wrong");
				e.printStackTrace();
				session.getTransaction().rollback();
			}
		
		session.close();
	}
	
	public void deleteCard(String id) {
		
		Session session = sf.openSession();
			session.beginTransaction();
			
			try {
				
				Card card = session.get(Card.class, Integer.parseInt(id));
				session.delete(card);
				System.out.println("Deleting card...");
				
				session.getTransaction().commit();
			} catch (Exception e) {
				System.out.println("Something went wrong");
				e.printStackTrace();
				session.getTransaction().rollback();			
			}
		
		session.close();
	}
	
	public void insertUserInDB(User user) {
		
		Session session = sf.openSession();
			session.beginTransaction();
			
			try {
				
				session.persist(user);
				System.out.println("Saving user...");
				session.getTransaction().commit();
			} catch (Exception e) {
				System.out.println("Something went wrong");
				e.printStackTrace();
				session.getTransaction().rollback();
			}
		session.close();
	}
	
	public User returnUserFromID(String id) {
		
		User user = null;
		Session session = sf.openSession();
			session.beginTransaction();
			
			try {
				
				user = session.get(User.class, Integer.parseInt(id));
				//eksplicitno sam mu rekao da ucita i listu kontakata
				//Hibernate.initialize(user.getKontakti());
				//user.getKontakti().size();
				Hibernate.initialize(user.getKartice());
				
				System.out.println("Retrieving user...");
				session.getTransaction().commit();
			} catch (Exception e) {
				System.out.println("Something went wrong");
				e.printStackTrace();
				session.getTransaction().rollback();
			}
			session.close();
		
		return user;
	}
	
	public void insertDebitCardInDB(DebitCard debitCard) {
		Session session = sf.openSession();
			session.beginTransaction();
			
			try {
				session.save(debitCard);
				System.out.println("Saving debit");
				session.getTransaction().commit();
			} catch (Exception e) {
				System.out.println("Somethin went wrong");
				e.printStackTrace();
				session.getTransaction().rollback();
			}
		session.close();	
	}
	
	public void insertBankeInDB(Banka banka, Ebank eBank, StandardBank sBank) {
		Session session = sf.openSession();
			session.beginTransaction();
			
			try {
				session.persist(banka);
				session.persist(eBank);
				session.persist(sBank);
				System.out.println("Saving banke");
				
				session.getTransaction().commit();
			} catch (Exception e) {
				System.out.println("Somethin went wrong");
				e.printStackTrace();
				session.getTransaction().rollback();
			}
		session.close();	
	}
	
	public void upisiPodrskuUDB(Podrska podrska) {
		
		Session session = sf.openSession();
			session.beginTransaction();
		
			try {
				session.persist(podrska);
				System.out.println("Saving podrska...");
				
				session.getTransaction().commit();
			} catch (Exception e) {
				System.out.println("Something went wrong...");
				session.getTransaction().rollback();
			}
			session.close();
	}
	
public void insertOperaterInDB(Operater operater) {
		
		Session session = sf.openSession();
			session.beginTransaction();
			
			try {
				
				session.persist(operater);
				System.out.println("Saving operater...");
				
				session.getTransaction().commit();
			} catch (Exception e) {
				System.out.println("Something went wrong...");
				e.printStackTrace();
				session.getTransaction().rollback();
			}
		session.close();
	}
}
