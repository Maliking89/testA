package fr.doranco.ecommerce.vue.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.doranco.ecommerce.entity.User;
import fr.doranco.ecommerce.enums.Profil;
import fr.doranco.ecommerce.metier.IUserMetier;
import fr.doranco.ecommerce.metier.UserMetier;

@ManagedBean(name = "connectBean")
@SessionScoped
public class ConnectBean {

	private final IUserMetier userMetier = new UserMetier();

	@ManagedProperty(name = "email", value = "")
	private String email;

	@ManagedProperty(name = "password", value = "")
	private String password;

	@ManagedProperty(name = "messageError", value = "")
	private static String messageError;

	@ManagedProperty(name = "messageSuccess", value = "")
	private static String messageSuccess;

	@ManagedProperty(name = "boutonAjouterActif", value = "false")
	private boolean boutonAjouterActif;

	private List<String> profils;

	static {
		messageError = "";
		messageSuccess = "";
	}

	public ConnectBean() {
	}

	public String connexion() {

		if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
			messageError = "mot de passe et/ou email incorrects !";
			messageSuccess = "";
			return "";
		}
		try {

			User user = userMetier.getUserByEmail(email);

			if (user != null && user.getPassword().equals(password)) {
				
				System.out.println("Connexion reussite");
				String profil = user.getProfil();
				if (profil.equals(Profil.ADMIN.getProfil())) {

					return "";
				}
				if (profil.contentEquals( Profil.MAGASINIER.getProfil())) {

					return "";
				}
				if (profil.equals(Profil.CLIENT.getProfil())) {

					return "categories.xhtml";
				}
				messageError = "";
				messageSuccess = "Utilisateur connecté avec succès.";
			} else {
				messageError = "mot de passe et/ou email incorrects !";
				messageSuccess = "";
				return "";
			}

		}

		catch (Exception e) {
			System.out.println(e);
		}

		return null;
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

	public String getMessageError() {
		return messageError;
	}

	public void setMessageError(String message) {
		messageError = message;
	}

	public String getMessageSuccess() {
		return messageSuccess;
	}

	public void setMessageSuccess(String message) {
		messageSuccess = message;
	}

	public boolean getBoutonAjouterActif() {
		return boutonAjouterActif;
	}

	public void setBoutonAjouterActif(boolean boutonAjouterActif) {
		this.boutonAjouterActif = boutonAjouterActif;
	}

}
