package fr.doranco.ecommerce.metier;

import java.util.List;

import fr.doranco.ecommerce.entity.Adresse;
import fr.doranco.ecommerce.model.dao.AdresseDao;
import fr.doranco.ecommerce.model.dao.IAdresseDao;



public class AdresseMetier implements IAdresseMetier{
	private final IAdresseDao adresseDao = new AdresseDao();
	

	@Override
	public Adresse addAdresse(Adresse adresse) throws Exception {
		return adresseDao.addAdresse(adresse);
	}

	@Override
	public List<Adresse> getAdresse() throws Exception {
		return null;
	}

	@Override
	public void remove(Integer id) throws Exception {
		adresseDao.removeAdressee(id);
		
	}

	@Override
	public void update(Adresse adresse) throws Exception {
		adresseDao.updateAdressee(adresse);
		
	}

}
