
public class Texthopsen {
    public static void hopseText(char[] extractedLetters){

        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_BLUE = "\u001B[34m";
        String ANSI_PURPLE = "\u001B[35m";

        Converter converter = new Converter();
        int[] extractedNumbers = converter.lettersToNumbers(extractedLetters);

        Hopser hopser = new Hopser();

        int win = hopser.hopsen(0, 1, extractedNumbers);

        System.out.println("--------------------------------------------------------------------------------------------------------------------");

        for (int i = 0; i < extractedNumbers.length; i++){
            System.out.print(extractedNumbers[i]);
        }
        System.out.println();

        System.out.println("--------------------------------------------------------------------------------------------------------------------");

        int posi1 = 0;
        int posi2 = 0;
        for (int i = 0; i < extractedLetters.length; i++) {
            boolean pos1InRange = (posi1 < hopser.pos1.size());
            boolean pos2InRange = (posi2 < hopser.pos2.size());

            if (pos1InRange && pos2InRange && hopser.pos1.get(posi1) == i && hopser.pos2.get(posi2) == i) {
                System.out.print(ANSI_PURPLE + extractedLetters[i] + ANSI_RESET);
                if (posi1 < hopser.pos1.size()) posi1++;
                if (posi2 < hopser.pos2.size()) posi2++;
            } else if (pos1InRange && hopser.pos1.get(posi1) == i) {
                System.out.print(ANSI_RED + extractedLetters[i] + ANSI_RESET);
                if (posi1 < hopser.pos1.size()) posi1++;
            } else if (pos2InRange && hopser.pos2.get(posi2) == i) {
                System.out.print(ANSI_BLUE + extractedLetters[i] + ANSI_RESET);
                if (posi2 < hopser.pos2.size()) posi2++;
            } else {
                System.out.print(extractedLetters[i]);
            }
        }
        System.out.println();

        System.out.println("--------------------------------------------------------------------------------------------------------------------");

        System.out.println("Der Text ist " + extractedNumbers.length + " Buchstaben lang.");

        if (win == 1){
            System.out.println("Bella(1) hat mit " + hopser.nededjumps1 + " Schprüngen gewonnen.");
            System.out.println("Amira(2) war auf Position " + (hopser.currendPos2+1) );
            System.out.println("Bella(1) war auf Position " + (hopser.currendPos1+1) );
        } else if (win == 2){
            System.out.println("Amira(2) hat mit " + hopser.nededjumps2 + " Schprüngen gewonnen.");
            System.out.println("Bella(1) war auf Position " + (hopser.currendPos1+1) );
            System.out.println("Amira(2) war auf Position " + (hopser.currendPos2+1) );
        }
    }
}
