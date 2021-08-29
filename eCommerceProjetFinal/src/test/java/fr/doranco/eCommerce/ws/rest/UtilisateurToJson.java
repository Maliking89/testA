package fr.doranco.eCommerce.ws.rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.logging.LoggingFeature;

import fr.doranco.ecommerce.entity.User;

public class UtilisateurToJson {

	public static void main(String[] args) {

		Client client = ClientBuilder.newClient(new ClientConfig().register(LoggingFeature.class));
		WebTarget webTarget = client.target("http://localhost:8080/eCommerce/rest/users/user/amusta87@yahoo.fr");
		
		Builder builder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = builder.get();
		//Status 200 is successful
				if(response.getStatus() == 200) {
					User user = (User) response.readEntity(User.class);
					System.out.println("code status : " + response.getStatus() + " (OK)");
					System.out.println("Output from Server ....");
					System.out.println(user);
				} else {
					System.out.println("Failed with HTTP Error code: " + response.getStatus());
					System.out.println(response.getStatusInfo());
					String output = (String) response.readEntity(String.class);
					System.out.println(output);
		
	   
		

			}

	}

}
