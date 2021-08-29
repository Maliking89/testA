package fr.doranco.ecommerce.model.dao;

import java.util.List;

import fr.doranco.ecommerce.entity.Commande;



public interface ICommandeDao {
	
   Commande getCommande(Integer id) throws Exception;
   Commande addCommande(Commande commande) throws Exception;
   void updateCommande(Commande commande) throws Exception;
   void removeCommande(Integer id) throws Exception;
   List<Commande> getCommandes1();// avec createNamedQuery
   List<Commande> getCommandes2();// avec createQuery
   List<Commande> getCommandes3();// avec createNativeQuery
}
