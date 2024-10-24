public class Converter{

    public char[] textToLetters(String text) {
        String cleanText = text.toLowerCase().replaceAll("[^a-zäöüß]", "");

        char[] letters = new char[cleanText.length()];
        for(int i = 0; i < letters.length; i++) {
            letters[i] = cleanText.charAt(i);
        }

        return letters;
    }
}