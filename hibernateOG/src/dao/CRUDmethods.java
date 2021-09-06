package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import main.HibernateUtil;
import model.Card;
import model.User;

public class CRUDmethods {
	
	SessionFactory sf = HibernateUtil.getSessionFactory();
	
	public void insertCardInDB(Card card) {
		
		Session session = sf.openSession();
			session.beginTransaction();
			
		try {
			
			session.save(card);
			System.out.println("Saving card");
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Something went wrong.");
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
				
				session.save(user);
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
	
}
