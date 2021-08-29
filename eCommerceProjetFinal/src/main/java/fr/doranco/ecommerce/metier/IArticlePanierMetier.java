package fr.doranco.ecommerce.metier;

import java.util.List;

import fr.doranco.ecommerce.entity.ArticlePanier;


public interface IArticlePanierMetier {
	ArticlePanier addArticlePanier(ArticlePanier articlePanier) throws Exception;
	List<ArticlePanier> getArticlePaniers() throws Exception;
	void remove(Integer id) throws Exception;
	void update(ArticlePanier articlePanier) throws Exception;

}
