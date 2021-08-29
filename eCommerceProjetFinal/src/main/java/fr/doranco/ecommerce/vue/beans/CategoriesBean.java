package fr.doranco.ecommerce.vue.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.doranco.ecommerce.entity.Categorie;
import fr.doranco.ecommerce.metier.ArticleMetier;
import fr.doranco.ecommerce.metier.CategorieMetier;
import fr.doranco.ecommerce.metier.IArticleMetier;
import fr.doranco.ecommerce.metier.ICategorieMetier;

@ManagedBean(name = "categoriesBean")
@SessionScoped
public class CategoriesBean {

	private final ICategorieMetier categorieMetier = new CategorieMetier();
	//private final IArticleMetier articleMetier = new ArticleMetier();

	@ManagedProperty(name = "nomArticle", value = "")
	private String nomArticle;

	@ManagedProperty(name = "nomCategorie", value = "")
	private String nomCategorie;

	private String messageError;

	public String deconnexion() {

		return "accueil.xhtml";

	}

	public List<Categorie> getCategories() {
		try {

			return categorieMetier.getCategories();
		} catch (Exception e) {
			messageError = "Erreur technique lors de la récupération de la liste des categories !";
			System.out.println(e);
			return new ArrayList<Categorie>();
		}
		
	}
	
	
	
	public String chercherArticle() {
				
		return "gestion_achats.xhtml";
		
	}
	
	
	
	

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public String getNomCategorie() {
		return nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	public String getMessageError() {
		return messageError;
	}

	public void setMessageError(String messageError) {
		this.messageError = messageError;
	}

}
