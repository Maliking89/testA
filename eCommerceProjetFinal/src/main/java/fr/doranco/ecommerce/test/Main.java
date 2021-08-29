package fr.doranco.ecommerce.test;

import fr.doranco.ecommerce.entity.User;
import fr.doranco.ecommerce.model.dao.UserDao;
import fr.doranco.ecommerce.utils.Dates;

public class Main {

	public static void main(String[] args) {
		try {
		// TODO Auto-generated method stub
		UserDao utilisateurDao = new UserDao();

		User utilisateur = new User();
		utilisateur.setNom("juba");
		utilisateur.setPrenom("juba");
		utilisateur.setEmail("juba232@yahoo.fr");
		utilisateur.setTelephone("077773");
		//utilisateur.setProfil("admin");
		utilisateur.setDateNaissance(Dates.convertStringToDateUtil("03/09/1985"));
		utilisateur.setGenre("homme");
		utilisateur.setPassword("1223");
		//utilisateur.setIsActif(true);
		
		
		
		utilisateurDao.addUser(utilisateur);
		System.out.println("c bon creation reussite mlehhhhhhhhhhhhhhhhhh");
	}
		catch(Exception e)
		{
			System.out.println(e);
		}
		}

}
