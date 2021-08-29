package fr.doranco.ecommerce.metier;

import java.util.List;

import fr.doranco.ecommerce.entity.Commentaire;

import fr.doranco.ecommerce.model.dao.CommentaireDao;

import fr.doranco.ecommerce.model.dao.ICommentaireDao;

public class CommentaireMetier implements ICommentaireMetier {
	
	private final ICommentaireDao commentaireDao = new CommentaireDao();

	@Override
	public Commentaire addCommentaire(Commentaire commentaire) throws Exception {
		return commentaireDao.addCommentaire(commentaire);
	}

	@Override
	public List<Commentaire> getCommentaires() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Integer id) throws Exception {
		commentaireDao.removeCommentaire(id);
		
	}

	@Override
	public void update(Commentaire commentaire) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
