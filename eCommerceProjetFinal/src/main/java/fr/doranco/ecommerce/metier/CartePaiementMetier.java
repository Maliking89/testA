package fr.doranco.ecommerce.metier;

import java.util.List;

import fr.doranco.ecommerce.entity.CartePaiement;
import fr.doranco.ecommerce.entity.User;
import fr.doranco.ecommerce.model.dao.CartePaiementDao;
import fr.doranco.ecommerce.model.dao.ICartePaiementDao;

public class CartePaiementMetier implements ICartePaiementMetier {
	private final ICartePaiementDao cartePaiementDao = new CartePaiementDao();

	@Override
	public CartePaiement addCartePaiement(CartePaiement cartePaiement) throws Exception {
		// TODO Auto-generated method stub
		return cartePaiementDao.addCartePaiement(cartePaiement);
	}

	@Override
	public List<User> getUCartePaiement() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Integer id) throws Exception {
		// TODO Auto-generated method stub
		cartePaiementDao.removeCartePaiement(id);
		
	}

	@Override
	public void update(CartePaiement cartePaiement) throws Exception {
		// TODO Auto-generated method stub
		cartePaiementDao.updatCartePaiement(cartePaiement);
		
	}

}
