import java.util.Scanner;

public class Hopsitexte {
    public static void main(String[] args) {

        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_BLUE = "\u001B[34m";
        
        Scanner scanner = new Scanner(System.in);

        Texthopsen texthopsen = new Texthopsen();

        System.out.println(ANSI_YELLOW + "Hopsitext editor 3000" + ANSI_RESET);
        System.out.println("um einen Hopsitext zu schreiben beginne in der folgenden Zeile mit deinem ersten Wort: ");
        String aktuelleEingabe = scanner.nextLine();
        System.out.println("um mit der Erstellung eines Hopsitextes zu helfen kannst du nun immer einen Teil des volgenden Satzes schreiben bis du zum nachsten Buhstaben gelangst über den einer der Teilnehmer springt.");
        System.out.println("Wenn du deien Text beenden willst schreibe einfach 'end' in die Eingabe.");

        String lastText = "";
        String text = aktuelleEingabe;
        while (!aktuelleEingabe.equals("end")) {
            Hopser h = texthopsen.hopseText(text);

            if (h.currendPos1 == h.currendPos2){
                System.out.println("Bitte verwende ein anderes Wort da dein Text sonst kein Hopsitext sein kann.");
                text = lastText;
            } else{

                int x = 0;
                if (h.currendPos1 > h.currendPos2){
                    x = h.currendPos1+1;
                } else {
                    x = h.currendPos2+1;
                }

                for (int i = texthopsen.extractedLetters.length; i <= x; i++){
                    if(i == h.currendPos1){
                        System.out.print(ANSI_RED + "0" + ANSI_RESET);
                    }else if(i == h.currendPos2){
                        System.out.print(ANSI_BLUE + "0" + ANSI_RESET);
                    } else{
                        System.out.print("0");
                    }
                }
                System.out.println();

                aktuelleEingabe = scanner.nextLine();
                lastText = text;
                text = text + aktuelleEingabe;

            }
        }

        
        scanner.close();
    }
}
