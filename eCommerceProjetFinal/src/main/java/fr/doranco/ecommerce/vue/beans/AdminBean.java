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
import fr.doranco.ecommerce.metier.IAdresseMetier;
import fr.doranco.ecommerce.metier.IUserMetier;
import fr.doranco.ecommerce.metier.UserMetier;
import fr.doranco.ecommerce.utils.Dates;

@ManagedBean(name = "adminBean")
@SessionScoped
public class AdminBean {

	IUserMetier userMetier = new UserMetier();
	IAdresseMetier adresseMetier = new AdresseMetier();
	@ManagedProperty(name = "profil", value = "")
	private String profil;

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
	private String id;

	private List<String> genres;

	private List<String> profils;

	private String messageError;
	private String niveauDeService;

	private String messageSuccess;

	public AdminBean() {

	}

	@PostConstruct
	public void init() {
		messageError = "";
		messageSuccess = "";

		profils = new ArrayList<String>();
		profils.add(Profil.ADMIN.getProfil());
		profils.add(Profil.MAGASINIER.getProfil());

	}

	// cette methode getUsers elle recupere tout les Users avec Profil ( Admin ou
	// Magasinier);

	public List<User> getUsers() {
		try {
			List<User> users = new ArrayList<User>();
			// List<User> users = userMetier.getUsersByProfil(Profil.ADMIN.getProfil());
			users.addAll(userMetier.getUsersByProfil(Profil.MAGASINIER.getProfil()));
			return users;
		} catch (Exception e) {
			messageError = "Erreur technique lors de la récupération de la liste des employes !";
			System.out.println(messageError);
			System.err.println(e);
			return new ArrayList<User>();
		}

	}

	public void updateUser() {
		Adresse adresse = null;
		User user = null;
		try {
		//	user = userMetier.getUserByEmail(this.email);
           user= userMetier.getUser(Integer.parseInt(this.id));
			user.setPrenom(this.prenom);
			user.setNom(this.nom);
			user.setDateNaissance(Dates.convertStringToDateUtil(this.dateNaissance));
			user.setPassword(this.password);
			user.setTelephone(this.telephone);
			user.setProfil(this.profil);
			userMetier.update(user);

			adresse = adresseMetier.getAdresseByEmail(this.email);
			adresse.setNumero(Integer.parseInt(this.numeroDeRue));
			adresse.setRue(this.rue);
			adresse.setVille(this.ville);
			adresse.setCodePostal(this.codePostal);
			adresse.setUser(user);

		} catch (Exception e) {
			messageError = "Erreur technique !";
			System.out.println(e);
		}
		return;
	}

	public String modifierUser(User user) {
		Adresse adresse = null;

		this.prenom = user.getPrenom();
		this.nom = user.getNom();
		this.password = user.getPassword();
		this.telephone = user.getTelephone();
		this.profil = user.getProfil();
		try {
			this.dateNaissance = Dates.convertDateUtilToString(user.getDateNaissance());
		} catch (Exception e) {
			messageError = "Erreur technique lors de la récupération de la date de l'user !";
			System.out.println(e.getMessage());
			return "";
		}
		
		this.email = user.getEmail();
//		
//		try {
	//		adresse =adresseMetier.getAdresse(Integer.parseInt(this.id));
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//		}
//		 this.rue=adresse.getRue();
//		 this.numeroDeRue=adresse.getNumero().toString();
//		 this.codePostal=adresse.getCodePostal();
//		 this.ville=adresse.getVille();
		return "";
	}

	public String creerUser() {

		User user = new User();

		user.setNom(nom);
		user.setPrenom(prenom);
		user.setPassword(password);
		user.setTelephone(telephone);
		user.setProfil(profil);
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

		try {
			User addedUser = userMetier.addUser(user);
			System.out.println(addedUser);
			messageSuccess = "User ajouté avec succès.";

			Adresse addedAdresse = adresseMetier.addAdresse(adress1);
			System.out.println(addedAdresse);
			messageSuccess = "User ajouté avec succès.";

			return "";

		} catch (Exception e) {
			messageError = "Erreur technique lors de l'ajout de l'user.";
			System.out.println(e);
			return "";

		}
	}

	public String supprimerUser(User user) {
		try {
			userMetier.remove(user);
		} catch (Exception e) {
			messageError = "Erreur technique lors de la suppression de la categorie !";
			System.out.println(e);
		}

		return "";
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getProfil() {
		return profil;
	}

	public void setProfil(String profil) {
		this.profil = profil;
	}

	public List<String> getProfils() {
		return profils;
	}

	public void setProfils(List<String> profils) {
		this.profils = profils;
	}

	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

}
