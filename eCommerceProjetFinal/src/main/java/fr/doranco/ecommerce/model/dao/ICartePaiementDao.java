package fr.doranco.ecommerce.model.dao;


import fr.doranco.ecommerce.entity.CartePaiement;

public interface ICartePaiementDao {
	CartePaiement getCartePaiement(Integer id) throws Exception;
	CartePaiement addCartePaiement(CartePaiement cartePaiement) throws Exception;
	
	void updatCartePaiement(CartePaiement cartePaiement) throws Exception;
	void removeCartePaiement(Integer id) throws Exception;
}
