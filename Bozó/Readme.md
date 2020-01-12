Bozó
====

Esse é um jogo de dados no qual seu objetico é formar jogos e posicioná-los no tabuleiro de maneira a maximizar seus pontos.

Como Jogar
----------

A cada jogada você tem o direito de rodar os dados ate 3 vezes, apos rodas os dados você deve ver quais faces estão para cima e baseada nelas estudar quantos pontos pode fazer. 

A pontuação depende da posição no tabuleiro onde escolher inserir o jogo.

Tabuleiro:
<div style="display:flex; align-self: center; height: 200px;
flex-direction: column; align-items: center; justify-itens: flex-start;">
<div style="width: 100%; text-align: center; font-size: x-large;">| (1) | (7) | (4) |</div> 
<div style="width: 100%; text-align: center; font-size: x-large;">| (2) | (8) | (5) |</div> 
<div style="width: 100%; text-align: center; font-size: x-large;">| (3) | (9) | (6) |</div>
<div style="width: 100%; text-align: center; font-size: x-large;">| (10) |</div>  
</div>

Dependendo da posição escolhida os pontos serão atribuidos:
* (1): Pontos serão atribuidos de acordo com a quantidade de ums que tenha nos seus dados multiplicado por 1, isto é se tiver 3 ums a pontuação será 3. De 1 a 5 pontos.
* (2): Pontos serão atribuidos de acordo com a quantidade de dois que tenha nos seus dados multiplicado por 2, isto é se tiver 2 dois a pontuação será 4. De 2 a 10 pontos.
* (3): Pontos serão atribuidos de acordo com a quantidade de tres que tenha nos seus dados multiplicado por 3, isto é se tiver 3 tres a pontuação será 9. De 3 a 15 pontos.
* (4): Pontos serão atribuidos de acordo com a quantidade de quatros que tenha nos seus dados multiplicado por 4, isto é se tiver 1 quatro a pontuação será 4.  De 4 a 20 pontos.
* (5): Pontos serão atribuidos de acordo com a quantidade de cincos que tenha nos seus dados multiplicado por 5, isto é se tiver 5 cincos a pontuação será 25. De 5 a 25 pontos.
* (6): Pontos serão atribuidos de acordo com a quantidade de seis que tenha nos seus dados multiplicado por 6, isto é se tiver 2 seis a pontuação será 12. De 6 a 30 pontos.
* (7): 20 pontos serão atribuidos se você tiver um FullHouse, isto é, um par de dados iguais e uma trinca de dados iguais, ou seja, se seus dados forem [3, 3, 5, 5, 5] e voce colocar esse jogo no (7) você ganhara 20 pontos, se seu jogo for [3, 4, 1, 2, 1] e você colocar no (7) você não ganhará 0 pontos.
* (8): 30 pontos serão atribuidos se os numeros dos dados formarem uma sequencia, isto é, se seu jogo for [1, 4, 2, 3] você ganhara 30 pontos, se seu jogo for [1, 1, 2, 2, 2] você ganhará 0 pontos.
* (9): 40 pontos serão atribuidos se você tiver uma quadra, ou seja, 4 dados com faces iguais, isto é, se seu jogo for [1, 1, 1, 1, 3] você ganhara 40 pontos, se deu jogo for [2, 2, 2, 4, 5] você ganhará 0 pontos.
* (10): 50 pontos serão atribuidos se você tiver uma quina, isto é, 5 dados com faces iguais, ou seja, se seu jogo for [3, 3, 3, 3, 3], voce ganhará 50, já se for [1, 2, 3, 4, 5] você ganhará 0 pontos.

A cada rodada você colocara um jogo numa posição, e, apos colocado, ele não poderá ser removido.

Como Usar
---------

Para compilar o programa simplesmente use:

```shell
    > make
```

E então rode-o com:

```shell
    > make run
```

Siga então as instruções que serão exibidas na tela para jogar.<br/>
Para selecionar os dados que quer trocar, simplesmente comoque os numero s separados por espaço.<br/>
Se você não quiser re-rodar os jogos mais simplesmente aperte entre sem nada escrito.

Repositório
-----------

[Voltar para a página do repositório.](https://github.com/EdPirro/USP-SSC0103)
