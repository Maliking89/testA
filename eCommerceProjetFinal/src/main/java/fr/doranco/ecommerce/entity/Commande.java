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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "commande")
@NamedQueries({ @NamedQuery(name = "Commande:findAll", query = "FROM Commande c"),

})

public class Commande implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "numero", length = 49, nullable = false)
	private String numero;

	@Column(name = "date_commande", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateCommande;

	@Column(name = "date_livraison")
	@Temporal(TemporalType.DATE)
	private Date dateLivraison;
	
	@Column(name = "total_remise", nullable = true)
	private Double totalRemise;
	
	@Column(name = "frais_expedition", nullable = true)
	private Double fraisExpedition;
	
	@Column(name = "total_general", nullable = false)
	private Double totalGeneral;
	
	@Column(name = "adresse_facturation", nullable = false)
	private Adresse adresseFacturation;
	
	@Column(name = "adresse_livraison", nullable = false)
	private Adresse adresseLivraison;
	
	@Column(name = "carte_paiement_default", nullable = true)
	private CartePaiement cartePaiementDefault;
	
	

	@OneToMany(mappedBy = "commande", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<LigneDeCommande> lignesDeCommande;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Commande() {
		lignesDeCommande = new ArrayList<LigneDeCommande>();
	}

	@Override
	public String toString() {
		return "Commande [id=" + id + ", numero=" + numero + ", dateCommande=" + dateCommande + ", dateLivraison="
				+ dateLivraison + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Date getDateLivraison() {
		return dateLivraison;
	}

	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<LigneDeCommande> getLignesDeCommande() {
		return lignesDeCommande;
	}

}
