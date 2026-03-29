package chatbot;

import edu.stanford.nlp.pipeline.*;
import java.util.*;

public class NLPProcessor {
    private StanfordCoreNLP pipeline;

    public NLPProcessor() {
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize,ssplit,pos,lemma");
        pipeline = new StanfordCoreNLP(props);
    }

    public String process(String text) {
        CoreDocument doc = new CoreDocument(text);
        pipeline.annotate(doc);

        StringBuilder result = new StringBuilder();
        doc.tokens().forEach(token ->
                result.append(token.lemma()).append(" ")
        );

        return result.toString().trim();
    }
}