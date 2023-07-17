import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String string = "The Tao gave birth to machine language.  Machine language gave birth\n" +
                "to the assembler.\n" +
                "The assembler gave birth to the compiler.  Now there are ten thousand\n" +
                "languages.\n" +
                "Each language has its purpose, however humble.  Each language\n" +
                "expresses the Yin and Yang of software.  Each language has its place within\n" +
                "the Tao.\n" +
                "But do not program in COBOL if you can avoid it.\n" +
                "        -- Geoffrey James, \"The Tao of Programming\"";
        System.out.println(findUniqueChar(string));
    }
    static public Character findUniqueChar(String str) {
        String[] words = str.split("\\s+");
        StringBuilder uniqueChar = new StringBuilder();

        for (String word : words) {
            char nonRepeatedChar = findFirstNonRepeatedChar(word);
            uniqueChar.append(nonRepeatedChar);
        }
        return findFirstNonRepeatedChar(String.valueOf(uniqueChar));
    }
    static public char findFirstNonRepeatedChar(String word) {
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char c : word.toCharArray()) {
            charFrequencyMap.put(c, charFrequencyMap.getOrDefault(c, 0) + 1);
        }
        for (char c : word.toCharArray()) {
            if (charFrequencyMap.get(c) == 1) {
                return c;
            }
        }
        return ' ';
    }
}
