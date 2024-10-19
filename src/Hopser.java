import java.util.ArrayList;

public class Hopser {
    int nededjumps1 = 0;
    int nededjumps2 = 0;
    int currendPos1 = 0;
    int currendPos2 = 0;
    ArrayList<Integer> pos1;
    ArrayList<Integer> pos2;

    public int hopsen(int start1, int start2, int[] extractedNumbers){
        int win = 0;

        pos1 = new ArrayList<>(extractedNumbers.length / 15);
        pos2 = new ArrayList<>(extractedNumbers.length / 15);
        
        currendPos1 = start1;
        currendPos2 = start2;
        while (true){

                pos1.addLast(currendPos1);
                currendPos1 += extractedNumbers[currendPos1];
                nededjumps1++;
                if (currendPos1 > extractedNumbers.length-1){
                    win = 1;
                }

                pos2.addLast(currendPos2);
                currendPos2 += extractedNumbers[currendPos2];
                nededjumps2++;
                if (currendPos2 > extractedNumbers.length-1){
                    win = 2;
                }

                if (win != 0){
                    break;
                }

        }
        return win;
    }
}
