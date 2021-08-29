package fr.doranco.ecommerce.ws.rest.services;

import java.net.URISyntaxException;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import fr.doranco.ecommerce.entity.User;
import fr.doranco.ecommerce.metier.IUserMetier;
import fr.doranco.ecommerce.metier.UserMetier;




@Path("users")
//@Produces(MediaType.TEXT_PLAIN)
public class UserResource implements IUserResource {

	private final IUserMetier userMetier = new UserMetier();

	@GET
	public String getInfos() {
		return "Hello from eCommerce";
	}
	
	@Override
	@Path("user/{email}")
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response getUserByEmail(@PathParam("email") String email) throws URISyntaxException {
		if (email == null || email.isEmpty()) {
			return Response.status(Status.BAD_REQUEST).entity("L'email dans l'url est incorrect !").build();
		}
		try {
			User user = userMetier.getUserByEmail(email);
			if (user == null) {
				return Response.status(Status.NOT_FOUND).entity("Cet utilisateur n'existe pas !").build();
			}
			return Response.ok().entity(user).build();
		} catch (Exception e) {
			return Response.serverError()
					.entity("Erreur interne au serveur ! Veuillez réessayer plus tard.\n" + e.getMessage())
					.build();
		}
	}

	@Override
	@GET
	@Path("all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers() throws URISyntaxException {
		try {
			// appel à la couche métier
			 List<User> listeUsers = userMetier.getUsers();
			
			 if (listeUsers == null || listeUsers.isEmpty()) {
					return Response.status(Status.BAD_REQUEST).entity("La List des utilisateur est vide").build();
				}

			GenericEntity<List<User>> users = new GenericEntity<List<User>>(listeUsers) {};
			
			return Response.ok().entity(users).build();
		} catch (Exception e) {
			return Response.serverError()
					.entity("Erreur interne au serveur ! Veuillez réessayer plus tard.\n" + e.getMessage())
					.build();
		}
	}

	@Override
	@POST
	@Path("add")
	@Consumes( MediaType.APPLICATION_JSON)
	@Produces( MediaType.APPLICATION_JSON)
	public Response addUser(User user) throws URISyntaxException {

		if (user == null) {
			return Response.status(Status.NOT_FOUND).entity("Impossible d'ajouter l'utilisateur est null ").build();
		}

		try {
			// appel à la couche métie
			
			userMetier.addUser(user);

			return Response.ok().entity(user).build();
		} catch (Exception e) {
			return Response.serverError()
					.entity("Erreur interne au serveur ! Veuillez réessayer plus tard.\n" + e.getMessage()).build();
		}
	}

	@Override
	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUser(User user) throws URISyntaxException {
		if (user == null) {
	return Response.status(Status.NOT_FOUND).entity("Impossible d'ajouter l'utilisateur est null ").build();
		}
		try {
			// appel à la couche métier
			 userMetier.update(user);
			//user.setPrenom(user.getPrenom() + " modifié");
			return Response.ok().entity("L'utilisateur " + user.getId() + " a été mis à jour.").build();
		} catch (Exception e) {
			return Response.serverError()
					.entity("Erreur interne au serveur ! Veuillez réessayer plus tard.\n" + e.getMessage())
					.build();
		}
	}

	@Override
	@DELETE
	@Path("remove")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeUser(User user) throws URISyntaxException {
		if (user == null) {
			return Response.status(Status.NOT_FOUND).entity("Impossible de supprimer  l'utilisateur est null ").build();}
		try {
			// appel à la couche métier
			userMetier.remove(user);
			return Response.ok().entity("L'utilisateur \" + user.getId() + \" a été supprimé.").build();
		} catch (Exception e) {
			return Response.serverError()
					.entity("Erreur interne au serveur ! Veuillez réessayer plus tard.\n" + e.getMessage())
					.build();
		}
	}

}
