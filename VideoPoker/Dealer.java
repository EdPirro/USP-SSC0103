/**
 * Essa classe simula o dealer do video poker.
 * Ao criar o objeto é possivel definir qual a aposta
 * feita pelo jogador.
 * Também essa classe verifica se o jogador vai ter
 * algum prêmio com a mão que possui.
 *
 * @author alex
 * @author eduardo
 */
public class Dealer {
    private double bet;
    private int[] cardsNum;
    private int[] cardsSuit;

    /**
     * Cria um dealer com valor 0 de aposta
     */
    public Dealer(){
        this.bet = 0;
    }

    /**
     * Cria um dealer com a aposta escolhida
     * @param bet aposta escolhida
     */
    public Dealer(double bet){
        this.bet = bet;
    }

    /**
     * Altera o valor da aposta sendo realizada
     * @param bet valor da aposta
     */
    public void setBet(double bet) {
        this.bet = bet;
    }

    /**
     * Utiliza os vetores para armazenar as contagens de
     * cada numero de carta que aparece e de cada naipe
     * de carta que aparece, para que possam ser verificadas
     * as combinações de cartas.
     *
     * @param playerCards array das cartas que o jogador possui
     */
    private void countCards(Card[] playerCards){
        int[] cardsNum = new int[13];
        int[] cardsSuit = new int[4];

        for(int i = 0; i < 13; i++) // inicializa contagem com 0
            cardsNum[i] = 0;

        for(int i = 0; i < 4; i++) // inicializa contagem com 0
            cardsSuit[i] = 0;


        for(int i = 0; i < 5; i++){
            cardsNum[playerCards[i].getNumber()]++;
            cardsSuit[playerCards[i].getSuit()]++;
        }


        this.cardsSuit = cardsSuit;
        this.cardsNum = cardsNum;

        return;
    }

    /**
     * Verifica se o jogador possui dois pares
     * (utilizando os arrays de contagem)
     * @return true se sim, se não false
     */
    private boolean hasTwoPairs(){
        int countPairs = 0;

        for(int i = 0; i < 13; i++)
            if(cardsNum[i] == 2) countPairs++;


        if(countPairs == 2) return true;
        else return false;

    }

    /**
     * Verifica se o jogador possui uma trinca
     * (utilizando os arrays de contagem)
     * @return  true se sim, se não false
     */
    private boolean hasThreeOfAKind(){
        for(int i = 0; i < 13; i++)
            if(cardsNum[i] == 3) return true;


        return false;
    }

    /**
     * Verifica se o jogador possui um full house
     * (utilizando os arrays de contagem)
     * @return  true se sim, se não false
     */
    private boolean hasFullHouse(){
        boolean hasTOAK, hasPair;
        hasTOAK = hasPair = false;

        for(int i = 0; i < 13; i++){
            if(cardsNum[i] == 3) hasTOAK = true;
            if(cardsNum[i] == 2) hasPair = true;
        }

        if(hasTOAK && hasPair) return true;
        else return false;
    }

    /**
     * Verifica se o jogador possui uma sequencia
     * (utilizando os arrays de contagem)
     * @return  true se sim, se não false
     */
    private boolean hasStaight(){
        int i;
        for(i = 1; i < 13; i++){
            if(cardsNum[i] == 1) break;
            if(cardsNum[i] > 1) return false;
        }

        //if(i == 0 && cardsNum[i + 1] != 1) i = 9;
        if (i > 9) return false;

        for(int j = i; j < (i + 5); j++) {
            if (cardsNum[j % 13] != 1) return false;
        }


        return true;
    }

    /**
     * Verifica se o jogador possui um flush
     * (utilizando os arrays de contagem)
     * @return  true se sim, se não false
     */
    private boolean hasFlush(){
        for(int i = 0; i < 4; i++)
            if(cardsSuit[i] == 5) return true;

        return false;
    }

    /**
     * Verifica se o jogador possui uma quadra
     * (utilizando os arrays de contagem)
     * @return  true se sim, se não false
     */
    private boolean hasFourOfAKind(){
        for(int i = 0; i < 13; i++)
            if(cardsNum[i] == 4) return true;

        return false;
    }

    /**
     * Verifica se o jogador possui uma sequencia real
     * (utilizando os arrays de contagem)
     * @return  true se sim, se não false
     */
    private boolean isRoyal(){
        for(int i = 9; i < 14; i++)
            if(cardsNum[i%13] != 1) return false;

        return true;
    }

    /**
     * Calcula qual vai ser o prêmio do jogador, baseado em
     * sua aposta e nas cartas que possui
     *
     * @param playerHand mão do jogador (cartas)
     * @return premio do jogador na rodada
     */
    public double awardPoints(Hand playerHand){
        countCards(playerHand.getCards());

        if(hasStaight()){
            if(hasFlush()){
                if(isRoyal()) return this.bet * 200; // Royal Straight Flush
                else return this.bet * 100;                    // Straight Flush
            }
            return this.bet * 5;                               // Straight
        }

        if(hasFourOfAKind()) return this.bet * 50;  // Quadra

        if(hasFullHouse()) return this.bet * 20;     // Full Hand

        if(hasFlush()) return this.bet * 10;         // Flush

        if(hasThreeOfAKind()) return this.bet * 2;    // Trinca

        if(hasTwoPairs()) return this.bet;            // 2 pares

        return 0;
    }
}
