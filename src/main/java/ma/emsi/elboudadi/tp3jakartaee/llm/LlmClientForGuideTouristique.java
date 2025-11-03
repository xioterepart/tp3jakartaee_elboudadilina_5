package ma.emsi.elboudadi.tp3jakartaee.llm;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.service.AiServices;

public class LlmClientForGuideTouristique {

    // ✅ The API key is read from the environment variable "GEMINI-API-KEY"
    private static final String API_KEY = System.getenv("GEMINI-API-KEY");

    private final GuideTouristique guideTouristique;

    public LlmClientForGuideTouristique() {
        ChatModel model = GoogleAiGeminiChatModel.builder()
                .apiKey(API_KEY)
                .modelName("gemini-2.5-flash")
                .temperature(0.5)
                .build();

        guideTouristique = AiServices.create(GuideTouristique.class, model);
    }

    /**
     * Returns a JSON-formatted response containing the main places to visit and meal prices.
     *
     * @param lieu the city or country to get tourist information for
     * @param nb   the number of places to list
     * @return a JSON string with tourist info
     */
    public String getInfosAvecNombre(String lieu, int nb) {
        String prompt = "Tu es un guide touristique. Donne les " + nb +
                " principaux endroits à visiter dans le lieu demandé, et le prix moyen d’un repas. " +
                "Réponds au format JSON EXACT suivant, sans utiliser Markdown : " +
                "{ \"ville_ou_pays\": \"nom du lieu\", " +
                "\"endroits_a_visiter\": [\"endroit1\", ...], " +
                "\"prix_moyen_repas\": \"<prix> <devise>\" }";

        return guideTouristique.getInfosTouristiques(
                lieu + "\nInstruction: " + prompt
        );
    }

    /**
     * Returns general tourist information for a given place.
     *
     * @param lieu the city or country to get information about
     * @return a string response from the AI model
     */
    public String getInfos(String lieu) {
        return guideTouristique.getInfosTouristiques(lieu);
    }
}
