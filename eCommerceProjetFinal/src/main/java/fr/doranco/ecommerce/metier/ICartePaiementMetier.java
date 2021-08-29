package fr.doranco.ecommerce.metier;

import java.util.List;

import fr.doranco.ecommerce.entity.CartePaiement;
import fr.doranco.ecommerce.entity.User;

public interface ICartePaiementMetier {
	
	CartePaiement addCartePaiement(CartePaiement cartePaiement) throws Exception;
	List<User> getUCartePaiement() throws Exception;
	void remove(Integer id) throws Exception;
	void update(CartePaiement cartePaiement) throws Exception;

}
