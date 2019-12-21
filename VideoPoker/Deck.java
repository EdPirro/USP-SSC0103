import java.util.ArrayList;

/**
 * Essa classe simula um baralho de cartas.
 * Ao criar o objeto as cartas são inseridas no baralho
 * e logo após o baralho é embaralhado.
 * É possivel remover cartas de cima do baralho e
 * colocar cartas por baixo do baralho
 *
 * @author alex
 * @author eduardo
 */
public class Deck {
    private ArrayList<Card> deck = new ArrayList<>();

    /**
     * Inicializa um baralho ordenado em numeros e logo
     * após embaralha ele
     */
    public Deck() {
        ArrayList<Card> temp = new ArrayList<>();

        for (int i = 0; i < 52; i++) {
            Card c = new Card(i);
            temp.add(c);
        }

        for (int i = 0; i < 52; i++) {
            int r = (int) (Math.random() * temp.size());
            Card c = temp.remove(r);
            this.deck.add(c);
        }

    }

    /**
     * Remove uma carta do topo do baralho
     * @return carta removida
     */
    public Card drawCard() {
        Card c = this.deck.remove(0);
        return c;
    }

    /**
     * Coloca uma carta por baixo do baralho
     * @param c carta a ser colocada
     */
    public void putCard(Card c) {
        this.deck.add(c);
    }
}
