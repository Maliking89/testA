package fr.doranco.ecommerce.metier;

import java.util.List;

import fr.doranco.ecommerce.entity.Commentaire;

public interface ICommentaireMetier {
	Commentaire addCommentaire(Commentaire commentaire) throws Exception;
	List<Commentaire> getCommentaires() throws Exception;
	void remove(Integer id) throws Exception;
	void update(Commentaire commentaire) throws Exception;

}
