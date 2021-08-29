package fr.doranco.ecommerce.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ligne_de_commande")
@NamedQueries({ @NamedQuery(name = "LigneDeCommande:findAll", query = "FROM LigneDeCommande l"),

})
public class LigneDeCommande implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "article_id")
	private Article article;

	@Column(name = "prix_unitaire", nullable = false)
	private Double prixUnitaire;
	
	@Column(name = "remise_article", nullable = true)
	private Double remiseArticle;

	@Column(name = "quantite", nullable = false)
	private Integer quantite;

	@ManyToOne
	@JoinColumn(name = "commande_id")
	private Commande commande;

	
	public LigneDeCommande() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "LigneDeCommande [id=" + id + ", article=" + article + ", prixUnitaire=" + prixUnitaire
				+ ", remiseArticle=" + remiseArticle + ", quantite=" + quantite + ", commande=" + commande + "]";
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Double getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(Double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public Double getRemiseArticle() {
		return remiseArticle;
	}

	public void setRemiseArticle(Double remiseArticle) {
		this.remiseArticle = remiseArticle;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

}
