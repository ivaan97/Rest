import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.ws.rs.*;


@Path("SocialNetwork")
public class Hallo {
	
	
	@Path("get")
	@GET
	@Produces("text/plain")
	public String sayHello(){
		return "Hello";
	}
	
	

	@GET
	@Path("functions")
	public String functions(){
		return "- Benutzer ausgeben: <user/[username]> \n"
				+ "- Freunde ausgeben: <user/[username]/friends> \n"
				+ "- Status ausgeben: <user/[username]/status> \n" 
				+ "- Per post senden: <post>";
	}
	
	
	@GET
	@Path("user/{user}")
	public String message(@PathParam("user") String user)
	{
		return String.format( "Hallo %s", user);
	}
	
	@GET
	@Path("user/{user}/friends")
	public String message2(@PathParam("user") String user)
	{	
		return String.format( "Hallo %s, deine Freunde sind: Hannes, Maxi, Tobi, Mircus", user);
	}
	
	@GET
	@Path("user/{user}/status")
	public String message3(@PathParam("user") String user)
	{	
		return String.format( "Status von %s: Hallo das ist dein Status", user);
	}
	
	@POST
	@Path("post")
	public String message3()
	{	
		return String.format("Das ist post");
	}
	
	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public String postUser(@Context Request request, String user)
	{	
		return "user " + user + "added";
	}
	
	
	@Path("readUser")
	@GET
	@Produces("text/plain")
	
	public String getUser(){
	
    FileReader reader = null;
    
	try {
		
		reader = new FileReader("src/User.txt");
			
		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		}
		
	    BufferedReader br = new BufferedReader(reader);

	    String zeile1 = null;
	    
		try {
			
			zeile1 = br.readLine();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	     try {
	    	 
			br.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	     
	     return zeile1;
}
	
}
