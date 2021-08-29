package fr.doranco.ecommerce.ws.rest.services;

import java.net.URISyntaxException;

import javax.ws.rs.core.Response;

import fr.doranco.ecommerce.entity.User;



public interface IUserResource {
	 String getInfos() ;
	Response getUserByEmail(String email) throws URISyntaxException;
	Response getUsers() throws URISyntaxException;
	Response addUser(User user) throws URISyntaxException;
	Response updateUser(User user) throws URISyntaxException;
	Response removeUser(User user) throws URISyntaxException;
}
