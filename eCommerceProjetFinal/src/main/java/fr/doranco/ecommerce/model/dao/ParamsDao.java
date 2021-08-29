package fr.doranco.ecommerce.model.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.doranco.ecommerce.entity.Adresse;
import fr.doranco.ecommerce.entity.Params;
import fr.doranco.ecommerce.model.datasource.HibernateConnector;

public class ParamsDao implements IParamsDao {

	@Override
	public Params getParams(Integer id) throws Exception {
		Session session = null;
		Params params = null;
		try {
			session = HibernateConnector.getSession();
			params = session.find(Params.class, id);

		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return params;
		
	}

	@Override
	public Params addParams(Params params) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getSession();
			tx = session.beginTransaction();
			session.save(params);
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
		return params;

	}

	@Override
	public void updatParams(Params params) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getSession();
			tx = session.beginTransaction();
			session.update(params);
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
	public void removeParams(Integer id) throws Exception {
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
