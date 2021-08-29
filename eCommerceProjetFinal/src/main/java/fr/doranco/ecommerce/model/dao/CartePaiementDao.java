package fr.doranco.ecommerce.model.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.doranco.ecommerce.entity.Adresse;
import fr.doranco.ecommerce.entity.CartePaiement;
import fr.doranco.ecommerce.model.datasource.HibernateConnector;

public class CartePaiementDao implements ICartePaiementDao {

	@Override
	public CartePaiement getCartePaiement(Integer id) throws Exception {
		Session session = null;
CartePaiement cartePaiement = null;
		try {
			session = HibernateConnector.getSession();
	cartePaiement = session.find(CartePaiement.class, id);

		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return cartePaiement;
		
		
	}

	@Override
	public CartePaiement addCartePaiement(CartePaiement cartePaiement) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getSession();
			tx = session.beginTransaction();
			session.save(cartePaiement);
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
		return cartePaiement;
	}

	@Override
	public void updatCartePaiement(CartePaiement cartePaiement) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getSession();
			tx = session.beginTransaction();
			session.update(cartePaiement);
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
	public void removeCartePaiement(Integer id) throws Exception {
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
