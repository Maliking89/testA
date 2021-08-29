package fr.doranco.ecommerce.model.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.doranco.ecommerce.entity.ArticlePanier;
import fr.doranco.ecommerce.model.datasource.HibernateConnector;

public class ArticlePanierDao implements IArticlePanierDao {

	@Override
	public ArticlePanier getArticlePanier(Integer id) throws Exception {
		Session session = null;
		ArticlePanier articlePanier = null;
		try {
			session = HibernateConnector.getSession();
		articlePanier = session.find(ArticlePanier.class, id);

		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return articlePanier;
		
	}

	@Override
	public ArticlePanier addArticlePanier(ArticlePanier articlePanier) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getSession();
			tx = session.beginTransaction();
			session.save(articlePanier);
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
		return articlePanier;
	}

	@Override
	public void updateArticlePanier(ArticlePanier articlePanier) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getSession();
			tx = session.beginTransaction();
			session.update(articlePanier);
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
	public void removeArticlePanier(Integer id) throws Exception {
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
