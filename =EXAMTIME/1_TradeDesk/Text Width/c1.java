import java.util.ArrayList;
import java.util.List;

public class c1 {

    public static List<String> createSentenceRectangle(List<String> sentences, int sentenceWidth) {
        List<String> result = new ArrayList<>();
        result.add("*".repeat(sentenceWidth + 2));

        for (String input : sentences) {
            String[] sentencesArray = input.split("(?<=[.!?])");

            for (String sentence : sentencesArray) {

                String[] words = sentence.split("\\s+");
                String line = "  ";
                int i = 0;
                for (String word : words) {

                    if (line.length() + word.length() + (line.isEmpty() ? 0 : 1) > sentenceWidth) {
                        // Start a new line when the width is exhausted
                        line += " ".repeat(sentenceWidth - line.length());

                        result.add("*" + line + "*");
                        line = "";
                    }

                    if (!line.isEmpty() && i != 0 && i!=1) {
                        line += " ";
                    }

                    line += word;
                    i++;
                }

                if (!line.isEmpty()) {
                    // Fill the remaining spaces at the end of the line
                    if (sentenceWidth - line.length() > 2)
                        line += " ".repeat(sentenceWidth - line.length() - 1);
                    else
                        line += " ".repeat(sentenceWidth - line.length());

                    result.add("*" + line + " *");
                }
            }
        }

        result.add("*".repeat(sentenceWidth + 2));
        return result;
    }

    public static void main(String[] args) {
        List<String> sentences = List
                .of("Hi! This is the article you have to format properly. Could you do that for me, please?");
        int sentenceWidth = 16;

        List<String> rectangle = createSentenceRectangle(sentences, sentenceWidth);

        for (String line : rectangle) {
            System.out.println(line);
        }
    }
}
