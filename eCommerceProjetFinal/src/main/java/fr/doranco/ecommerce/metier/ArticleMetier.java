package fr.doranco.ecommerce.metier;

import java.util.List;


import fr.doranco.ecommerce.entity.Article;
import fr.doranco.ecommerce.model.dao.ArticleDao;
import fr.doranco.ecommerce.model.dao.IArticleDao;

public class ArticleMetier implements IArticleMetier{

	private IArticleDao articleDao= new ArticleDao();

	@Override
	public Article addArticle(Article article) throws Exception {
		return articleDao.addArticle(article);
	}

	

	@Override
	public void remove(Integer id) throws Exception {
		articleDao.removeArticle(id);
		
	}

	@Override
	public void update(Article article) throws Exception {
		articleDao.addArticle(article);
	}

	@Override
	public List<Article> getArticles() throws Exception {
		return articleDao.getArticles();
	}
	


}
