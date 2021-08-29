package fr.doranco.ecommerce.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.doranco.ecommerce.entity.Commande;
import fr.doranco.ecommerce.model.datasource.HibernateConnector;



public class CommandeDao implements ICommandeDao {

	public CommandeDao() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public Commande getCommande(Integer id) throws Exception {
		Session session = null;
		Commande commande = null;
		try {
			session = HibernateConnector.getSession();
			commande = session.find(Commande.class, id);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return commande;
	}

	@Override
	public Commande addCommande(Commande commande) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getSession();
			tx = session.beginTransaction();
			session.save(commande);
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
		return commande;
	}

	@Override
	public void updateCommande(Commande commande) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getSession();
			tx = session.beginTransaction();
			session.update(commande);
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
	public void removeCommande(Integer id) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getSession();
			tx = session.beginTransaction();
			
			//commande =session.getCommande(id);
			session.remove(id);
			tx.commit();
			//session.detach(commande);
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
	public List<Commande> getCommandes1() {
		Session session = null;
		List<Commande> commandes = new ArrayList<Commande>();
		try {
			session = HibernateConnector.getSession();
			Query<Commande> query = session.createNamedQuery("Commande:findAll", Commande.class);
			
			// soit on choisie getresultList ou une List c pareille
			//commandes = query.getResultList();
			commandes=query.list();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return commandes;
		
	}
	@Override
	public List<Commande> getCommandes2() {
		Session session = null;
		List<Commande> commandes = new ArrayList<Commande>();
		try {
			session = HibernateConnector.getSession();
			
			String requeteJPQL = "FROM Commande c ";
				
			Query<Commande> query = session.createQuery(requeteJPQL,Commande.class);
			commandes = query.getResultList();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return commandes;
	}
	@Override
	public List<Commande> getCommandes3() {
		Session session = null;
		List<Commande> commandes = new ArrayList<Commande>();
		try {
			session = HibernateConnector.getSession();
			
			String requeteNormale = "Select * FROM Commande  ";
				
			Query<Commande> query = session.createNativeQuery(requeteNormale,Commande.class);
			commandes = query.getResultList();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return commandes;
	}

	

}
