package chatbot;

import java.util.Random;

public class ResponseGenerator {

    String[] jokes = {
            "Why do programmers hate nature? Too many bugs.",
            "Why did the computer get cold? It forgot to close Windows.",
            "Why do Java developers wear glasses? Because they don't see sharp 😄",
            "Why was the computer tired? It had too many tabs open.",
            "Debugging: Removing the needles from the haystack."
    };

    public String getResponse(String intent) {

        switch (intent) {
            case "greeting":
                return "Hello! How can I help you?";

            case "ask_name":
                return "I am your Java NLP chatbot.";

            case "help":
                return "I can chat, tell jokes, and answer simple questions.";

            case "joke":
                return getRandomJoke();

            default:
                return "Can you please clarify?";
        }
    }

    private String getRandomJoke() {
        Random rand = new Random();
        return jokes[rand.nextInt(jokes.length)];
    }
}