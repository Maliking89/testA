package fr.doranco.ecommerce.model.dao;

import java.util.List;

import fr.doranco.ecommerce.entity.LigneDeCommande;




public interface ILigneDeCommandeDao {
	
	   LigneDeCommande getLigneDeCommande(Integer id) throws Exception;
	   LigneDeCommande addLigneDeCommande(LigneDeCommande lignedecommande) throws Exception;
	   void updateLigneDeCommande(LigneDeCommande lignedecommande) throws Exception;
	   void removeLigneDeCommande(Integer id) throws Exception;
	   List<LigneDeCommande> getLigneDeCommandes()throws Exception;
	   

}
