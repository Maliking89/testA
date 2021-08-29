package fr.doranco.ecommerce.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "carte_paiement")
public class CartePaiement implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	
	private Integer id;
	
	@Column(name = "nom_proprietaire", length = 45, nullable = false)
	
	private String nomProprietaire;
	
	@Column(name = "prenom_proprietaire", length = 45, nullable = false)
	
	private String prenomProprietaire;

	
	//numero a crypte 
	@Column(name = "numero", nullable = false)
	
	private byte[]  numero;
	
	@Column(name = "date_fin_validite", nullable = false)
	
	private Date  dateFinValidite;

	@Column(name = "cryptogramme", nullable = false)
	private byte[] cryptogramme;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	
	private User user;

	
	public CartePaiement() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomProprietaire() {
		return nomProprietaire;
	}

	public void setNomProprietaire(String nomProprietaire) {
		this.nomProprietaire = nomProprietaire;
	}

	public String getPrenomProprietaire() {
		return prenomProprietaire;
	}

	public void setPrenomProprietaire(String prenomProprietaire) {
		this.prenomProprietaire = prenomProprietaire;
	}

	public byte[] getNumero() {
		return numero;
	}

	public void setNumero(byte[] numero) {
		this.numero = numero;
	}

	public Date getDateFinValidite() {
		return dateFinValidite;
	}

	public void setDateFinValidite(Date dateFinValidite) {
		this.dateFinValidite = dateFinValidite;
	}

	public byte[] getCryptogramme() {
		return cryptogramme;
	}

	public void setCryptogramme(byte[] cryptogramme) {
		this.cryptogramme = cryptogramme;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "CartePaiement [id=" + id + ", nomProprietaire=" + nomProprietaire + ", prenomProprietaire="
				+ prenomProprietaire + ", numero=" + Arrays.toString(numero) + ", dateFinValidite=" + dateFinValidite
				+ ", cryptogramme=" + Arrays.toString(cryptogramme) + ", user=" + user + "]";
	}
	

}
