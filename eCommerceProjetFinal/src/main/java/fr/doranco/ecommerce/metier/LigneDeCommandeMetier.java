package fr.doranco.ecommerce.metier;

import java.util.List;

import fr.doranco.ecommerce.entity.LigneDeCommande;
import fr.doranco.ecommerce.model.dao.ILigneDeCommandeDao;

import fr.doranco.ecommerce.model.dao.LigneDeCommandeDao;


public class LigneDeCommandeMetier implements ILigneDeCommandeMetier {
	private final ILigneDeCommandeDao ligneDeCommandeDao = new LigneDeCommandeDao();

	@Override
	public LigneDeCommande addLigneDeCommande(LigneDeCommande ligneDeCommande) throws Exception {
		
		return ligneDeCommandeDao.addLigneDeCommande(ligneDeCommande) ;
	}

	@Override
	public List<LigneDeCommande> getLigneDeCommandes() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Integer id) throws Exception {
		ligneDeCommandeDao.removeLigneDeCommande(id);
		
	}

	@Override
	public void update(LigneDeCommande ligneDeCommande) throws Exception {
		ligneDeCommandeDao.updateLigneDeCommande(ligneDeCommande);
		
	}
	

}
