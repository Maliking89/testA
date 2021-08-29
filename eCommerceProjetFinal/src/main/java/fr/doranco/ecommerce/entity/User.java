package fr.doranco.ecommerce.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "user")
@NamedQueries({
		@NamedQuery(name = "User:findAllOfVille", query = "SELECT u.user FROM Adresse u where u.ville=:ville"),
		@NamedQuery(name = "User:findByEmail", query = "FROM User u WHERE u.email=:email") })
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "genre", length = 8, nullable = true)
	private String genre;

	@Column(name = "nom", length = 45, nullable = false) 
	private String nom;

	@Column(name = "telephone", length = 25, nullable = false) 
	private String telephone;
	
	

	@Column(name = "prenom", length = 45, nullable = false)
	private String prenom;

	@Column(name = "date_naissance", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;

	@Column(name = "email", length = 30, nullable = false, unique = true)
	private String email;

	@Column(name = "password", length = 20, nullable = false)
	private String password;
	
	@Column(name = "is_actif", length = 6, nullable = true)
	private Boolean isActif;
	
	@Column(name = "profil", length = 16, nullable = true)
	private String  Profil ;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Commande> commandes;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Adresse> adresses;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<CartePaiement> cartesPaiements;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Commentaire> commentaires;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<ArticlePanier> paniers;
	
	
	public User() {
		this.commandes = new ArrayList<Commande>();
		this.adresses = new ArrayList<Adresse>();
		this.cartesPaiements= new ArrayList<CartePaiement>();
		this.commentaires= new ArrayList<Commentaire>();
		this.paniers= new ArrayList<ArticlePanier>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Adresse> getAdresses() {
		return adresses;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	
	public Boolean getIsActif() {
		return isActif;
	}

	public void setIsActif(Boolean isActif) {
		this.isActif = isActif;
	}

	public String getProfil() {
		return Profil;
	}

	public void setProfil(String profil) {
		Profil = profil;
	}

	public List<CartePaiement> getCartesPaiements() {
		return cartesPaiements;
	}

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	public List<ArticlePanier> getPaniers() {
		return paniers;
	}
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", genre=" + genre + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance="
				+ dateNaissance + ", email=" + email + ", password=" + password + "]";
	}

}
