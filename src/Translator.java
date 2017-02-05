/**
 * Created by Perry on 2/4/2017.
 */
public class Translator {
    private LanguageContainer charContainer;
    private String wordSeparator;

    public Translator() {
        charContainer = new LanguageContainer();
        wordSeparator = "/";
    }

    /** Converts str into the language given and returns translated string
     * @param language either "morse" or "english"
     * @param str valid string, either in morse or english
     * @return string that is translated to language
     */
    public String translate(String str, String language) {
        //parses str into a readable format
        String[] characters = characters(str, language);
        String translated = "";

        for (int i = 0; i < characters.length; i++) {
            String character = characters[i];
            //Currently have morse
            if (language.equals("english")) {
                if (character.equals(wordSeparator)) {
                    translated += " ";
                } else {
                    translated += charContainer.find(character, language);
                }
            } else { //Currently have english
                if (character.equals(wordSeparator)) {
                     translated += wordSeparator;
                } else {
                    translated += charContainer.find(character, language) + " ";
                }
            }
        }
        return translated;
    }

    /**
     * Turns str into a readable format
     * Returns array where each element is a character of its language
     * and words are separated with wordSeparator
     */
    private String[] characters(String str, String language){
        //Currently have english
        if (language.equals("morse")) {
            String splitStr = "";
            for (int i = 0; i < str.length(); i++) {
                String substring = str.substring(i, i+1);
                if (substring.equals(" ")) {
                    splitStr += wordSeparator;
                } else {
                    splitStr += substring;
                }
            }
            return splitStr.split("");
        } else { //Currently have morse
            String[] words = str.split("/");
            String cutWords = "";

            for (String i: words) {
                cutWords += i + wordSeparator;
            }

            String delims = "[ /]+";
            return cutWords.split(delims);
        }
    }
}
