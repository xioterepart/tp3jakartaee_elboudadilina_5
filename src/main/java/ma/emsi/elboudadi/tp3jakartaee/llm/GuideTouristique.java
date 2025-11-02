package ma.emsi.elboudadi.tp3jakartaee.llm;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;

public interface GuideTouristique {
    @SystemMessage("Tu es un guide touristique. Donne les 2 principaux endroits à visiter dans le lieu demandé, " +
            "et le prix moyen d’un repas. Réponds au format JSON EXACT suivant, sans utiliser Markdown :" +
            " { \"ville_ou_pays\":\"nom du lieu\", \"endroits_a_visiter\": [\"endroit1\", \"endroit2\"], \"prix_moyen_repas\": \"<prix> <devise>\" }")

        @UserMessage("Lieu : {lieu}")
        String getInfosTouristiques(String lieu);
    }
