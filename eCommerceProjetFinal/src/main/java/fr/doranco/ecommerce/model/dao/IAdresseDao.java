package fr.doranco.ecommerce.model.dao;

import fr.doranco.ecommerce.entity.Adresse;

public interface IAdresseDao {
	Adresse getAdresse(Integer id) throws Exception;
	Adresse addAdresse(Adresse adresse) throws Exception;
	
	void updateAdressee(Adresse adresse) throws Exception;
	void removeAdressee(Integer id) throws Exception;
}
