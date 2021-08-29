package fr.doranco.ecommerce.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "article")

public class Article implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nom", length = 45, nullable = false)
	private String nom;

	@Column(name = "description", length = 255, nullable = false)
	private String description;

	@Column(name = "prix", length = 25, nullable = false)
	private Double prix;

	@Column(name = "remise", length = 5, nullable = true)
	private byte remise;

	@Column(name = "stock", length = 25, nullable = false)
	private Integer stock;

	@Column(name = "is_vendable", length = 8, nullable = false)
	private boolean isVendable;

	@OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)

	private List<Commentaire> commentaires;
	
	
	@ManyToOne
	@JoinColumn(name = "categorie_id")
	private Categorie categorie;

	public Article() {
		this.commentaires=new ArrayList<Commentaire>();

	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", nom=" + nom + ", description=" + description + ", prix=" + prix + ", remise="
				+ remise + ", stock=" + stock + ", isVendable=" + isVendable + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public byte getRemise() {
		return remise;
	}

	public void setRemise(byte remise) {
		this.remise = remise;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public boolean isVendable() {
		return isVendable;
	}

	public void setVendable(boolean isVendable) {
		this.isVendable = isVendable;
	}

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

}
