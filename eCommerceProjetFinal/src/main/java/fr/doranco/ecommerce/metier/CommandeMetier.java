package fr.doranco.ecommerce.metier;

import java.util.List;

import fr.doranco.ecommerce.entity.Commande;
import fr.doranco.ecommerce.model.dao.CommandeDao;

import fr.doranco.ecommerce.model.dao.ICommandeDao;


public class CommandeMetier implements ICommandeMetier {

	
	private final ICommandeDao commandeDao = new CommandeDao();

	@Override
	public Commande addCommande(Commande commande) throws Exception {
		
		return commandeDao.addCommande(commande);
	}

	@Override
	public List<Commande> getCommandes() throws Exception {
		
		return commandeDao.getCommandes1();
	}	

	@Override
	public void remove(Integer id) throws Exception {
		commandeDao.removeCommande(id);
		
	}

	@Override
	public void update(Commande commande) throws Exception {
		commandeDao.updateCommande(commande);
		
	}
}
