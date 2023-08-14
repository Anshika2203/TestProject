import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

public class MainApplication {
    public static void main(String[] args) {
        URI baseUri = URI.create("http://localhost:8080/");
        ResourceConfig config = new ResourceConfig().packages("UserDetails.api");
        JdkHttpServerFactory.createHttpServer(baseUri, config);

        System.out.println("Server started at " + baseUri);
    }
}
