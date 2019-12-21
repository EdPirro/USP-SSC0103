import java.io.IOException;

public class Bozo {
    public static void main(String[] args) throws IOException {
        RolaDados roll = new RolaDados(5);
        Placar score = new Placar();
        int[] curr = new int[5];
        int nTurns = 0;
        while(nTurns < 10){
            curr = roll.rolar();
            System.out.println("Rodada " + (nTurns + 1) + "/10.");
            System.out.println("Os dados rodados deram os seguintes resultados:\n\n" + roll);
            for(int i = 0; i < 3; i++) {
                System.out.println("Escolha os dados que deseja re-rolar (" + (3 - i) + " re-rolls restantes).");
                String reroll = EntradaTeclado.leString();
                if (reroll.length() == 0) break;
                if (reroll.equals("*")) curr = roll.rolar();
                else curr = roll.rolar(reroll);
                System.out.println("Os dados rodados deram os seguintes resultados:\n\n" + roll);
            }
            System.out.println("O placar atual eh:\n\n" + score + "\nOnde deseja inserir a pontuação atual?");
            int pos;
            while(true) {
                try {
                    pos = EntradaTeclado.leInt();
                    score.add(pos, curr);
                    break;
                } catch (Exception e) {
                    System.out.println("Insira um valor válido para posição, ou seja, entre 0 e 10 e não ocupado.\n\n");
                    System.out.println("Os dados rodados deram os seguintes resultados:\n\n" + roll);
                    System.out.println("O placar atual eh:\n\n" + score + "\nOnde deseja inserir a pontuação atual?");
                    continue;
                }
            }
            System.out.println("O placar agora eh:\n" + score + "\nPontuação total: " + score.getScore() + ".\n");
            nTurns++;
        }
        System.out.println("\n\nFim de Jogo!\n\nResultado Final: " + score.getScore() + " pontos.\n\n");
    }
}
