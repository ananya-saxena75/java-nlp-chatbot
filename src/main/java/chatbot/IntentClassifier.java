package chatbot;

import java.nio.file.*;
import java.util.*;
import org.json.*;

public class IntentClassifier {

    private JSONObject intents;

    public IntentClassifier() {
        try {
            String content = new String(Files.readAllBytes(
                    Paths.get("src/main/resources/intents.json")
            ));
            intents = new JSONObject(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String detectIntent(String input) {

        String[] inputWords = input.split(" ");

        String bestIntent = "unknown";
        int maxScore = 0;

        for (String key : intents.keySet()) {
            JSONArray patterns = intents.getJSONArray(key);

            for (int i = 0; i < patterns.length(); i++) {
                String pattern = patterns.getString(i);
                String[] patternWords = pattern.split(" ");

                int score = 0;

                for (String word : inputWords) {
                    for (String pWord : patternWords) {
                        if (word.equalsIgnoreCase(pWord)) {
                            score++;
                        }
                    }
                }

                if (score > maxScore) {
                    maxScore = score;
                    bestIntent = key;
                }
            }
        }

        return bestIntent;
    }
}