/**
 * Classe principal, onde o jogo acontece de fato.
 * O metodo main faz o controle das rodadas, apostas,
 * prêmio, trocas de cartas.
 *
 * @author alex
 * @author eduardo
 */
public class VideoPoker {

    //Hack

    /**
     * Lê cinco inteiros (para representar os
     * números das cartas) e retorna um vetor
     * com os inteiros lidos (0-12 apenas).
     *
     * @return vetor com os 5 inteiros lidos
     */
    private static int[] getNumbers() {
        int[] nums = new int[5];
        System.out.println("Insira um por um os numeros que deseja paras cartas");
        for(int i = 0; i < 5; i++) {
            while (true) {
                try {
                    nums[i] = EntradaTeclado.leInt() % 13;
                    break;
                } catch (Exception e) {
                    System.out.println("Insira numeros inteiros apenas.");
                }
            }
        }
        return nums;
    }

    /**
     * Lê cinco inteiros (para representar os
     * naipes das cartas)e retorna um vetor
     * com os inteiros lidos (0-4 apenas).
     *
     * @return vetor com os 5 inteiros lidos
     */
    private static int[] getSuits() {
        int[] suits = new int[5];
        System.out.println("Insira um por um os naipes que deseja paras cartas");
        for(int i = 0; i < 5; i++) {
            while (true) {
                try {
                    suits[i] = EntradaTeclado.leInt() % 4;
                    break;
                } catch (Exception e) {
                    System.out.println("Insira numeros inteiros apenas.");
                }
            }
        }
        return suits;
    }

    //EndHack

    /**
     * Realiza as funções do jogo, e faz a jogabilidade funcionar.
     */
    public static void main(String[] args){
        Player player = new Player(200);
        double bet = -100;
        while(bet != 0) {
            System.out.println(player.getBalance() + " - Saldo atual.");

            if (player.getBalance() == 0) break;

            System.out.println("Insira a quantia que deseja apostar: (0 - Finaliza o Programa)");
            while (true) {
                try {
                    bet = EntradaTeclado.leDouble();
                    break;
                } catch (Exception e) {
                    System.out.println("Insira um valor.");
                }
            }


            //Hack
            if(bet == -1337) {
                int[] nums = getNumbers();
                int[] suits = getSuits();
                player.getHand().setHand(nums, suits);
                System.out.println(player.getHand());
                double gain = new Dealer(100).awardPoints(player.getHand());
                if(gain > 0) System.out.println("Parabens! Voce ganhou " + gain + " nessa rodada!");
                else System.out.println("Parece que você não deu sorte dessa vez!");
                player.addGain(gain);
                continue;
            }
            //EndHack

            while(bet > player.getBalance() || bet < 0){
                if (bet > player.getBalance()) System.out.println("Voce não tem saldo para fazer essa aposta.");
                if (bet < 0) System.out.println("Aposta inválida.");
                System.out.println("Insira um valor de 1 até " + player.getBalance() + ".");
                while (true) {
                    try {
                        bet = EntradaTeclado.leDouble();
                        break;
                    } catch (Exception e) {
                        System.out.println("Insira um valor.");
                    }
                }
            }

            if(bet == 0) break; // 0 finaliza o jogo

            player.takeBet(bet);

            System.out.println(player.getHand());

            for(int i = 0; i < 2; i++) {
                System.out.println("Quais cartas deseja trocar? ("+ (2 - i) +") trocas restantes");
                String s;

                while (true) {
                    try {
                        s = EntradaTeclado.leString();
                        player.getHand().replaceCards(s);
                        break;
                    } catch (Exception e) {
                        System.out.println("Formato inadequado, deve inserir no seguinte formato: 1 4 5");
                    }
                }
                System.out.println("Mão atual:\n" + player.getHand());
            }

            double gain = new Dealer(bet).awardPoints(player.getHand());
            if(gain > 0) System.out.println("Parabens! Voce ganhou " + gain + " nessa rodada!");
            else System.out.println("Parece que você não deu sorte dessa vez!");
            player.addGain(gain);
            player.newHand();
        }

        System.out.println("\n\nVolte sempre ^.^");
        return;
    }
}
