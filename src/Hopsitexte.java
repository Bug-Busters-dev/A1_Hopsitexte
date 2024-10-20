import java.util.Scanner;

public class Hopsitexte {
    public static void main(String[] args) {

        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_RESET = "\u001B[0m";
        
        Scanner scanner = new Scanner(System.in);

        Texthopsen texthopsen = new Texthopsen();
        
        //String name = scanner.nextLine();

        System.out.println(ANSI_YELLOW + "Hopsitext editor 3000" + ANSI_RESET);
        System.out.println("um einen Hopsitext zu schreiben beginne in der folgenden Zeile mit deinem ersten Wort: ");
        String aktuelleEingabe = scanner.nextLine();
        System.out.println("um mit der Erstellung eines Hopsitextes zu helfen kannst du nun immer einen Teil des volgenden Satzes schreiben bis du zum nachsten Buhstaben gelangst über den einer der Teilnehmer springt.");
        System.out.println("Wenn du deien Text beenden willst schreibe einfach 'end' in die Eingabe.");

        String text = aktuelleEingabe;

        while (aktuelleEingabe != "end"){
            Hopser h = texthopsen.hopseText(text);

        }

        
        scanner.close();
    }
}
