import java.util.Scanner;

public class Hopsitexte {
    public static void main(String[] args) {

        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_BLUE = "\u001B[34m";
        
        Scanner scanner = new Scanner(System.in);

        Texthopsen texthopsen = new Texthopsen();

        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        System.out.println(ANSI_YELLOW + "Willkommen zum Hopsitext Editor 3000!" + ANSI_RESET);
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        System.out.println("Mit diesem Programm kannst du ganz einfach einen Hopsitext erstellen.");
        System.out.println("Ein Hopsitext ist ein spezieller Text, bei dem sichergestellt wird, dass die Spieler beim Texthopsen nie auf derselben Stelle landen.");
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        System.out.println("So funktioniert es:");
        System.out.println("- Beginne, indem du das erste Wort oder den ersten Satzteil in die Eingabezeile schreibst.");
        System.out.println("- Der Editor zeigt dir dann die Positionen an, die beim Texthopsen relevant sind.");
        System.out.println("- Schreibe deinen Text weiter, bis du zu einer markierten Position gelangst.");
        System.out.println("- Wenn ein Konflikt auftritt (beide Spieler landen an derselben Stelle), wirst du benachrichtigt und kannst den letzten Schritt korrigieren.");
        System.out.println("- Du kannst jederzeit den letzten Schritt mit 'back' rückgängig machen.");
        System.out.println("- Um deinen Hopsitext fertigzustellen, gib 'end' ein.");
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        System.out.println("Starte jetzt mit deinem ersten Wort oder Satzteil:");
        String aktuelleEingabe = scanner.nextLine();


        String lastText = "";
        String text = aktuelleEingabe;
        while (!aktuelleEingabe.equals("end")) {
            Hopser h = texthopsen.hopseText(text);

            if (h.currendPos1 == h.currendPos2 || texthopsen.selbesFeld){
                System.out.println("Bitte verwende ein anderes Wort da dein Text sonst kein Hopsitext sein kann.");
                text = lastText;
            } else{

                for (int i = texthopsen.extractedLetters.length; i <= Math.max(h.currendPos1+1, h.currendPos2+1); i++){
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

                if (aktuelleEingabe.equals("back")){
                    text = lastText;
                } else{
                    lastText = text;
                    text = text + aktuelleEingabe;

                }
            }
        }
        scanner.close();
    }
}
