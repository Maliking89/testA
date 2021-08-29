package fr.doranco.ecommerce.model.dao;


import java.util.List;

import fr.doranco.ecommerce.entity.Article;


public interface IArticleDao {
	Article getArticle(Integer id) throws Exception;
	Article addArticle(Article article) throws Exception;
	
	void updateArticle(Article article) throws Exception;
	void removeArticle(Integer id) throws Exception;
   List<Article> getArticles() throws Exception;

}
