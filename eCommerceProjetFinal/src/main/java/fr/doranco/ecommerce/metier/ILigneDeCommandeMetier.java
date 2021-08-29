package fr.doranco.ecommerce.metier;

import java.util.List;

import fr.doranco.ecommerce.entity.LigneDeCommande;

public interface ILigneDeCommandeMetier {
	LigneDeCommande addLigneDeCommande(LigneDeCommande ligneDeCommande) throws Exception;
	List<LigneDeCommande> getLigneDeCommandes() throws Exception;
	void remove(Integer id) throws Exception;
	void update(LigneDeCommande ligneDeCommande) throws Exception;

}
