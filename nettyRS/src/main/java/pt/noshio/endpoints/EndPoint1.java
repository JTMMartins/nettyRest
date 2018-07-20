package pt.noshio.endpoints;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pt.noshio.injectables.Injectable1;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/test")
public class EndPoint1 {

	@Inject
	Injectable1 Injectable1;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sendSomeResponse() {
		Injectable1.setJustAString("setting the string in the injected bean");
		return Injectable1.getJustAString();
	}

}
