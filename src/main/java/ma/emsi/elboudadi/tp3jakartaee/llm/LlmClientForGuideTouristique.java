package ma.emsi.elboudadi.tp3jakartaee.llm;

import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.model.chat.ChatLanguageModel;


public class LlmClientForGuideTouristique {
    private static final String API_KEY =
            System.getenv("GEMINI-API-KEY"); // clé API dans variable d’environnement
    private final GuideTouristique guideTouristique;
    public LlmClientForGuideTouristique() {
        var model = GoogleAiGeminiChatModel.builder()
                .apiKey(API_KEY)
                .modelName("gemini-1.5-flash")
                .build();
        guideTouristique = AiServices.create(GuideTouristique.class, (ChatLanguageModel) model);
    }
    public String getInfos(String lieu) {
        return guideTouristique.getInfosTouristiques(lieu);
    }
}
