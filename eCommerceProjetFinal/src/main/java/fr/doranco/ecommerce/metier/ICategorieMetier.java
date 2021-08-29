package fr.doranco.ecommerce.metier;

import java.util.List;

import fr.doranco.ecommerce.entity.Article;
import fr.doranco.ecommerce.entity.Categorie;

public interface ICategorieMetier {
	Categorie addCategorie(Categorie Categorie) throws Exception;
	List<Categorie> getCategories() throws Exception;
	void remove(Integer id) throws Exception;
	void update(Categorie categorie) throws Exception;
 

}
