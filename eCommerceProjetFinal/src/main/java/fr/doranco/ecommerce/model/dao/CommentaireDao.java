package fr.doranco.ecommerce.model.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;


import fr.doranco.ecommerce.entity.Commentaire;
import fr.doranco.ecommerce.model.datasource.HibernateConnector;

public class CommentaireDao implements ICommentaireDao {

	@Override
	public Commentaire getCommentaire(Integer id) throws Exception {
		Session session = null;
		Commentaire commentaire = null;
		try {
			session = HibernateConnector.getSession();
			commentaire = session.find(Commentaire.class, id);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return commentaire;
	
	}

	@Override
	public Commentaire addCommentaire(Commentaire commentaire) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getSession();
			tx = session.beginTransaction();
			session.save(commentaire);
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
		return commentaire;
		
	}

	@Override
	public void updatCommentaire(Commentaire commentaire) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getSession();
			tx = session.beginTransaction();
			session.update(commentaire);
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
	public void removeCommentaire(Integer id) throws Exception {
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

}
