
public class Texthopsen {
    public char[] extractedLetters;
    public Hopser hopseText(String text){

        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_BLUE = "\u001B[34m";
        String ANSI_PURPLE = "\u001B[35m";

        Converter converter = new Converter();
        extractedLetters = converter.textToLetters(text);
        int[] extractedNumbers = converter.lettersToNumbers(extractedLetters);

        Hopser hopser = new Hopser();

        int win = hopser.hopsen(0, 1, extractedNumbers);

       
        System.out.println("--------------------------------------------------------------------------------------------------------------------");

        int posi1 = 0;
        int posi2 = 0;
        int irelewanteZeichen = 0;
        for (int i = 0; i < text.length(); i++) {
            if (!Character.isLetter(text.charAt(i))){
                System.out.print(text.charAt(i));
                irelewanteZeichen++;
            } else{
                boolean pos1InRange = (posi1 < hopser.pos1.size());
                boolean pos2InRange = (posi2 < hopser.pos2.size());

                if (pos1InRange && pos2InRange && hopser.pos1.get(posi1) == i-irelewanteZeichen && hopser.pos2.get(posi2) == i-irelewanteZeichen) {
                    System.out.print(ANSI_PURPLE + text.charAt(i) + ANSI_RESET);
                    if (posi1 < hopser.pos1.size()) posi1++;
                    if (posi2 < hopser.pos2.size()) posi2++;
                } else if (pos1InRange && hopser.pos1.get(posi1) == i-irelewanteZeichen) {
                    System.out.print(ANSI_RED + text.charAt(i) + ANSI_RESET);
                    if (posi1 < hopser.pos1.size()) posi1++;
                } else if (pos2InRange && hopser.pos2.get(posi2) == i-irelewanteZeichen) {
                    System.out.print(ANSI_BLUE + text.charAt(i) + ANSI_RESET);
                    if (posi2 < hopser.pos2.size()) posi2++;
                } else {
                    System.out.print(text.charAt(i));
                }
            }
        }
        System.out.println();

        System.out.println("--------------------------------------------------------------------------------------------------------------------");

        return hopser;
    }
}
