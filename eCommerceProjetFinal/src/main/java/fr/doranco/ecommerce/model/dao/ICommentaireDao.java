package fr.doranco.ecommerce.model.dao;

import fr.doranco.ecommerce.entity.Commentaire;

public interface ICommentaireDao {
	Commentaire getCommentaire(Integer id) throws Exception;
	Commentaire addCommentaire(Commentaire commentaire) throws Exception;
	
	void updatCommentaire(Commentaire commentaire) throws Exception;
	void removeCommentaire(Integer id) throws Exception;


}
