package fr.doranco.ecommerce.metier;

import java.util.List;

import fr.doranco.ecommerce.entity.Adresse;


public interface IAdresseMetier {
	Adresse addAdresse(Adresse adresse) throws Exception;
	List<Adresse> getAdresse() throws Exception;
	void remove(Integer id) throws Exception;
	void update(Adresse adresse) throws Exception;
	


}
