package pt.noshio.nettyrest;

import java.net.URI;

/**
 * Demonstration project for netty http2 server -JAX-RS -CDI with Java SE
 */

public class App {

	private static final URI BASE_URI = URI.create("http://localhost:8080/");

	public static void main(String args[]) {

		start();

	}

	private static void start() {
		Server server = new Server();
		server.start(BASE_URI);
	}
}
