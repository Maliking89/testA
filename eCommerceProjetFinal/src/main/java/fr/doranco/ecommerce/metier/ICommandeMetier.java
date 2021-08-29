package fr.doranco.ecommerce.metier;

import java.util.List;

import fr.doranco.ecommerce.entity.Commande;

public interface ICommandeMetier {
	Commande addCommande(Commande commande) throws Exception;
	List<Commande> getCommandes() throws Exception;
	void remove(Integer  id) throws Exception;
	void update(Commande commande) throws Exception;
	

}
