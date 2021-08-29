package fr.doranco.ecommerce.model.dao;

import java.util.List;

import fr.doranco.ecommerce.entity.Article;
import fr.doranco.ecommerce.entity.Categorie;

public interface ICategorieDao {
	Categorie getCategorie(Integer id) throws Exception;
	Categorie addCategorie(Categorie cartePaiement) throws Exception;
	
	void updatCategorie(Categorie cartePaiement) throws Exception;
	void removeCategorie(Integer id) throws Exception;
	 List<Categorie> getCategories() throws Exception;
	

}
