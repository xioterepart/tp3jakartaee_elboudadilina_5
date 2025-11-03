package ma.emsi.elboudadi.tp3jakartaee.filters;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;
import java.io.IOException;

// L'annotation @Provider indique à JAX-RS de découvrir et d'utiliser cette classe.
@Provider
public class CorsFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext,
                       ContainerResponseContext responseContext) throws IOException {

        // **Ajouter le support CORS** pour autoriser toutes les origines (*)
        responseContext.getHeaders().add(
                "Access-Control-Allow-Origin",
                "*"
        );

        // Ajouter les méthodes HTTP autorisées pour les requêtes (surtout pour les pre-flight OPTIONS)
        responseContext.getHeaders().add(
                "Access-Control-Allow-Methods",
                "GET, POST, PUT, DELETE, OPTIONS, HEAD"
        );

        // Autoriser les entêtes personnalisées
        responseContext.getHeaders().add(
                "Access-Control-Allow-Headers",
                "origin, content-type, accept, authorization"
        );

        // Ajouter les entêtes de contrôle du cache (facultatif, mais recommandé pour le développement)
        responseContext.getHeaders().add("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0");
        responseContext.getHeaders().add("Pragma", "no-cache");
        responseContext.getHeaders().add("Expires", "0");
    }
}