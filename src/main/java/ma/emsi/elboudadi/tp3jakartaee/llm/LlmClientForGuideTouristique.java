package ma.emsi.elboudadi.tp3jakartaee.llm;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.service.AiServices;

public class LlmClientForGuideTouristique {

    private static final String API_KEY = System.getenv("GEMINI-API-KEY"); // ✅ must match environment variable
    private final GuideTouristique guideTouristique;

    public LlmClientForGuideTouristique() {
        ChatModel model = GoogleAiGeminiChatModel.builder()
                .apiKey(API_KEY)
                .modelName("gemini-2.5-flash")
                .temperature(0.5)
                .build();

        guideTouristique = AiServices.create(GuideTouristique.class, (ChatModel) model);
    }

    public String getInfos(String lieu) {
        return guideTouristique.getInfosTouristiques(lieu);
    }
}
