package fr.doranco.ecommerce.metier;

import java.util.List;

import fr.doranco.ecommerce.entity.ArticlePanier;
import fr.doranco.ecommerce.model.dao.AdresseDao;
import fr.doranco.ecommerce.model.dao.ArticlePanierDao;
import fr.doranco.ecommerce.model.dao.IAdresseDao;
import fr.doranco.ecommerce.model.dao.IArticlePanierDao;



public class ArticlePanierMetier implements IArticlePanierMetier {
	
	private final IArticlePanierDao articlePanierDao = new ArticlePanierDao();

	@Override
	public ArticlePanier addArticlePanier(ArticlePanier articlePanier) throws Exception {
		// TODO Auto-generated method stub
	return articlePanierDao.addArticlePanier(articlePanier);
	}

	@Override
	public List<ArticlePanier> getArticlePaniers() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Integer id) throws Exception {
		// TODO Auto-generated method stub
		articlePanierDao.removeArticlePanier(id);
	}

	@Override
	public void update(ArticlePanier articlePanier) throws Exception {
		// TODO Auto-generated method stub
		articlePanierDao.updateArticlePanier(articlePanier);
		
	}
	


	
		
	

}
