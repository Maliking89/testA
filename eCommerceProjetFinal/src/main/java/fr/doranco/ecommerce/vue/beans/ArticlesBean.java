package fr.doranco.ecommerce.vue.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.doranco.ecommerce.entity.Article;
import fr.doranco.ecommerce.entity.ArticlePanier;
import fr.doranco.ecommerce.entity.Categorie;
import fr.doranco.ecommerce.entity.User;
import fr.doranco.ecommerce.metier.ArticleMetier;
import fr.doranco.ecommerce.metier.ArticlePanierMetier;

import fr.doranco.ecommerce.metier.IArticleMetier;
import fr.doranco.ecommerce.metier.IArticlePanierMetier;


@ManagedBean(name = "articleBean")
@SessionScoped
public class ArticlesBean {
	
	private final IArticlePanierMetier articlePanierMetier = new ArticlePanierMetier();
	private final IArticleMetier articleMetier = new ArticleMetier();
	@ManagedProperty(name = "id", value = "")
	private String id;
	
	@ManagedProperty(name = "articleId", value = "")
	private Article articleId;
	
	@ManagedProperty(name = "userId", value = "")
	private User userId;
	
	@ManagedProperty(name = "quantite", value = "")
	private String quantite;
	
	


	public ArticlesBean() {
		
	}

	public String ajouterAuPannier(Article article) {
		ArticlePanier articlePanier = new ArticlePanier();

	//setQuantite(Integer.parseInt(quantite));
		articlePanier.setUser(userId);
		articlePanier.setArticle(article);
		
		try {
			articlePanierMetier.addArticlePanier(articlePanier);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		return "panier.xhtml";
	}
	
	public String supprimerDuPannier(Article article) {
		return "";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}



	public Article getArticleId() {
		return articleId;
	}

	public void setArticleId(Article articleId) {
		this.articleId = articleId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public String getQuantite() {
		return quantite;
	}

	public void setQuantite(String quantite) {
		this.quantite = quantite;
	}

	
	
	

	

	
	
}
