package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.NonUniqueResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;



import main.HibernateUtil;
import model.Card;
import model.Podrska;
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
	
	public List<Podrska> dajSveIzPodrske(){
		
		List<Podrska> local = null;
		Session session = sf.openSession();
			session.beginTransaction();
			
			try {
				//postavljanje upita
				String hql = "from Podrska";
				//slanje upita
				Query query = session.createQuery(hql);
				//storniranje podataka iz upita
				local =  (List<Podrska>) query.getResultList();
				
				System.out.println("Lista ima " +local.size() +" clanova");
				
				session.getTransaction().commit();
			} catch (Exception e) {
				System.out.println("Something went wrong...");
				local = null;
				session.getTransaction().rollback();
			}
			session.close();
		return local;
	}
	
public List<Podrska> vratiPodrskuPoName(String ime){
		
		List<Podrska> local = null;
		Session session = sf.openSession();
			session.beginTransaction();
			
			try {
				//postavljanje upita
				String hql = "from Podrska where name = :imePodrske";
				//slanje upita
				Query query = session.createQuery(hql);
				//setovanje parametara
				query.setParameter("imePodrske", ime);
				//storniranje podataka iz upita
				local =  (List<Podrska>) query.getResultList();
				
				System.out.println("Lista ima " +local.size() +" clanova");
				
				session.getTransaction().commit();
			} catch (Exception e) {
				System.out.println("Something went wrong...");
				local = null;
				session.getTransaction().rollback();
			}
			session.close();
		return local;
	}
	
public String vratiNamePoID(int id){
	
		String localName = null;
		Session session = sf.openSession();
			session.beginTransaction();
		
		try {
			//postavljanje upita
			String hql = "select name from Podrska where id = :idSaUlaza";
			//slanje upita
			Query query = session.createQuery(hql);
			//setovanje parametara
			query.setParameter("idSaUlaza", id);
			//storniranje podataka iz upita
			localName = (String) query.getSingleResult();
			
			System.out.println("Acquiring selected ID...");
			
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Something went wrong...");
			e.printStackTrace();
			localName = null;
			session.getTransaction().rollback();
		}
		session.close();
	return localName;
}

}
