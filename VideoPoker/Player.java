/**
 * Esta classe representa um jogador, que possui uma
 * mão (conjunto de 5 cartas) e um saldo atual, para
 * fazer apostas.
 * É possivel escolher o saldo inicial ao criar o
 * objeto.
 *
 * @author alex
 * @author eduardo
 */
public class Player {

    private double balance;
    private Hand hand;

    /**
     * Cria um jogador, dando um saldo para ele
     * fazer apostas
     * @param balance saldo inicial do jogador
     */
    public Player(double balance){
        this.balance = balance;
        this.hand = new Hand();
    }

    /**
     * Recupera o saldo do jogador
     * @return saldo
     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * Muda o saldo do jogador
     * @param balance novo saldo
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Remove o valor de uma aposta do jogador
     * @param bet valor da aposta
     */
    public void takeBet(double bet){
        this.balance -= bet;
    }

    /**
     * Adiciona o ganho da aposta feita pelo jogador
     * @param gain ganho recebido
     */
    public void addGain(double gain){
        this.balance += gain;
    }

    /**
     * Cria uma nova mão para o jogador, com
     * novas cartas
     */
    public void newHand() {
        this.hand = new Hand();
    }

    /**
     * Recupera a mão atual do jogador
     * @return mão atual
     */
    public Hand getHand() {
        return this.hand;
    }


}
