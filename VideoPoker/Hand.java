/**
 * Simula o conjunto de cinco cartas que formam a
 * mão do jogador.
 * Ao criar, 5 cartas são puxadas de um baralho e
 * colocadas na mão.
 * É possivel trocar algumas cartas selecionadas
 * da mão.
 *
 * @author alex
 * @author eduardo
 */
public class Hand {
    private Card[] hand;
    private Deck deck;

    /**
     *  Inicializa uma mão, puxando 5 cartas do baralho
     */
    public Hand() {
        this.hand = new Card[5];
        this.deck = new Deck();

        for (int i = 0; i < 5; i++) {
            this.hand[i] = this.deck.drawCard();
        }
    }

    /**
     * Troca as cartas selecionadas. As cartas devem
     * ser entradas na seguinte formatação: <br>
     *     1 2 3 4 5 <br>
     *     1 3 4 <br>
     * @param s cartas que serao trocadas
     */
    public void replaceCards(String s) {
        if (s.equals("")) return;

        boolean[] changed = new boolean[5];
        for (int i = 0; i < 5; i++) {
            changed[i] = false;
        }

        String[] temp = s.split(" ");
        for (int i = 0; i < temp.length; i++) {
            int pos = Integer.parseInt(temp[i]) - 1;
            if (!changed[pos]) {
                this.deck.putCard(this.hand[pos]);
                hand[pos] = this.deck.drawCard();
                changed[pos] = true;
            }
        }
    }

    /**
     * Retorna as cartas da mão
     * @return vetor de cartas
     */
    public Card[] getCards() {
        return this.hand;
    }

    /**
     * Transforma a representação de uma mão em String. <br>
     * Exemplo: <br>
     * +-----+  +-----+  +-----+  +-----+  +-----+  <br>
     * |     |  |     |  |     |  |     |  |     |  <br>
     * | A ♠ |  | 7 ♥ |  | 9 ♣ |  | 9 ♦ |  | A ♥ |  <br>
     * |     |  |     |  |     |  |     |  |     |  <br>
     * +-----+  +-----+  +-----+  +-----+  +-----+  <br>
     *   (1)      (2)      (3)      (4)      (5)    <br>
     * @return representação da mão em String
     */
    @Override
    public String toString(){
        String s = "";
        String[][] temp = new String[5][5];

        for (int i = 0; i < 5; i++) {
            temp[i] = hand[i].toString().split("\n");
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                s += temp[j][i] + "  ";
            }
            s += "\n";
        }

        for (int i = 1; i <= 5; i++) {
            s += "  (" + i + ")    ";
        }

        return s;
    }


    //Hack
    /**
     * Muda todas os naipes e numeros das cartas pelos
     * escolhidos
     * @param nums numeros a serem colocados
     * @param suits naipes a serem colocados
     */
    public void setHand(int[] nums, int[] suits){
        for(int i = 0; i < 5; i++){
            hand[i].setNumber(nums[i]);
            hand[i].setSuit(suits[i]);
        }
        return;
    }
    //EndHack
}
