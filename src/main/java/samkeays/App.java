package samkeays;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

public class App
{
    public static void main( String[] args ) throws Exception {
        Server server = new Server(8080);

        server.setHandler(getJerseyHandler());

        server.start();
        server.join();
    }

    private static Handler getJerseyHandler() {
        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        handler.setContextPath("/");

        handler.addServlet(new ServletHolder(new ServletContainer(resourceConfig())), "/api/v1/*");
        return handler;
    }

    private static ResourceConfig resourceConfig() {
        BayesInterface bayesInterface = new BayesInterface();
        return new ResourceConfig().register(new PredictorEndpoint(bayesInterface));
    }
}
