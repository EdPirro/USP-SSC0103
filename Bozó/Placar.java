public class Placar {
    private boolean[] isUsed = new boolean[10];
    private int[] points = new int[10];

    public Placar(){
        for(int i = 0; i < 10; i++) {
            isUsed[i] = false;
            points[i] = 0;
        }
    }

    private int checkFullHand(int[] count){
        boolean haveTwo = false;
        boolean haveThree = false;
        for(int i = 0; i < count.length; i++){
            if(count[i] == 2) haveTwo = true;
            else if(count[i] == 3) haveThree = true;
            else if(count[i] == 5) return 20;
        }
        if(haveTwo && haveThree) return 20;
        else return 0;
    }

    private int checkStraight(int[] count){
        int countOne = 0;
        if(count[0] >= 1 && count[5] >= 1) return 0;
        for(int i = 0; i < count.length; i++)
            if(count[i] == 1) countOne++;
        if(countOne == 5) return 30;
        else return 0;
    }

    private int checkFourOfAKind(int[] count){
        for(int i = 0; i < count.length; i++)
            if(count[i] >= 4) return 40;
        return 0;
    }

    private int checkFiveOfAKind(int[] count){
        for(int i = 0; i < count.length; i++)
            if(count[i] == 5) return 50;
        return 0;
    }



    public void add(int pos, int[] data){
        if(pos > 10 || pos < 0 || isUsed[pos - 1])
            throw new
                    java.lang.IllegalArgumentException("A posição ja esta ocupada ou não existe");

        int[] count = new int[6];

        for(int i = 0; i < 6; i++)
            count[i] = 0;

        for(int i = 0; i < data.length; i++){
            count[(data[i] - 1)]++;
        }

        if(pos < 7) points[pos - 1] = count[pos - 1] * pos;
        else if(pos == 7) points[pos - 1] = checkFullHand(count);
        else if(pos == 8) points[pos - 1] = checkStraight(count);
        else if(pos == 9) points[pos - 1] = checkFourOfAKind(count);
        else if(pos == 10) points[pos - 1] = checkFiveOfAKind(count);
        isUsed[pos - 1] = true;
    }

    public int getScore(){
        int score = 0;
        for(int i = 0; i < 10; i++)
            if(isUsed[i]) score += points[i];
        return score;
    }

    private String printPos(int i){
        String ret = "";
        if (isUsed[i]) ret += " " + points[i] + " ";
        else ret += "(" + (i + 1) + ")";
        ret += "    ";
        return ret;
    }
    @Override
    public String toString(){
        String ret = "";
        int i = 0;
        while(i != 3){
            ret += printPos(i);
            ret += "|   ";
            i += 6;
            ret += printPos(i);
            ret += "|   ";
            i -= 3;
            ret += printPos(i);
            ret += "\n--------------------------\n";
            i -= 2;
        }
        ret += "       |   ";
        if(isUsed[9]) ret += " " + points[9] + " ";
        else ret += "(10)";
        ret += "   |\n       +----------+ \n";
        return ret;
    }

}
