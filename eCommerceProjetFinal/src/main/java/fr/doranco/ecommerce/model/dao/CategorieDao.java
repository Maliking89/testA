package fr.doranco.ecommerce.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.doranco.ecommerce.entity.Article;
import fr.doranco.ecommerce.entity.CartePaiement;
import fr.doranco.ecommerce.entity.Categorie;
import fr.doranco.ecommerce.entity.User;
import fr.doranco.ecommerce.model.datasource.HibernateConnector;

public class CategorieDao implements ICategorieDao{

	@Override
	public Categorie getCategorie(Integer id) throws Exception {
		Session session = null;
		Categorie categorie = null;
				try {
					session = HibernateConnector.getSession();
			categorie = session.find(Categorie.class, id);

				} finally {
					if (session != null && session.isOpen()) {
						session.close();
					}
				}
				return categorie;
				
	}

	@Override
	public Categorie addCategorie(Categorie categorie) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getSession();
			tx = session.beginTransaction();
			session.save(categorie);
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
		return categorie;
	}

	@Override
	public void updatCategorie(Categorie categorie) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getSession();
			tx = session.beginTransaction();
			session.update(categorie);
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
	public void removeCategorie(Integer id) throws Exception {
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
	public List<Categorie> getCategories() throws Exception {
		
		Session session = null;
		List<Categorie> categories = new ArrayList<Categorie>();
		try {
			session = HibernateConnector.getSession();
			Query<Categorie> query = session.createQuery("FROM Categorie c", Categorie.class);
			categories = query.list();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return categories;
	}

	

}
