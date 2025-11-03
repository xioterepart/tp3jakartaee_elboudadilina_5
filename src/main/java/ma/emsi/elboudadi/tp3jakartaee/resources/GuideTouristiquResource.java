package ma.emsi.elboudadi.tp3jakartaee.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import ma.emsi.elboudadi.tp3jakartaee.llm.GuideTouristique;
import jakarta.inject.Inject; // <-- Import is correct

@Path("/guide")
public class GuideTouristiquResource {
    @Inject // <-- CDI injects an instance of LlmClientForGuideTouristique here
    private GuideTouristique client; // <-- 'client' is declared with the correct interface type
    // In GuideTouristiquResource.java
    @GET
    @Path("/lieu/{ville_ou_pays}/{nombre}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String getGuide(
            @PathParam("ville_ou_pays") String ville_ou_pays,
            @PathParam("nombre") int nombre // <-- Receives the number from the URL
    ) {
        // Passes the number to the LangChain4j client implementation
        return client.ask(ville_ou_pays,nombre);
    }
}