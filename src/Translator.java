/**
 * Created by Perry on 2/4/2017.
 */
public class Translator {
    private LanguageContainer charContainer;
    private String wordSeparator;
    private String charSeparator;

    public Translator() {
        charContainer = new LanguageContainer();
        wordSeparator = "/";
        charSeparator = "_";
    }

    /** Converts str into the language given and returns translated string
     * @param language valid language implemented in LanguageContainer
     * @param str valid string with english characters
     * @return string that is translated in language
     */
    public String translate(String str, String language) {
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
                     translated += "/";
                } else {
                    translated += charContainer.find(character, language) + " ";
                }
            }
        }
        return translated;
    }

    private String[] characters(String str, String language){
        //Currently have english
        if (language.equals("morse")) {
            str = str.toLowerCase();
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
                cutWords += i + "/";
            }

            String delims = "[ /]+";
            return cutWords.split(delims);
        }
    }
}
