
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReaderx {

    public char[] redarray(String file, int aZeile) {
        List<Character> buchstabenListe = new ArrayList<>();  // Dynamische Liste für Zeichen (char)
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
            
            // Überspringe die ersten Zeilen bis zur gewünschten Startzeile
            for (int q = 0; q < aZeile; q++) {
                br.readLine();
            }
            
            // Lies die Datei Zeile für Zeile
            String zinhalt;
            while ((zinhalt = br.readLine()) != null) {
                // Nur Buchstaben berücksichtigen, einschließlich Umlaute, und in Kleinbuchstaben umwandeln
                zinhalt = zinhalt.toLowerCase().replaceAll("[^a-zäöüß]", "");  // Umlaute und ß erlauben
                
                // Speichere jeden Buchstaben als char in die Liste
                for (int i = 0; i < zinhalt.length(); i++) {
                    buchstabenListe.add(zinhalt.charAt(i));
                }
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("Datei existiert nicht.");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Lesen hat nicht geklappt.");
        }
        
        // Umwandeln der Liste in ein char[]
        char[] buchstabenArray = new char[buchstabenListe.size()];
        for (int i = 0; i < buchstabenListe.size(); i++) {
            buchstabenArray[i] = buchstabenListe.get(i);  // Konvertierung von Character zu char
        }
        
        return buchstabenArray;
    }
}