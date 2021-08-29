package fr.doranco.ecommerce.model.dao;


import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.doranco.ecommerce.entity.Adresse;

import fr.doranco.ecommerce.model.datasource.HibernateConnector;


public class AdresseDao implements IAdresseDao  {

	@Override
	public Adresse getAdresse(Integer id) throws Exception {

		Session session = null;
		Adresse adresse = null;
		try {
			session = HibernateConnector.getSession();
			adresse = session.find(Adresse.class, id);

		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return adresse;
		
		
		
		
	}

	@Override
	public Adresse addAdresse(Adresse adresse) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getSession();
			tx = session.beginTransaction();
			session.save(adresse);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			System.out.println(e);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return adresse;

		
		
		
	}

	@Override
	public void updateAdressee(Adresse adresse) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getSession();
			tx = session.beginTransaction();
			session.update(adresse);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			System.out.println(e);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		
	}

	@Override
	public void removeAdressee(Integer id) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getSession();
			tx = session.beginTransaction();
			session.remove(id);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			System.out.println(e);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		
	}
	
	
	

}
