package fr.doranco.ecommerce.vue.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.doranco.ecommerce.entity.Adresse;
import fr.doranco.ecommerce.entity.CartePaiement;
import fr.doranco.ecommerce.entity.User;
import fr.doranco.ecommerce.enums.Genre;
import fr.doranco.ecommerce.enums.Profil;
import fr.doranco.ecommerce.metier.AdresseMetier;
import fr.doranco.ecommerce.metier.CartePaiementMetier;
import fr.doranco.ecommerce.metier.IAdresseMetier;
import fr.doranco.ecommerce.metier.ICartePaiementMetier;
import fr.doranco.ecommerce.metier.IUserMetier;
import fr.doranco.ecommerce.metier.UserMetier;
import fr.doranco.ecommerce.utils.Dates;

@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean {

	private final IUserMetier userMetier = new UserMetier();
	private final IAdresseMetier adresserMetier = new AdresseMetier();
	private final ICartePaiementMetier cartePaiementMetier = new CartePaiementMetier();

	@ManagedProperty(name = "nom", value = "")
	private String nom;

	@ManagedProperty(name = "telephone", value = "")
	private String telephone;

	@ManagedProperty(name = "prenom", value = "")
	private String prenom;

	@ManagedProperty(name = "password", value = "")
	private String password;

	@ManagedProperty(name = "dateNaissance", value = "")
	private String dateNaissance;

	@ManagedProperty(name = "genre", value = "")
	private String genre;

	@ManagedProperty(name = "email", value = "")
	private String email;

	@ManagedProperty(name = "numeroDeRue", value = "")
	private String numeroDeRue;

	@ManagedProperty(name = "rue", value = "")
	private String rue;

	@ManagedProperty(name = "codePostal", value = "")
	private String codePostal;

	@ManagedProperty(name = "ville", value = "")
	private String ville;

	@ManagedProperty(name = "adresseLivraison", value = "")
	private String adresseLivraison;

	@ManagedProperty(name = "numeroCarte", value = "")
	private String numeroCarte;

	@ManagedProperty(name = "nomProprietaire", value = "")
	private String nomProprietaire;

	@ManagedProperty(name = "prenomProprietaire", value = "")
	private String prenomProprietaire;

	@ManagedProperty(name = "dateFinValidite", value = "")
	private String dateFinValidite;

	@ManagedProperty(name = "cryptogramme", value = "")
	private String cryptogramme;

	@ManagedProperty(name = "isEmailEnabled", value = "true")
	private boolean isEmailEnabled;

	@ManagedProperty(name = "boutonMajActif", value = "true")
	private boolean boutonMajActif;

	@ManagedProperty(name = "boutonAjouterActif", value = "false")
	private boolean boutonAjouterActif;

	private String niveauDeService;
	private List<String> profils;

	private List<String> genres;
	private String messageError;
	private String messageSuccess;

	public UserBean() {
	}

	@PostConstruct
	public void init() {
		messageError = "";
		messageSuccess = "";
		genres = new ArrayList<String>();
		genres.add(Genre.MASCULIN.getGenre());
		genres.add(Genre.FEMININ.getGenre());
		genre = Genre.MASCULIN.getGenre();

		profils = new ArrayList<String>();
		profils.add(Profil.ADMIN.getProfil());
		profils.add(Profil.MAGASINIER.getProfil());
		profils.add(Profil.CLIENT.getProfil());
	}

	public String creerUser() {

		initMessages();
		User user = new User();

		user.setGenre(genre);
		user.setNom(nom);
		user.setPrenom(prenom);
		user.setPassword(password);
		user.setTelephone(telephone);
		user.setProfil(Profil.CLIENT.toString());
		user.setIsActif(true);

		try {
			user.setDateNaissance(Dates.convertStringToDateUtil(dateNaissance));
		} catch (Exception e) {
			messageError = "Erreur technique lors du traitement de la date de naissance !";
			System.out.println(e);
			return "";
		}
		user.setEmail(email);

		Adresse adress1 = new Adresse();
		adress1.setNumero(Integer.parseInt(numeroDeRue));
		adress1.setRue(rue);
		adress1.setCodePostal(codePostal);
		adress1.setVille(ville);

		adress1.setUser(user);

		CartePaiement cartePaiement = new CartePaiement();
		cartePaiement.setNomProprietaire(nomProprietaire);
		cartePaiement.setPrenomProprietaire(prenomProprietaire);
		cartePaiement.setNumero(numeroCarte.getBytes());
		cartePaiement.setCryptogramme(cryptogramme.getBytes());
		try {
			cartePaiement.setDateFinValidite(Dates.convertStringToDateUtil(dateFinValidite));
		} catch (Exception e) {
			messageError = "Erreur technique lors du traitement de la date de validite !";
			System.out.println(e);
			return "";
		}
		cartePaiement.setUser(user);

		try {
			User addedUser = userMetier.addUser(user);
			System.out.println(addedUser);
			messageSuccess = "User ajouté avec succès.";

			Adresse addedAdresse = adresserMetier.addAdresse(adress1);
			System.out.println(addedAdresse);
			messageSuccess = "User ajouté avec succès.";

			CartePaiement addCartePaiement = cartePaiementMetier.addCartePaiement(cartePaiement);
			System.out.println(addCartePaiement);
			messageSuccess = "User ajouté avec succès.";
			return "";

		} catch (Exception e) {
			messageError = "Erreur technique lors de l'ajout de l'user.";
			System.out.println(e);
			return "";

		}

	}

	private void initMessages() {
		messageError = "";
		messageSuccess = "";
	}

	private void initFields() {
		this.nom = "";
		this.prenom = "";
		this.genre = Genre.MASCULIN.getGenre();
		this.dateNaissance = "";
		this.email = "";

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

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getIsEmailEnabled() {
		return isEmailEnabled;
	}

	public void setIsEmailEnabled(boolean isEmailEnabled) {
		this.isEmailEnabled = isEmailEnabled;
	}

	public boolean getBoutonMajActif() {
		return boutonMajActif;
	}

	public void setBoutonMajActif(boolean boutonMajActif) {
		this.boutonMajActif = boutonMajActif;
	}

	public boolean getBoutonAjouterActif() {
		return boutonAjouterActif;
	}

	public void setBoutonAjouterActif(boolean boutonAjouterActif) {
		this.boutonAjouterActif = boutonAjouterActif;
	}

	public String getNiveauDeService() {
		return niveauDeService;
	}

	public void setNiveauDeService(String niveauDeService) {
		this.niveauDeService = niveauDeService;
	}

	public String getMessageError() {
		return messageError;
	}

	public void setMessageError(String messageError) {
		this.messageError = messageError;
	}

	public String getMessageSuccess() {
		return messageSuccess;
	}

	public void setMessageSuccess(String messageSuccess) {
		this.messageSuccess = messageSuccess;
	}

	public List<String> getGenres() {
		return genres;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAdresseLivraison() {
		return adresseLivraison;
	}

	public void setAdresseLivraison(String adresseLivraison) {
		this.adresseLivraison = adresseLivraison;
	}

	public String getNumeroDeRue() {
		return numeroDeRue;
	}

	public void setNumeroDeRue(String numeroDeRue) {
		this.numeroDeRue = numeroDeRue;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getNumeroCarte() {
		return numeroCarte;
	}

	public void setNumeroCarte(String numeroCarte) {
		this.numeroCarte = numeroCarte;
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

	public String getDateFinValidite() {
		return dateFinValidite;
	}

	public void setDateFinValidite(String dateFinValidite) {
		this.dateFinValidite = dateFinValidite;
	}

	public String getCryptogramme() {
		return cryptogramme;
	}

	public void setCryptogramme(String cryptogramme) {
		this.cryptogramme = cryptogramme;
	}

	public List<String> getProfils() {
		return profils;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

}
