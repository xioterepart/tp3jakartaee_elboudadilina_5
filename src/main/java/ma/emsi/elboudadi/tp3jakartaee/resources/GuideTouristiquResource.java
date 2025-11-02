package ma.emsi.elboudadi.tp3jakartaee.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
@Path("/guide")
public class GuideTouristiquResource {

    @GET
    @Path("lieu/{ville_ou_pays}")
    @Produces(MediaType.APPLICATION_JSON)
    public String villeOuPays(@PathParam("ville_ou_pays") String lieu) {
// pour commencer, renvoyez simplement la valeur du paramètre
        return "\"" + lieu + "\""; // renvoie une string JSON-like (unsimple chaîne)
    }
}