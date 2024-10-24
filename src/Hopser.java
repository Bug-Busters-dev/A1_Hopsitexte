import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Hopser {
    int nededjumps1 = 0;
    int nededjumps2 = 0;
    int currendPos1 = 0;
    int currendPos2 = 0;
    ArrayList<Integer> pos1;
    ArrayList<Integer> pos2;

    private static final Map<Character, Integer> LETTER_TO_NUMBER_MAP = createMap();

    private static Map<Character, Integer> createMap() {
        Map<Character, Integer> map = new HashMap<>();
        
        map.put('a', 1);
        map.put('b', 2);
        map.put('c', 3);
        map.put('d', 4);
        map.put('e', 5);
        map.put('f', 6);
        map.put('g', 7);
        map.put('h', 8);
        map.put('i', 9);
        map.put('j', 10);
        map.put('k', 11);
        map.put('l', 12);
        map.put('m', 13);
        map.put('n', 14);
        map.put('o', 15);
        map.put('p', 16);
        map.put('q', 17);
        map.put('r', 18);
        map.put('s', 19);
        map.put('t', 20);
        map.put('u', 21);
        map.put('v', 22);
        map.put('w', 23);
        map.put('x', 24);
        map.put('y', 25);
        map.put('z', 26);
        map.put('ä', 27);
        map.put('ö', 28);
        map.put('ü', 29);
        map.put('ß', 30);

        return map;
    }

    public int hopsen(int start1, int start2, char[] extractedLetters){
        int win = 0;

        pos1 = new ArrayList<>(extractedLetters.length / 15);
        pos2 = new ArrayList<>(extractedLetters.length / 15);
        
        currendPos1 = start1;
        currendPos2 = start2;
        while (true){

                if (win != 1){
                pos1.addLast(currendPos1);
                currendPos1 += LETTER_TO_NUMBER_MAP.get(extractedLetters[currendPos1]);
                nededjumps1++;
                }
                if (currendPos1 > extractedLetters.length-1 && win == 0){
                    win = 1;
                }

                if (win != 2){
                pos2.addLast(currendPos2);
                currendPos2 += LETTER_TO_NUMBER_MAP.get(extractedLetters[currendPos2]);
                nededjumps2++;
                }
                if (currendPos2 > extractedLetters.length-1 && win == 0){
                    win = 2;
                }

                if (win != 0 && currendPos2 > extractedLetters.length-1 && currendPos1 > extractedLetters.length-1){
                    break;
                }

        }
        return win;
    }
}
