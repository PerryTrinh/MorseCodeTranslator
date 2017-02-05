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
            return english.equals(str) || morse.equals(str);
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
        characters[0] = new Node("a", ".-"); characters[1] = new Node("b", "-...");
        characters[2] = new Node("c", "-.-."); characters[3] = new Node("d", "-..");
        characters[4] = new Node("e", "."); characters[5] = new Node("f", "..-.");
        characters[6] = new Node("g", "--."); characters[7] = new Node("h", "....");
        characters[8] = new Node("i", ".."); characters[9] = new Node("j", ".---");
        characters[10] = new Node("k", "-.-"); characters[11] = new Node("l", ".-..");
        characters[12] = new Node("m", "--"); characters[13] = new Node("n", "-.");
        characters[14] = new Node("o", "---"); characters[15] = new Node("p", ".--.");
        characters[16] = new Node("q", "--.-"); characters[17] = new Node("r", ".-.");
        characters[18] = new Node("s", "..."); characters[19] = new Node("t", "-");
        characters[20] = new Node("u", "..-"); characters[21] = new Node("v", "...-");
        characters[22] = new Node("w", ".--"); characters[23] = new Node("x", "-..-");
        characters[24] = new Node("y", "-.--"); characters[25] = new Node("z", "--..");
        characters[26] = new Node("1", ".----"); characters[27] = new Node("2", "..---");
        characters[28] = new Node("3", "...--"); characters[29] = new Node("4", "....-");
        characters[30] = new Node("5", "....."); characters[31] = new Node("6", "-....");
        characters[32] = new Node("7", "--..."); characters[33] = new Node("8", "---..");
        characters[34] = new Node("9", "----."); characters[35] = new Node("0", "-----");
    }

    public String find(String str, String language) {
        for (int n = 0; n < characters.length; n++) {
            if (characters[n].contains(str)) {
                return characters[n].toLanguage(language);
            }
        }
        return "Character Not Found";
    }
}
