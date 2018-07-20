package pt.noshio.nettyrest;

import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.glassfish.jersey.netty.httpserver.NettyHttpContainerProvider;
import org.glassfish.jersey.server.ResourceConfig;
import org.jboss.weld.environment.se.Weld;

import io.netty.channel.Channel;

public class Server {

	public void start(URI uri) {

		Weld weld = new Weld();
		weld.initialize(); // The weld container will be initialized

		RestApplication restApplication = new RestApplication();
		ResourceConfig resourceConfig = new ResourceConfig(restApplication);

		try {
			final Channel server = NettyHttpContainerProvider.createHttp2Server(uri, resourceConfig, null);

			Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

				public void run() {
					server.close();
					weld.shutdown();
				}
			}));

			System.out.println(String.format("Application started. (HTTP/2 enabled!)\nTerminate with " + "CTRL+C."));
			Thread.currentThread().join();
		} catch (InterruptedException ex) {
			Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
}
