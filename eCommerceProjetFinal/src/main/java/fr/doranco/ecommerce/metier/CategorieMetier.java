package fr.doranco.ecommerce.metier;

import java.util.List;

import fr.doranco.ecommerce.entity.Article;
import fr.doranco.ecommerce.entity.Categorie;
import fr.doranco.ecommerce.model.dao.CategorieDao;
import fr.doranco.ecommerce.model.dao.ICategorieDao;

public class CategorieMetier implements ICategorieMetier {
	private final ICategorieDao categorieDao = new CategorieDao();

	@Override
	public Categorie addCategorie(Categorie categorie) throws Exception {
		// TODO Auto-generated method stub
		return categorieDao.addCategorie(categorie);
	}

	@Override
	public List<Categorie> getCategories() throws Exception {
		return categorieDao.getCategories();
	}

	@Override
	public void remove(Integer id) throws Exception {
		// TODO Auto-generated method stub
		categorieDao.removeCategorie(id);
		
	}

	@Override
	public void update(Categorie categorie) throws Exception {
		// TODO Auto-generated method stub
		categorieDao.updatCategorie(categorie);
		
	}

	
}
