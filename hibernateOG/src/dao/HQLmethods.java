package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.NonUniqueResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;



import main.HibernateUtil;
import model.Card;
import model.Operater;
import model.OperaterWrapper;
import model.Podrska;
import model.Racun;

public class HQLmethods {
	
	//SessionFactory object
	private static SessionFactory sf = HibernateUtil.getSessionFactory();
	private static final Session sesija = sf.openSession();	//napravio static final instancu da ne bih otvarao sesiju dvesta miliona puta

	
	public List<Card> sveKartice(){
		
		List<Card> listaKartica = new ArrayList<Card>();
		
		//Session session = sf.openSession();
			sesija.beginTransaction();
			
			try {
				// hql upit
				String hql = "from Card";
				// slanje upita ka bazi
				Query query = sesija.createQuery(hql);
				// prihvatanje objekata iz baze
				listaKartica = query.getResultList(); //moze i  ne mora da se castuje u (List<Card>)
				System.out.println("Trenutno u bazi imamo: " +listaKartica.size());
				
				sesija.getTransaction().commit();
			} catch (Exception e) {
				System.out.println("Something went wrong...");
				listaKartica = null;
				sesija.getTransaction().rollback();
			}
			
			sesija.close();
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
			} catch (NoResultException e) {
				System.out.println("Something went wrong...");
				local = null;
				session.getTransaction().rollback();
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
		} catch (NoResultException nre) {
			System.out.println("User not found...");
			
			session.getTransaction().rollback();
			
		} catch (Exception e) {
			System.out.println("Something went wrong...");
			//e.printStackTrace();
			localName = null;
			session.getTransaction().rollback();
		}
		 session.close();
		return localName;
	}
	
public List<Operater> dajSveOperaterHQL(){
		
		List<Operater> local = null;
		Session session = sf.openSession();
			session.beginTransaction();
			
			try {
				//postavljanje upita
				String hql = "from Operater";
				//slanje upita
				Query query = session.createQuery(hql);
				//storniranje podataka iz upita
				local =  (List<Operater>) query.getResultList();
				
				System.out.println("Lista operatera ima " +local.size() +" clanova");
				
				session.getTransaction().commit();
			} catch (Exception e) {
				System.out.println("Something went wrong...");
				local = null;
				session.getTransaction().rollback();
			}
			session.close();
		return local;
	}
public List<OperaterWrapper> dajSveOperaterSQL(){
	
	List<OperaterWrapper> returnList = new ArrayList<OperaterWrapper>();
	List<Object[]> listaIzBaze = new ArrayList<Object[]>();
	Session session = sf.openSession();
		session.beginTransaction();
		
		try {
			//postavljanje upita
			String sql = "select o.idOperater, o.sifraOperatera, p.name, p.contact \n"
					+ "from operater o\n"
					+ "inner join podrska p on p.id = o.podrska_id"; // SQL obracamo se bazi/tabeli!
			//slanje upita
			Query query = session.createNativeQuery(sql); // pravi sql query
			//storniranje podataka iz upita
			listaIzBaze = query.getResultList();
			//mapiranje
			for(Object[] object: listaIzBaze) {
				OperaterWrapper localOperater = new OperaterWrapper();
				if(object[0] != null) localOperater.setId((int)object [0]);				
				if(object[1] != null) localOperater.setSifra((String)object[1]);
				if(object[2] != null) localOperater.setName((String) object[2]);		
				if(object[3] != null) localOperater.setContact((String) object[3]);
					returnList.add(localOperater);
			}
			
			System.out.println("Lista operatera ima " +returnList.size() +" clanova");
			
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Something went wrong...");
			returnList = null;
			session.getTransaction().rollback();
		}
		 session.close();
	 return returnList;
	}
}
