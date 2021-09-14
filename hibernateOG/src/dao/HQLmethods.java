package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;



import main.HibernateUtil;
import model.Card;
import model.Racun;

public class HQLmethods {
	
	//SessionFactory object
	SessionFactory sf = HibernateUtil.getSessionFactory();

	
	public List<Card> sveKartice(){
		
		List<Card> listaKartica = new ArrayList<Card>();
		
		Session session = sf.openSession();
			session.beginTransaction();
			
			try {
				// hql upit
				String hql = "from Card";
				// slanje upita ka bazi
				Query query = session.createQuery(hql);
				// prihvatanje objekata iz baze
				listaKartica = query.getResultList();
				
				session.getTransaction().commit();
			} catch (Exception e) {
				System.out.println("Something went wrong...");
				listaKartica = null;
				session.getTransaction().rollback();
			}
			
		
			session.close();
		return listaKartica;
	}
	
}
