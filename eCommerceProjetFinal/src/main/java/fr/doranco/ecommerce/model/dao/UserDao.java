package fr.doranco.ecommerce.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.doranco.ecommerce.entity.Adresse;
import fr.doranco.ecommerce.entity.User;
import fr.doranco.ecommerce.model.datasource.HibernateConnector;

public class UserDao implements IUserDao {

	public UserDao() {
	}

	@Override
	public User getUserByEmail(String email) throws Exception {
		Session session = null;
		User user = null;
		try {
			session = HibernateConnector.getSession();
			Query<User> query = session.createNamedQuery("User:findByEmail", User.class);
			query.setParameter("email", email);

			// user=query.getSingleResult();
			user = query.uniqueResult();

		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return user;

	}

	@Override
	public User getUser(Integer id) throws Exception {
		Session session = null;
		User user = null;
		try {
			session = HibernateConnector.getSession();
			user = session.find(User.class, id);

		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return user;

	}

	@Override
	public User addUser(User user) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getSession();
			tx = session.beginTransaction();
			session.save(user);
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
		return user;
	}

	@Override
	public void updateUser(User user) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getSession();
			tx = session.beginTransaction();
			session.update(user);
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
	public void removeUser(User user) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getSession();
			tx = session.beginTransaction();
			session.remove(user);
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
	public List<User> getUsers() throws Exception {
		Session session = null;
		List<User> users = new ArrayList<User>();
		try {
			session = HibernateConnector.getSession();
			Query<User> query = session.createQuery("FROM User u", User.class);
			users = query.list();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return users;

	}

	@Override
	public List<User> getUsersByVille(String ville) throws Exception {
		Session session = null;
		List<User> users = new ArrayList<User>();
		try {
			session = HibernateConnector.getSession();

			Query<User> query = session.createNamedQuery("User:findAllOfVille", User.class);

			query.setParameter("ville", ville);
			users = query.getResultList();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return users;
	}

	@Override
	public Map<String, List<User>> getUsersOfVille() throws Exception {

		Map<String, List<User>> mapUsers = new HashMap<String, List<User>>();

		List<User> users = new ArrayList<User>();

		users = getUsers();
		if (users != null && !users.isEmpty()) {
			for (User user : users) {
				for (Adresse adresse : user.getAdresses()) {
					if (adresse != null) {
						String ville = adresse.getVille();

						if (!mapUsers.containsKey(ville)) {
							mapUsers.put(ville, getUsersByVille(ville));
						}
					}
				}
			}
		}
		return mapUsers;
	}

}
