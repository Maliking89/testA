package fr.doranco.ecommerce.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.doranco.ecommerce.entity.LigneDeCommande;
import fr.doranco.ecommerce.model.datasource.HibernateConnector;



public class LigneDeCommandeDao implements ILigneDeCommandeDao {

public LigneDeCommandeDao() {
	// TODO Auto-generated constructor stub
}

	
	@Override
	public LigneDeCommande getLigneDeCommande(Integer id) throws Exception {
		Session session = null;
		LigneDeCommande lignedecommande = null;
		try {
			session =  HibernateConnector.getSession();
			lignedecommande = session.find(LigneDeCommande.class, id);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return lignedecommande;
	}
	@Override
	public LigneDeCommande addLigneDeCommande(LigneDeCommande lignedecommande) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getSession();
			tx = session.beginTransaction();
			session.save(lignedecommande);
			//session.save(commande.getUser());
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
		return lignedecommande;
	}
	@Override
	public void updateLigneDeCommande(LigneDeCommande lignedecommande) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getSession();
			tx = session.beginTransaction();
			session.update(lignedecommande);
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
	public void removeLigneDeCommande(Integer id) throws Exception {
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
	@Override
	public List<LigneDeCommande> getLigneDeCommandes() throws Exception {
		Session session = null;
		List<LigneDeCommande> lignedecommandes = new ArrayList<LigneDeCommande>();
		try {
			session = HibernateConnector.getSession();
			Query<LigneDeCommande> query = session.createNamedQuery("LigneDeCommande:findAll", LigneDeCommande.class);
			lignedecommandes = query.getResultList();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return lignedecommandes;
	}

	

}
