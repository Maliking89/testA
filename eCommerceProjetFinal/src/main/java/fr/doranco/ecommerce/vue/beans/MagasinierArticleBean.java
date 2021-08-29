package fr.doranco.ecommerce.vue.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;


import fr.doranco.ecommerce.entity.Article;

import fr.doranco.ecommerce.enums.DisponibiliteArticle;

import fr.doranco.ecommerce.metier.ArticleMetier;
import fr.doranco.ecommerce.metier.IArticleMetier;


@ManagedBean(name = "magasinierArticleBean")
@SessionScoped
public class MagasinierArticleBean {
	
	private final IArticleMetier articleMetier = new ArticleMetier();
	private String messageError;
		
	
	@ManagedProperty(name = "id", value = "")
	private String id;

	
	@ManagedProperty(name = "nom", value = "")
	private String nom;

	@ManagedProperty(name = "description", value = "")
	private String description;
	
	@ManagedProperty(name = "prix", value = "")
	private String prix;
	
	@ManagedProperty(name = "remise", value = "")
	private String remise;
	
	@ManagedProperty(name = "stock", value = "")
	private String stock;
	
	


	@ManagedProperty(name = "isVendable", value = "")
	private String isVendable;
	
	@ManagedProperty(name = "commentaire", value = "")
	private String commentaire;
	
	@ManagedProperty(name = "categorie", value = "")
	private String categorie;
	
	private List<String> disponibilitesArticles;
	
	
	@PostConstruct
	public void init() {
		

		disponibilitesArticles = new ArrayList<String>();
		disponibilitesArticles.add(DisponibiliteArticle.NOVENDABLE.getDisponibiliteArticle());
		disponibilitesArticles.add(DisponibiliteArticle.VENDABLE.getDisponibiliteArticle());
	}
	
	public MagasinierArticleBean() {
		
	}
	

	public String creerArticle() {

		Article article = new Article();
		article.setNom(nom);
		article.setDescription(description);
		article.setPrix(Float.parseFloat(prix));
		article.setRemise(Byte.parseByte(remise));
		
		//article.setIsVendable(Boolean.parseBoolean(isVendable));
	    article.setIsVendable(isVendable);
		article.setStock(Integer.parseInt(stock));
	   // article.setCategorie(String.valueOf(article));
		
		try {
		articleMetier.addArticle(article);
			
			return "";

		} catch (Exception e) {
			messageError = "Erreur technique lors de l'ajout de l'article.";
			System.out.println(e);
			return "";

		}
	}

	
	public List<Article>  getArticles() {
		try {
			return articleMetier.getArticles();
		} catch (Exception e) {
			messageError = "Erreur technique lors de la récupération de la liste des users !";
			System.out.println(messageError);
			return new ArrayList<Article>();
		}
		
	}
	public String modifierArticle(Article article) {
		
        this.id=article.getId().toString();
		this.nom = article.getNom();
		this.description = article.getDescription();
		this.prix = article.getPrix().toString();
		this.remise = article.getRemise().toString();
		this.stock = article.getStock().toString();
		this.categorie=article.getCategorie().toString();
		this.isVendable=article.getIsVendable().toString();
	
		return "";
	}
		
	
	public String supprimerArticle(Article article) {
		try {
			articleMetier.remove(article);
		} catch (Exception e) {
			messageError = "Erreur technique lors de la suppression de l'article !";
			System.out.println(e);
		}

		return "";
	}
	
	
	public void updateArticle() {
		Article article=null;
		try {
			article=articleMetier.getArticle(Integer.parseInt(this.id));
			article.setNom(this.nom);
			article.setPrix(Float.parseFloat(this.prix));
			article.setStock (Integer.parseInt (this.stock));
			article.setDescription(this.description);
			article.setRemise(Byte.parseByte(this.remise));
			//article.setIsVendable( Boolean.parseBoolean(this.isVendable));
			article.setIsVendable(this.isVendable);
		
	    // 	article.setCategorie(this.categorie);
			
			articleMetier.update(article);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}
	
	public String getCategorie() {
		return categorie;
	}

	public void setCategorieId(String categorie) {
		this.categorie = categorie;
	}
	
	
	

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getPrix() {
		return prix;
	}


	public void setPrix(String prix) {
		this.prix = prix;
	}


	public String getRemise() {
		return remise;
	}


	public void setRemise(String remise) {
		this.remise = remise;
	}


	public String getStock() {
		return stock;
	}


	public void setStock(String stock) {
		this.stock = stock;
	}


	public String getIsVendable() {
		return isVendable;
	}


	public void setIsVendable(String isVendable) {
		this.isVendable = isVendable;
	}


	public String getCommentaire() {
		return commentaire;
	}


	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public List<String> getDisponibilitesArticles() {
		return disponibilitesArticles;
	}

	public void setDisponibilitesArticles(List<String> disponibilitesArticles) {
		this.disponibilitesArticles = disponibilitesArticles;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}