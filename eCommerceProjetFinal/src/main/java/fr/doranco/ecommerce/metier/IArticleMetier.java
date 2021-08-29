package fr.doranco.ecommerce.metier;

import java.util.List;

import fr.doranco.ecommerce.entity.Article;
import fr.doranco.ecommerce.entity.User;


public interface IArticleMetier {
	Article addArticle(Article article) throws Exception;
	
	void remove(Integer id) throws Exception;
	void update(Article article) throws Exception;
	List<Article> getArticles() throws Exception;

}
