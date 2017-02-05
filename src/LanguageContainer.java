/**
 * Created by Perry on 2/4/2017.
 */
public class LanguageContainer {
    private class Node {
        public String english;
        public String morse;

        public Node(String english, String morse) {
            this.english = english;
            this.morse = morse;
        }

        public boolean contains(String str) {
            return english.equalsIgnoreCase(str) || morse.equals(str);
        }

        public String toLanguage(String language) {
            switch (language) {
                case "english":
                    return english;
                case "morse":
                    return morse;
                default:
                    return "Invalid language";
            }
        }
    }

    private Node[] characters;

    public LanguageContainer() {
        characters = new Node[37];
        characters[0] = new Node("A", ".-"); characters[1] = new Node("B", "-...");
        characters[2] = new Node("C", "-.-."); characters[3] = new Node("D", "-..");
        characters[4] = new Node("E", "."); characters[5] = new Node("F", "..-.");
        characters[6] = new Node("G", "--."); characters[7] = new Node("H", "....");
        characters[8] = new Node("I", ".."); characters[9] = new Node("J", ".---");
        characters[10] = new Node("K", "-.-"); characters[11] = new Node("L", ".-..");
        characters[12] = new Node("M", "--"); characters[13] = new Node("N", "-.");
        characters[14] = new Node("O", "---"); characters[15] = new Node("P", ".--.");
        characters[16] = new Node("Q", "--.-"); characters[17] = new Node("R", ".-.");
        characters[18] = new Node("S", "..."); characters[19] = new Node("T", "-");
        characters[20] = new Node("U", "..-"); characters[21] = new Node("V", "...-");
        characters[22] = new Node("W", ".--"); characters[23] = new Node("X", "-..-");
        characters[24] = new Node("Y", "-.--"); characters[25] = new Node("Z", "--..");
        characters[26] = new Node("1", ".----"); characters[27] = new Node("2", "..---");
        characters[28] = new Node("3", "...--"); characters[29] = new Node("4", "....-");
        characters[30] = new Node("5", "....."); characters[31] = new Node("6", "-....");
        characters[32] = new Node("7", "--..."); characters[33] = new Node("8", "---..");
        characters[34] = new Node("9", "----."); characters[35] = new Node("0", "-----");
    }

    public String find(String str, String language) {
        for (Node n: characters) {
            if (n.contains(str)) {
                return n.toLanguage(language);
            }
        }
        return "Character Not Found";
    }
}
