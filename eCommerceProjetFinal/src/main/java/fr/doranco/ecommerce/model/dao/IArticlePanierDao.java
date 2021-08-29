package fr.doranco.ecommerce.model.dao;


import fr.doranco.ecommerce.entity.ArticlePanier;

public interface IArticlePanierDao {
	ArticlePanier getArticlePanier(Integer id) throws Exception;
	ArticlePanier addArticlePanier(ArticlePanier articlePanier) throws Exception;
		
	void updateArticlePanier(ArticlePanier articlePanier) throws Exception;
	void removeArticlePanier(Integer id) throws Exception;

}
