package fr.doranco.ecommerce.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.doranco.ecommerce.entity.Article;
import fr.doranco.ecommerce.entity.User;
import fr.doranco.ecommerce.model.datasource.HibernateConnector;

public class ArticleDao implements IArticleDao {

	@Override
	public Article getArticle(Integer id) throws Exception {
		Session session = null;
		Article article = null;
		try {
			session = HibernateConnector.getSession();
			 article = session.find(Article.class, id);

		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return  article;
	}

	@Override
	public Article addArticle(Article article) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getSession();
			tx = session.beginTransaction();
			session.save(article);
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
		return article ;
	}

	@Override
	public void updateArticle(Article article) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getSession();
			tx = session.beginTransaction();
			session.update(article);
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
	public void removeArticle(Integer id) throws Exception {
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
	public List<Article> getArticles() throws Exception {
		
		Session session = null;
		List<Article> articles = new ArrayList<Article>();
		try {
			session = HibernateConnector.getSession();
			Query<Article> query = session.createQuery("FROM Article a", Article.class);
			articles = query.list();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return articles;
	}
	
	
		
	

}
