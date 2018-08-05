package pt.noshio.nettyrest;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

public class RestApplication extends ResourceConfig {
	public RestApplication() {
		// classes in this package will be scanned
		// for resources (endpoints)
		packages("pt.noshio.endpoints");
		property(ServerProperties.TRACING, "ALL");
	}

}
