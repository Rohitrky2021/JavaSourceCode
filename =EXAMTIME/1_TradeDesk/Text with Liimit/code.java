import java.util.ArrayList;
import java.util.List;

public class code {

    public static List<String> splitTextToSMS(String text, int limit) {
        List<String> messages = new ArrayList<>();

        int totalLength = text.length();
        int messagesCount = (int) Math.ceil((double) totalLength / (limit - 7)); // 7 for the length of "<X/Y>"

        for (int i = 1; i <= messagesCount; i++) {
            int startIndex = (i - 1) * (limit - 7);
            int endIndex = Math.min(i * (limit - 7), totalLength);
            String messagePart = text.substring(startIndex, endIndex);
            String smsMessage = messagePart + "<" + i + "/" + messagesCount + ">";
            messages.add(smsMessage);
        }

        return messages;
    }

    public static void main(String[] args) {
        String inputText = "Your input text goes here. Replace this with the actual text you want to send as SMS.";
        int smsLimit = 20; // Adjust this according to the SMS character limit

        List<String> smsMessages = splitTextToSMS(inputText, smsLimit);

        // Printing the resulting SMS messages
        for (String message : smsMessages) {
            System.out.println(message);
        }
    }
}
