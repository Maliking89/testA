package fr.doranco.ecommerce.vue.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.doranco.ecommerce.entity.Article;
import fr.doranco.ecommerce.entity.Categorie;
import fr.doranco.ecommerce.entity.User;
import fr.doranco.ecommerce.metier.CategorieMetier;
import fr.doranco.ecommerce.metier.ICategorieMetier;
import fr.doranco.ecommerce.utils.Dates;

@ManagedBean(name = "magasinierCategorieBean")
@SessionScoped
public class MagasinierCategorieBean {
	
	private final ICategorieMetier categorieMetier = new CategorieMetier();
	private String messageError;
	
	@ManagedProperty(name = "nom", value = "")
	private String nom;

	
	@ManagedProperty(name = "remise", value = "")
	private String remise;

	@ManagedProperty(name = "photo", value = "")
	private String photo;
	@ManagedProperty(name = "id", value = "")
	private String id;
	
	
	
	
	public MagasinierCategorieBean() {
		
	}

	
	public List<Categorie> getCategories() {
		try {

			return categorieMetier.getCategories();
		} catch (Exception e) {
			messageError = "Erreur technique lors de la récupération de la liste des categories !";
			System.out.println(e);
			return new ArrayList<Categorie>();
		}
		
	}
	public String supprimerCategorie(Categorie categorie) {
		try {
			categorieMetier.remove(categorie);
		} catch (Exception e) {
			messageError = "Erreur technique lors de la suppression de la categorie !";
			System.out.println(e);
		}
		return "";
	}
	
	
	public String modifierCategorie(Categorie categorie) {
		this.id=categorie.getId().toString();
		this.nom = categorie.getNom();
		this.remise = categorie.getRemise().toString();
		this.photo = categorie.getPhoto();
		return"";
	}
	public String updateCategorie() {
		;
		Categorie categorie=null;
		try {
			 
			categorie=categorieMetier.getCategorie(Integer.parseInt(this.id));

			categorie.setNom(this.nom);
			
			categorie.setRemise(Integer.parseInt(this.remise));
		
			categorie.setPhoto(this.photo);
			categorieMetier.update(categorie);
}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return"";
	}
	 public String creerCategorie() {
		Categorie categorie = new Categorie();

			categorie.setNom(nom);
			categorie.setRemise(Integer.parseInt(remise));
			categorie.setPhoto(photo);
			try {
				Categorie addedCategorie =categorieMetier.addCategorie(categorie);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
		 return"";
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

	public String getRemise() {
		return remise;
	}

	public void setRemise(String remise) {
		this.remise = remise;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	
	
	
}
