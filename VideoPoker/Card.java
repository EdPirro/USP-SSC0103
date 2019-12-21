/**
 * Essa classe simula uma carta, com seu número e naipe.
 * Ao criar o objeto é possivel definir o número e o naipe,
 * ou deixar que sejam gerados automaticamente (gerador
 * aleatório).
 *
 * @author alex
 * @author eduardo
 */
public class Card {
    private int number;
    private int suit;

    /**
     * Cria uma carta com número e naipe gerados aleatoriamente
     */
    public Card() {
        draw();
    }

    /**
     * Cria uma carta utilizando o valor informado para calcular
     * o naipe e o número.<br><br>
     *
     * Ex: 14 <br>
     *     14 % 13 = 1 (número 2) <br>
     *     14 % 4 = 2  (naipe espadas)
     *
     * @param card valor usado para calcular número e naipe da carta
     */
    public Card(int card) {
        this.number = (card % 13);
        this.suit = (card % 4);
    }

    /**
     * Sorteia um valor aleatório para a carta, calculando o
     * naipe e o número.<br><br>
     *
     * Ex: número 14 é sorteado<br>
     *     14 % 13 = 1 (número 2) <br>
     *     14 % 4 = 2  (naipe espadas)
     */
    public void draw() {
        int card = (int) (Math.random() * 52);
        this.number = (card % 13);
        this.suit = (card % 4);
    }

    /**
     * Transforma a representação de uma carta em String. <br>
     *     Exemplo: <br>
     *     +-----+  <br>
     *     |     |  <br>
     *     | 6 ♥ |  <br>
     *     |     |  <br>
     *     +-----+  <br>
     * @return representação da carta em String
     */
    @Override
    public String toString() {
        String[] suits = {"♦", "♠", "♥", "♣"};
        String[] values = {"A ", "2 ", "3 ", "4 ", "5 ", "6 ", "7 ", "8 ", "9 ", "10", "J ", "Q ", "K "};
        return  "+-----+" + "\n" +
                "|     |" + "\n" +
                "| " + values[this.number] + suits[this.suit] + " |" + "\n" +
                "|     |" + "\n" +
                "+-----+";
    }

    /**
     * Retorna um valor de 0-3 que representa o naipe da carta
     * (Ouro, Espada, Copas, Paus, respectivamente)
     * @return valor do naipe
     */
    public int getSuit() {
        return this.suit;
    }

    /**
     * Retorna um valor de 0-12 que representa o numero da carta
     * (A, 2, 3, ... , 10, J, Q, K, respectivamente)
     * @return
     */
    public int getNumber() {
        return this.number;
    }

    /**
     * Compara duas cartas, vendo se elas possuem o mesmo naipe e
     * o mesmo numero
     * @param c carta a ser comparada
     * @return true se as cartas são iguais, false se não são
     */
    public boolean equals(Card c) {
        return (this.suit == c.getSuit() && this.number == c.getNumber());
    }

    //Hack

    /**
     * Muda o número da carta para o numero escolhido
     * @param number numero escolhido
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Muda o naipe da carta para o naipe escolhido
     * @param suit naipe escolhido
     */
    public void setSuit(int suit) {
        this.suit = suit;
    }

    //Endhack
}
