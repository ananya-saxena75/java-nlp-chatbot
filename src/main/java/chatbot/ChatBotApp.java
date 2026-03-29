package chatbot;

import java.util.Scanner;

public class ChatBotApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        NLPProcessor nlp = new NLPProcessor();
        IntentClassifier classifier = new IntentClassifier();
        ResponseGenerator generator = new ResponseGenerator();

        System.out.println("🤖 Chatbot started! Type 'exit' to quit.");

        // 🧠 STEP 1: Add this line
        String lastIntent = "";

        while (true) {
            System.out.print("You: ");
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("exit"))
                break;

            String processed = nlp.process(input);
            String intent = classifier.detectIntent(processed);

            // 🧠 STEP 2: Add context logic here
            if (intent.equals("unknown")) {
                intent = lastIntent;
            }

            String response = generator.getResponse(intent);

            System.out.println("Bot: " + response);

            // 🧠 STEP 3: Update last intent
            lastIntent = intent;
        }

        sc.close();
    }
}